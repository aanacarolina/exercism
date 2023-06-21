(ns exercism.alpha-mirror
  (:require [clojure.string :as str]))

;;write a function alpha_mirror that takes a string and displays this string
;;after replacing each alphabetical character by the opposite alphabetical character, followed by a newline.

;'a' becomes 'z', 'Z' becomes 'A'
;'d' becomes 'w', 'M' becomes 'N'

;Case is not changed.

;verificar case 
;fazer correspondencias a = z (poderia calcular, mas ok - ou qdo soma no começo diminui no final)
;substituir - map 



(def mirror-chars {\a \z
                   \b \y
                   \c \x
                   \d \w
                   \e \v
                   \f \u
                   \g \t
                   \h \s
                   \i \r
                   \j \q
                   \k \p
                   \l \o
                   \m \n
                   \A \Z
                   \B \Y
                   \C \X
                   \D \W
                   \E \V
                   \F \U
                   \G \T
                   \H \S
                   \I \R
                   \J \Q
                   \K \P
                   \L \O
                   \M \N})


(defn calculate-value [upper bottom value] 
 (+ bottom (- upper value)))

(def upper-case (partial calculate-value 90 65))

(def lower-case (partial calculate-value 122 97))

(defn case-checker-ascii [char]
  (let [char->ascii (int char)]
    (cond
      (and (>= char->ascii 65) (<= char->ascii 90)) (upper-case char->ascii)
      (and (>= char->ascii 97) (<= char->ascii 122)) (lower-case char->ascii)
      :else char->ascii)))

(defn alpha-mirror [sentence]
  (->> sentence
       (map #(char (case-checker-ascii %)))
       (apply str)))

(defn case-and-replace [char]
  (get mirror-chars char char))

(defn alpha-mirror-map [sentence]
 (apply str (map case-and-replace sentence)))

  (comment
    (alpha-mirror-map "My horse is Amazing.")
     ;;expected Nb slihv rh Znzarmt.$
    )

