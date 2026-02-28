## 1️⃣ Definition

`TreeSet` is a class in Java that implements the `Set` interface and stores elements in **sorted order**.

It:

* Does NOT allow duplicate elements
* Does NOT allow null (in natural ordering)
* Stores elements in ascending order by default
* Is backed by a `TreeMap` internally

It is part of `java.util` package.

---

## 2️⃣ Visual Representation

### Internal Structure (Red-Black Tree)

```id="ts_v1"
        20
       /  \
     10    30
     / \
    5  15
```

Balanced Binary Search Tree (Red-Black Tree).

---

### Sorted Order

```id="ts_v2"
Add: 30
Add: 10
Add: 20

Stored As:
[10, 20, 30]
```

Automatically sorted.

---

### No Duplicates

```id="ts_v3"
Add: 10
Add: 10  ❌ Ignored
```

---

## 3️⃣ Key Features / Properties

* Implements `NavigableSet`
* Sorted set
* No duplicates
* Does not allow null (in natural ordering)
* Not synchronized
* Backed by `TreeMap`
* Uses Red-Black Tree
* Time complexity O(log n)
* Uses `Comparable` or `Comparator`

---

## 4️⃣ Syntax

```java id="ts_s1"
Set<Integer> set = new TreeSet<>();
```

With Comparator:

```java id="ts_s2"
Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
```

---

## 5️⃣ Code Example

```java id="ts_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();

        set.add(30);
        set.add(10);
        set.add(20);
        set.add(10);  // Duplicate ignored

        System.out.println(set);  // Sorted output
    }
}
```

---

## 6️⃣ Use Cases

* Sorted unique data
* Ranking systems
* Leaderboards
* Range queries
* Autocomplete systems
* Navigation-based operations (ceiling, floor, etc.)

---

## 7️⃣ Pitfalls / Notes

* ❌ Does not allow null (natural ordering)
* ❌ Slower than HashSet
* ❌ Must implement Comparable for custom objects
* ❌ Comparator must be consistent with equals
* ❌ Not thread-safe
* ❌ Ordering impacts performance

---

## 8️⃣ Real-World Analogy

🏆 Ranking Board

* Players automatically arranged by score
* No duplicate ranking
* Always sorted

---

## 9️⃣ Best Practices

* Use when sorted data required
* Implement Comparable correctly
* Use Comparator for custom sorting
* Prefer HashSet if sorting not required
* Avoid null values
* Use generics

---

## 🔟 Tricky Questions

1. What is TreeSet?
   ➜ Sorted Set implementation.

2. Does TreeSet allow duplicates?
   ➜ No.

3. Does TreeSet allow null?
   ➜ No (in natural ordering).

4. What data structure does TreeSet use?
   ➜ Red-Black Tree.

5. What is time complexity of add()?
   ➜ O(log n).

6. Which interface does TreeSet implement?
   ➜ NavigableSet.

7. Is TreeSet synchronized?
   ➜ No.

8. Which class backs TreeSet internally?
   ➜ TreeMap.

9. How does TreeSet sort elements?
   ➜ Using Comparable or Comparator.

10. What happens if custom object does not implement Comparable?
    ➜ ClassCastException.

11. Which is faster: HashSet or TreeSet?
    ➜ HashSet.

12. Can we provide custom sorting in TreeSet?
    ➜ Yes.

13. Is TreeSet ordered?
    ➜ Yes (sorted order).

14. Does TreeSet maintain insertion order?
    ➜ No.

15. When should TreeSet be used?
    ➜ When sorted unique elements required.

---

## 🧾 Quick Recap / Cheat Sheet

* TreeSet = Sorted Set
* No duplicates
* No null (natural order)
* Backed by TreeMap
* Uses Red-Black Tree
* O(log n) operations
* Uses Comparable/Comparator
* Not synchronized
* Sorted automatically
* Slower than HashSet
* Good for ranking & range queries
* Implements NavigableSet
* Not insertion ordered
* Important interview topic
* Use when sorting required

---
