(ns nnet.core-test
  (:require [clojure.test :refer :all]
            [nnet.core :refer :all]))

(deftest perceptron-test
  (testing "should fire"
    (is (= (perceptron -3 [1 0 0] [6 2 2]) 1))
    (is (= (perceptron -3 [0 1 1] [6 2 2]) 1))))

(deftest bitwise-add-test
  (testing "should return correct output"
    (is (= (bitwise-add 1 1) [1 0]))
    (is (= (bitwise-add 1 0) [0 1]))
    (is (= (bitwise-add 0 1) [0 1]))
    (is (= (bitwise-add 0 0) [0 0]))))
