## 1️⃣ Definition

`requires` is a keyword used inside **`module-info.java`** to declare that one module depends on another module.

It tells the compiler and runtime:

> “My module needs access to this other module.”

Without `requires`, you cannot access public types from another module.

---

## 2️⃣ Visual Representation

### Basic Dependency

```id="req1"
Module A
  |
  |-- requires --> Module B
```

Meaning:

* Module A depends on Module B
* Module A can access exported packages of Module B

---

### Without `requires`

```id="req2"
Module A  ----X---->  Module B
(Compilation Error)
```

Access denied at compile-time.

---

### With `requires`

```id="req3"
Module A  ---->  Module B
         (Access allowed)
```

---

## 3️⃣ Key Features / Properties

* Declares dependency explicitly
* Checked at compile-time
* Verified at runtime
* Improves modular security
* Prevents hidden dependencies
* Part of strong encapsulation

---

## 4️⃣ Basic Syntax

```java
module com.example.app {
    requires com.example.crypto;
}
```

Meaning:

* `com.example.app` depends on `com.example.crypto`

---

## 5️⃣ Types of `requires`

---

### 1️⃣ Normal `requires`

```java
requires com.example.crypto;
```

* Direct dependency
* Only current module can use it
* Not exposed to dependent modules

---

### 2️⃣ `requires transitive`

```java
requires transitive com.example.common;
```

Meaning:

* Your module depends on `common`
* Any module that depends on you automatically gets access to `common`

---

### Visual of `requires transitive`

```id="req4"
Module C --> Module A --> Module B

If A:
requires transitive B

Then C can also access B
```

---

### 3️⃣ `requires static`

```java
requires static lombok;
```

* Dependency required at compile-time
* Not required at runtime

Used for:

* Annotation processors
* Optional dependencies

---

## 6️⃣ Example

### Module B

```java
module com.example.crypto {
    exports com.example.crypto.api;
}
```

---

### Module A

```java
module com.example.app {
    requires com.example.crypto;
}
```

Now Module A can access:

```
com.example.crypto.api
```

But only if it is exported.

---

## 7️⃣ Use Cases

* Accessing `java.sql`
* Accessing `java.logging`
* Using custom internal modules
* Shared common utilities
* Enterprise modular projects
* Microservices modular monolith

Example:

```java
requires java.sql;
requires java.logging;
```

---

## 8️⃣ Pitfalls / Notes

* ❌ Forgetting to add `requires`
* ❌ Circular module dependencies
* ❌ Misusing `requires transitive`
* ❌ Depending on non-exported packages
* ❌ Split package errors
* ❌ Mixing classpath and module path
* ❌ Using static when runtime dependency is needed

---

## 9️⃣ Real-World Analogy

🏢 Office Access

* Your team needs access to Finance department.
* You submit request → `requires finance.module`
* If approved, you can use Finance services.

`requires transitive`:

If Team C depends on your team, they automatically get Finance access too.

---

# 🔟 Tricky Questions (Interview Level)

1. What does `requires` do?
   ➜ Declares module dependency.

2. What happens if `requires` is missing?
   ➜ Compilation error when accessing other module classes.

3. What is difference between `requires` and `requires transitive`?
   ➜ `transitive` exposes dependency to downstream modules.

4. What is `requires static`?
   ➜ Compile-time only dependency.

5. Is `requires` checked at runtime?
   ➜ Yes, module graph validated.

6. Can circular dependency exist with `requires`?
   ➜ No, module system prevents cycles.

7. Does `requires` give access to all packages?
   ➜ Only exported packages.

8. Can you access non-exported packages even with `requires`?
   ➜ No.

9. What is difference between classpath dependency and module `requires`?
   ➜ Module system enforces strong encapsulation.

10. What is module graph?
    ➜ Dependency structure created at runtime.

11. When should `requires transitive` be used?
    ➜ When building reusable API modules.

12. Why is explicit dependency better than implicit?
    ➜ Improves maintainability and security.

13. Can you require unnamed module?
    ➜ No.

14. What happens if required module is not on module path?
    ➜ Startup/runtime error.

15. Is `requires` mandatory for java.base?
    ➜ No, automatically available.

---

# 🧾 Quick Recap / Cheat Sheet

* `requires` declares dependency
* Needed to access another module
* Only exported packages accessible
* Checked at compile & runtime
* `requires transitive` propagates dependency
* `requires static` = compile-time only
* Prevents hidden dependencies
* Avoid circular dependencies
* No access without export
* Strong encapsulation enforced
* Validated via module graph
* Used in module-info.java
* Improves modular security
* Mandatory for external modules
* java.base auto-included

---
