(ns exercism.log-levels
   (:require [clojure.string :as str]))

(def message-one "[ERROR]: Invalid operation")
(def message-two "[WARNING]:  Disk almost full\r\n")

(defn parse-msgs1 [msg]
(str/replace (subs msg (inc (str/index-of msg " "))) "\r\n" ""))

(defn parse-msgs [msg]
  (str/trim (subs msg (inc (str/index-of msg " ")))))

(parse-msgs message-one)
(parse-msgs message-two)

(defn log-level [msg]
 (str/lower-case (subs msg (inc (str/index-of msg "[")) (str/index-of msg "]"))))

(log-level message-one)
(log-level message-two)


(defn reformat [msg]
  (let [level-msg (log-level msg)]
    (str (parse-msgs msg) " " "(" level-msg ")")))
    ;(reformat message-two) 
    ;(reformat message-one)
