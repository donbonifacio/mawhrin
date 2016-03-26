(ns ^{:added "0.1.0" :author "Pedro Santos"}
  mawhrin.coordinate
  "Representes a board coordinate, has several utility funcions"
  (:refer-clojure :exclude [get])
  (:require [primitive-math :as p]))

(deftype Coordinate [^long x ^long y])

(defn ^Coordinate create
  "Creates a coordinate representation"
  [^long x ^long y]
  (Coordinate. x y))

(defn ^Coordinate get
  "Gets a coordinate"
  [^long x ^long y]
  (create x y))

(defn adjacent?
  "Checks if two coordinates are adjacent"
  [^Coordinate c1 ^Coordinate c2]
  (let [dx (p/- (.x c1) (.x c2))
        dy (p/- (.y c1) (.y c2))]
    (and
      (p/< -2 dx)
      (p/> 2 dx)
      (p/< -2 dy)
      (p/> 2 dy))))

(defn in-bounds?
  "Checks if a given coord is in the board"
  [^Coordinate c]
  (and
    (p/> (.x c) 0)
    (p/> (.y c) 0)
    (p/<= (.x c) 8)
    (p/<= (.y c) 8)))
