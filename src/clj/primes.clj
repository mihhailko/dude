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


;; map-oriented approach w/o dictionary

(defn defsentence [subject predicate] {:subject subject :predicate predicate})

(defn defword [form meaning] {:form form :meaning meaning})

(defn get-meaning [sentence]
  (let [{s :subject p :predicate} sentence]
    [(:meaning s) (:meaning p)]))

(defn get-forms [sentence]
  (let [{s :subject p :predicate} sentence]
    [(:form s) (:form p)]))

(def start (defword "start" ["when after not happen now do happen"]))

(def i (defword "I" ["you one can think do live now here"]))

(def sent (defsentence i start))

(get-meaning sent)

(get-forms sent)


;; some macro stuff

(defmacro deffword [symbol form & primes]
  `(def ~symbol '{:form ~form :primes ~primes}))

(deffword new-i "i" "you" "one" "can" "think" "do" "live" "now" "here")

(deffword new-start "start" "when" "after" "not" "happen" "now" "do" "happen")

(defmacro deffsentence [symbol subject predicate]
  `(def ~symbol (defsentence ~subject ~predicate)))

(deffsentence stc new-i new-start)

(defn print-primes [sentence] (do (println (-> sentence :subject :primes))
  (println (-> sentence :predicate :primes))))
