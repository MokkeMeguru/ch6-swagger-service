(ns swag-cljs.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[swag-cljs started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[swag-cljs has shut down successfully]=-"))
   :middleware identity})
