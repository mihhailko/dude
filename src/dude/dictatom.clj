(ns dude.dictatom)

(def dict (atom {:words22 {:form "words"
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
                    :lang "en"}}))

(defn add-word [form primes lang]
           (let [wrd {(keyword (gensym form)) {:form form
                                               :primes primes
                                               :lang lang}}]
             (swap! dict conj wrd)))

(defn findtarl [tar n]
              (let [lang (:lang ((nth (keys @dict) n) @dict))]
                (if (= tar lang)
                  ((nth (keys @dict) n) @dict)
                  (recur tar (inc n)))))

(defn findtarp [tar map n]
              (let [p (nth (:primes map) n)]
                (if (= tar p)
                  (:form map)
                  (recur tar map (inc n)))))


(defn findtarm [tar n]
              (let [map ((nth (keys @dict) n) @dict)
                    form (:form map)
                    cnt (count (keys @dict))]
                (if (= tar form)
                  map
                  (recur tar (inc n)))))

(defn translate [form tar]
              (let [f (findtarm form 0)
                    l (findtarl tar 0)
                    p (findtarp (nth (:primes f) 0) l 0)]
                p))

(defn translate2 [form tar dict]
  (let [primes2 (first (filter #(= (:form %) form) (vals dict)))
        primes (some #(if (= (:form %) form) (:primes %)) (vals dict))
        tar-form (some #(if
                          (and
                            (= (:primes %) primes)
                            (= (:lang %) tar))
                          (:form %)) (vals dict))]
tar-form))
