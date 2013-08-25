(ns gae.user
  (:gen-class :extends javax.servlet.http.HttpServlet)
  (:require [gae.user-impl :as impl]
            [ring.util.servlet :as ring]))

(defn -service
  [^HttpServlet this
   ^HttpServletRequest rqst
   ^HttpServletRequest resp]
  (do
    (println "gae.user -service method implementation invoked")
    (let [request-map  (ring/build-request-map rqst)
          response-map (impl/theRouter request-map)]
      (when response-map
        (ring/update-servlet-response resp response-map)))))

