(ns ^{:added "0.1.0" :author "Pedro Santos"}
  mawhrin.element
  "Represents an element on the board"
  (:refer-clojure :exclude [get])
  (:import [mawhrin.coordinate Coordinate])
  (:require [mawhrin.coordinate :as coord]))

(deftype Element
  [^Coordinate coord])

(defn create
  "Creates an element"
  [^Coordinate coord]
  (Element. coord))
