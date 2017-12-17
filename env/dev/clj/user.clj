(ns user
  (:require 
            [mount.core :as mount]
            [swag-cljs.figwheel :refer [start-fw stop-fw cljs]]
            swag-cljs.core))

(defn start []
  (mount/start-without #'swag-cljs.core/repl-server))

(defn stop []
  (mount/stop-except #'swag-cljs.core/repl-server))

(defn restart []
  (stop)
  (start))


