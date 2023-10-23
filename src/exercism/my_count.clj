(ns exercism.my-count)

(defn my-count [lst]
  (loop [cnt 0
         arr (reduce conj [] lst)]
    (if (empty? (first arr))
      cnt
      (recur (inc cnt) (rest arr)))))

;https://www.hackerrank.com/challenges/fp-list-length/submissions/code/352920042