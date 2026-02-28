## 1️⃣ Definition

**Custom Annotations** are user-defined annotations created using `@interface` to provide metadata for classes, methods, fields, parameters, or constructors.

They are used to:

* Add custom metadata
* Enable runtime processing
* Support frameworks
* Build validation or configuration systems

---

## 2️⃣ Visual Representation

### Basic Structure

```id="ca1"
@MyAnnotation
Class / Method / Field
```

---

### Annotation Processing Flow

```id="ca2"
Annotated Class
      |
      |  Reflection
      v
Read Annotation Metadata
      |
      v
Perform Action
```

---

### Runtime Processing

```id="ca3"
@Role("ADMIN")
UserClass
      |
      v
Check Role at Runtime
```

---

## 3️⃣ Key Features / Properties

* Created using `@interface`
* Provide metadata (not logic)
* Can have elements (attributes)
* Require retention policy
* Can define target location
* Can be accessed via Reflection
* Used heavily in frameworks

---

## 4️⃣ Syntax

### Define Custom Annotation

```java id="cacode1"
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MyAnnotation {
    String value();
}
```

---

## 5️⃣ Code Example

### Define Annotation

```java id="cacode2"
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecution {
}
```

### Apply Annotation

```java id="cacode3"
class Service {

    @LogExecution
    public void process() {
        System.out.println("Processing...");
    }
}
```

### Access Using Reflection

```java id="cacode4"
Method method = Service.class.getMethod("process");

if (method.isAnnotationPresent(LogExecution.class)) {
    System.out.println("Log before execution");
}
```

---

## 6️⃣ Use Cases

* Validation frameworks
* Dependency Injection
* Security roles
* Logging systems
* ORM mapping
* REST endpoint mapping
* Configuration metadata

---

## 7️⃣ Pitfalls / Notes

* ❌ Forgetting retention policy
* ❌ Wrong target element
* ❌ Not using RUNTIME when reflection needed
* ❌ Overcomplicating logic
* ❌ Assuming annotation executes automatically
* ❌ Ignoring performance overhead

---

## 8️⃣ Real-World Analogy

🏷 Custom Label System

* Annotation → Label
* Class → File
* Reflection → Inspector
* Retention policy → How long label stays
* Target → Where label can be placed

Annotation itself does nothing unless someone reads it.

---

## 9️⃣ Best Practices

* Always define proper RetentionPolicy
* Use clear annotation names
* Keep attributes minimal
* Document usage clearly
* Avoid heavy logic inside processing
* Use RUNTIME only when required
* Combine with reflection carefully

---

## 🔟 Tricky Questions

11. How do you create custom annotation?
    ➜ Using `@interface`.

12. What is mandatory when defining annotation?
    ➜ Retention and Target (recommended).

13. What happens if retention not specified?
    ➜ Default is CLASS.

14. What is RetentionPolicy.RUNTIME used for?
    ➜ Access annotation at runtime.

15. Can annotation have methods?
    ➜ Yes, they define attributes.

16. Can annotation extend another interface?
    ➜ No.

17. What is default value in annotation?
    ➜ Defined using `default` keyword.

18. Can annotation be applied multiple times?
    ➜ Yes, if declared as repeatable.

19. Does annotation execute automatically?
    ➜ No, must be processed via reflection or tools.

20. What is difference between built-in and custom annotation?
    ➜ Built-in provided by Java; custom created by user.

21. What is ElementType used for?
    ➜ Defines where annotation can be applied.

22. Can annotation be inherited?
    ➜ Yes, using `@Inherited`.

23. What is RetentionPolicy.SOURCE?
    ➜ Discarded at compile time.

24. What is RetentionPolicy.CLASS?
    ➜ Available in class file but not at runtime.

25. Why are custom annotations important in frameworks?
    ➜ They enable configuration through metadata.

---

## 🧾 Quick Recap / Cheat Sheet

* Created using `@interface`
* Provide metadata
* Use `@Retention`
* Use `@Target`
* Access via Reflection
* Default retention = CLASS
* RUNTIME needed for reflection
* Can define attributes
* Can define default values
* Used in frameworks
* Does not execute by itself
* Must be processed
* Improves flexibility
* Enables metadata-driven programming
* Frequently asked in interviews

---
