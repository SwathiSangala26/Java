## 1️⃣ Definition

The **Collection Hierarchy** in Java represents the structured architecture of interfaces and classes used to store and manipulate groups of objects.

It is part of the **Java Collections Framework (JCF)** in `java.util` package.

It provides:

* Data storage
* Dynamic resizing
* Searching & sorting
* Iteration support

---

## 2️⃣ Visual Representation

### Top-Level Hierarchy

```id="ch_v1"
                Iterable
                    |
                Collection
                    |
      --------------------------------
      |              |              |
     List            Set            Queue
      |
   ArrayList
   LinkedList
   Vector
```

---

### Map Hierarchy (Separate from Collection)

```id="ch_v2"
                Map
                 |
      -------------------------
      |           |           |
   HashMap     LinkedHashMap  TreeMap
```

Note: `Map` is NOT a child of Collection.

---

## 3️⃣ Key Features / Properties

* Part of `java.util`
* Based on interfaces
* Supports generics
* Dynamic data structures
* Provides iterators
* Allows sorting (Comparator/Comparable)
* Two main branches:

  * Collection
  * Map

---

## 4️⃣ Syntax

### List Example

```java id="ch_s1"
List<String> list = new ArrayList<>();
```

---

### Set Example

```java id="ch_s2"
Set<Integer> set = new HashSet<>();
```

---

### Map Example

```java id="ch_s3"
Map<String, Integer> map = new HashMap<>();
```

---

## 5️⃣ Code Example

```java id="ch_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");

        Set<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);

        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);

        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
    }
}
```

---

## 6️⃣ Use Cases

* Storing dynamic data
* Removing duplicates (Set)
* Maintaining order (List)
* Key-value storage (Map)
* Queue processing
* Caching
* Database result handling

---

## 7️⃣ Pitfalls / Notes

* ❌ Confusing List and Set
* ❌ Forgetting Map is not part of Collection
* ❌ Not overriding equals() and hashCode() properly
* ❌ Choosing wrong implementation
* ❌ Ignoring performance differences
* ❌ Using non-generic collections

---

## 8️⃣ Real-World Analogy

🗂 Filing System

* List → Ordered notebook
* Set → Unique ID registry
* Queue → Waiting line
* Map → Dictionary (Key → Value)

Each structure serves a different purpose.

---

## 9️⃣ Best Practices

* Use interface type for reference (List, Set, Map)
* Choose implementation based on requirement
* Use generics
* Override equals() & hashCode() when using Set/Map
* Prefer ArrayList for frequent reads
* Prefer LinkedList for frequent insertions
* Use TreeMap/TreeSet for sorted data

---

## 🔟 Tricky Questions

1. What is Collection Framework?
   ➜ A framework for storing and manipulating groups of objects.

2. Which package contains collections?
   ➜ `java.util`.

3. What is root interface of Collection hierarchy?
   ➜ `Iterable`.

4. Is Map part of Collection interface?
   ➜ No.

5. Difference between List and Set?
   ➜ List allows duplicates; Set does not.

6. Which collection maintains insertion order?
   ➜ LinkedHashSet, LinkedHashMap.

7. Which collection is sorted automatically?
   ➜ TreeSet, TreeMap.

8. Which list is dynamic array?
   ➜ ArrayList.

9. Which list is based on linked structure?
   ➜ LinkedList.

10. What is difference between HashMap and Hashtable?
    ➜ Hashtable is synchronized; HashMap is not.

11. Can HashMap store null key?
    ➜ Yes (one).

12. Can TreeMap store null key?
    ➜ No.

13. What method is required for HashSet uniqueness?
    ➜ equals() and hashCode().

14. What is difference between Comparable and Comparator?
    ➜ Comparable defines natural order; Comparator defines custom order.

15. Which interface allows iteration using for-each loop?
    ➜ Iterable.

---

## 🧾 Quick Recap / Cheat Sheet

* Part of java.util
* Root interface: Iterable
* Collection → List, Set, Queue
* Map separate hierarchy
* List → Allows duplicates
* Set → No duplicates
* Queue → FIFO
* Map → Key-Value pairs
* Use generics
* Choose implementation wisely
* HashMap → Fast lookup
* TreeMap → Sorted
* LinkedHashMap → Maintains order
* Important for performance
* Very common interview topic

---
