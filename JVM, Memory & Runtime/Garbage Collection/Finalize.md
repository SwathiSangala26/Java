## 1️⃣ Definition

`finalize()` is a method of the `Object` class that is called by the **Garbage Collector before an object is destroyed**.

It is used to perform **cleanup activities** such as releasing resources before memory is reclaimed.

Important:

* It is called **only once per object**
* It is **not guaranteed to run**

---

## 2️⃣ Visual Representation

### Object Lifecycle

```id="fin_v1"
Object Created
      |
Object Used
      |
Object Becomes Unreachable
      |
Garbage Collector detects it
      |
finalize() executed
      |
Object memory removed
```

---

### GC Invocation Flow

```id="fin_v2"
Program Running
      |
Object not referenced
      |
Eligible for Garbage Collection
      |
GC calls finalize()
```

---

### Memory Cleanup

```id="fin_v3"
Heap Memory
   |
   |-- Object (no references)
   |
   |-- finalize() called
   |
Memory released
```

---

## 3️⃣ Key Features / Properties

* Defined in `Object` class
* Called by **Garbage Collector**
* Used for cleanup operations
* Runs **before object destruction**
* Executed only once
* Not guaranteed to execute
* Deprecated in modern Java (Java 9+)

---

## 4️⃣ Syntax

Method signature:

```java
protected void finalize() throws Throwable
```

---

## 5️⃣ Code Example

```java
class Test {

    protected void finalize() {
        System.out.println("Object destroyed");
    }

    public static void main(String[] args) {

        Test obj = new Test();

        obj = null;

        System.gc();
    }
}
```

Possible Output:

```
Object destroyed
```

Explanation:

* Object becomes eligible for GC
* JVM may call `finalize()`

---

## 6️⃣ Use Cases

* Resource cleanup
* Closing file streams
* Releasing database connections
* Logging object destruction
* Debugging memory issues

---

## 7️⃣ Pitfalls / Notes

* ❌ Not guaranteed to execute
* ❌ Execution timing unpredictable
* ❌ Deprecated since Java 9
* ❌ Slows down garbage collection
* ❌ Not recommended for resource cleanup
* ❌ Prefer `try-with-resources` or `close()`

---

## 8️⃣ Real-World Analogy

🧹 House Cleaning Before Demolition

* House used normally
* Before demolition → cleanup happens

`finalize()` = cleanup before object removal.

---

## 9️⃣ Best Practices

* Avoid using `finalize()`
* Use **try-with-resources** instead
* Explicitly close resources
* Use `AutoCloseable` interface
* Prefer modern resource management

---

## 🔟 Tricky Questions

1. What is finalize() method?
   ➜ Method called before object is garbage collected.

2. Which class defines finalize()?
   ➜ `Object` class.

3. Who calls finalize()?
   ➜ Garbage Collector.

4. Is finalize() guaranteed to run?
   ➜ No.

5. When is finalize() executed?
   ➜ Before object destruction.

6. Can finalize() run multiple times?
   ➜ No.

7. What is access modifier of finalize()?
   ➜ Protected.

8. Is finalize() deprecated?
   ➜ Yes (Java 9+).

9. Can we call finalize() manually?
   ➜ Yes but not recommended.

10. Which method suggests garbage collection?
    ➜ `System.gc()`.

11. Does GC always run when `System.gc()` called?
    ➜ No.

12. Is finalize reliable for resource cleanup?
    ➜ No.

13. Which modern feature replaces finalize()?
    ➜ try-with-resources.

14. Does every object have finalize()?
    ➜ Yes (inherited from Object).

15. Why was finalize deprecated?
    ➜ Unpredictable behavior and performance issues.

---

## 🧾 Quick Recap / Cheat Sheet

* finalize() defined in Object class
* Called by Garbage Collector
* Runs before object destruction
* Used for cleanup tasks
* Not guaranteed to execute
* Runs only once per object
* Access modifier = protected
* Deprecated in Java 9+
* GC decides execution time
* Not reliable for resource cleanup
* System.gc() only suggests GC
* Prefer try-with-resources
* Avoid using finalize() in modern Java
* Important JVM lifecycle concept
* Common interview question
