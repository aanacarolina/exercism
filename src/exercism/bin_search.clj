(ns exercism.bin-search)

(defn value [node] ;; <- arglist goes here extract value from node
  (:value node) ;; your code goes here
  )

(defn left [node] ;; <- arglist goes here
  (:left node);; your code goes here
  )

(defn right [node] ;; <- arglist goes here
  (:right node);; your code goes here
  )


(defn singleton [value] ;; criando a estrutura raiz da arvore simples, sem left e right
  {:value value})

(defn insert [val node] ;; <- arglist goes here
  (if (< (value node) val)
    (assoc node :right (singleton val))
    (assoc node :left (singleton val))) 
  )


(defn to-list [] ;; <- arglist goes here
  ;; your code goes here
  )

(defn from-list [] ;; <- arglist goes here
  ;; your code goes here
  )