(ns exercism.flatten-array)

(def input [1,[2,3,nil,4],[nil],5])



(defn my-flatten [arr] 
(filter #(not (nil? %)) (flatten arr)))

(comment 
  (my-flatten input))
