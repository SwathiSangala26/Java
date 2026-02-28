# 1️⃣ Definition

**Batch Processing in JDBC** is a feature that allows multiple SQL statements to be grouped together and executed in a single database call.

Instead of sending queries one by one:

```
Insert 1 → DB
Insert 2 → DB
Insert 3 → DB
```

Batch sends them together:

```
Insert 1
Insert 2
Insert 3
   ↓
Single DB Call
```

This improves performance and reduces network overhead.

---

# 2️⃣ Visual Representation

### Without Batch

```id="a7k2fd"
Java App
   |
   v
Insert 1  → DB
Insert 2  → DB
Insert 3  → DB
```

Multiple network round trips ❌

---

### With Batch

```id="b9mp3s"
Java App
   |
   v
Add to Batch
Add to Batch
Add to Batch
   |
   v
executeBatch()
   |
   v
Database (Single Call)
```

Single round trip ✔

---

# 3️⃣ Key Features / Properties

* Reduces network calls
* Improves performance
* Executes multiple statements at once
* Returns array of update counts
* Works with:

  * Statement
  * PreparedStatement
* Supports transaction control
* Not thread-safe

---

# 4️⃣ Syntax

---

## Using Statement

```java
Statement stmt = con.createStatement();

stmt.addBatch("INSERT INTO users VALUES(1,'A')");
stmt.addBatch("INSERT INTO users VALUES(2,'B')");

int[] result = stmt.executeBatch();
```

---

## Using PreparedStatement (Preferred)

```java
PreparedStatement ps =
    con.prepareStatement("INSERT INTO users VALUES (?, ?)");

ps.setInt(1, 1);
ps.setString(2, "A");
ps.addBatch();

ps.setInt(1, 2);
ps.setString(2, "B");
ps.addBatch();

int[] result = ps.executeBatch();
```

---

## Clearing Batch

```java
ps.clearBatch();
```

---

# 5️⃣ Code Example (Best Practice Version)

```java
import java.sql.*;

public class BatchProcessingDemo {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "password");

        con.setAutoCommit(false);

        PreparedStatement ps =
                con.prepareStatement("INSERT INTO users VALUES (?, ?)");

        for (int i = 1; i <= 3; i++) {
            ps.setInt(1, i);
            ps.setString(2, "User" + i);
            ps.addBatch();
        }

        int[] results = ps.executeBatch();

        con.commit();

        ps.close();
        con.close();
    }
}
```

---

# 6️⃣ Use Cases

* Bulk insert operations
* Data migration
* Importing CSV files
* Log processing
* Batch updates in enterprise systems

---

# 7️⃣ Pitfalls / Notes

* Forgetting executeBatch()
* Not handling partial failures
* Large batch size → memory issue
* Not disabling auto-commit
* Not clearing batch after execution

If auto-commit = true → each statement may commit individually.

---

# 8️⃣ Real-World Analogy

```id="m4pv8d"
Without Batch → Sending 100 courier packages separately
With Batch → Sending all packages in one shipment
```

Batch saves time and cost.

---

# 9️⃣ Best Practices

* Use PreparedStatement for batch
* Disable auto-commit before batch
* Commit after executeBatch()
* Handle BatchUpdateException
* Use reasonable batch size (e.g., 500–1000)
* Clear batch after execution
* Close resources properly

---

# 🔟 Tricky Questions (Continuous Numbering)

---

### 1️⃣ What does executeBatch() return?

**Answer:**
int[] containing update counts for each statement.

---

### 2️⃣ Why is batch processing faster?

**Answer:**
Because it reduces network round trips and database calls.

---

### 3️⃣ What exception is thrown if batch fails?

**Answer:**
BatchUpdateException.

---

### 4️⃣ Should auto-commit be disabled during batch?

**Answer:**
Yes, for proper transaction control.

---

### 5️⃣ Can batch processing be used with PreparedStatement?

**Answer:**
Yes (preferred way).

---

### 6️⃣ What happens if one statement fails in batch?

**Answer:**
Depends on driver; partial execution may occur.

---

### 7️⃣ Is batch processing thread-safe?

**Answer:**
No.

---

### 8️⃣ How to remove all statements from batch?

**Answer:**
clearBatch().

---

### 9️⃣ Does batch processing improve performance for single insert?

**Answer:**
No.

---

### 🔟 When should batch processing be avoided?

**Answer:**
When:

* Only one query is executed
* Very small data size
* Memory constraints exist

---

# 🧾 Quick Recap / Cheat Sheet

* Used for bulk operations
* addBatch() → executeBatch()
* Returns int[]
* Disable auto-commit
* Improves performance
* Preferred with PreparedStatement
* Not thread-safe
* Clear batch after execution
* Handles BatchUpdateException

---
