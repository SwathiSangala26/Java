# 1️⃣ Definition

A **Statement** in JDBC is an interface used to execute static SQL queries against the database.

It is created from a `Connection` object and is mainly used for:

* Executing simple SQL queries
* Running SQL statements without parameters
* Executing DDL (CREATE, DROP, ALTER)

It does **not support parameter placeholders (?)**.

---

# 2️⃣ Visual Representation

### Where Statement Fits

```
Java Application
        |
        v
Connection
        |
        v
Statement
        |
        v
Database
        |
        v
ResultSet (for SELECT)
```

---

### Execution Flow

```
Create Connection
        |
        v
Create Statement
        |
        v
Execute SQL
        |
        v
ResultSet / Update Count
```

---

# 3️⃣ Key Features / Properties

* Executes static SQL
* No parameter support
* SQL compiled every time
* Vulnerable to SQL Injection
* Can execute:

  * SELECT
  * INSERT
  * UPDATE
  * DELETE
  * DDL statements
* Returns ResultSet (for SELECT)
* Returns int (for DML)

---

# 4️⃣ Syntax

## Creating Statement

```java
Statement stmt = con.createStatement();
```

---

## Executing SELECT

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
```

---

## Executing INSERT / UPDATE / DELETE

```java
int rows = stmt.executeUpdate("UPDATE users SET name='Swathi' WHERE id=1");
```

---

## Generic Execute

```java
boolean result = stmt.execute("SELECT * FROM users");
```

---

# 5️⃣ Code Example

```java
import java.sql.*;

public class StatementDemo {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
```

---

# 6️⃣ Use Cases

* Executing static queries
* Running DDL commands
* Simple applications
* Admin scripts

---

# 7️⃣ Pitfalls / Notes

* SQL Injection risk
* Query compiled every execution (performance issue)
* Not suitable for dynamic queries
* Should not concatenate user input
* Not efficient for repeated queries

Example of bad practice:

```java
String query = "SELECT * FROM users WHERE name='" + userInput + "'";
```

This is vulnerable to SQL Injection.

---

# 8️⃣ Real-World Analogy

```
Statement = Writing a fresh order every time in a restaurant.

Every time you order → kitchen processes from scratch.
No pre-preparation.
```

---

# 9️⃣ Best Practices

* Avoid using Statement for user input
* Prefer PreparedStatement
* Close Statement after use
* Do not reuse for different dynamic queries
* Use for DDL only in most cases

---

# 🔟 Tricky Questions (Continuous Numbering)

---

### 1️⃣ Can Statement prevent SQL Injection?

**Answer:**
No.

---

### 2️⃣ Is Statement precompiled?

**Answer:**
No. SQL is compiled every time.

---

### 3️⃣ What does executeQuery() return?

**Answer:**
ResultSet.

---

### 4️⃣ What does executeUpdate() return?

**Answer:**
int (number of affected rows).

---

### 5️⃣ What does execute() return?

**Answer:**
boolean (true if ResultSet, false if update count).

---

### 6️⃣ Can we reuse the same Statement for multiple queries?

**Answer:**
Yes, but not recommended for dynamic queries.

---

### 7️⃣ Is Statement thread-safe?

**Answer:**
No.

---

### 8️⃣ Can Statement execute DDL commands?

**Answer:**
Yes.

---

### 9️⃣ What happens if Statement is not closed?

**Answer:**
Resource leak.

---

### 🔟 Why is Statement slower than PreparedStatement?

**Answer:**
Because SQL is compiled every execution.

---

# 🧾 Quick Recap / Cheat Sheet

* Statement executes static SQL
* No parameter support
* Vulnerable to SQL Injection
* SQL compiled every time
* executeQuery() → ResultSet
* executeUpdate() → int
* Not thread-safe
* Use mainly for DDL
* Prefer PreparedStatement in real apps

---
