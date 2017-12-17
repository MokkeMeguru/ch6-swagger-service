(ns swag-cljs.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [swag-cljs.core-test]))

(doo-tests 'swag-cljs.core-test)

