(ns exercism.linked-list
  (:require [clojure.test :refer [deftest is]]))

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
  (conj tail head))

(defn head [llist]
  (first llist))

(defn tail [llist]
  (rest llist))

(defn v-linked-list [head tail] ;;use vector
  (vector tail head))

(defn v-head [llist]
  (subvec llist 0 1))

(defn v-tail [llist]
  (subvec llist 1))

;get last node (subvec [1 2 3 4] (- (count [1 2 3 4]) 1))

;;implement rest first and conj na unha
;;body tudo q nao eh head

;;inserir ligar com o prox
;;trocar linha do head para o endereco do novo head

(let [subject (v-linked-list 42 nil)]
  (assert (= 42 (v-head subject))))
(let [subject (v-linked-list 30 nil)]
  (assert (= 30 (v-head subject))))

(let [subject (v-linked-list 42 nil)
      subject (v-linked-list 30 subject) 
      _ (assert (= 30 (v-head subject))) 
      subject (v-tail subject)
      _ (assert (= 42 (v-head subject)))])

