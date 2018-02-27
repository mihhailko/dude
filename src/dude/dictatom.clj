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

;; to translate if the primes' lists are identical

(defn translate2 [form tar dict]
  (let [primes2  (first (filter #(= (:form %) form) (vals dict)))
        primes   (some #(if (= (:form %) form) (:primes %)) (vals dict))
        tar-form (some #(if
                            (and
                             (= (:primes %) primes)
                             (= (:lang %) tar))
                          (:form %)) (vals dict))]
    tar-form))

;; to convert into dudespeak - could be fun and useful for sentences

(defn find-list-primes [form dict]
  (let [res (some #(if (= (:form %) form) (:primes %)) (vals dict))]
    res))

(defn to-dudespeak [list dict] 
  (vec (for [x list
             :let   [y (find-list-primes x dict)]]
     y)))

(to-dudespeak '("words" "are" "cool") @dict)

(defn match-primes [lst tarlst]
  (for [x lst
        y tarlst
              :let [z ((partial = y) x)]]
    z))

(defn test-if-primes-match [seq]
  (let [cnt   (/ (count seq) 2)
        trcnt (count (filter #(= true %) seq))]
    (if (>= trcnt (* 3/4 cnt)) 
      true
      false
  )))

;; to translate while looking for a match over several primes in random order

(defn translate3 [form src tar dict]
  (let [src-primes (some #(if (and
                               (= (:form %) form)
                               (= (:lang %) src))
                            (:primes %)) (vals dict))
        tar-form   (some #(if (and
                               (= (:lang %) tar)
                               (test-if-primes-match (match-primes src-primes (:primes %))))
                            (:form %)) (vals dict))]
    tar-form))

(translate3 "words" "en" "ee" @dict)



















