## 1️⃣ Definition

`LinkedHashSet` is a class in Java that implements the `Set` interface.

It:

* Does NOT allow duplicate elements
* Maintains insertion order
* Allows one null value
* Is backed by `LinkedHashMap` internally

It combines:

* Hashing (like HashSet)
* Linked list (to maintain order)

Part of `java.util` package.

---

## 2️⃣ Visual Representation

### Internal Structure

```id="lhs_v1"
LinkedHashSet
    |
    |-- Hash Table (for uniqueness)
    |-- Doubly Linked List (for order)
```

---

### Insertion Order Maintained

```id="lhs_v2"
Add: A
Add: B
Add: C

Output:
[A, B, C]
```

---

### No Duplicates

```id="lhs_v3"
Add: A
Add: B
Add: A   ❌ Ignored
```

---

## 3️⃣ Key Features / Properties

* Implements `Set`
* No duplicates
* Maintains insertion order
* Allows one null
* Not synchronized
* Slightly slower than HashSet
* Uses `hashCode()` and `equals()`
* Backed by `LinkedHashMap`

---

## 4️⃣ Syntax

```java id="lhs_s1"
Set<String> set = new LinkedHashSet<>();
```

---

## 5️⃣ Code Example

```java id="lhs_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> set = new LinkedHashSet<>();

        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("Java");  // Duplicate ignored

        System.out.println(set);
    }
}
```

Output maintains insertion order.

---

## 6️⃣ Use Cases

* Maintaining unique elements with order
* Cache implementation
* Removing duplicates while preserving order
* Ordered result sets
* Data processing pipelines

---

## 7️⃣ Pitfalls / Notes

* ❌ Slightly slower than HashSet
* ❌ Not sorted (only insertion order)
* ❌ Must override equals() & hashCode() properly
* ❌ Not thread-safe
* ❌ Cannot store multiple nulls

---

## 8️⃣ Real-World Analogy

📋 Attendance Register

* Names recorded in order
* No duplicate names allowed
* Order preserved

---

## 9️⃣ Best Practices

* Use when both uniqueness and order required
* Prefer HashSet if order not required
* Use TreeSet if sorting required
* Override equals() & hashCode() properly
* Use generics
* Avoid storing mutable objects

---

## 🔟 Tricky Questions

1. What is LinkedHashSet?
   ➜ Set implementation that maintains insertion order.

2. Does LinkedHashSet allow duplicates?
   ➜ No.

3. Does LinkedHashSet maintain order?
   ➜ Yes (insertion order).

4. Does LinkedHashSet allow null?
   ➜ Yes (one null).

5. Is LinkedHashSet synchronized?
   ➜ No.

6. Which class backs LinkedHashSet internally?
   ➜ LinkedHashMap.

7. Is LinkedHashSet sorted?
   ➜ No.

8. Which is faster: HashSet or LinkedHashSet?
   ➜ HashSet.

9. Why is LinkedHashSet slower than HashSet?
   ➜ Due to linked list maintenance.

10. What methods ensure uniqueness?
    ➜ hashCode() and equals().

11. Can LinkedHashSet store custom objects?
    ➜ Yes.

12. Which Set maintains sorted order?
    ➜ TreeSet.

13. Can LinkedHashSet be used for LRU cache?
    ➜ Yes (with LinkedHashMap logic).

14. Does it allow multiple null values?
    ➜ No.

15. When should LinkedHashSet be used?
    ➜ When uniqueness and insertion order both required.

---

## 🧾 Quick Recap / Cheat Sheet

* LinkedHashSet = Ordered HashSet
* No duplicates
* Maintains insertion order
* Allows one null
* Backed by LinkedHashMap
* Slightly slower than HashSet
* Not sorted
* Uses hashCode() & equals()
* Not thread-safe
* Good for ordered unique data
* Part of java.util
* O(1) average performance
* Common interview topic
* Use when order matters
* Combines hashing + linked list

---
