## 1️⃣ Definition

`Hashtable` is a legacy class in Java that implements the `Map` interface and stores data in **key–value pairs**.

It:

* Does NOT allow duplicate keys
* Does NOT allow null key
* Does NOT allow null value
* Is synchronized (thread-safe)
* Uses hashing internally

It is part of `java.util` package and introduced in Java 1.0.

---

## 2️⃣ Visual Representation

### Key–Value Storage

```id="ht_v1"
Key        Value
----       -----
"A"   →     10
"B"   →     20
"C"   →     30
```

---

### Hashing Concept

```id="ht_v2"
Key
  |
  |-- hashCode()
  |
Bucket Index
  |
  |-- Entry(key, value)
```

---

### Synchronization

```id="ht_v3"
Thread1 ----\
              ---> Hashtable (methods synchronized)
Thread2 ----/
```

Only one thread can access at a time.

---

## 3️⃣ Key Features / Properties

* Implements `Map`
* No duplicate keys
* No null key
* No null value
* Synchronized
* Legacy class
* Average time complexity O(1)
* Uses `hashCode()` and `equals()`
* Slower than HashMap

---

## 4️⃣ Syntax

```java id="ht_s1"
Map<String, Integer> table = new Hashtable<>();
```

---

## 5️⃣ Code Example

```java id="ht_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> table = new Hashtable<>();

        table.put("Java", 1);
        table.put("Python", 2);

        // table.put(null, 3);   ❌ Not allowed
        // table.put("C++", null); ❌ Not allowed

        System.out.println(table);
    }
}
```

---

## 6️⃣ Use Cases

* Legacy systems
* Thread-safe key-value storage
* Multi-threaded applications (older code)
* Backward compatibility
* Configuration storage

---

## 7️⃣ Pitfalls / Notes

* ❌ Slower due to synchronization
* ❌ No null key or value
* ❌ Legacy class (rarely used now)
* ❌ Prefer ConcurrentHashMap in modern apps
* ❌ Not suitable for high-performance systems
* ❌ Iteration requires Enumeration (legacy style)

---

## 8️⃣ Real-World Analogy

🛡 Locked Dictionary

* Only one person can access at a time
* Safer but slower

---

## 9️⃣ Best Practices

* Avoid using Hashtable in modern applications
* Prefer HashMap (single-threaded)
* Prefer ConcurrentHashMap (multi-threaded)
* Avoid legacy APIs
* Use Map interface as reference type
* Override equals() & hashCode() properly

---

## 🔟 Tricky Questions

1. What is Hashtable?
   ➜ Synchronized Map implementation.

2. Does Hashtable allow null key?
   ➜ No.

3. Does Hashtable allow null value?
   ➜ No.

4. Is Hashtable synchronized?
   ➜ Yes.

5. Which is faster: HashMap or Hashtable?
   ➜ HashMap.

6. Is Hashtable legacy class?
   ➜ Yes.

7. What is time complexity of put()?
   ➜ O(1) average.

8. Which package contains Hashtable?
   ➜ java.util.

9. Does Hashtable implement Map?
   ➜ Yes.

10. What replaced Hashtable in modern Java?
    ➜ ConcurrentHashMap.

11. Can Hashtable be used in multi-threading?
    ➜ Yes.

12. What methods ensure key uniqueness?
    ➜ hashCode() and equals().

13. Does Hashtable maintain order?
    ➜ No.

14. Why is Hashtable slower?
    ➜ Due to synchronization.

15. When should Hashtable be used?
    ➜ Only for legacy support.

---

## 🧾 Quick Recap / Cheat Sheet

* Hashtable = Synchronized Map
* No duplicate keys
* No null key or value
* Legacy class
* Slower than HashMap
* Thread-safe
* O(1) average performance
* Uses hashing
* Not ordered
* Prefer ConcurrentHashMap
* Part of java.util
* Introduced in Java 1.0
* Avoid in modern design
* Important interview comparison topic
* Understand difference from HashMap

---
