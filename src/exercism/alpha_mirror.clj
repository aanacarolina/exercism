(ns exercism.alpha-mirror)

(def mirror-chars {\a \z
                   \b \y
                   \c \x
                   \d \w
                   \e \v
                   \f \u
                   \g \t
                   \h \s
                   \i \r
                   \j \q
                   \k \p
                   \l \o
                   \m \n
                   \A \Z
                   \B \Y
                   \C \X
                   \D \W
                   \E \V
                   \F \U
                   \G \T
                   \H \S
                   \I \R
                   \J \Q
                   \K \P
                   \L \O
                   \M \N})

(defn mirror-char [char]
  (get mirror-chars char char))

(defn mirror [sentence]
 (apply str (map mirror-char sentence)))

(mirror "My horse is Amazing.")

