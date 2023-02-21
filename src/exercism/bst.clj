(ns exercism.bst)

(defn create-node [val]
  {:left nil :right nil :value val})

(defn left [val] ;; <- arglist goes here
  (:left val))

(defn right [val] ;; <- arglist goes here
  ;; your code goes here
  :right val)

(def root (create-node nil))

(defn value [node] ;; <- arglist goes here
  (:value node))

(defn singleton [val] ;; <- arglist goes here
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

(defn to-list [] ;; <- arglist goes here
  ;; your code goes here
  )

(defn from-list [] ;; <- arglist goes here
  ;; your code goes here
  )


(comment
  )