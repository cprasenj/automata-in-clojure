(ns dfa.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn dfa-evaluator [delta q0 final-states input-string]
  (contains? final-states (reduce (fn [last-state current-charecter]
                                    (get-in delta [last-state current-charecter])) q0 (str/split input-string #"")))
  )

