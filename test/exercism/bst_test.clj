(ns exercism.bst-test
  (:require [clojure.test :refer :all]
            [exercism.bst :refer :all]))

(deftest insert-test
  (testing "Inserting left"
    (is (= {:value 42 :left {:value 32}}
           (insert 32 {:value 42}))))
  (testing "Inserting right"
    (is (= {:value 42 :right {:value 52}}
           (insert 52 {:value 42}))))
  (testing "Inserting existing value"
    (is (= {:value 42}
           (insert 42 {:value 42}))))
  (testing "Inserting left left"
    (is (= {:value 42 :left {:value 32 :left {:value 22}}}
           (insert 22 {:value 42 :left {:value 32}}))))
  (testing "Inserting right right"
    (is (= {:value 42 :right {:value 52 :right {:value 62}}}
           (insert 62 {:value 42 :right {:value 52}})))))

;novos testes
;left do right
;right to left
;right same 
;left same

