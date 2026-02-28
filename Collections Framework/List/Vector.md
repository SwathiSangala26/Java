## 1️⃣ Definition

`Vector` is a legacy class in Java that implements the `List` interface.

It is:

* A dynamic array
* Synchronized (thread-safe)
* Part of `java.util`
* Introduced in Java 1.0

It is similar to `ArrayList`, but synchronized.

---

## 2️⃣ Visual Representation

### Internal Structure

```id="vec_v1"
Vector
   |
   |-- Dynamic Array (Object[])
   |
Index → 0   1   2   3
        A   B   C   D
```

---

### Synchronization Concept

```id="vec_v2"
Thread1 ----\
              ---> Vector (methods synchronized)
Thread2 ----/
```

Only one thread can access at a time.

---

### Capacity Growth

```id="vec_v3"
Default Capacity = 10
When full →
Capacity doubles (or grows by increment)
```

---

## 3️⃣ Key Features / Properties

* Implements `List`
* Dynamic array
* Maintains insertion order
* Allows duplicates
* Allows null values
* Synchronized (thread-safe)
* Legacy class
* Slower than ArrayList due to synchronization
* Default capacity = 10

---

## 4️⃣ Syntax

```java id="vec_s1"
Vector<String> vector = new Vector<>();
```

---

## 5️⃣ Code Example

```java id="vec_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Vector<String> vector = new Vector<>();

        vector.add("Java");
        vector.add("Python");
        vector.add("Java");  // duplicate allowed

        System.out.println(vector);

        vector.remove("Python");

        System.out.println(vector);
    }
}
```

---

## 6️⃣ Use Cases

* Multi-threaded applications (legacy)
* When synchronization required
* Backward compatibility
* Thread-safe dynamic arrays
* Older enterprise systems

---

## 7️⃣ Pitfalls / Notes

* ❌ Slower than ArrayList
* ❌ Overhead due to synchronization
* ❌ Legacy class (rarely used now)
* ❌ Prefer ArrayList + Collections.synchronizedList
* ❌ Not ideal for high-performance apps

---

## 8️⃣ Real-World Analogy

🛡 Secured Notebook

* Only one person can write at a time
* Safe but slower

---

## 9️⃣ Best Practices

* Avoid using Vector in modern applications
* Prefer ArrayList
* Use concurrent collections if thread safety needed
* Use synchronization only when necessary
* Avoid legacy APIs

---

## 🔟 Tricky Questions

1. What is Vector?
   ➜ Synchronized dynamic array implementation of List.

2. Is Vector synchronized?
   ➜ Yes.

3. Does Vector allow duplicates?
   ➜ Yes.

4. Does Vector allow null values?
   ➜ Yes.

5. What is default capacity of Vector?
   ➜ 10.

6. How does Vector grow?
   ➜ Doubles capacity (or uses capacity increment).

7. Which is faster: ArrayList or Vector?
   ➜ ArrayList.

8. Why is Vector slower?
   ➜ Due to synchronization.

9. Is Vector legacy class?
   ➜ Yes.

10. Which package contains Vector?
    ➜ `java.util`.

11. Should we use Vector in modern Java?
    ➜ Generally no.

12. Can Vector be used in multi-threading?
    ➜ Yes.

13. Does Vector implement List?
    ➜ Yes.

14. Can we make ArrayList synchronized?
    ➜ Yes, using Collections.synchronizedList().

15. What replaced Vector in modern Java?
    ➜ ArrayList and concurrent collections.

---

## 🧾 Quick Recap / Cheat Sheet

* Vector = Synchronized dynamic array
* Implements List
* Maintains order
* Allows duplicates & null
* Thread-safe
* Default capacity = 10
* Grows by doubling
* Slower than ArrayList
* Legacy class
* Part of java.util
* Not preferred in modern apps
* Prefer ArrayList
* Use concurrent collections instead
* Important for interview comparison
* Understand difference with ArrayList

---
