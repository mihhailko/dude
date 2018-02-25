(ns newdict)

(def dict {:words22 {:form   "words"
                     :primes '("many" "say")
                     :lang   "en"}
           :sonad34 {:form   "sõnad"
                     :primes '("many" "say")
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
                     :lang   "en"}})

(defn find-target-language [tar n]
      (let [lang (:lang ((nth (keys dict) n) dict))]
           (if (= tar lang)
             ((nth (keys dict) n) dict)
             (recur tar (inc n)))))

(defn find-target-primes [tar map n]
      (let [p (nth (:primes map) n)]
           (if (= tar p)
             (:form map)
             (recur tar map (inc n)))))


(defn find-target-meaning [tar n]
      (let [map ((nth (keys dict) n) dict)
            form (:form map)
            cnt (count (keys dict))]
           (if (= tar form)
             map
             (recur tar (inc n)))))

(defn translate [form tar]
      (let [f (find-target-meaning form 0)
            l (find-target-language tar 0)
            p (find-target-primes (nth (:primes f) 0) l 0)]
           p))
