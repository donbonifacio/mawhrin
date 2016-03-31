(ns ^{:added "0.1.0" :author "Pedro Santos"}
  mawhrin.actions
  "Represents possible actions on a board"
  (:require [mawhrin.coordinate :as coordinate]
            [primitive-math :as p]
            [mawhrin.element :as element]
            [mawhrin.board :as board])
  (:import [mawhrin.coordinate Coordinate]
           [mawhrin.element Element]
           [mawhrin.board Board]))

(defn deploy
  "Performs a deploy action"
  [^Board board ^long quantity unit ^Coordinate coord]
  (board/set-coord board coord (element/create coord)))
