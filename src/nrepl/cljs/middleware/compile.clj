(ns nrepl.cljs.middleware.compile
  (:require [clojure.tools.nrepl.transport :as t]
            [clojure.tools.nrepl.misc :as m]
            [cljs.compiler :as c]
            [cljs.analyzer :as a]))

(defn f [cljs]
  (c/with-core-cljs
    (let [env (a/empty-env)
          ast (a/analyze env cljs)]
      (with-out-str (c/emit ast)))))

(defn compile-cljs [h]
  (fn [{:keys [op transport code id] :as msg}]
    (if (= op "compile-cljs")
      (t/send transport
              (m/response-for msg
                              :status :done
                              :javascript
                              (f `(cljs.core/identity
                                   (fn [] ~(read-string code))))))
      (h msg))))
