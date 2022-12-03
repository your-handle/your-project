(ns your-project.index
  {:nextjournal.clerk/visibility {:code :fold}}
  (:require [nextjournal.clerk :as clerk]))

;; # Hello, Clerk!

^{::clerk/visibility {:result :hide}}
(defn primes
  []
  (letfn [(primes*
           [candidate state]
           (if-let [factors (state candidate)]
             (recur (+ 2 candidate)
                    (reduce (fn [s factor]
                              (update s (+ candidate factor factor) conj factor))
                            (dissoc state candidate)
                            factors))
             (lazy-seq (cons candidate
                             (primes* (+ 2 candidate)
                                      (assoc state (* candidate candidate) [candidate]))))))]
    (cons 2 (primes* 3 {}))))

(primes)
