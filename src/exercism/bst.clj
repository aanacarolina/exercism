(ns exercism.bst)

(def value {:left :val,
 4 {:value 2, :left {:left nil, :value 1, :right nil}, :right {:left nil, :value 3, :right nil}},
 :right {:value 6, :left {:left nil, :value 5, :right nil}, :right {:left nil, :value 7, :right nil}}})

(defn left [val] ;; <- arglist goes here
  (:left val))

(defn right [val] ;; <- arglist goes here
  ;; your code goes here
  (:right val))

(defn value [node] ;; <- arglist goes here
  (:value node))

(defn singleton [val] ;; <- arglist goes here ;;cria mapa inicial (creates root)
  {:value val})

(defn insert [val node] ;; <- arglist goes here
  ;fazer passar o teste, ou seja insert left only
  )

(defn to-list [val] ;; <- arglist goes here
  (when val
    (println val)
    (concat (to-list (left val))
            (:value val) 
            (to-list (right val)))))

(defn from-list [] ;; <- arglist goes here
  ;; your code goes here
  )


(comment
  (to-list value))

;----
;Inorder traversal
;First, visit all the nodes in the left subtree
;Then the root node
;Visit all the nodes in the right subtree

    ;  4
  ;  /   \
 ;  /     \
;  2       6
; / \     / \
;1   3   5   7

;[1, 2, 3]
;--