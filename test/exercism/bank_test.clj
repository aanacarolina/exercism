(ns exercism.bank-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.bank :as bank]))


(deftest create-account-test
  (is (= {:accounts {0 {:balance 0}}}
         (bank/create-account {} 0)))

  (is (= {:accounts {0 {:balance 10}
                     1 {:balance 0}}}
         (bank/create-account {:accounts {0 {:balance 10}}} 1))))

(deftest make-deposit-test
  (is (= {:accounts {0 {:balance 10}}}
         (bank/make-deposit {:accounts {0 {:balance 0}}} 0 10)))
  (is (= {:accounts {0 {:balance 35}}}
         (bank/make-deposit {:accounts {0 {:balance 10}}} 0 25))))


