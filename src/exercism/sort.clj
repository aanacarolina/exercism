(ns exercism.sort)

(def initial-values [100 300 9000 500 42])
(def listinha [42 29 12 99])
(def names-list ["klaus" "nodari" "carol" "liv"])
;;nth vector index
;;count 
;;change position assoc vector index new-value
;;loop [a initial-value-a 
;;      b initial-value-b ]
;;       (recur new-value-a new-value-b) 
#_(loop [a 1]
    (if (= 1 1)
      "ok"
      (recur 2)))

#_(loop [index 0]
    (when (< index (count initial-values))
      (println (nth initial-values index))
      (recur (inc index))))

(def stop-please (atom 0))

(defn swap-values [values position1 position2]
  (let [v1 (nth values position1)
        v2 (nth values position2)]
    (println "v1\n" v1)
    (println "v2\n" v2)
    (assoc values position1 v2
           position2 v1)))

(defn sort-two-by-two [list]
  (loop [values list
         index 0]
    (when (> (swap! stop-please inc) 1000) (throw (RuntimeException.)));;AVOID INFINITE LOOP
    (println "#index\n"index)
    (println "@values\n"values)
    (println "list\n" list)
    (if (and
         (< index (- (count list) 1))
         (> (nth values index) (nth values (+ index 1)))) ;; se  a POSICAO for menor que o tamanho da lista -1 ()pq inicia de 0)  
      (swap-values values index (+ index 1))
      (recur values
             (inc index))))) ;;poderia ser (inc index) como abaixo 

#_(defn sort-one-to-end [list]
  ())

(comment (sort-two-by-two initial-values)
         (sort-two-by-two names-list)
         (sort-two-by-two listinha))
;;thread 