(ns exercism.lasagna-test
  (:require [clojure.test :refer [deftest testing is]]
            [exercism.lasagna :as lasagna]))

(deftest remaining-time-test
  (testing "return remaining time if actual time is lower than expected time"
    (is (= 35 (lasagna/remaining-time 5))))
  (testing "return zero if minutes-in-oven is equal to expected time"
    (is (= 0 (lasagna/remaining-time 40))))
  (testing "return zero if minutes-in-oven exceeds expected time"
    (is (= 0 (lasagna/remaining-time 50))))
  (testing "return expected-time if minutes-in-oven is negative"
    (is (= 40 (lasagna/remaining-time -15)))))

(deftest total-time-test
  (testing "return zero if total time is lower than minutes in oven"
    (is (= 35 (lasagna/remaining-time 5)))))