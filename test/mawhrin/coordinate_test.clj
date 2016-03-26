(ns mawhrin.coordinate-test
  (:require [clojure.test :refer [deftest testing is run-tests]]
            [criterium.core :refer [quick-bench]]
            [mawhrin.coordinate :as coordinate]))

(deftest create-coordinate
  (is (coordinate/create 1 1)))

(deftest get-coordinate
  (is (coordinate/get 1 1)))

(deftest adjacent-test
  (testing "adjacent"
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 1 2)))
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 1 3)))
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 2 1)))
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 2 2)))
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 2 3)))
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 3 1)))
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 3 2)))
    (is (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 3 3))))
  (testing "not coordinate/adjacent"
    (is (not (coordinate/adjacent? (coordinate/get 2 2) (coordinate/get 4 4))))))

(deftest in-bounds-test
  (is (coordinate/in-bounds? (coordinate/get 1 1)))
  (is (coordinate/in-bounds? (coordinate/get 4 4)))
  (is (not (coordinate/in-bounds? (coordinate/get 0 0))))
  (is (not (coordinate/in-bounds? (coordinate/get 1 0))))
  (is (not (coordinate/in-bounds? (coordinate/get 1 9))))
  (is (not (coordinate/in-bounds? (coordinate/get 1 20))))
  (is (not (coordinate/in-bounds? (coordinate/get 1 -2))))
  (is (not (coordinate/in-bounds? (coordinate/get 9 9)))))
