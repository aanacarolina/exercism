(ns exercism.sort)

(def initial-values [100 300 9000 500 42])
(def papelzin [2 7 9 1])
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
    (assoc values
           position1 v2
           position2 v1)))

#_(defn sort-two-by-two [list]
  (loop [values list ;copia da lista - imutabilidade
         index 0 ;contador
         flag 0] ;Se = 1 sinaliza que chamamos swap no loop atual
    (when (> (swap! stop-please inc) 1000) (throw (RuntimeException.)));;AVOID INFINITE LOOP
    (if (and (< index (dec (count list))) (> (nth values index) (nth values (+ index 1)))) ;;3  ;; se  a POSICAO for menor que o tamanho da lista -1 ()pq inicia de 0)  
      (do (swap-values values index (+ index 1))
          (flag 1)
          (if (when (and (= index (dec (count list))) (= flag 1)) ;2
                index 0))
          (and (= index (dec (count list))) (= flag 0));BREAK como? retornando a lista
          )
      (recur values
             (inc index)))))


#_(defn sorta [original-values]
  (loop [values original-values
         index 0
         swapped-in-current-pass? false]
    (println values)
    (if (= index (dec (count values))) ;fim da lista (VERIFICAR)
      (if (not swapped-in-current-pass?) ; significa q lista está ordenada
        values
        (recur values 0 false))
      (if (> (nth values index) (nth values (inc index))) ;precisa fazer troca 
        (recur (swap-values values index (inc index)) ;fazendo a troca atual
               (inc index) ; indo para o proximo elemento
               true) ;houve troca
        (recur values
               (inc index)
               false))))) ;nao faz mudança, nao ta no fim da lista vai pro proximo e marca que nao fez troca

(defn sorta [original-values]
    (loop [values original-values
           index 0
           swapped-in-current-pass? false]
      (println "index" index) 
      (println values)
      (println swapped-in-current-pass?)
      (if (= index (dec (count values)))
        (if (not swapped-in-current-pass?) 
          values
          (recur values 0 false))
        (if (> (nth values index) (nth values (inc index)))
          (recur (swap-values values index (inc index))
                 (inc index)
                 true)
          (recur values
                 (inc index)
                 swapped-in-current-pass?))))) ;nao tem que trocar toda vez (hence NAO FAZ MUDANCA x-)
  
  

#_(defn explanation [info]
    1 - Recebe lista desordenada
    2 - Troca os elementos de posição, apos comparação
    2.1 - Resetar "sinalizador" e para cada elemento compare com o seu proximo
    ( 2.1 .1) - Se o 1 maior troque-os de lugar e ative o "sinalizador de troca durante a passada"
    2.2 - Se "sinalizador" ativado voltar ao passo 2.1 
    3 - Devolve lista ordenada

    - if EOL & flag fl = FIM
    - if EOL & flag TRUE = seta index 0 e recomeça
    - if index menor que lista = itera e compara flag seta 1)


(defn sort-one-to-end [listinha])

(comment 
         (sort initial-values)
         (sort names-list)
         (sort papelzin)
         (sort listinha)
         (sorta initial-values)
         (sorta names-list)
         (sorta papelzin)
         (sorta listinha)
         (sort-one-to-end initial-values)
         (sort-one-to-end names-list)
         (sort-one-to-end papelzin)
         (sort-one-to-end listinha))

;;thread 