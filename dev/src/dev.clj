(ns dev
  (:require [fipp.edn :refer [pprint]]
            [clojure.spec.alpha :as spec.alpha]
            [clojure.java.io :as io]
            [expound.alpha :as expound]
            [orchestra.spec.test :as stest]
            [app-base.config :refer [config]]
            [juxt.clip.repl :refer [start stop set-init! reset system]]))

(set-init! (fn [] (config :dev)))

(comment
  (start)
  (reset)
  (stop)
  system)

;;; code start



;;; expound and Orchestra

(defn unstrument
  []
  (stest/unstrument))


(defn instrument
  []
  (set! spec.alpha/*explain-out* expound/printer)
  (stest/instrument))

(instrument)

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;