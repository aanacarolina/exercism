(ns exercism.lasagna)

(def expected-time 40)

(defn remaining-time
  [minutes-in-oven]
  (let [result (- expected-time minutes-in-oven)]
    (cond
      (= result 0) 0
      (< minutes-in-oven 0) expected-time
      (> minutes-in-oven expected-time) 0
      :else result)))

(defn prep-time
  [layers]
  (* layers 2))

(defn total-time
  [layers minutes-in-oven]
    (+ (prep-time layers) minutes-in-oven))


