# 1️⃣ Definition

A **ResultSet** in JDBC is an object that holds the data returned from a SQL query (typically a SELECT statement).

It represents a **table of data** retrieved from the database.

* It maintains a cursor pointing to rows
* Initially cursor is placed **before the first row**
* Data is accessed column by column

Without ResultSet → You cannot read query results.

---

# 2️⃣ Visual Representation

### Where ResultSet Fits

```id="8phm2q"
Java Application
        |
        v
Statement / PreparedStatement
        |
        v
Database
        |
        v
ResultSet (Table Data)
        |
        v
Application Reads Rows
```

---

### Cursor Movement

```id="2mrtv9"
Before First Row
        |
        v
[ Row 1 ]
        |
        v
[ Row 2 ]
        |
        v
[ Row 3 ]
        |
        v
After Last Row
```

Cursor moves using `next()`.

---

# 3️⃣ Key Features / Properties

* Holds tabular data
* Maintains cursor position
* Not thread-safe
* Default type: TYPE_FORWARD_ONLY
* Default concurrency: CONCUR_READ_ONLY
* Supports different types:

  * Forward Only
  * Scrollable
* Supports:

  * Read-only
  * Updatable

---

# 4️⃣ Types of ResultSet

---

## 🔹 ResultSet Types (Cursor Movement)

1️⃣ TYPE_FORWARD_ONLY

* Can move only forward using `next()`

2️⃣ TYPE_SCROLL_INSENSITIVE

* Can move forward & backward
* Does not reflect DB changes

3️⃣ TYPE_SCROLL_SENSITIVE

* Can move forward & backward
* Reflects DB changes

Example:

```java
Statement stmt = con.createStatement(
    ResultSet.TYPE_SCROLL_INSENSITIVE,
    ResultSet.CONCUR_READ_ONLY
);
```

---

## 🔹 Concurrency Types

1️⃣ CONCUR_READ_ONLY

* Cannot update data

2️⃣ CONCUR_UPDATABLE

* Can update rows directly

---

# 5️⃣ Syntax

## Executing Query

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
```

---

## Moving Cursor

```java
rs.next();
rs.previous();
rs.first();
rs.last();
rs.absolute(2);
rs.beforeFirst();
rs.afterLast();
```

---

## Retrieving Data

```java
rs.getInt("id");
rs.getString("name");
rs.getDouble("salary");
```

OR

```java
rs.getString(2); // by column index
```

Column index starts from **1**.

---

# 6️⃣ Code Example

```java
import java.sql.*;

public class ResultSetDemo {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "root",
                "password");

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + " " + name);
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
```

---

# 7️⃣ Use Cases

* Reading SELECT query results
* Iterating over table records
* Processing report data
* Data validation
* Mapping DB rows to Java objects

---

# 8️⃣ Pitfalls / Notes

* Must call `next()` before reading data
* Column index starts from 1
* Accessing invalid column → SQLException
* Not closing ResultSet → resource leak
* Default ResultSet is forward-only
* Scrollable ResultSet may impact performance

Common mistake:

```java
ResultSet rs = stmt.executeQuery("SELECT * FROM users");
System.out.println(rs.getString("name")); // ❌ cursor not moved
```

---

# 9️⃣ Real-World Analogy

```id="7aovmf"
ResultSet = Printed report from database

Cursor = Your finger pointing to each row
Move finger → Read row → Move again
```

---

# 🔟 Tricky Questions (Continuous Numbering)

---

### 1️⃣ Where is cursor initially positioned?

**Answer:**
Before the first row.

---

### 2️⃣ Is ResultSet thread-safe?

**Answer:**
No.

---

### 3️⃣ What happens if next() is not called?

**Answer:**
SQLException occurs when accessing data.

---

### 4️⃣ What is default ResultSet type?

**Answer:**
TYPE_FORWARD_ONLY.

---

### 5️⃣ What is default concurrency?

**Answer:**
CONCUR_READ_ONLY.

---

### 6️⃣ What is difference between getString(1) and getString("name")?

**Answer:**

* getString(1) → by column index
* getString("name") → by column label

---

### 7️⃣ Can ResultSet update data?

**Answer:**
Yes, if created with CONCUR_UPDATABLE.

---

### 8️⃣ What is difference between TYPE_SCROLL_INSENSITIVE and TYPE_SCROLL_SENSITIVE?

**Answer:**
INSENSITIVE → Does not reflect DB changes
SENSITIVE → Reflects DB changes

---

### 9️⃣ What happens when ResultSet is closed?

**Answer:**
Cursor invalidated and resources released.

---

### 🔟 Can we use ResultSet after Connection is closed?

**Answer:**
No.

---

# 🧾 Quick Recap / Cheat Sheet

* Holds query result data
* Cursor starts before first row
* Must call next()
* Default: Forward-only, Read-only
* Column index starts from 1
* Not thread-safe
* Close ResultSet after use
* Can be scrollable or updatable

---
