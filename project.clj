(defproject mawhrin "0.1.0"
  :description "Orion's Belt BattleGrounds Game"
  :url "https://github.com/donbonifacio/mawhrin"

  :license {:name         "MPLv2"
            :distribution :repo}

  :min-lein-version "2.6.0"

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-tuple "0.2.2"]
                 [primitive-math "0.1.5"]]

  :scm {:name "git"
        :url "git@github.com:donbonifacio/mawhrin.git"}

  :aliases {"autotest" ["with-profile" "+test" "test-refresh"]}

  :profiles {:test {:dependencies [[criterium "0.4.4"]]
                    :global-vars {*warn-on-reflection* true
                                  *assert* false}
                    :plugins [[com.jakemccrary/lein-test-refresh "0.14.0"]]}})

