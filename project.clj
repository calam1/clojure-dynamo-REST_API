(defproject product "0.1.0-SNAPSHOT"
  :description "Product Search for Orion MCP"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [liberator "0.5.0"]
                 [ring/ring-json "0.2.0"]
                 [rotary "0.4.1"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [org.clojure/data.json "0.2.2"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler product.server/app}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}}
  :main product.server)
