(ns user
  (:require [nextjournal.clerk :as clerk]
            [your-project.index :as index]))

(clerk/serve! {:port 7878 :browse true})

(comment
  (clerk/build! {:paths ["src/your_project/index.clj"] :browse true}))

