(ns swag-cljs.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [swag-cljs.layout :refer [error-page]]
            [swag-cljs.routes.home :refer [home-routes]]
            [swag-cljs.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [swag-cljs.env :refer [defaults]]
            [mount.core :as mount]
            [swag-cljs.middleware :as middleware]))

(mount/defstate init-app
                :start ((or (:init defaults) identity))
                :stop  ((or (:stop defaults) identity)))

(def app-routes
  (routes
   #'service-routes
   (wrap-routes #'home-routes middleware/wrap-csrf)
   (route/not-found
    (:body
     (error-page {:status 404
                  :title "page not found"})))))

;; (def app-routes
;;   (routes
;;     (-> #'home-routes
;;         (wrap-routes middleware/wrap-csrf)
;;         (wrap-routes middleware/wrap-formats))
;;     #'service-routes
;;     (route/not-found
;;       (:body
;;         (error-page {:status 404
;;                      :title "page not found"})))))


(defn app [] (middleware/wrap-base #'app-routes))
