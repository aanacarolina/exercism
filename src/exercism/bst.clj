(ns exercism.bst)

(def value {:left :val,
 4 {:value 2, :left {:left nil, :value 1, :right nil}, :right {:left nil, :value 3, :right nil}},
 :right {:value 6, :left {:left nil, :value 5, :right nil}, :right {:left nil, :value 7, :right nil}}})

(defn create-node [val]
  {:left nil :right nil :value val})

(defn left [val] ;; <- arglist goes here
  (:left val))

(defn right [val] ;; <- arglist goes here
  ;; your code goes here
  (:right val))

(def root (create-node nil))

(defn value [node] ;; <- arglist goes here
  (:value node))

(defn singleton [val] ;; <- arglist goes here ;;cria mapa inicial
  (create-node val))

(defn insert [val node] ;; <- arglist goes here
  (let [node-value (value val)
        right-node (right val)
        left-node (left val)]
    (cond
      (nil? node-value) (assoc node :value val)
      (and (>= val node-value) (nil? right-node) (assoc node :right val))
      (and (< val node-value) (nil? left-node) (assoc node :left val)) ;;update insert
      (>= val node-value) (insert val right-node)
      :else (insert val left-node))))

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