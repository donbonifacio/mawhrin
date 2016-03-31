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

(defmethod print-method Element [^Element elem ^java.io.Writer writer]
  (let [coord (.coord elem)]
    (print-method (str "Elem c" (.x coord) (.y coord)) writer)))
