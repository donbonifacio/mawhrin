(ns mawhrin.actions-test
  (:require [clojure.test :refer [deftest testing is run-tests]]
            [criterium.core :refer [quick-bench]]
            [mawhrin.coordinate :as coordinate]
            [mawhrin.actions :as actions]
            [mawhrin.element :as element]
            [mawhrin.board :as board]))

(deftest deploy-action
  (let [board (board/create)
        coord (coordinate/create 1 1)
        unit "rain"
        quantity 100
        deployed-board (actions/deploy board quantity unit coord)]
    (is (board/get-coord deployed-board coord))))
