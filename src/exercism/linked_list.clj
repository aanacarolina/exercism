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


(defn linked-list [head body] ;;use vector
  (conj body head))

(defn head [llist]
  (first llist))

(defn body [llist]
  (rest llist))

;;implement rest first and conj na unha
;;body tudo q nao eh head

;;inserir ligar com o prox
;;trocar linha do head para o endereco do novo head

(let [subject (linked-list 42 nil)]
  (assert (= 42 (head subject))))
(let [subject (linked-list 30 nil)]
  (assert (= 30 (head subject))))

(let [subject (linked-list 42 nil)
      subject (linked-list 30 subject)
      _ (assert (= 30 (head subject)))
      subject (body subject)
      _ (assert (= 42 (head subject)))])
