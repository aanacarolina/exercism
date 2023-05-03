(ns exercism.reverse)

;função que recebe vetor e devolve invertido
;allowed functions - length - loop - nth
;not allowed - revert do clojure
;array - java, não tem no clojure. tamanho fixo, consegue modificar 
;java tbm tem vector q pode adicionar elementos - deprecated
;vector - imutavel clojure
;lista indexada 

#_(contar o tamanho do vetor
          [0 1 2 3 4 5]
length = 6
[0] - length - 1
i++ (recur)
[nth +1 ] - lenght -2 
recur
qtdade mov = lenght / 2 
X - stop cond = length [NO] 
          stop cond - qdo nth +1 nth -1 = 0 
          
0 1 2 3 4 5
5 1 2 3 4 0
5 4 2 3 1 0
5 4 3 2 1 0)

(def vtr [10 20 30 40 50 60])
(def vtorzin [7 23 115 55 10])
(def veh-thor ["a" "b" "c"])

(defn swap-pos [pos1 pos2 vect]
  (let [element-1 (nth vect pos2)
        element-2 (nth vect pos1)] 
    (assoc vect 
           pos1 element-1 
           pos2 element-2))) ;usar update pq nao ta retornando o novo, alterar e usar de novo thread



(defn reverter [vect]
  (loop [new-vect vect
         initial-pos 0
         last-pos (- (count vect) 1)] 
    (if (< initial-pos (int (/ (count vect) 2)))
      (recur (swap-pos initial-pos last-pos new-vect)
             (inc initial-pos)
             (dec last-pos))
      new-vect)))


(defn swap-pos [pos1 pos2 vect]
  (let [element-1 (nth vect pos2)
        element-2 (nth vect pos1)]
    (assoc vect
           pos1 element-1
           pos2 element-2)))


(defn reverter-atom [vect]
  (let [atom-vec (atom vect)]
    (loop [initial-pos 0
           last-pos (- (count vect) 1)]
      (if (< initial-pos (int (/ (count vect) 2)))
        (do
          (swap-pos initial-pos last-pos @atom-vec)
          (recur                (inc initial-pos)
                                (dec last-pos)))
        @atom-vec))))

(defn reverter-atom2 [vect]
  (let [atom-vec (atom vect)]
    (loop [initial-pos 0
           last-pos (- (count vect) 1)]
      (when (< initial-pos (int (/ (count vect) 2)))
        (swap-pos initial-pos last-pos @atom-vec) ;;como setar valor do atom para correto/esperado
        (recur                (inc initial-pos)
                              (dec last-pos))))
    @atom-vec))


(comment 
  (reverter-atom vtr)
  (reverter vtorzin)
  (reverter veh-thor))