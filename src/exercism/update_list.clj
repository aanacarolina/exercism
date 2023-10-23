(ns exercism.update-list)

(fn [lst]
  (map
   #(if (< % 0)
      (* % -1)
      (* % +1))
   lst))

;https://www.hackerrank.com/challenges/fp-update-list/submissions/code/352928353