(ns exercism.almighty-reduce)

(defn long-lengths
  [strings]
  (map count
       (filter (fn [string]
                 (< 5 (count string)))
               strings)))

;Refactor the following code to use a single reduce instead of a map and filter:

;return the count of letter of words that are bigger than 5 letters

(defn long-lengths-two [strings]
  (reduce (fn [acc string]
            (let [str-len (count string)]
              (if (< 5 str-len)
                (conj acc str-len)
                acc))) () strings))

#_(defn (Often) If what you are feeding ‘reduce’ is not the form you want to end with, you probably need to seed it with a value. For example, if you’re giving reduce a string, but you want your result to be a number, give it the value of 0. - Robert)
