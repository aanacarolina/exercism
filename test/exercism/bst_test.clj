(ns exercism.bst-test
  (:require [clojure.test :refer :all]
            [exercism.bst :refer :all]))

(deftest insert-test
  (testing "Inserting to left"
    (is (= {:value 42 :left {:value 32}} (insert 32 {:value 42})))))