(ns moises-api.handler
  (:use ring.util.response)
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.json :as middleware]
            [cheshire.core :refer :all]))

(defn relou [& args-list]
  "<h1>Rélou</h1>")

(defroutes app-routes
  (GET "/" [] relou)
  (route/not-found "Not Found"))

(def app (-> app-routes
             (middleware/wrap-json-body {:keywords? true})
             (middleware/wrap-json-response)
             (wrap-defaults site-defaults)))
