## 1️⃣ Definition

**HashMap Internal Working** explains how `HashMap` stores, retrieves, and manages key–value pairs using:

* Hashing
* Buckets
* Collision handling
* Resizing
* Tree conversion (JDK 8+)

HashMap internally uses:

* Array (bucket table)
* Linked List (before JDK 8)
* Red-Black Tree (JDK 8+, when threshold exceeded)

---

## 2️⃣ Visual Representation

### Step 1: Hash Calculation

```id="hmi_v1"
Key
  |
  |-- hashCode()
  |
  |-- hash = (h ^ (h >>> 16))
  |
Bucket Index = hash & (n - 1)
```

Where:

* n = table length

---

### Step 2: Bucket Structure

```id="hmi_v2"
Bucket[3]
   |
   |-- Node(K1,V1)
   |-- Node(K2,V2)  ← Collision
   |-- Node(K3,V3)
```

---

### Step 3: Tree Conversion (JDK 8+)

```id="hmi_v3"
If bucket size > 8
      |
Linked List → Red-Black Tree
```

---

### Step 4: Resizing

```id="hmi_v4"
Size > capacity * loadFactor
      |
New capacity = old capacity * 2
      |
Rehash elements
```

---

## 3️⃣ Key Features / Properties

* Default capacity = 16
* Default load factor = 0.75
* Time complexity:

  * get() → O(1) average
  * put() → O(1) average
* Collision handled via chaining
* JDK 8+: Treeification threshold = 8
* Resize when threshold exceeded
* Index calculation uses bitwise AND
* Not synchronized

---

## 4️⃣ Syntax

```java id="hmi_s1"
Map<String, Integer> map = new HashMap<>();
```

With capacity & load factor:

```java id="hmi_s2"
Map<String, Integer> map =
    new HashMap<>(32, 0.75f);
```

---

## 5️⃣ Code Example

```java id="hmi_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        System.out.println(map.get("B"));
    }
}
```

Internally:

1. Compute hash
2. Find bucket index
3. If bucket empty → insert
4. If collision → check equals()
5. Insert or replace
6. Resize if threshold crossed

---

## 6️⃣ Use Cases

* Fast key-based lookup
* Caching systems
* Database indexing
* Configuration storage
* Counting frequency
* In-memory storage

---

## 7️⃣ Pitfalls / Notes

* ❌ Poor hashCode() causes collisions
* ❌ Not overriding equals() properly
* ❌ Mutable keys break map behavior
* ❌ Not thread-safe
* ❌ Resize operation costly
* ❌ Heavy collisions degrade to O(n)

---

## 8️⃣ Real-World Analogy

📦 Parcel Sorting System

* Each parcel has barcode (hashCode)
* Barcode determines sorting bin (bucket)
* If bin crowded → arranged inside
* If too crowded → structured arrangement (tree)

---

## 9️⃣ Best Practices

* Always override equals() & hashCode()
* Use immutable keys
* Provide initial capacity if size known
* Avoid heavy collisions
* Prefer ConcurrentHashMap for multi-threading
* Understand load factor tuning

---

## 🔟 Tricky Questions

1. What is default capacity of HashMap?
   ➜ 16.

2. What is default load factor?
   ➜ 0.75.

3. How is bucket index calculated?
   ➜ hash & (n - 1).

4. What happens during collision?
   ➜ Elements stored in same bucket (chaining).

5. What changed in JDK 8?
   ➜ Linked list converts to Red-Black Tree after threshold.

6. What is treeify threshold?
   ➜ 8.

7. When does resizing occur?
   ➜ When size > capacity × load factor.

8. What is time complexity of get()?
   ➜ O(1) average.

9. Can performance degrade?
   ➜ Yes, heavy collisions → O(n).

10. Why must equals() and hashCode() be consistent?
    ➜ To maintain proper key behavior.

11. Can HashMap store null key?
    ➜ Yes (one).

12. Is HashMap thread-safe?
    ➜ No.

13. What is rehashing?
    ➜ Recalculating bucket positions during resize.

14. What data structures used internally?
    ➜ Array + LinkedList + Red-Black Tree.

15. Why is power-of-two capacity used?
    ➜ Efficient index calculation using bitwise AND.

---

## 🧾 Quick Recap / Cheat Sheet

* Uses hashing mechanism
* Default capacity = 16
* Load factor = 0.75
* Bucket index = hash & (n - 1)
* Collision handled via chaining
* JDK 8 → Tree after 8 elements
* Resize doubles capacity
* O(1) average performance
* Not thread-safe
* Uses equals() & hashCode()
* Avoid mutable keys
* Heavy collisions reduce performance
* Backed by array
* Rehashing during resize
* Very common interview topic

---
