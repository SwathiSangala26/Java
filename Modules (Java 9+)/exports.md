## 1️⃣ Definition

`exports` is a keyword in **`module-info.java`** used to make a package accessible to other modules.

It controls **package-level visibility at module level**.

If a package is not exported, it is completely hidden from other modules — even if classes are `public`.

---

## 2️⃣ Visual Representation

### Without `exports`

```id="exp1"
Module A
  |
  |-- package: com.app.internal
  |       public class Service
  |
Module B tries to access Service
  |
  X  (Access Denied)
```

---

### With `exports`

```id="exp2"
module com.app {
    exports com.app.api;
}
```

```id="exp3"
Module A
  |
  |-- com.app.api  (Exported → Accessible)
  |
  |-- com.app.internal (Not Exported → Hidden)
```

---

### Access Flow

```id="exp4"
Module B
   |
   |-- requires com.app
            |
            |-- exports com.app.api
```

Access allowed only to exported package.

---

## 3️⃣ Key Features / Properties

* Works at **package level**
* Enables strong encapsulation
* Only exported packages visible externally
* Internal packages remain hidden
* Enforced at compile-time and runtime
* Improves security and modular design

---

## 4️⃣ Basic Syntax

```java id="9qhz1m"
module com.example.app {
    exports com.example.api;
}
```

Meaning:

* Only `com.example.api` is accessible to other modules.

---

## 5️⃣ Export to Specific Module (Qualified Export)

```java id="p08jty"
module com.example.app {
    exports com.example.internal to com.example.testing;
}
```

Meaning:

* Only `com.example.testing` can access `internal` package.
* Other modules cannot.

---

### Visual of Qualified Export

```id="exp5"
Module A
  |
  |-- exports internal to Module B

Module B --> Access Allowed
Module C --> Access Denied
```

---

## 6️⃣ Example

### Module: Crypto

```java id="j12gh9"
module com.example.crypto {
    exports com.example.crypto.api;
}
```

### Structure

```id="exp6"
com.example.crypto
   |
   |-- com.example.crypto.api      (Exported)
   |-- com.example.crypto.internal (Hidden)
```

Only `api` package is accessible.

---

## 7️⃣ Use Cases

* Exposing public APIs
* Hiding implementation details
* Framework development
* Library development
* Secure modular systems
* Plugin architectures

---

## 8️⃣ Pitfalls / Notes

* ❌ Forgetting to export required package
* ❌ Over-exporting internal packages
* ❌ Assuming `public` class is enough
* ❌ Not understanding package-level control
* ❌ Mixing classpath and module path
* ❌ Split package errors
* ❌ Exposing sensitive internal APIs

---

## 9️⃣ Real-World Analogy

🏢 Office Building

* Exported package → Reception area (public access)
* Non-exported package → Private office (restricted)
* Qualified export → VIP-only room

Even if door is public (public class), building rules (module system) may block entry.

---

# 🔟 Tricky Questions (Interview Level)

1. What does `exports` do?
   ➜ Makes a package accessible to other modules.

2. Does `public` class automatically make it accessible outside module?
   ➜ No, package must be exported.

3. Is `exports` applied to class or package?
   ➜ Package level.

4. What happens if package is not exported?
   ➜ Compile-time access error.

5. What is qualified export?
   ➜ Exporting package to specific module only.

6. What is difference between `exports` and `opens`?
   ➜ `exports` allows compile-time access; `opens` allows reflection.

7. Can you export multiple packages?
   ➜ Yes, multiple `exports` statements.

8. Can two modules export same package name?
   ➜ No, split package error.

9. Does `requires` automatically expose packages?
   ➜ No, exporting is separate.

10. Is `java.base` automatically exported?
    ➜ Core packages are available by default.

11. Why is `exports` important for security?
    ➜ Prevents unintended access.

12. Can you remove `exports` later without breaking code?
    ➜ It may break dependent modules.

13. What is strong encapsulation?
    ➜ Only explicitly exported packages are visible.

14. Is export checked at runtime?
    ➜ Yes, module system enforces it.

15. What happens if you over-export packages?
    ➜ Internal implementation becomes accessible, reducing modular integrity.

---

# 🧾 Quick Recap / Cheat Sheet

* `exports` makes package visible
* Works at package level
* Public class ≠ automatically accessible
* Non-exported packages are hidden
* Supports qualified export
* Enforced at compile & runtime
* Improves encapsulation
* Prevents accidental exposure
* Separate from `requires`
* Avoid exporting internal packages
* Helps secure modular systems
* Part of JPMS (Java 9+)
* Multiple exports allowed
* Enables API design clarity
* Strong module boundaries

---
