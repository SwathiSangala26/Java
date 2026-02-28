# 1️⃣ Definition

**Transaction Management in JDBC** controls how multiple SQL operations are executed as a single logical unit of work.

A transaction ensures:

* **All operations succeed → Commit**
* **If any fails → Rollback**

This guarantees data consistency.

---

# 2️⃣ Visual Representation

### Without Transaction

```id="t1v9kx"
Update Account A (-100)
        |
        v
System Crash ❌
        |
        v
Account B not updated
```

Money lost ❌ Inconsistent state

---

### With Transaction

```id="p4m8rz"
Begin Transaction
        |
        v
Update Account A (-100)
        |
        v
Update Account B (+100)
        |
        v
Commit
```

If failure:

```id="q8n2fa"
Failure Occurs
        |
        v
Rollback
        |
        v
Database Restored
```

---

# 3️⃣ Key Features / Properties

* Default auto-commit = true
* Supports:

  * commit()
  * rollback()
  * setAutoCommit(false)
* Supports savepoints
* Supports isolation levels
* Not thread-safe
* Works at Connection level

---

# 4️⃣ Syntax

---

## Disable Auto-Commit

```java
con.setAutoCommit(false);
```

---

## Commit Transaction

```java
con.commit();
```

---

## Rollback Transaction

```java
con.rollback();
```

---

## Using Savepoint

```java
Savepoint sp = con.setSavepoint();
con.rollback(sp);
```

---

# 5️⃣ Code Example (Money Transfer Scenario)

```java
import java.sql.*;

public class TransactionDemo {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "password");

        try {

            con.setAutoCommit(false);

            PreparedStatement debit =
                con.prepareStatement(
                    "UPDATE accounts SET balance = balance - 100 WHERE id = 1");

            PreparedStatement credit =
                con.prepareStatement(
                    "UPDATE accounts SET balance = balance + 100 WHERE id = 2");

            debit.executeUpdate();
            credit.executeUpdate();

            con.commit();

        } catch (Exception e) {
            con.rollback();
        }

        con.close();
    }
}
```

---

# 6️⃣ Use Cases

* Banking transactions
* E-commerce order placement
* Payment systems
* Inventory management
* Any multi-step DB operation

---

# 7️⃣ Pitfalls / Notes

* Forgetting to disable auto-commit
* Forgetting commit()
* Not handling rollback properly
* Long-running transactions → DB locks
* Not setting proper isolation level
* Sharing Connection across threads

---

# 8️⃣ Isolation Levels

Isolation level controls how transactions see each other’s data.

---

## Types of Isolation Levels

### 1️⃣ TRANSACTION_READ_UNCOMMITTED

* Can read uncommitted data (Dirty Read possible)

### 2️⃣ TRANSACTION_READ_COMMITTED

* Can read only committed data

### 3️⃣ TRANSACTION_REPEATABLE_READ

* Same row read multiple times gives same result

### 4️⃣ TRANSACTION_SERIALIZABLE

* Highest isolation
* Prevents phantom reads

---

## Setting Isolation Level

```java
con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
```

---

# 9️⃣ ACID Properties

Transaction Management follows **ACID**:

* **Atomicity** → All or nothing
* **Consistency** → DB remains valid
* **Isolation** → Transactions don’t interfere
* **Durability** → Committed changes are permanent

---

# 🔟 Tricky Questions (Continuous Numbering)

---

### 1️⃣ What is default auto-commit value?

**Answer:**
true

---

### 2️⃣ What happens if auto-commit is true?

**Answer:**
Each SQL statement is committed automatically.

---

### 3️⃣ What happens if commit() is not called?

**Answer:**
Changes are rolled back when connection closes.

---

### 4️⃣ Can we rollback after commit?

**Answer:**
No.

---

### 5️⃣ What is dirty read?

**Answer:**
Reading uncommitted data from another transaction.

---

### 6️⃣ Which isolation level prevents dirty reads?

**Answer:**
READ_COMMITTED and above.

---

### 7️⃣ What is phantom read?

**Answer:**
New rows appearing in repeated query execution.

---

### 8️⃣ Which isolation level is safest?

**Answer:**
SERIALIZABLE.

---

### 9️⃣ Does transaction work without disabling auto-commit?

**Answer:**
No.

---

### 🔟 At what level is transaction controlled in JDBC?

**Answer:**
Connection level.

---

# 🧾 Quick Recap / Cheat Sheet

* Default auto-commit = true
* Disable using setAutoCommit(false)
* Use commit() to save
* Use rollback() on failure
* Supports savepoints
* Isolation levels control data visibility
* Follows ACID principles
* Managed at Connection level
* Not thread-safe

---
