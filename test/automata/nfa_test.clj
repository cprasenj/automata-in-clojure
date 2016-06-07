(ns automata.nfa-test
  (:require [clojure.test :refer :all]
            [automata.nfa :refer :all]))

(def nfa-ends-with-101 (partial nfa-evaluator
                                (hash-map "q1" (hash-map "0" #{"q1"} "1" #{"q1" "q2"})
                                          "q2" (hash-map "0" #{"q3"})
                                          "q3" (hash-map "1" #{"q4"}))
                                "q1" #{"q4"})
  )

(deftest nfa_should_return_true_for_101
  (testing "should give true for 101"
    (is (= (nfa-ends-with-101 "101") true))))

(deftest nfa_should_return_false_for_01
  (testing "should give false for 01"
    (is (= (nfa-ends-with-101 "01") false))))

;(def nfa-divisibility-of-2-and-3 (partial nfa-evaluator
;                                          (hash-map
;                                            "1" (hash-map "epsilon" ["2" "4"])
;                                            "2" (hash-map "0" ["3"] "1" ["3"])
;                                            "3" (hash-map "0" ["2"] "1" ["2"])
;                                            "4" (hash-map "0" ["5"] "1" ["5"])
;                                            "5" (hash-map "epsilon" ["Intermediate1"])
;                                            "Intermediate1" (hash-map "0" ["Intermediate2"] "1" ["Intermediate2"])
;                                            "Intermediate2" (hash-map "epsilon" ["6"])
;                                            "6" (hash-map "0" ["4"] "1" ["4"])
;                                            )
;                                          "1" #{"2" "4"})
;  )
;
;(deftest nfa_should_give_true_for_10
;  (testing "should give false for 10"
;    (is (= (nfa-divisibility-of-2-and-3 "10") true))))
;
;
;(deftest nfa_should_give_true_for_10
;  (testing "should give false for 10"
;    (is (= (nfa-divisibility-of-2-and-3 "01") false))))
;
;
;(deftest nfa_should_give_true_for_101111111110000101010101010101010111111111111110
;  (testing "should give false for 101111111110000101010101010101010111111111111110"
;    (is (= (nfa-divisibility-of-2-and-3 "101111111110000101010101010101010111111111111110") true))))
