## 1️⃣ Definition

**Dynamic Object Creation** is the process of creating objects at **runtime** instead of compile time.

It is typically done using:

* Reflection API
* Class loaders
* Factory patterns

It allows flexible and extensible application design.

---

## 2️⃣ Visual Representation

### Normal Object Creation (Compile-Time)

```id="doc1"
Compile Time
   |
   |  new MyClass()
   v
Object Created
```

---

### Dynamic Object Creation (Runtime)

```id="doc2"
Runtime
   |
   |  Class.forName("MyClass")
   |  getConstructor()
   |  newInstance()
   v
Object Created
```

---

### Dynamic Selection Based on Input

```id="doc3"
User Input --> "Car"
                |
                v
Load Class "Car"
                |
                v
Create Object
```

---

## 3️⃣ Key Features / Properties

* Runtime flexibility
* Uses reflection
* No direct dependency at compile time
* Useful for plugin systems
* Slower than normal instantiation
* Can bypass constructors visibility
* Throws checked exceptions

---

## 4️⃣ Syntax

### Using Reflection

```java id="doccode1"
Class<?> clazz = Class.forName("com.example.MyClass");
Object obj = clazz.getDeclaredConstructor().newInstance();
```

---

### Using Constructor with Parameters

```java id="doccode2"
Constructor<?> constructor =
    clazz.getConstructor(String.class);

Object obj = constructor.newInstance("Hello");
```

---

## 5️⃣ Code Example

```java id="doccode3"
class Demo {
    public Demo() {
        System.out.println("Object Created");
    }
}

public class Example {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Demo");
        Object obj = clazz.getDeclaredConstructor().newInstance();
    }
}
```

---

## 6️⃣ Use Cases

* Dependency Injection frameworks
* Plugin architectures
* ORM tools
* Testing frameworks
* Configuration-based object creation
* Dynamic service loading
* Microservice extensibility

---

## 7️⃣ Pitfalls / Notes

* ❌ Performance overhead
* ❌ Runtime errors instead of compile-time errors
* ❌ Breaks encapsulation
* ❌ Security risks
* ❌ Complex exception handling
* ❌ Harder debugging
* ❌ ClassNotFoundException risk

---

## 8️⃣ Real-World Analogy

🏗 Construction Based on Blueprint Name

* Normal → You directly build “House”
* Dynamic → You read blueprint name from file and build that structure

You don’t know the structure until runtime.

---

## 9️⃣ Best Practices

* Use only when flexibility is required
* Prefer factory pattern when possible
* Handle exceptions carefully
* Avoid in performance-critical code
* Restrict access to private constructors
* Validate class names before loading
* Use dependency injection frameworks

---

## 🔟 Tricky Questions

11. What is dynamic object creation?
    ➜ Creating objects at runtime instead of compile time.

12. Which API is mainly used?
    ➜ Reflection API.

13. What method loads class dynamically?
    ➜ Class.forName().

14. How to create object using reflection?
    ➜ getDeclaredConstructor().newInstance().

15. Is dynamic creation faster than normal instantiation?
    ➜ No.

16. What exception occurs if class not found?
    ➜ ClassNotFoundException.

17. Can private constructors be invoked?
    ➜ Yes, using setAccessible(true).

18. Why do frameworks use dynamic object creation?
    ➜ For flexibility and dependency injection.

19. What is downside of dynamic object creation?
    ➜ Runtime errors and performance overhead.

20. What is alternative to reflection for dynamic creation?
    ➜ Factory pattern.

21. Is compile-time checking available?
    ➜ No.

22. What happens if constructor parameters mismatch?
    ➜ NoSuchMethodException.

23. Can dynamic object creation improve extensibility?
    ➜ Yes.

24. Does it break encapsulation?
    ➜ It can.

25. Why use it in plugin systems?
    ➜ To load classes dynamically without recompiling.

---

## 🧾 Quick Recap / Cheat Sheet

* Created at runtime
* Uses Reflection API
* Load class → Class.forName()
* Create instance → newInstance()
* Slower than normal creation
* No compile-time safety
* Used in frameworks
* Enables plugins
* Supports parameterized constructors
* Throws checked exceptions
* Flexible but risky
* Alternative → Factory pattern
* Used in DI & ORM
* Improves extensibility
* Use carefully

---
