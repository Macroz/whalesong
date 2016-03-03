(ns whalesong.core
  (:require [aleph.http :as http]
            [manifold.stream :as s]))

(defn connect [url]
  (let [s @(http/websocket-client url)]
    s))

(defn send [msg]
  (let [ws (connect "ws://localhost:8887/ws")]
    (println "Writing")
    (s/put! ws msg)
    (println "Reading")
    @(s/take! ws)))


