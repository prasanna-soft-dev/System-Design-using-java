/*Design a system with following functionalities,
1.	SET a variable
2.	GET a variable
3.	UNSET a variable
4.	COUNT NUMBERS OF VARIABLE with given value
5.	BEGIN — Begins a new transaction
6.	ROLLBACK — Roll back all the commands in the open transaction
7.	COMMIT — Commit the transaction */

import java.util.HashMap;
import java.util.Stack;

public class SetGetRollbackCommit {
    private HashMap<String, String> store = new HashMap<>();
    private Stack<HashMap<String, String>> storeTransaction = new Stack<>();

    public SetGetRollbackCommit() {
        this.store = new HashMap<>();
        this.storeTransaction = new Stack<>();
    }

    // SET a variable
    public void set(String key, String value) {
        if (storeTransaction.isEmpty()) {
            store.put(key, value);
        } else {
            storeTransaction.peek().put(key, value);
        }
    }

    // GET a variable
    public String get(String key) {
        if (!storeTransaction.isEmpty() && storeTransaction.peek().containsKey(key)) {
            return storeTransaction.peek().get(key);
        }
        return store.getOrDefault(key, null);
    }

    // UNSET a variable
    public void unset(String key) {
        if (storeTransaction.isEmpty()) {
            store.remove(key);
        } else {
            storeTransaction.peek().put(key, null);
        }
    }

    // COUNT variables with a given value
    public int count(String value) {
        int count = 0;
        HashMap<String, String> tempStore = new HashMap<>(store);

        if (!storeTransaction.isEmpty()) {
            tempStore.putAll(storeTransaction.peek());
        }

        for (String v : tempStore.values()) {
            if (value.equals(v)) {
                count++;
            }
        }

        return count;
    }

    // UPDATE a variable
    public void update(String key, String value) {
        if (store.containsKey(key) || (!storeTransaction.isEmpty() && storeTransaction.peek().containsKey(key))) {
            set(key, value);
        } else {
            System.out.println("No variable named \"" + key + "\"");
        }
    }

    // BEGIN a new transaction
    public void begin() {
        storeTransaction.push(new HashMap<>());
    }

    // ROLLBACK a transaction
    public void rollBack() {
        if (!storeTransaction.isEmpty()) {
            storeTransaction.pop();
        } else {
            System.out.println("NO TRANSACTION");
        }
    }

    // COMMIT a transaction
    public void commit() {
        if (!storeTransaction.isEmpty()) {
            HashMap<String, String> changes = storeTransaction.pop();
            for (String key : changes.keySet()) {
                if (changes.get(key) == null) {
                    store.remove(key);
                } else {
                    store.put(key, changes.get(key));
                }
            }
            while (!storeTransaction.isEmpty()) {
                commit();
            }
        } else {
            System.out.println("NO TRANSACTION");
        }
    }

    public static void main(String[] args) {
        SetGetRollbackCommit vs = new SetGetRollbackCommit();

                // 1. SET a variable
                vs.set("a", "10");
                System.out.println("GET a: " + vs.get("a")); // Should print: GET a: 10
        
                // 2. BEGIN a new transaction
                vs.begin();
        
                // 3. SET a variable within the transaction
                vs.set("a", "20");
                System.out.println("GET a: " + vs.get("a")); // Should print: GET a: 20
        
                // 4. BEGIN another transaction
                vs.begin();
        
                // 5. SET a variable within the nested transaction
                vs.set("a", "30");
                System.out.println("GET a: " + vs.get("a")); // Should print: GET a: 30
        
                // 6. UNSET a variable within the nested transaction
                vs.unset("a");
                System.out.println("GET a: " + vs.get("a")); // Should print: GET a: null
        
                // 7. ROLLBACK the nested transaction
                vs.rollBack();
                System.out.println("GET a: " + vs.get("a")); // Should print: GET a: 20
        
                // 8. COMMIT the outer transaction
                vs.commit();
                System.out.println("GET a: " + vs.get("a")); // Should print: GET a: 20
        
                // 9. COUNT variables with a given value
                System.out.println("COUNT 10: " + vs.count("10")); // Should print: COUNT 10: 1
                System.out.println("COUNT 20: " + vs.count("20")); // Should print: COUNT 20: 1
                System.out.println("COUNT 30: " + vs.count("30")); // Should print: COUNT 30: 0
        
                // 10. UNSET the variable "a"
                vs.unset("a");
                System.out.println("GET a: " + vs.get("a")); // Should print: GET a: null
        
                // 11. ROLLBACK when no transaction is active
                vs.rollBack(); // Should print: NO TRANSACTION
        
                // 12. BEGIN a new transaction and SET variable
                vs.begin();
                vs.set("b", "40");
                System.out.println("GET b: " + vs.get("b")); // Should print: GET b: 40
        
                // 13. COMMIT the transaction
                vs.commit();
                System.out.println("GET b: " + vs.get("b")); // Should print: GET b: 40
        
                // 14. COUNT variables with a given value after commit
                System.out.println("COUNT 40: " + vs.count("40")); // Should print: COUNT 40: 1
    }
}
