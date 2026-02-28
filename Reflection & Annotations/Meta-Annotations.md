## 1️⃣ Definition

**Meta-Annotations** are annotations that are applied to other annotations.

They define the behavior and characteristics of custom annotations, such as:

* Where annotation can be used
* How long it is retained
* Whether it is inherited
* Whether it can be repeated

They are part of `java.lang.annotation` package.

---

## 2️⃣ Visual Representation

### Annotation on Annotation

```id="ma1"
@Retention(RUNTIME)
@Target(METHOD)
@interface MyAnnotation { }
```

Here:

* `@Retention`
* `@Target`

are meta-annotations applied to `@MyAnnotation`.

---

### Retention Lifecycle

```id="ma2"
SOURCE  ---> Discarded after compilation
CLASS   ---> Stored in .class file
RUNTIME ---> Available at runtime via Reflection
```

---

### Target Control

```id="ma3"
@Target(METHOD)
@MyAnnotation   // Allowed

@Target(TYPE)
@MyAnnotation on method  // Compilation Error
```

---

## 3️⃣ Key Features / Properties

* Applied to annotations only
* Control annotation lifecycle
* Define where annotation is valid
* Used while defining custom annotations
* Improve safety and clarity
* Essential for reflection-based frameworks

---

## 4️⃣ Syntax

```java id="macode1"
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
}
```

---

## 5️⃣ Code Example

```java id="macode2"
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@interface Audit {
}

class Parent {
    @Audit
    public void display() {}
}

class Child extends Parent {
}
```

---

## 6️⃣ Use Cases

* Defining retention policy
* Restricting annotation usage location
* Enabling runtime processing
* Framework configuration
* Security role annotations
* ORM mapping
* Dependency injection frameworks

---

## 7️⃣ Pitfalls / Notes

* ❌ Forgetting to define retention
* ❌ Using wrong retention policy
* ❌ Incorrect target selection
* ❌ Assuming CLASS retention works with reflection
* ❌ Not understanding inheritance behavior
* ❌ Overusing repeatable annotations

---

## 8️⃣ Real-World Analogy

📋 Rulebook for Labels

* Annotation → Label
* Meta-annotation → Rule defining label behavior
* Retention → How long label stays
* Target → Where label can be placed
* Inherited → Whether children copy label

Meta-annotations define the rules for custom annotations.

---

## 9️⃣ Best Practices

* Always define `@Retention` explicitly
* Use `RUNTIME` only when needed
* Choose correct `ElementType`
* Avoid overly broad targets
* Understand inheritance behavior
* Keep annotation scope minimal
* Document annotation purpose clearly

---

## 🔟 Tricky Questions

11. What are meta-annotations?
    ➜ Annotations applied to other annotations.

12. Which package contains meta-annotations?
    ➜ `java.lang.annotation`.

13. What does `@Retention` control?
    ➜ Annotation lifecycle.

14. What are retention types?
    ➜ SOURCE, CLASS, RUNTIME.

15. Which retention is required for reflection?
    ➜ RUNTIME.

16. What does `@Target` define?
    ➜ Where annotation can be applied.

17. What is `@Inherited` used for?
    ➜ Allows subclass to inherit annotation.

18. Does `@Inherited` work for methods?
    ➜ No, only class-level.

19. What is default retention policy?
    ➜ CLASS.

20. What happens if no `@Target` is specified?
    ➜ Annotation can be applied anywhere.

21. What is `@Repeatable` used for?
    ➜ Allows multiple annotations of same type.

22. Does SOURCE retention remain in class file?
    ➜ No.

23. Does CLASS retention allow runtime reflection?
    ➜ No.

24. Why are meta-annotations important?
    ➜ They define behavior of custom annotations.

25. Can meta-annotations be applied to classes directly?
    ➜ No, only to annotation definitions.

---

## 🧾 Quick Recap / Cheat Sheet

* Meta-annotations define annotation behavior
* Applied to custom annotations
* Package: java.lang.annotation
* `@Retention` → lifecycle
* `@Target` → location
* `@Inherited` → inheritance
* `@Repeatable` → multiple usage
* Default retention = CLASS
* RUNTIME needed for reflection
* Essential in frameworks
* Control safety
* Prevent misuse
* Define scope
* Frequently asked in interviews
* Must be used carefully

---
