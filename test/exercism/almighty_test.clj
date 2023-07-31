(ns exercism.almighty-test
  (:require [clojure.test :refer [is testing]
             [exercism.almighty-reduce :as reduce]]))

(is (= [8 6 7]
       (reduce/long-lengths ["foo" "aoeusnth" "q" "aoeus" "abcdef" "1234567"])))

(clojure.test/run-tests)