(ns exercism.anagra
  (:require [clojure.string :as str]))

#_(defn  1 - receber palavra e lista
2 - criar funcao que conta e mapeia as letras de todas
     2.1 transformar para minusculo
3 - comparar se mapa igual de palavras
    3.1 verificar palavras com todas maiusculas na lista
4 - retornar as ok

contar quantas letras de cada temos na primeira palavra
hello
:h 1
:e 1
:l 2
:o 1

ohell

:o 1
:h 1
:e)

(defn string-split->map [word]
  (reduce (fn [acc letra]
            (merge-with + acc {letra 1})) {} (str/lower-case word)))

(defn anagram [word words-list]
  (let [word-mapped (string-split->map word)]
    (->> words-list
         (filter #(not= (str/lower-case word) (str/lower-case %)))
         (filter #(= word-mapped (string-split->map %)))
         (into []))))


#_(Conceitos para lembrar:
  map 1 :1
  reduce TRANSFORMAR para 1 final (pode ate ser maior)
  filter diminuir ou igual) 


REFAZER USANDO sort
