## 1️⃣ What is a Package in Java?

A **package** is a **namespace** that groups related classes and interfaces to:

* Avoid name conflicts
* Improve organization
* Control access
* Support reuse

📌 **One-liner (interview)**

> A package in Java is a namespace used to logically group related classes and interfaces.

---

## 2️⃣ Why are Packages Needed?

* **Name collision prevention**

  * `java.util.Date` vs `java.sql.Date`
* **Logical grouping**
* **Access control**
* **Reusability**
* **Maintainability**

---

## 3️⃣ When is a Package Created?

> ✅ **At compile time**

* Created when `javac` processes the `package` statement
* Results in **directory structure on disk**
* ❌ Not created at build time
* ❌ Not created at runtime

| Stage           | Package Exists? |
| --------------- | --------------- |
| Writing code    | ❌               |
| **Compilation** | ✅               |
| Build (JAR)     | ❌               |
| Runtime         | ❌               |

---

## 4️⃣ How is a Package Created?

```java
package com.app.service;

public class UserService { }
```

Compile:

```bash
javac UserService.java
```

Result:

```
com/app/service/UserService.class
```

![Image](https://i.sstatic.net/03agn.png)

![Image](https://i.sstatic.net/Zk4gn.png)

📌 Compiler creates folders automatically.

---

## 5️⃣ Types of Packages

### 🔹 Built-in Packages

Provided by Java API.

| Package     | Purpose       |
| ----------- | ------------- |
| `java.lang` | Core classes  |
| `java.util` | Collections   |
| `java.io`   | File handling |
| `java.sql`  | JDBC          |
| `java.time` | Date & time   |

📌 `java.lang` is imported automatically.

---

### 🔹 User-Defined Packages

Created by developers using `package` keyword.

---

## 6️⃣ Importing Packages

```java
import com.app.service.UserService;
```

```java
import java.util.*;
```

📌 Import is **compile-time only**.

---

## 7️⃣ Package & Access Modifiers (VERY IMPORTANT)

| Modifier    | Same Class | Same Package | Subclass (diff pkg) | Everywhere |
| ----------- | ---------- | ------------ | ------------------- | ---------- |
| `private`   | ✅          | ❌            | ❌                   | ❌          |
| default     | ✅          | ✅            | ❌                   | ❌          |
| `protected` | ✅          | ✅            | ✅                   | ❌          |
| `public`    | ✅          | ✅            | ✅                   | ✅          |

📌 **Default access = package-private**

---

## 8️⃣ Sub-Packages (Trick Question)

```text
com.app
com.app.service
```

❗ They are **NOT parent-child**

* No automatic access
* Treated as separate packages

![Image](https://refreshjava.com/images/java/SubPackages.png)

![Image](https://prepbytes-misc-images.s3.ap-south-1.amazonaws.com/assets/1671442742950-package%20program%20in%20java%201.png)

---

## 9️⃣ Do Packages Exist at Runtime?

❌ **NO**

* Packages exist:

  * At compile time (namespace)
  * On disk (folders)
* At runtime:

  * Only **classes** are loaded
  * Stored in **Metaspace**

📌 JVM does **not load packages**

---

## 🔟 Using a Package in Another Project

### Steps:

1. Compile package
2. Create JAR
3. Add JAR to classpath / Maven dependency

![Image](https://i.sstatic.net/NWDz8.png)

![Image](https://m.media-amazon.com/images/I/81c52PGeaZL._AC_UF1000%2C1000_QL80_.jpg)

📌 JAR = reusable unit, not package itself.

---

## 1️⃣1️⃣ Common Interview Traps ❌

| Statement                       | Correct? |
| ------------------------------- | -------- |
| Packages created at runtime     | ❌        |
| Build tools create packages     | ❌        |
| Sub-packages inherit access     | ❌        |
| `javac` creates package folders | ✅        |
| Package exists in memory        | ❌        |
