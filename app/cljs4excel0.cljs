; Copy of cljs4excel.cljs, but as one liners before I figure out how to load these files properly..
(defn js->fn [fn js] (fn (js->clj js)))
(defn binding->fn [fn id type cc rc] (fn {:id id :type type :cc cc :rc rc}))
(defn binding-data->fn [fn id type cc rc data] (fn {:id id :type type :cc cc :rc rc :data (js->clj data)}))
(defn get-selection [fn] (.getSelection js/app (partial js->fn fn)))
(defn set-selection! [matrix] (.setSelection js/app (clj->js matrix)))
(defn add-binding-named-item [name id fn] (.addBindingFromNamedItem js/app name id (partial binding->fn fn)))
(defn add-binding-prompt [id fn] (.addBindingFromPrompt js/app id (partial binding->fn fn)))
(defn add-binding-selection [id fn] (.addBindingFromSelection js/app id (partial binding->fn fn)))
(defn get-all-bindings [fn] (.getAllBindings js/app (partial js->fn fn)))
(defn get-binding-details [id fn] (.getBindingDetails js/app id (partial binding->fn fn)))
(defn get-binding-data [id fn] (.getBindingData js/app id (partial binding-data->fn fn)))
(defn set-binding-data! [id matrix] (.setBindingData js/app id (clj->js matrix)))
(defn add-binding-data-event [id fn] (.addBindingDataEvent js/app id fn))
(defn remove-binding [id] (.removeBinding js/app id))
(defn remove-binding-data-event [id] (.removeBindingDataEvent js/app id))

(println "cljs4excel ready..")