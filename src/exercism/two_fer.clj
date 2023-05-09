(ns exercism.two-fer
   (:require [clojure.string :as str]))

(defn two-fer 
  ([] (two-fer nil))
  ([name]
 (str "One for " (if (str/blank? name) "you" name) ", one for me.")))

;multi arities - se nao passar param, chama ele mesmo passando parametro nil (OOP = sobrecarga de metodo)


#_(defn two-fer [name]
    (str "One for " (if (empty? name) "you" (first name)) ", one for me."))



;- frase padrao, com espaço para nome
;- se name dado, coloca nome dado, do contrario you.
