(ns exercism.birds
  (:require [exercism.birds :as birds]))

(def last-week
  [0 2 5 3 7 8 4])

(defn today [birds]
  (last birds))

(defn inc-bird [birds]
  (update birds (dec (count birds)) inc))

(defn day-without-birds? [birds]
  (boolean (some zero? birds)))

(defn n-days-count [birds n]
  (->> birds
       (take n)
       (reduce +)))

(defn busy-days [birds]
  (->> birds
       (filter #(>= % 5))
       count))

(defn odd-week? [birds]
  ;(or (= 1 (first birds)) (= 0 (first birds))))
  (or (= [1 0 1 0 1 0 1] birds) (= [0 1 0 1 0 1 0] birds)))

(defn is-a-7-day-week? [birds]
  (= 7 (count birds)))

(defn new-odd-week? [birds]
  (or (empty? birds)
      (let [primeiro (first birds)
            segundo (second birds)]
        (if (or
             (and (= 1 primeiro) (or (= 0 (second birds)) (nil? (second birds)))) ;can't compare with the function 
             (and (= 0 primeiro) (or (= 1 segundo) (nil? segundo))))
          (recur (rest birds));;same as new-odd-week but won't overflow
          false))))


;first = 1 second = 0 / first = 0 second 1 - if second nil? end true


(comment
  (not (empty? (filter zero? [2 4 6 7])))
  (boolean (seq (filter zero? [2 4 6 7])))

  (count [2 5 0 7 4 2])
  (->> [2 5 0 7 4 2]
       (take 4)
       (reduce +))

  (busy-days [2 5 0 7 4 2])

  (new-odd-week? [0 1 0 1 0 0])
  (new-odd-week? [0 1 0 1 0 1 2])
  (is-a-7-day-week? [0 1 0 1 0])
  (is-a-7-day-week? [0 1 0 1 0 1 2]))