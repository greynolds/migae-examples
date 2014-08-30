(ns gae2.main-impl
  (:use compojure.core)
  (:require [compojure.route :as route])
  (:import com.google.apphosting.api.ApiProxy
           com.google.appengine.api.memcache.MemcacheService))

(defroutes theRouter
  (GET "/hello" [] "<h1>Hello World from gae2.main servlet!</h1>")
  (GET "/goodbye" [] "<h1>Goodbye World! from gae2.main servlet!</h1>")
  (GET "/stats" []
    (str "<ul>"
         "<li>" (format "Runtime env: %s"
                        (System/getProperty "com.google.appengine.runtime.environment"))
         "</li><li>"
         (format "Remaining millis: %s"
                 (.getRemainingMillis
                  (ApiProxy/getCurrentEnvironment)))
         "</li></ul>"))
  (route/not-found "<h1>Main page not found</h1>"))

