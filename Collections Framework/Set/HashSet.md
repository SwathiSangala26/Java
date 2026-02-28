## 1️⃣ Definition

`HashSet` is a class in Java that implements the `Set` interface.

It:

* Does NOT allow duplicate elements
* Does NOT maintain insertion order
* Allows one null value
* Is backed by a `HashMap` internally

It is part of `java.util` package.

---

## 2️⃣ Visual Representation

### Internal Working

```id="hs_v1"
HashSet
   |
   |-- Internally uses HashMap
   |
   |-- Value stored as key in HashMap
```

---

### No Duplicates

```id="hs_v2"
Add: A
Add: B
Add: A  ❌ Ignored
```

---

### Hashing Concept

```id="hs_v3"
Element
   |
   |-- hashCode()
   |
Bucket Index
   |
   |-- equals() check (if collision)
```

---

## 3️⃣ Key Features / Properties

* Implements `Set`
* No duplicate elements
* Does not maintain order
* Allows one null
* Not synchronized
* Based on hashing
* Average time complexity O(1)
* Uses `hashCode()` and `equals()`

---

## 4️⃣ Syntax

```java id="hs_s1"
Set<String> set = new HashSet<>();
```

---

## 5️⃣ Code Example

```java id="hs_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("Java");
        set.add("Python");
        set.add("Java");  // Duplicate ignored
        set.add(null);

        System.out.println(set);

        set.remove("Python");

        System.out.println(set);
    }
}
```

---

## 6️⃣ Use Cases

* Removing duplicates
* Fast lookup
* Unique ID storage
* Caching
* Membership checking
* Data filtering

---

## 7️⃣ Pitfalls / Notes

* ❌ Order not guaranteed
* ❌ Must override equals() & hashCode() for custom objects
* ❌ Not thread-safe
* ❌ Hash collisions affect performance
* ❌ Cannot store multiple nulls
* ❌ Poor hashCode implementation reduces performance

---

## 8️⃣ Real-World Analogy

🆔 Unique ID Registry

* Each ID must be unique
* Duplicate ID rejected
* Order not important

---

## 9️⃣ Best Practices

* Override equals() and hashCode() properly
* Use LinkedHashSet if order needed
* Use TreeSet if sorted order required
* Avoid storing mutable objects
* Use generics
* Prefer Set reference type

---

## 🔟 Tricky Questions

1. What is HashSet?
   ➜ Implementation of Set using hashing.

2. Does HashSet allow duplicates?
   ➜ No.

3. Does HashSet maintain insertion order?
   ➜ No.

4. Does HashSet allow null?
   ➜ Yes (one null).

5. Is HashSet synchronized?
   ➜ No.

6. What is time complexity of add()?
   ➜ O(1) average.

7. Which methods are important for HashSet?
   ➜ hashCode() and equals().

8. What happens if equals() overridden but hashCode() not?
   ➜ Contract breaks, unexpected behavior.

9. Can HashSet store custom objects?
   ➜ Yes.

10. What happens during collision?
    ➜ equals() used to compare elements.

11. Is HashSet ordered?
    ➜ No.

12. Which class backs HashSet internally?
    ➜ HashMap.

13. Can HashSet contain duplicates of null?
    ➜ No.

14. Which Set maintains insertion order?
    ➜ LinkedHashSet.

15. Which Set maintains sorted order?
    ➜ TreeSet.

---

## 🧾 Quick Recap / Cheat Sheet

* HashSet = Unique elements
* Implements Set
* Backed by HashMap
* No duplicates
* No order guarantee
* Allows one null
* Uses hashCode() & equals()
* O(1) average performance
* Not thread-safe
* Good for lookup
* Override equals & hashCode
* Part of java.util
* Common interview topic
* Not sorted
* Use when uniqueness required

---
