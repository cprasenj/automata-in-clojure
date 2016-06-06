(ns automata.nfa-test
  (:require [clojure.test :refer :all]
            [automata.nfa :refer :all]))

(def dfa-ends-with-101 (partial nfa-evaluator (hash-map "q1" (hash-map "0" ["q1"] "1" ["q1" "q2"])
                                                        "q2" (hash-map "0" ["q3"])
                                                        "q3" (hash-map "1" ["q4"]))
                                      "q1" #{"q4"})
  )

(deftest dfa_should_return_true_for_101
  (testing "should give true for 101"
    (is (= (dfa-ends-with-101 "101")) true)))

(deftest dfa_should_return_false_for_01
  (testing "should give false for 01"
    (is (= (dfa-ends-with-101 "01")) false)))