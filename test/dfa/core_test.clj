(ns dfa.core-test
  (:require [clojure.test :refer :all]
            [dfa.core :refer :all]))

(def even-number-of-zero-dfa (partial dfa-evaluator (hash-map "a" (hash-map "0" "b" "1" "a") "b" (hash-map "0" "a" "1" "b"))
                                      "a" #{"a"})
  )

(deftest dfa_should_return_true_for_00
  (testing "should give true for 00"
    (is (= (even-number-of-zero-dfa "00")) true)))

(deftest dfa_should_return_false_for_01
  (testing "should give false for 01"
    (is (= (even-number-of-zero-dfa "01")) false)))