## 1️⃣ Definition

`module-info.java` is a special Java file introduced in **Java 9** as part of the **Java Platform Module System (JPMS)**.

It defines:

* Module name
* Dependencies on other modules
* Packages that are exported
* Services used or provided

It controls **encapsulation at module level**, not just class level.

---

## 2️⃣ Visual Representation

### Basic Structure

```id="mi1"
+--------------------------+
| module-info.java         |
|--------------------------|
| module com.app.main {    |
|   requires com.app.auth; |
|   exports com.app.api;   |
| }                        |
+--------------------------+
```

---

### Module Relationship

```id="mi2"
Module: com.app.main
      |
      |-- requires --> com.app.auth
      |
      |-- exports --> com.app.api
```

---

### Encapsulation Concept

```id="mi3"
Module A
  |
  |-- exports package1  --> Accessible
  |
  |-- package2 (not exported) --> Hidden
```

Only exported packages are visible to other modules.

---

## 3️⃣ Key Features / Properties

* Strong encapsulation
* Explicit dependency declaration
* Compile-time checking
* Runtime module graph validation
* Improves security
* Reduces classpath conflicts
* Supports services

---

## 4️⃣ Syntax

### Basic Syntax

```java
module com.example.app {
    requires com.example.crypto;
    exports com.example.service;
}
```

---

## 5️⃣ Important Keywords

### 1️⃣ `module`

Defines module name.

```java
module com.example.app { }
```

---

### 2️⃣ `requires`

Declares dependency on another module.

```java
requires java.sql;
```

---

### 3️⃣ `exports`

Makes package accessible to other modules.

```java
exports com.example.api;
```

---

### 4️⃣ `requires transitive`

Makes dependency available to modules that depend on you.

```java
requires transitive com.example.common;
```

---

### 5️⃣ `opens`

Allows reflection access.

```java
opens com.example.model;
```

---

### 6️⃣ `uses`

Declares service usage.

```java
uses com.example.payment.PaymentService;
```

---

### 7️⃣ `provides ... with`

Registers service implementation.

```java
provides com.example.payment.PaymentService
    with com.example.payment.impl.PaymentServiceImpl;
```

---

## 6️⃣ Example

### Project Structure

```id="mi4"
com.example.app
   |
   |-- module-info.java
   |-- com/example/api/App.java
```

### module-info.java

```java
module com.example.app {
    requires java.sql;
    exports com.example.api;
}
```

---

## 7️⃣ Use Cases

* Large enterprise applications
* Secure modular systems
* Microservices (modularized monolith)
* Plugin architectures
* Strong encapsulation in frameworks
* Service-based architecture

---

## 8️⃣ Pitfalls / Notes

* ❌ Forgetting to export required packages
* ❌ Circular module dependencies
* ❌ Misusing `requires transitive`
* ❌ Reflection failing without `opens`
* ❌ Mixing classpath and module path incorrectly
* ❌ Over-exporting internal packages

---

## 9️⃣ Real-World Analogy

🏢 Apartment Building

* Module = Apartment building
* Packages = Rooms
* `exports` = Doors opened to visitors
* Non-exported package = Private room
* `requires` = Visiting another building
* `opens` = Allowing inspection

Only permitted doors are accessible.

---

## 🔟 Tricky Questions (Interview Level)

1. What is `module-info.java`?
   ➜ Configuration file defining module structure and dependencies.

2. In which Java version was it introduced?
   ➜ Java 9.

3. What is difference between classpath and module path?
   ➜ Classpath has no strong encapsulation; module path enforces module boundaries.

4. What happens if package is not exported?
   ➜ Other modules cannot access it.

5. What is `requires transitive`?
   ➜ Makes dependency available to dependent modules.

6. What is difference between `exports` and `opens`?
   ➜ `exports` allows compile-time access; `opens` allows reflection access.

7. Why might reflection fail in modular system?
   ➜ Package not opened using `opens`.

8. Can two modules have same package name?
   ➜ No, causes split package error.

9. What is service loader used with modules?
   ➜ Dynamic service implementation loading.

10. What is strong encapsulation?
    ➜ Hiding internal packages unless explicitly exported.

11. What is unnamed module?
    ➜ Code on classpath without module-info.

12. What happens if required module is missing?
    ➜ Compilation/runtime error.

13. Why is JPMS useful for large applications?
    ➜ Clear boundaries and dependency control.

14. Can module depend on itself?
    ➜ No.

15. What is split package problem?
    ➜ Same package in multiple modules.

---

# 🧾 Quick Recap / Cheat Sheet

* Introduced in Java 9
* Defines module structure
* `requires` → dependency
* `exports` → public packages
* `opens` → reflection access
* `requires transitive` → propagate dependency
* Strong encapsulation
* Prevents classpath issues
* Supports service loader
* Avoid circular dependencies
* Avoid split packages
* Use module path instead of classpath
* Only exported packages accessible
* Improves security
* Better large-scale project structure

---
