# 1️⃣ Definition

A **Connection** in JDBC represents a session between a Java application and a database.

It is created using:

```java
DriverManager.getConnection()
```

The `Connection` object:

* Establishes communication with the database
* Manages transactions
* Creates Statement/PreparedStatement/CallableStatement
* Controls auto-commit behavior

Without Connection → No database interaction.

---

# 2️⃣ Visual Representation

### Where Connection Fits in Architecture

```
Java Application
        |
        v
DriverManager / DataSource
        |
        v
   Connection   ← (Session with DB)
        |
        v
Statement / PreparedStatement
        |
        v
Database
```

---

### Lifecycle of a Connection

```
Load Driver (Auto in JDBC 4+)
        |
        v
Get Connection
        |
        v
Execute SQL
        |
        v
Commit / Rollback
        |
        v
Close Connection
```

---

# 3️⃣ Key Features / Properties

* Represents a DB session
* Not thread-safe
* Supports transaction management
* Default auto-commit = true
* Creates Statement objects
* Can be closed to release resources
* Can set isolation levels
* Supports savepoints

---

# 4️⃣ Syntax

## Creating a Connection

```java
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/testdb",
    "root",
    "password"
);
```

---

## Using DataSource (Enterprise Way)

```java
DataSource ds = ...;
Connection con = ds.getConnection();
```

---

## Disabling Auto-Commit

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

## Closing Connection

```java
con.close();
```

---

# 5️⃣ Code Example (Complete Flow)

```java
import java.sql.*;

public class ConnectionDemo {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        Connection con = DriverManager.getConnection(url, user, password);

        con.setAutoCommit(false);

        PreparedStatement ps =
                con.prepareStatement("UPDATE users SET name=? WHERE id=?");

        ps.setString(1, "Swathi");
        ps.setInt(2, 1);

        ps.executeUpdate();

        con.commit();

        ps.close();
        con.close();
    }
}
```

---

# 6️⃣ Use Cases

* Creating database session
* Managing transactions
* Setting isolation level
* Creating statements
* Handling savepoints

---

# 7️⃣ Pitfalls / Notes

* Not closing Connection → Connection leak
* Sharing Connection between threads → Unsafe
* Keeping Connection open too long
* Opening Connection inside loop
* Forgetting commit() when auto-commit disabled
* Hardcoding DB credentials

---

# 8️⃣ Real-World Analogy

```
Connection = Phone Call Between You and Bank

You dial → Call connected → Perform operations →
Confirm transaction → End call
```

If you don’t hang up → Line remains busy (Connection leak).

---

# 9️⃣ Best Practices

* Use try-with-resources
* Use connection pooling (DataSource)
* Disable auto-commit for grouped operations
* Always close Connection in finally block (or auto close)
* Do not share across threads
* Keep Connection short-lived

---

# 🔟 Tricky Questions (Continuous Numbering)

---

### 1️⃣ Is Connection thread-safe?

**Answer:**
No.

---

### 2️⃣ What is default auto-commit value?

**Answer:**
true

---

### 3️⃣ What happens if commit() is not called when auto-commit is false?

**Answer:**
Changes are rolled back when connection closes.

---

### 4️⃣ What happens internally when close() is called?

**Answer:**

* Releases DB session
* Frees network resources
* Returns connection to pool (if pooled)

---

### 5️⃣ Can we reuse a closed Connection?

**Answer:**
No. It throws SQLException.

---

### 6️⃣ Why is Connection expensive?

**Answer:**
Because it involves:

* Network handshake
* Authentication
* Resource allocation on DB

---

### 7️⃣ Difference between DriverManager and DataSource for Connection?

**Answer:**
DriverManager → Basic, no pooling
DataSource → Supports connection pooling

---

### 8️⃣ What is transaction isolation level?

**Answer:**
It defines how transactions are isolated from each other.

Example:

```java
con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
```

---

### 9️⃣ Can multiple Statements be created from one Connection?

**Answer:**
Yes.

---

### 🔟 Why should we avoid creating Connection inside loop?

**Answer:**
It repeatedly creates expensive DB sessions → performance issue.

---

# 🧾 Quick Recap / Cheat Sheet

* Connection = Session with DB
* Created via getConnection()
* Not thread-safe
* Auto-commit = true by default
* Used for transaction control
* Must be closed always
* Expensive operation
* Use connection pooling in enterprise apps

---
