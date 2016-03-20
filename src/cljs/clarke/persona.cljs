(ns clarke.persona
  (:require [goog.dom :as gdom]
            [om.next :as om :refer-macros [defui]]
            [om.dom :as dom]))

(defui Persona
  static om/Ident
  (ident [this {:keys [name]}]
    [:persona/by-name name])
  static om/IQuery
  (query [this]
    '[:name :description :age])
  Object
  (render [this]
    (let [{:keys [points name] :as props} (om/props this)]
      (dom/li nil
        (dom/label nil (str name ", age: " age))))))

(def persona (om/factory Persona {:keyfn :name}))
