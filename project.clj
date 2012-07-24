(defproject nrepl-cljs-middleware "1.0.0-SNAPSHOT"
  :description "middleware for nrepl that does cljs compilation"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/tools.nrepl "0.2.0-beta8"]
                 [org.clojure/clojurescript "0.0-1443"
                  :exclusions [org.apache.ant/ant]]])
