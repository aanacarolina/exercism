(ns exercism.log-levels
   (:require [clojure.string :as str]))

(def message-one "[ERROR]: Invalid operation")
(def message-two "[WARNING]:  Disk almost full\r\n")

(defn parse-msgs [msg]
  (str/replace msg (or "[ERROR]: " "[WARNING]:  "  )""))

(parse-msgs message-one)
(parse-msgs message-two)

(defn log-level [msg])

(defn reformat [msg]
  )

(parse-msgs message-one)
(parse-msgs message-two)

