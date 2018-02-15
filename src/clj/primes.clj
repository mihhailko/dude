(ns primes)

(use 'clojure.walk)

(def primes {:this "this" :is "is" :something "something"})

(def syntax '(:subject :predicate))

(def dictionary {:oneword "oneword" :twoword "twoword" :threeword "threeword"})

(defn word [dictentry primentry syntax] {syntax dictentry :meaning primentry})

(keywordize-keys (word (:oneword dictionary)(:something primes):subject)) ;;probably unnecessary

(def oneword (word (:oneword dictionary)(:something primes):subject))

(defn meaning [word] (:meaning word))

(meaning oneword)

(defn role [word] (nth (keys word) 0))

(role oneword)

(def twoword (word (:twoword dictionary)[(:is primes)(:something primes)] :predicate))

(defn print-sentence [word1 word2]
  (if (and (:subject word1) (:predicate word2))
    (println (:subject word1) (:predicate word2))
    (println (:subject word2) (:predicate word1))))

(defn meaning-sentence [word1 word2]
  (if (and (:subject word1) (:predicate word2))
    [(:meaning word1)(:meaning word2)]
    [(:meaning word2)(:meaning word1)]))

(meaning-sentence oneword twoword)


