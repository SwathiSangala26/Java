# 1️⃣ Definition

A **PreparedStatement** in JDBC is a precompiled SQL statement that supports parameterized queries using placeholders (`?`).

It is used for:

* Executing dynamic queries safely
* Preventing SQL Injection
* Improving performance for repeated execution

Unlike `Statement`, it supports parameters.

---

# 2️⃣ Visual Representation

### Where PreparedStatement Fits

```id="c7lxnm"
Java Application
        |
        v
Connection
        |
        v
PreparedStatement (Precompiled SQL)
        |
        v
Database
        |
        v
ResultSet / Update Count
```

---

### Internal Working

```id="je6tnu"
SQL with ?
        |
        v
Sent to DB for compilation
        |
        v
Execution plan created
        |
        v
Parameters bound later
        |
        v
Query executed
```

Key Point:

* SQL compiled once
* Parameters set multiple times
* Execution plan reused

---

# 3️⃣ Key Features / Properties

* Precompiled SQL
* Supports parameter placeholders (`?`)
* Prevents SQL Injection
* Faster for repeated queries
* Type-safe parameter binding
* Can execute SELECT, INSERT, UPDATE, DELETE
* Not thread-safe

---

# 4️⃣ Syntax

## Creating PreparedStatement

```java
PreparedStatement ps = con.prepareStatement(
    "SELECT * FROM users WHERE id=?"
);
```

---

## Setting Parameters

```java
ps.setInt(1, 10);
```

Parameter index starts from **1** (not 0).

---

## Executing Query

```java
ResultSet rs = ps.executeQuery();
```

---

## Executing Update

```java
int rows = ps.executeUpdate();
```

---

# 5️⃣ Code Example

```java
import java.sql.*;

public class PreparedStatementDemo {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        Connection con = DriverManager.getConnection(url, user, password);

        PreparedStatement ps =
                con.prepareStatement("SELECT * FROM users WHERE id=?");

        ps.setInt(1, 1);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        rs.close();
        ps.close();
        con.close();
    }
}
```

---

# 6️⃣ Use Cases

* User login systems
* Search filters
* Repeated batch inserts
* Secure data entry forms
* Transaction-based operations

---

# 7️⃣ Pitfalls / Notes

* Parameter index starts at 1
* Cannot change SQL structure after creation
* Must set all parameters before execution
* Not thread-safe
* Forgetting to close → resource leak

Wrong:

```java
PreparedStatement ps =
    con.prepareStatement("SELECT * FROM users WHERE id=?");

ResultSet rs = ps.executeQuery(); // ❌ parameter not set
```

---

# 8️⃣ Real-World Analogy

```id="h2yb3a"
Statement → Writing full order every time

PreparedStatement → Pre-printed order form
Only fill values each time
Kitchen already knows structure
```

PreparedStatement saves preparation time.

---

# 9️⃣ Best Practices

* Always use PreparedStatement for user input
* Reuse PreparedStatement for repeated execution
* Use batch updates when inserting multiple records
* Close resources using try-with-resources
* Avoid building SQL using string concatenation

---

# 🔟 Tricky Questions (Continuous Numbering)

---

### 1️⃣ Why is PreparedStatement faster than Statement?

**Answer:**
Because SQL is precompiled and execution plan is reused.

---

### 2️⃣ How does PreparedStatement prevent SQL Injection?

**Answer:**
Parameters are sent separately from SQL query.
User input is treated as data, not executable SQL.

---

### 3️⃣ What is the starting index of parameters?

**Answer:**
1 (not 0).

---

### 4️⃣ Can we change SQL query after PreparedStatement creation?

**Answer:**
No.

---

### 5️⃣ What happens if a parameter is not set?

**Answer:**
SQLException is thrown.

---

### 6️⃣ Is PreparedStatement thread-safe?

**Answer:**
No.

---

### 7️⃣ Can PreparedStatement execute DDL statements?

**Answer:**
Yes, but rarely used for that purpose.

---

### 8️⃣ Does PreparedStatement improve performance for single execution?

**Answer:**
Not significantly. Benefit is visible for repeated execution.

---

### 9️⃣ What is difference in compilation between Statement and PreparedStatement?

**Answer:**
Statement → Compiled every time
PreparedStatement → Compiled once

---

### 🔟 Can PreparedStatement be reused with different parameter values?

**Answer:**
Yes.

---

# 🧾 Quick Recap / Cheat Sheet

* Precompiled SQL
* Uses ? placeholders
* Parameter index starts from 1
* Prevents SQL Injection
* Faster for repeated execution
* Not thread-safe
* Must set all parameters
* Preferred over Statement

---
