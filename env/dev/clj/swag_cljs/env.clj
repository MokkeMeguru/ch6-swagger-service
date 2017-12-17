(ns swag-cljs.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [swag-cljs.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[swag-cljs started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[swag-cljs has shut down successfully]=-"))
   :middleware wrap-dev})
