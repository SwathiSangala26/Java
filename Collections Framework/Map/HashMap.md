## 1️⃣ Definition

`HashMap` is a class in Java that implements the `Map` interface and stores data in **key–value pairs**.

It:

* Does NOT allow duplicate keys
* Allows duplicate values
* Allows one null key
* Allows multiple null values
* Is NOT synchronized
* Is based on hashing

It is part of `java.util` package.

---

## 2️⃣ Visual Representation

### Key–Value Structure

```id="hm_v1"
Key        Value
----       -----
"A"   →     10
"B"   →     20
"C"   →     30
```

---

### Internal Working (Hashing)

```id="hm_v2"
Key
  |
  |-- hashCode()
  |
Bucket Index
  |
  |-- Store Node(key, value)
```

---

### Collision Handling

```id="hm_v3"
Bucket[5]
   |
   |-- (K1,V1)
   |-- (K2,V2)   // collision
```

(JDK 8+ → Linked List converts to Tree if large)

---

## 3️⃣ Key Features / Properties

* Implements `Map`
* Stores key–value pairs
* No duplicate keys
* Allows one null key
* Not synchronized
* Average time complexity O(1)
* Backed by array + linked list / tree
* Uses `hashCode()` and `equals()`
* Default initial capacity = 16
* Default load factor = 0.75

---

## 4️⃣ Syntax

```java id="hm_s1"
Map<String, Integer> map = new HashMap<>();
```

---

## 5️⃣ Code Example

```java id="hm_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("Java", 1);
        map.put("Python", 2);
        map.put("Java", 3);   // Replaces old value

        map.put(null, 100);   // One null key allowed

        System.out.println(map);

        System.out.println("Value for Java: " + map.get("Java"));
    }
}
```

---

## 6️⃣ Use Cases

* Caching
* Database record mapping
* Configuration storage
* Fast lookup
* Counting frequency
* Key-based retrieval systems

---

## 7️⃣ Pitfalls / Notes

* ❌ Does not maintain order
* ❌ Not thread-safe
* ❌ Must override equals() & hashCode() properly
* ❌ Poor hashCode affects performance
* ❌ Allows only one null key
* ❌ Resizing is costly

---

## 8️⃣ Real-World Analogy

📖 Dictionary

* Word → Meaning
* Unique word (key)
* Meaning can repeat

---

## 9️⃣ Best Practices

* Always override equals() & hashCode() for custom keys
* Use initial capacity if size known
* Prefer ConcurrentHashMap for multi-threading
* Avoid mutable keys
* Use Map reference type
* Choose LinkedHashMap if order required

---

## 🔟 Tricky Questions

1. What is HashMap?
   ➜ Map implementation based on hashing.

2. Does HashMap allow duplicate keys?
   ➜ No.

3. Does HashMap allow duplicate values?
   ➜ Yes.

4. Does HashMap allow null key?
   ➜ Yes (one).

5. Is HashMap synchronized?
   ➜ No.

6. What is default initial capacity?
   ➜ 16.

7. What is default load factor?
   ➜ 0.75.

8. What is time complexity of get()?
   ➜ O(1) average.

9. What happens during collision?
   ➜ Stored in same bucket (list/tree).

10. What change happened in JDK 8?
    ➜ Bucket converts to Tree if threshold exceeded.

11. Which methods ensure key uniqueness?
    ➜ hashCode() and equals().

12. Can HashMap be used in multi-threading safely?
    ➜ No.

13. What happens if equals overridden but hashCode not?
    ➜ Contract breaks.

14. Is HashMap ordered?
    ➜ No.

15. Which Map maintains insertion order?
    ➜ LinkedHashMap.

---

## 🧾 Quick Recap / Cheat Sheet

* HashMap = Key–Value storage
* No duplicate keys
* Allows one null key
* Not synchronized
* O(1) average performance
* Backed by array + list/tree
* Default capacity = 16
* Load factor = 0.75
* Uses hashCode() & equals()
* Not ordered
* JDK 8 → Tree conversion
* Avoid mutable keys
* Common interview topic
* Fast lookup
* Part of java.util

---
