(ns exercism.odd-sum)

(defn odd-sum [lst]
  (reduce
   +
   (filter odd? lst)))

 
 

