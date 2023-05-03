(ns exercism.refactor-ifs)

(defn process-value
  [value]
  (if (and (number? value) (> value 10))
    :pretty-big
    (if (and (number? value) (< value 0))
      :negative
      (if (and (number? value) (zero? value))
        :zero
        (if (number? value)
          :small-number
          (if (string? value)
            :a-string
            :something-else))))))

(defn process-value-cond
  [value]
  (cond
    (string? value) :a-string
    (not (number? value)) :something-else
    (and (number? value) (zero? value)) :zero
    (and (number? value) (> value 10)) :pretty-big
    (and (number? value) (< value 0)) :negative
    :else :small-number))