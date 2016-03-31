(ns ^{:added "0.1.0" :author "Pedro Santos"}
  mawhrin.board
  "Represents a board"
  (:import [mawhrin.coordinate Coordinate]
           [mawhrin.element Element])
  (:require [mawhrin.coordinate :as coordinate]
            [primitive-math :as p]
            [criterium.core :refer [quick-bench]]
            ))

(defrecord Board
  [elements])

(defn create
  "Creates a board"
  []
  (Board. nil))

(defn ^Element get-coord
  "Gets the element for the given coordinate"
  [^Board board ^Coordinate coord]
  (get-in board [:elements coord]))

(defn ^Board set-coord
  "Sets an element on a coordinate"
  [^Board board ^Coordinate coord ^Element elem]
  (update board :elements assoc coord elem))

(defn empty-coord?
  "Checks if an element can be placed"
  [^Board board ^Coordinate coord]
  (and
    (coordinate/in-bounds? coord)
    (nil? (get-coord board coord))))
