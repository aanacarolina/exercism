(ns exercism.birds-test
  (:require [clojure.test :refer [deftest is testing]]
            [exercism.birds :as birds])
  (:import (clojure.lang ExceptionInfo)))



(deftest odd-week-test
  (testing "First item is 1"
    (is (= true
           (birds/odd-week? [1 0 1 0 1 0 1]))))
  (testing "First item is 0"
    (is (= true
           (birds/odd-week? [0 1 0 1 0 1 0]))))
  (testing "All values are 1"
    (is (= false
           (birds/odd-week? [1 1 1 1 1 1 1]))))
  (testing "last one is repeated"
  (is (= false
         (birds/odd-week? [1 0 1 0 1 1 1]))))
  (testing "Invalid coll"
  (is (= false
         (birds/odd-week? [1 0 1 2 0 1 0])))))


(deftest new-odd-week-test
  (testing "First item is 1"
    (is (= true
           (birds/new-odd-week? [1 0 1 0 1 0 1]))))
  (testing "First item is 0"
    (is (= true
           (birds/new-odd-week? [0 1 0 1 0 1])))) ;;not working?
  (testing "All values are 1"
    (is (= false
           (birds/new-odd-week? [1 1 1 1 1 1 1]))))
  (testing "last one is repeated"
  (is (= false
         (birds/new-odd-week? [1 0 1 0 1 1 1]))))
(testing "Invalid coll"
  (is (= false
         (birds/new-odd-week? [1 0 1 2 0 1 0])))))


