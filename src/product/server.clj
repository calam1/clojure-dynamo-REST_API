(ns product.server
  (:use [compojure.core]
        [liberator.core :only [defresource request-method-in]]
        [rotary.client])
  (:require
   [ring.adapter.jetty :as jetty]
   [compojure.handler :as handler]
   [clojure.data.json :as json]
   [ring.middleware.json :as middleware]))

(def aws-credential {:access-key "ACCESS_KEY", :secret-key "SECRET_KEY"})

(defn retrieveProducts [query]
  (println (str "retrieve products " query))
  (json/write-str (get-item aws-credential "commerce.business.promote.PRODUCT" query)))

(defresource home
  :available-media-types ["text/plain"]
  :handle-ok "Product Search Home Page")

(defresource productSearch [params]
  :method-allowed? (request-method-in :get)
  :available-media-types ["*"]
  :handle-ok (retrieveProducts params))
  
(defroutes app-routes
  (GET "/" [] home)
  (GET "/product/search" {params :params} (productSearch params))
)

(def app
  (handler/api app-routes))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
