(ns json-edn.arch-bela
  (:require [cheshire.core :refer :all]
            [clojure.string :as str]))


(defonce arch (parse-string (slurp "arch.json") true))

(->> arch
     :dependencies
     (map :to)
     (filter #(str/starts-with? % "service/"))
     frequencies
     (sort-by (juxt second first))
     (spit "deps-info.json"))

(->> arch
     :dependencies
     (map :to))