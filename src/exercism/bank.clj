(ns exercism.bank)

(def accts {:accounts {0 {:balance 10 :status "open"}
                       1 {:balance 0 :status "open"}
                       2 {:balance 100 :status "open"}
                       3 {:balance 10 :status "closed"}}})


(defn create-account
  [state account-id]
  (assoc-in state [:accounts account-id] {:balance 0 :status "open"}))
;TO DO ID criada

(defn make-deposit
  [state account-id amount]
  (assoc-in state [:accounts account-id] {:balance (+ (get-in state [:accounts account-id :balance]) amount)}))

(defn make-deposit-up
  [state account-id amount]
  (update-in state
             [:accounts account-id :balance ]
             + amount))

(defn account-closed
  [state account-id]
       (get-in state [:accounts account-id :status]))

(defn withdrawal
  [state account-id amount]
  (let [balance (get-in state [:accounts account-id :balance])]
    (if (< 0 (- amount balance))
      (throw (ex-info "Insuficient funds" {:account-id account-id :balance balance :amount amount :account "closed"}))
      (update-in state
                 [:accounts account-id :balance]
                 - amount))))

(defn close-account
  [state account-id]
  (update state
          :accounts
          dissoc account-id))

(defn close-account-status
  [state account-id status]
  (update-in state
             [:accounts account-id :status]
             assoc status "closed"))

(defn close-account-balance
  [state account-id]
  (let [balance (get-in state [:accounts account-id :balance])]
    (if (> balance 0)
      (throw (ex-info "Balance is not zero" {:account-id account-id}))
      (assoc-in state
                [:accounts account-id :status]
                "closed"))))



(comment
  (create-account accts 0)
  (make-deposit-up accts 3 350)
  (make-deposit-up accts 1 10)
  (make-deposit accts 0 10)
  (close-account-balance accts 1)
  (withdrawal accts 0 5)
(withdrawal accts 3 5)
  (close-account-status accts 1 "closed"))




