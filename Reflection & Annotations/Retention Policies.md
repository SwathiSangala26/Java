## 1️⃣ Definition

**Retention Policy** defines how long an annotation is retained in the program lifecycle.

It specifies whether an annotation is:

* Discarded after compilation
* Stored in the `.class` file
* Available at runtime via reflection

Defined using:

```java
@Retention(RetentionPolicy.X)
```

---

## 2️⃣ Visual Representation

### Lifecycle of Annotation

```id="rp1"
Source Code
   |
   |  Compile
   v
Class File (.class)
   |
   |  Run
   v
JVM Runtime
```

---

### Retention Types

```id="rp2"
SOURCE  --> Exists only in source code
CLASS   --> Stored in .class file
RUNTIME --> Available during execution
```

---

### Reflection Availability

```id="rp3"
SOURCE  --> Not available
CLASS   --> Not available via reflection
RUNTIME --> Available via reflection
```

---

## 3️⃣ Key Features / Properties

* Defined using `@Retention`
* Uses `RetentionPolicy` enum
* Applied on custom annotations
* Controls annotation lifecycle
* Affects reflection capability
* Default retention is CLASS

---

## 4️⃣ Syntax

```java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
}
```

---

## 5️⃣ Code Example

### SOURCE Retention

```java
@Retention(RetentionPolicy.SOURCE)
@interface TestAnnotation {
}
```

Removed after compilation.

---

### CLASS Retention

```java
@Retention(RetentionPolicy.CLASS)
@interface TestAnnotation {
}
```

Stored in `.class`, not available at runtime.

---

### RUNTIME Retention

```java
@Retention(RetentionPolicy.RUNTIME)
@interface TestAnnotation {
}
```

Accessible using reflection.

---

## 6️⃣ Use Cases

* SOURCE → Compile-time tools (e.g., code analysis)
* CLASS → Bytecode processing tools
* RUNTIME → Frameworks (Spring, Hibernate)
* Logging systems
* Security validation
* Dependency Injection

---

## 7️⃣ Pitfalls / Notes

* ❌ Forgetting to specify retention
* ❌ Using SOURCE when runtime access needed
* ❌ Assuming CLASS works with reflection
* ❌ Overusing RUNTIME unnecessarily
* ❌ Not understanding default behavior

---

## 8️⃣ Real-World Analogy

📦 Label Lifetime

* SOURCE → Sticky note removed before delivery
* CLASS → Label stored in warehouse records
* RUNTIME → Label visible during product usage

Retention policy defines how long the label stays.

---

## 9️⃣ Best Practices

* Explicitly define retention policy
* Use RUNTIME only when reflection needed
* Use SOURCE for compile-time tools
* Avoid unnecessary runtime overhead
* Document annotation behavior clearly

---

## 🔟 Tricky Questions

11. What is retention policy?
    ➜ Defines how long an annotation is retained.

12. How many retention types exist?
    ➜ Three.

13. What are they?
    ➜ SOURCE, CLASS, RUNTIME.

14. What is default retention?
    ➜ CLASS.

15. Which retention allows reflection?
    ➜ RUNTIME.

16. Does SOURCE retention appear in class file?
    ➜ No.

17. Does CLASS retention allow runtime access?
    ➜ No.

18. Why use SOURCE retention?
    ➜ For compile-time tools.

19. When is CLASS retention useful?
    ➜ Bytecode-level tools.

20. What annotation is used to define retention?
    ➜ `@Retention`.

21. Where is RetentionPolicy enum located?
    ➜ `java.lang.annotation`.

22. Can annotation work without retention defined?
    ➜ Yes, default is CLASS.

23. What happens if wrong retention chosen?
    ➜ Annotation may not behave as expected.

24. Do built-in annotations use retention policy?
    ➜ Yes.

25. Why is RUNTIME retention important in frameworks?
    ➜ Enables reflection-based processing.

---

## 🧾 Quick Recap / Cheat Sheet

* Retention defines annotation lifetime
* Defined using `@Retention`
* Types: SOURCE, CLASS, RUNTIME
* Default = CLASS
* RUNTIME required for reflection
* SOURCE removed after compilation
* CLASS stored in bytecode
* Affects framework behavior
* Must be chosen carefully
* Common interview question
* Located in java.lang.annotation
* Controls annotation visibility
* Important for custom annotations
* Impacts performance
* Essential for metadata processing

---
