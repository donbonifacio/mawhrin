(ns mawhrin.board-test
  (:require [clojure.test :refer [deftest testing is run-tests]]
            [criterium.core :refer [quick-bench]]
            [mawhrin.coordinate :as coordinate]
            [mawhrin.element :as element]
            [mawhrin.board :as board]))

(deftest create-board
  (let [board (board/create)
        c11 (coordinate/create 1 1)]
    (is board)
    (is (nil? (board/get board c11)))
    (is (board/empty-coord? board c11))
    (let [elem (element/create c11)
          board (board/set board c11 elem)]
      (is (= elem (board/get board c11)))
      (is (false? (board/empty-coord? board c11))))))
