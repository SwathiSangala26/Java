## 1️⃣ Definition

`TreeMap` is a class in Java that implements the `NavigableMap` interface and stores key–value pairs in **sorted order of keys**.

It:

* Does NOT allow duplicate keys
* Does NOT allow null keys (natural ordering)
* Allows multiple null values
* Sorts keys using natural ordering or Comparator
* Is backed by a **Red-Black Tree**

It is part of `java.util` package.

---

## 2️⃣ Visual Representation

### Internal Structure (Red-Black Tree)

```id="tm_v1"
        20
       /  \
     10    30
     / \
    5  15
```

Balanced Binary Search Tree.

---

### Sorted by Keys

```id="tm_v2"
Put: 30=A
Put: 10=B
Put: 20=C

Stored As:
10=B
20=C
30=A
```

---

### No Duplicate Keys

```id="tm_v3"
Put: 10=A
Put: 10=B  → Replaces A
```

---

## 3️⃣ Key Features / Properties

* Implements `NavigableMap`
* Sorted by keys
* No duplicate keys
* Does not allow null key (natural order)
* Not synchronized
* Backed by Red-Black Tree
* Time complexity O(log n)
* Uses `Comparable` or `Comparator`
* Supports navigation methods (ceiling, floor, higher, lower)

---

## 4️⃣ Syntax

### Default (Natural Order)

```java id="tm_s1"
Map<Integer, String> map = new TreeMap<>();
```

---

### Custom Comparator

```java id="tm_s2"
Map<Integer, String> map =
    new TreeMap<>(Comparator.reverseOrder());
```

---

## 5️⃣ Code Example

```java id="tm_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> map = new TreeMap<>();

        map.put(30, "C");
        map.put(10, "A");
        map.put(20, "B");

        System.out.println(map);
    }
}
```

Output:
{10=A, 20=B, 30=C}

---

## 6️⃣ Use Cases

* Sorted key-value storage
* Leaderboards
* Ranking systems
* Range queries
* Autocomplete systems
* Financial data systems
* Navigation-based operations

---

## 7️⃣ Pitfalls / Notes

* ❌ Does not allow null key
* ❌ Slower than HashMap
* ❌ Must implement Comparable for custom keys
* ❌ Comparator must be consistent with equals
* ❌ Not thread-safe
* ❌ Sorting impacts performance

---

## 8️⃣ Real-World Analogy

📊 Sorted Phone Directory

* Names sorted alphabetically
* Cannot have duplicate name keys
* Always arranged in order

---

## 9️⃣ Best Practices

* Use when sorted keys required
* Implement Comparable correctly
* Use Comparator for custom sorting
* Prefer HashMap if sorting not required
* Avoid null keys
* Use generics

---

## 🔟 Tricky Questions

1. What is TreeMap?
   ➜ Sorted Map implementation.

2. Does TreeMap allow duplicate keys?
   ➜ No.

3. Does TreeMap allow null key?
   ➜ No (natural ordering).

4. What data structure backs TreeMap?
   ➜ Red-Black Tree.

5. What is time complexity of put()?
   ➜ O(log n).

6. Which interface does TreeMap implement?
   ➜ NavigableMap.

7. Is TreeMap synchronized?
   ➜ No.

8. How are keys sorted?
   ➜ Using Comparable or Comparator.

9. Which is faster: HashMap or TreeMap?
   ➜ HashMap.

10. What happens if key does not implement Comparable?
    ➜ ClassCastException.

11. Can TreeMap store null values?
    ➜ Yes.

12. What navigation methods does TreeMap support?
    ➜ ceiling(), floor(), higher(), lower().

13. Does TreeMap maintain insertion order?
    ➜ No.

14. Can custom sorting be applied?
    ➜ Yes.

15. When should TreeMap be used?
    ➜ When sorted key-based storage required.

---

## 🧾 Quick Recap / Cheat Sheet

* TreeMap = Sorted Map
* No duplicate keys
* No null key
* Allows null values
* Backed by Red-Black Tree
* O(log n) operations
* Uses Comparable/Comparator
* Not synchronized
* Sorted by keys
* Slower than HashMap
* Supports navigation methods
* Implements NavigableMap
* Not insertion ordered
* Important interview topic
* Use when sorted keys needed

---
