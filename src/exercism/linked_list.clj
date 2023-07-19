(ns exercism.linked-list)

;ideal for stack and add at the top (beginning)
;the end is the beginning (we actually start from the end)
; different spaces in memory (array is sequential)

;head - first element
;tail - rest of list 
;head - tail
;car - cdr
;first - last
;first - rest

#_(->americana->rome->seattle->toronto
   1 - iterar comparando o elemento (s > a , s > r)
   2 - qdo encontra, insere
   2.1 criar node apontando para o &elemento e o próximo node
   2.2 em seguida altera a referencia do node anterior pra o node criado)




(defn linked-list [head tail] 
  {:head head :tail tail})

(defn head [llist]
  (:head llist))

(defn tail [llist]
  (:tail llist))

#_(defn v-linked-list [head tail] ;;use vector
  (vector tail head))

#_(defn v-head [llist]
  (subvec llist 0 1))

#_(defn v-tail [llist]
  (subvec llist 1))

;get last node (subvec [1 2 3 4] (- (count [1 2 3 4]) 1))

;;implement rest first and conj na unha
;;body tudo q nao eh head

;;inserir ligar com o prox
;;trocar linha do head para o endereco do novo head

(let [subject (linked-list 42 nil)]
  (assert (= 42 (head subject))))
(let [subject (linked-list 30 nil)]
  (assert (= 30 (head subject))))

(let [lista-1 (linked-list 42 nil)
      lista-2 (linked-list 30 lista-1) 
      _ (assert (= 30 (head lista-2))) 
      lista-1b (tail lista-2)
      _ (assert (= 42 (head lista-1b)))
      lista-3 (linked-list 20 lista-2)
      _ (assert (= 20 (head lista-3))) 
      ])

(def lista-1 {:head 42 :tail nil})
 
(def lista-2 {:head 30 :tail lista-1})

(def lista-3 {:head 20 :tail lista-2})

(defn create-node [head]
  {:head head :tail nil})

(defn add-list [list head]
  (if (nil? (:tail list)) 
    (assoc  list :tail (create-node head))
    (assoc list :tail (add-list (:tail list) head))))

(defn add-nth 
  ([list head position] (add-nth list head position 0) )
  ([list head position current-position]
   (if (= (dec position) current-position)
     (let [new-node (create-node head)
           new-node-tail (assoc new-node :tail (:tail list))]
       (assoc list :tail new-node-tail))
     (assoc list :tail (add-nth (:tail list) head position (inc current-position))))))

;; cria node
;;altera o tail do novo node recebe tail da lista e o tail da lista recebe o novo node
{:head 3 :tail {:head 20, :tail nil}}
{:head 42, :tail {:head 30, :tail{:head 3 :tail {:head 20, :tail nil}}}}

;; CONTRARIO
;; altera o tail recursivamente, procurando a posicao até achar , por inc no current position 

;;count map = reduce by keys

(defn count-list [list current]
  (println "current: "current)
  (if (nil? (:tail list)) current
      (count-list (:tail list) (inc current))))

(def lista-v1 [42 nil])
(def lista-v2 [30 lista-v1]) 
(def lista-v3 [20 lista-v2]) ;;[20 [30 [42 nil]]]

;implement using vector
 ;change nth element 


(defn linked-list-v [head tail] 
  (conj [] head tail))

(defn head-v [list]
  (get list 0))

(defn tail-v [list]
  (get list (- (count list) 1)))

(defn tail-v2 [list]
    (get list 1))



(let [subject (linked-list-v 42 nil)]
  (assert (= 42 (head-v subject))))
(let [subject (linked-list-v 30 nil)]
  (assert (= 30 (head-v subject))))

(let [lista-1 (linked-list-v 42 nil)
      lista-2 (linked-list-v 30 lista-1)
      _ (assert (= 30 (head-v lista-2)))
      lista-1b (tail-v lista-2)
      _ (assert (= 42 (head-v lista-1b)))
      lista-3 (linked-list-v 20 lista-2)
      _ (assert (= 20 (head-v lista-3)))])
