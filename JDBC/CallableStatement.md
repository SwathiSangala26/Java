# 1️⃣ Definition

A **CallableStatement** in JDBC is used to execute stored procedures and stored functions present in the database.

It allows:

* Calling stored procedures
* Handling IN parameters
* Handling OUT parameters
* Handling INOUT parameters
* Retrieving return values

It extends `PreparedStatement`.

---

# 2️⃣ Visual Representation

### Where CallableStatement Fits

```id="s9k2df"
Java Application
        |
        v
Connection
        |
        v
CallableStatement (Calls Stored Procedure)
        |
        v
Database Stored Procedure
        |
        v
Result / OUT Parameters
```

---

### Internal Working

```id="k3ms8p"
Call Syntax Prepared
        |
        v
Parameters Registered (IN/OUT)
        |
        v
Procedure Executed in DB
        |
        v
Output Returned to Java
```

---

# 3️⃣ Key Features / Properties

* Used to call stored procedures
* Supports:

  * IN parameters
  * OUT parameters
  * INOUT parameters
* Can return:

  * ResultSet
  * Update count
  * Output parameters
* Precompiled at database level
* Not thread-safe
* Improves performance when logic resides in DB

---

# 4️⃣ Syntax

## Basic Syntax

```java
CallableStatement cs =
    con.prepareCall("{call procedure_name(?, ?, ?)}");
```

---

## Setting IN Parameter

```java
cs.setInt(1, 10);
```

---

## Registering OUT Parameter

```java
cs.registerOutParameter(2, Types.VARCHAR);
```

---

## Executing

```java
cs.execute();
```

---

## Getting OUT Parameter

```java
String result = cs.getString(2);
```

---

# 5️⃣ Code Example (IN + OUT Parameter)

Assume stored procedure:

```sql
CREATE PROCEDURE getUserName(IN userId INT, OUT userName VARCHAR(50))
BEGIN
    SELECT name INTO userName FROM users WHERE id = userId;
END;
```

Java Code:

```java
import java.sql.*;

public class CallableStatementDemo {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        Connection con = DriverManager.getConnection(url, user, password);

        CallableStatement cs =
                con.prepareCall("{call getUserName(?, ?)}");

        cs.setInt(1, 1);  // IN parameter

        cs.registerOutParameter(2, Types.VARCHAR); // OUT parameter

        cs.execute();

        String name = cs.getString(2);

        System.out.println(name);

        cs.close();
        con.close();
    }
}
```

---

# 6️⃣ Use Cases

* Complex business logic inside database
* Banking transaction procedures
* Reporting stored procedures
* Batch operations handled by DB
* Performance optimization when DB handles heavy logic

---

# 7️⃣ Pitfalls / Notes

* Parameter index starts at 1
* Must register OUT parameter before execution
* Must match SQL data types properly
* Stored procedure must exist in DB
* Not thread-safe
* Harder to debug than plain SQL

Common mistake:

```java
cs.execute();
cs.registerOutParameter(2, Types.VARCHAR); // ❌ Wrong order
```

---

# 8️⃣ Real-World Analogy

```id="p8dw2r"
Statement → Write full order
PreparedStatement → Preprinted order form
CallableStatement → Ask chef to prepare special recipe already stored in kitchen
```

Stored procedure = Recipe already saved in DB kitchen.

---

# 9️⃣ Best Practices

* Use for complex DB-side logic
* Keep business logic mostly in application layer unless necessary
* Always register OUT parameters before execute()
* Match SQL types carefully
* Close CallableStatement properly
* Use transactions when required

---

# 🔟 Tricky Questions (Continuous Numbering)

---

### 1️⃣ What is CallableStatement used for?

**Answer:**
To execute stored procedures and functions.

---

### 2️⃣ Does CallableStatement extend Statement?

**Answer:**
It extends PreparedStatement (which extends Statement).

---

### 3️⃣ What happens if OUT parameter is not registered?

**Answer:**
SQLException is thrown.

---

### 4️⃣ Can CallableStatement return ResultSet?

**Answer:**
Yes.

---

### 5️⃣ What is difference between PreparedStatement and CallableStatement?

**Answer:**
PreparedStatement → Executes SQL queries
CallableStatement → Calls stored procedures

---

### 6️⃣ What are IN, OUT, INOUT parameters?

**Answer:**
IN → Input only
OUT → Output only
INOUT → Both input and output

---

### 7️⃣ Is CallableStatement precompiled?

**Answer:**
Yes. Stored procedure is precompiled at database level.

---

### 8️⃣ Is CallableStatement thread-safe?

**Answer:**
No.

---

### 9️⃣ How do you call a function that returns a value?

**Answer:**

```java
CallableStatement cs =
    con.prepareCall("{? = call function_name(?)}");
```

First parameter registered as OUT.

---

### 🔟 When should we prefer CallableStatement over PreparedStatement?

**Answer:**
When complex business logic is already implemented as stored procedure in database.

---

# 🧾 Quick Recap / Cheat Sheet

* Used for stored procedures
* Extends PreparedStatement
* Supports IN / OUT / INOUT
* Must register OUT before execute
* Parameter index starts at 1
* Can return ResultSet or values
* Not thread-safe
* Used for DB-level business logic

---
