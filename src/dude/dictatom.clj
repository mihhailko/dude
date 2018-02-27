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


<<<<<<< HEAD
=======
(defn translate [form tar]
  (let [f (findtarm form 0)
        l (findtarl tar 0)
        p (findtarp (nth (:primes f) 0) l 0)]
                p))

>>>>>>> b34c112788f202c264eb4ab8a87f5df064669208
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


;; to match over several primes in random order

(defn findtarm [tar n dict]
  (let [map  ((nth (keys dict) n) dict)
        form (:form map)
        cnt  (count (keys dict))]
                (if (= tar form)
                  map
                  (recur tar (inc n) dict))))
<<<<<<< HEAD
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






=======

(defn translate3 [form tar dict]
  (let [primes2  (first (filter #(= (:form %) form) (vals dict)))
        primes   (some #(if (= (:form %) form) (:primes %)) (vals dict))
        tar-form (some #(if
                            (and
                             (= (:primes %) primes)
                             (= (:lang %) tar))
                          (:form %)) (vals dict))]
    tar-form))

(translate3 "words" "ee" @dict)

(filter #(= (:primes %) '("say" "many")) (vals @dict))

(filter #(= (:primes %) '("say" "many")) (vals @dict))

(some #(if (= (:form %) "words") (:primes %)) (vals @dict))

(some #(if (= (:primes %) '("many" "say")) (:form %)) (vals @dict))

(defn findtarp [tar map n]
  (let [p (nth (:primes map) n)]
                (if (= tar p)
                  (:form map)
                  (recur tar map (inc n)))))

(some (partial = "say") '("many" "say"))

(findtarm "words" 0 @dict)

(def srcmap (find-list-primes "words" @dict))

(def tarmap (find-list-primes "sõnad" @dict))
>>>>>>> b34c112788f202c264eb4ab8a87f5df064669208





















