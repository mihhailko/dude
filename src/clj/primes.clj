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

(def twoword )

