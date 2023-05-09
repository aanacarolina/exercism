(ns exercism.scrabble
  (:require [clojure.string :as str]))

(def scrabble-scores
  {1 #{\A \E \I \O \U \L \N \R \S \T}
   2 #{\D \G}
   3 #{\B \C \M \P}
   4 #{\F \H \V \W \Y}
   5 #{\K}
   8 #{\J \X}
   10 #{\Q \Z}})

(defn score [word]
  (reduce +
          (map (fn [a] (first (flatten (filter (fn [i] (contains? (second i) a)) scrabble-scores)))) (str/upper-case word))))

;(filter #(contains? (second %) %2) scrabble-scores) - Passa pelo mapa e pega o segundo item da tupla da lista dada e verifica se o segundo item contém o caracter passado no %2

;flatten para ficar na estrutura de lista (sem ele vem um array dentro da lista)

;first para pegar o primeiro item da lista, que no caso é a pontuação daquela letra passada em A

;MAP faz a esse procedimento em todas as letras da palavra 

;REDUCE soma todos os pontos das letras da palavra e retorna a pontuação daquela palavra

