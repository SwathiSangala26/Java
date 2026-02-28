## 1️⃣ Definition

`LinkedHashMap` is a class in Java that implements the `Map` interface.

It:

* Stores key–value pairs
* Does NOT allow duplicate keys
* Maintains insertion order (or access order)
* Allows one null key
* Allows multiple null values
* Is NOT synchronized

It combines:

* Hash table (like HashMap)
* Doubly linked list (to maintain order)

Part of `java.util` package.

---

## 2️⃣ Visual Representation

### Internal Structure

```id="lhm_v1"
LinkedHashMap
    |
    |-- Hash Table (for fast lookup)
    |-- Doubly Linked List (for order)
```

---

### Insertion Order Maintained

```id="lhm_v2"
Put: A=1
Put: B=2
Put: C=3

Iteration:
A=1, B=2, C=3
```

---

### Access Order Mode

```id="lhm_v3"
Access B
Order becomes:
A, C, B
```

(When created with access-order = true)

---

## 3️⃣ Key Features / Properties

* Extends `HashMap`
* Maintains insertion order
* Can maintain access order
* No duplicate keys
* Allows one null key
* Not synchronized
* Slightly slower than HashMap
* Useful for LRU cache
* Time complexity O(1) average

---

## 4️⃣ Syntax

### Default (Insertion Order)

```java id="lhm_s1"
Map<String, Integer> map = new LinkedHashMap<>();
```

---

### Access Order Mode

```java id="lhm_s2"
Map<String, Integer> map =
    new LinkedHashMap<>(16, 0.75f, true);
```

---

## 5️⃣ Code Example

```java id="lhm_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new LinkedHashMap<>();

        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        System.out.println(map);
    }
}
```

Output maintains insertion order.

---

## 6️⃣ Use Cases

* Maintaining insertion order
* LRU Cache implementation
* Ordered configuration storage
* API response formatting
* Caching systems
* Data processing pipelines

---

## 7️⃣ Pitfalls / Notes

* ❌ Slightly slower than HashMap
* ❌ Not thread-safe
* ❌ Must override equals() & hashCode() properly
* ❌ Consumes more memory than HashMap
* ❌ Not sorted (only ordered)

---

## 8️⃣ Real-World Analogy

📜 Ordered Dictionary

* Words stored with meaning
* Order preserved
* Lookup still fast

---

## 9️⃣ Best Practices

* Use when order matters
* Use access-order for LRU cache
* Prefer HashMap if order not required
* Avoid mutable keys
* Override equals() & hashCode() properly
* Use generics

---

## 🔟 Tricky Questions

1. What is LinkedHashMap?
   ➜ Ordered HashMap implementation.

2. Does LinkedHashMap allow duplicate keys?
   ➜ No.

3. Does LinkedHashMap maintain order?
   ➜ Yes (insertion or access).

4. Does LinkedHashMap allow null key?
   ➜ Yes (one).

5. Is LinkedHashMap synchronized?
   ➜ No.

6. Which class does LinkedHashMap extend?
   ➜ HashMap.

7. What is access-order mode?
   ➜ Maintains order based on access.

8. Which Map is used for LRU cache?
   ➜ LinkedHashMap.

9. Is LinkedHashMap sorted?
   ➜ No.

10. Which is faster: HashMap or LinkedHashMap?
    ➜ HashMap.

11. What is time complexity of get()?
    ➜ O(1) average.

12. Can LinkedHashMap be used in multi-threading safely?
    ➜ No.

13. Does it use hashing?
    ➜ Yes.

14. What extra structure does it maintain?
    ➜ Doubly linked list.

15. When should LinkedHashMap be used?
    ➜ When order + fast lookup required.

---

## 🧾 Quick Recap / Cheat Sheet

* LinkedHashMap = Ordered HashMap
* Maintains insertion order
* Optional access-order
* No duplicate keys
* Allows one null key
* Not synchronized
* Slightly slower than HashMap
* Uses hash table + linked list
* O(1) average performance
* Good for LRU cache
* Not sorted
* Extends HashMap
* More memory usage
* Common interview topic
* Use when order matters

---
