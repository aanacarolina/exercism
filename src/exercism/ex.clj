(ns exercism.ex)

(loop [x 1]
  (if (> 1 1)
    "ok"
    (recur (inc x))))


1 + x 
+
(x2 / 2!)
+
x3 / 3!
+
x4 / 4!
+ 
x10 /10!

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [n-itr (range n)]
  (def x (Double/parseDouble (clojure.string/trim (read-line))))
  
  (loop [result (+ 1 x)
         num 2]
    (if (> num 9)
      result
      (recur (+ result (/ (reduce * (repeat num x))
                          (loop [cnt num
                                 acc 1]
                            (if (zero? cnt)
                              acc
                              (recur (dec cnt) (* acc cnt))))))
             (inc num)))))