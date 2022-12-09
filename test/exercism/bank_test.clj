(ns exercism.bank-test
  (:require [clojure.test :refer [deftest is]]
            [exercism.bank :as bank])
  (:import (clojure.lang ExceptionInfo)))


(deftest create-account-test
  (is (= {:accounts {0 {:balance 0 :status "open"}}}
         (bank/create-account {} 0)))


  (is (= {:accounts {0 {:balance 10 :status "open" }
                     1 {:balance 0 :status "open"}}}
         (bank/create-account {:accounts {0 {:balance 10 :status "open"}}} 1))))

(deftest make-deposit-up-test
  (is (= {:accounts {0 {:balance 10 :status "open"}}}
         (bank/make-deposit-up {:accounts {0 {:balance 0 :status "open"}}} 0 10)))
  (is (= {:accounts {0 {:balance 35 :status "open"}}}
         (bank/make-deposit-up {:accounts {0 {:balance 10 :status "open"}}} 0 25)))
  (is (thrown-with-msg? ExceptionInfo #"Account closed" 
                        (bank/make-deposit-up {:accounts {3 {:balance 0 :status "closed"}}} 3 25))))

(deftest withdrawal-test
  (is (= {:accounts {0 {:balance 3 :status "open"}}}
         (bank/withdrawal {:accounts {0 {:balance 10 :status "open"}}} 0 7)))
  (is (thrown-with-msg? ExceptionInfo #"Insuficient funds" 
                        (bank/withdrawal {:accounts {0 {:balance 10 :status "open"}}} 0 25))))

(deftest close-account-balance-test
  (is (= {:accounts {0 {:balance 10 :status "open"}
                     1 {:balance 0 :status "closed"}}}
         (bank/close-account-balance {:accounts {0 {:balance 10 :status "open"}
                                                 1 {:balance 0 :status "open"}}} 1)))
  (is (thrown-with-msg? ExceptionInfo #"Balance is not zero"
                        (bank/close-account-balance {:accounts {1 {:balance 15 :status "open"}}} 1))))

