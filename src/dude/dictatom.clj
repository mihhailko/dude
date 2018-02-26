(ns dude.dictatom)

(def dict (atom {:words22 {:form   "words"
                           :primes '("many" "say")
                           :lang   "en"}
                 :sonad34 {:form   "sõnad"
                           :primes '("say" "many")
                           :lang   "ee"}
                 :ember32 {:form   "ember"
                           :primes '("touch")
                           :lang   "en"}
                 :ember76 {:form   "ember"
                           :primes '("people" "one")
                           :lang   "hu"}
                 :are89   {:form   "are"
                           :primes '("there" "exist")
                           :lang   "en"}
                 :cool56  {:form   "cool"
                           :primes '("good")
                           :lang   "en"}
                 :sonad45 {:form   "sõnad"
                           :primes '("many" "say")
                           :lang   "ee"}
                 }))

(defn add-word [form primes lang]
  (let [wrd {(keyword (gensym form)) {:form   form
                                      :primes primes
                                      :lang   lang}}]
             (swap! dict conj wrd)))

(defn findtarl [tar n]
  (let [lang (:lang ((nth (keys @dict) n) @dict))]
                (if (= tar lang)
                  ((nth (keys @dict) n) @dict)
                  (recur tar (inc n)))))

(defn translate2 [form tar dict]
  (let [primes2  (first (filter #(= (:form %) form) (vals dict)))
        primes   (some #(if (= (:form %) form) (:primes %)) (vals dict))
        tar-form (some #(if
                            (and
                             (= (:primes %) primes)
                             (= (:lang %) tar))
                          (:form %)) (vals dict))]
    tar-form))

;; could be useful for sentences

(defn find-list-primes [form dict]
  (let [res (some #(if (= (:form %) form) (:primes %)) (vals dict))]
    res))

(defn to-dudespeak [list dict] 
  (vec (for [x list
             :let   [y (find-list-primes x dict)]]
     y)))

(to-dudespeak '("words" "are" "cool") @dict)
























