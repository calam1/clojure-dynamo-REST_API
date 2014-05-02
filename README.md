# promote-product

simple GET REST api retrieving product(s)

# curl example

curl -G -v "http://localhost:3000/product/search" --data-urlencode "id=78CE7EB3D8AD4468940EE679D7D37307::BG-BRAND-4-2-3" --data-urlencode "sku=100"

## Prerequisites

You will need [Leiningen][1] 1.7.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server

## License

Copyright © 2014 FIXME
