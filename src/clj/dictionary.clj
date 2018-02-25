(ns dictionary)

(def dict {:words22 {:form "words"
                    :primes '("many" "say")
                    :lang "en"}
           :sonad34 {:form "sõnad"
                    :primes '("many" "say")
                    :lang "ee"}
           :ember32 {:form "ember"
                    :primes '("touch")
                    :lang "en"}
           :ember76 {:form "ember"
                    :primes '("people" "one")
                    :lang "hu"}
           :are89 {:form "are"
                  :primes '("there" "exist")
                  :lang "en"}
           :cool56 {:form "cool"
                   :primes '("good")
                    :lang "en"}})

(defn findtarl [tar n]
              (let [lang (:lang ((nth (keys dict) n) dict))]
                (if (= tar lang)
                  ((nth (keys dict) n) dict)
                  (recur tar (inc n)))))

(defn findtarp [tar map n]
              (let [p (nth (:primes map) n)]
                (if (= tar p)
                  (:form map)
                  (recur tar map (inc n)))))



