(ns ^{:added "0.1.0" :author "Pedro Santos"}
  mawhrin.board
  "Represents a board"
  (:refer-clojure :exclude [get set])
  (:import [mawhrin.coordinate Coordinate]
           [mawhrin.element Element])
  (:require [mawhrin.coordinate :as coordinate]
            [primitive-math :as p]
            [criterium.core :refer [quick-bench]]
            ))

(deftype Board
  [^objects elements])

(defn create
  "Creates a board"
  []
  (Board. (make-array Element (p/* 8 8))))

(defn ^Element get
  "Gets the element for the given coordinate"
  [^Board board ^Coordinate coord]
  (let [pos (p/* (.x coord) (.y coord))
        ^objects elements (.elements board)]
    (aget elements pos)))

(defn ^Board set
  "Sets an element on a coordinate"
  [^Board board ^Coordinate coord ^Element elem]
  (let [^objects elems (.elements board)
        pos (p/* (.x coord) (.y coord))]
    (aset elems pos elem)
    board))

(defn empty-coord?
  "Checks if an element can be placed"
  [^Board board ^Coordinate coord]
  (and
    (coordinate/in-bounds? coord)
    (nil? (get board coord))))
