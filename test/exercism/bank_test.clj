(ns exercism.bank-test
  (:require [clojure.test :refer :all]
            [exercism.bank :as bank]))


(deftest create-account-test
  (is (= {:accounts {0 {:balance 0}}}
         (bank/create-account {} 0)))
  (is (= {:accounts {0 {:balance 10}
                     1 {:balance 0}}}
         (bank/create-account {:accounts {0 {:balance 10}}} 1))))



