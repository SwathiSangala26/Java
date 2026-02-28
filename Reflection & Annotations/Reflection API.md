## 1️⃣ Definition

**Reflection API** in Java allows a program to inspect and manipulate:

* Classes
* Methods
* Fields
* Constructors

at **runtime**, even if their names were not known at compile time.

It is part of the `java.lang.reflect` package.

---

## 2️⃣ Visual Representation

### Normal Execution

```id="ref1"
Compile Time
   |
   |  Class known
   v
Direct Method Call
```

---

### Reflection Execution

```id="ref2"
Runtime
   |
   |  Load Class by Name
   |  Inspect Methods
   |  Invoke Method Dynamically
   v
Execute
```

---

### Accessing Private Members

```id="ref3"
Class
  |
  |-- private field
  |
Reflection
  |
  |-- setAccessible(true)
  |
Access Allowed
```

---

## 3️⃣ Key Features / Properties

* Runtime inspection
* Access private members
* Invoke methods dynamically
* Create objects dynamically
* Breaks encapsulation
* Slower than direct calls
* Used heavily in frameworks

---

## 4️⃣ Syntax

### Load Class

```java id="refcode1"
Class<?> clazz = Class.forName("com.example.MyClass");
```

---

### Get Methods

```java id="refcode2"
Method[] methods = clazz.getDeclaredMethods();
```

---

### Create Object

```java id="refcode3"
Object obj = clazz.getDeclaredConstructor().newInstance();
```

---

## 5️⃣ Code Example

```java id="refcode4"
import java.lang.reflect.*;

class Demo {
    private String message = "Hello Reflection";

    private void show() {
        System.out.println(message);
    }
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Demo");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method method = clazz.getDeclaredMethod("show");
        method.setAccessible(true);
        method.invoke(obj);
    }
}
```

---

## 6️⃣ Use Cases

* Framework development (Spring, Hibernate)
* Dependency Injection
* Annotation processing
* Testing frameworks
* Serialization libraries
* ORM tools
* Dynamic proxies

---

## 7️⃣ Pitfalls / Notes

* ❌ Performance overhead
* ❌ Breaks encapsulation
* ❌ Security risks
* ❌ Harder to debug
* ❌ No compile-time checking
* ❌ Can throw many checked exceptions
* ❌ Slower method invocation

---

## 8️⃣ Real-World Analogy

🧰 Master Key

* Class → Locked house
* Private members → Locked rooms
* Reflection → Master key
* setAccessible(true) → Force unlock

Powerful but risky if misused.

---

## 9️⃣ Best Practices

* Use only when necessary
* Avoid in performance-critical paths
* Restrict access in production
* Handle exceptions carefully
* Prefer direct calls when possible
* Use for frameworks, not regular business logic

---

## 🔟 Tricky Questions

11. What is Reflection API?
    ➜ Mechanism to inspect and modify classes at runtime.

12. Which package provides reflection?
    ➜ `java.lang.reflect`.

13. Can reflection access private members?
    ➜ Yes, using `setAccessible(true)`.

14. Is reflection faster than normal method call?
    ➜ No, it is slower.

15. Why is reflection considered risky?
    ➜ Breaks encapsulation and security.

16. What method loads class dynamically?
    ➜ `Class.forName()`.

17. How to invoke a method using reflection?
    ➜ `method.invoke(object)`.

18. Can reflection create objects?
    ➜ Yes, using constructor.

19. Why do frameworks use reflection?
    ➜ For dynamic behavior and dependency injection.

20. What happens if method name is wrong?
    ➜ NoSuchMethodException at runtime.

21. Is reflection compile-time safe?
    ➜ No.

22. What is performance impact?
    ➜ Slower due to dynamic resolution.

23. Can reflection modify final fields?
    ➜ Technically yes (but unsafe).

24. What is getDeclaredMethods()?
    ➜ Returns all methods including private ones.

25. What is difference between getMethods() and getDeclaredMethods()?
    ➜ getMethods() returns public inherited methods; getDeclaredMethods() returns all declared methods.

---

## 🧾 Quick Recap / Cheat Sheet

* Reflection = Runtime inspection
* Package: java.lang.reflect
* Load class → Class.forName()
* Create object → newInstance()
* Invoke method → method.invoke()
* Access private → setAccessible(true)
* Slower than direct call
* Breaks encapsulation
* Used in frameworks
* Not compile-time safe
* Can throw runtime exceptions
* Powerful but risky
* Used in DI & ORM
* Avoid overuse
* Runtime flexibility tool

---
