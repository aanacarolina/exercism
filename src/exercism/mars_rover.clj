(ns exercism.mars-rover)

;;input
;;tamanhho grid
;;posição inicial e direção

;;criar o grid
;;como fazer andar pra frente (coord +1 frente ou -1 trás)
;;como fazer virar para esquerda ()
;;como fazer virar para direita
;;pontos cardeais 


;;baby steps
;;1 dimensao
;;Apenas 1 rover
;;So um movimento

(defn new-rover []
  {:position 0 :direction :N})

(defn m [rover] 
  (if (= (:direction rover ) :N)
    (update rover :position inc)
    (update rover :position dec)))

(defn t [rover]
  (assoc rover :direction :S))
;;rotate north too.
(defn position [rover]
  (:position rover))
;position =  movimento + direcao
;------------------------------------------

(def rover (new-rover))

(-> rover
    m m m m
    position
    (= 4)
    assert)

(-> rover
    m m m m
    t
    m
    t
    m
    position
    (= 4)
    assert)



"success"

;dsl - domain specific language
;dojo - ignorar complexidade incidental ()inputs / parseamento args, etc)
