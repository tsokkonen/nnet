(ns nnet.core
  (:gen-class))

(defn dot-product [weight evidence]
  (reduce + (map * weight evidence)))

(defn perceptron [bias evidence weight]
  (let [dot-product (dot-product weight evidence)]
   (if (> (+ dot-product bias) 0) 1 0)))

(defn bitwise-add [x1 x2]
 "Returns carry bit n4 and sum n5 given two bits x1 and x2)"
 (let [bias 3
       weight [-2 -2]
       n1 (perceptron bias [x1 x2] weight)
       n2 (perceptron bias [x1 n1] weight)
       n3 (perceptron bias [n1 x2] weight)
       n4 (perceptron bias [n1]  [-4])
       n5 (perceptron bias [n2 n3] weight)]
   [n4 n5]))

(defn sigmoid [bias evidence weight]
  (let [dot-product (dot-product weight evidence)
        z (- (- dot-product) bias)]
    (/ 1 (+ 1 (Math/pow Math/E z)))))

(proto-repl-charts.charts/custom-chart
  "Sigmoid function"
  {:data
    {:columns
      [(concat ["x"] (range -4 5))
       (concat ["sigmoid function"] (map #(/ 1 (+ 1 (Math/pow Math/E (- %)))) (range -4 5)))]
     :x "x"
     :type "line"}})
