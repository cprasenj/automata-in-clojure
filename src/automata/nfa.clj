(ns automata.nfa
  (:gen-class)
  (:require [clojure.string :as str]))

(defn nfa-evaluator [delta q0 final-states input-string]
  (some (fn [aState] contains? final-states aState)
        (reduce (fn [previous-states current-charecter]
                  (reduce (fn [result-list aState]
                            (concat result-list (get-in delta [aState current-charecter]))) [] previous-states)) [q0]
                (str/split input-string #""))))



