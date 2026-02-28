## 1️⃣ Definition

**Hashing** is a technique used to convert a key into an integer value (hash code) to determine the index of a bucket in hash-based data structures like:

* `HashMap`
* `HashSet`
* `Hashtable`
* `ConcurrentHashMap`

A **Collision** occurs when:

* Two different keys produce the same bucket index.

---

## 2️⃣ Visual Representation

### Hashing Process

```id="hc_v1"
Key
  |
  |-- hashCode()
  |
Hash Value
  |
Bucket Index = hash & (n - 1)
  |
Stored in Bucket
```

---

### Collision Example

```id="hc_v2"
Key1 → hash → Bucket[5]
Key2 → hash → Bucket[5]  ← Collision
```

Both stored in same bucket.

---

### Collision Handling (Chaining)

```id="hc_v3"
Bucket[5]
   |
   |-- Node(K1,V1)
   |-- Node(K2,V2)
   |-- Node(K3,V3)
```

(JDK 8+: LinkedList → Tree if > 8 nodes)

---

## 3️⃣ Key Features / Properties

* Hashing provides fast lookup
* Uses `hashCode()` method
* Bucket index calculation: `hash & (n - 1)`
* Default capacity usually power of 2
* Average time complexity O(1)
* Heavy collisions degrade performance
* Collision handled by chaining
* JDK 8+: Tree conversion threshold = 8

---

## 4️⃣ Syntax

Example using HashMap:

```java id="hc_s1"
Map<String, Integer> map = new HashMap<>();
```

Custom key class must override:

```java id="hc_s2"
@Override
public int hashCode() { }

@Override
public boolean equals(Object obj) { }
```

---

## 5️⃣ Code Example

```java id="hc_ex1"
import java.util.*;

class Key {

    int id;

    Key(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 10;  // Forces collision
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((Key)obj).id;
    }
}

public class Main {

    public static void main(String[] args) {

        Map<Key, String> map = new HashMap<>();

        map.put(new Key(1), "A");
        map.put(new Key(2), "B");

        System.out.println(map);
    }
}
```

Both keys go to same bucket due to same hashCode.

---

## 6️⃣ Use Cases

* Fast data retrieval
* Caching
* Indexing
* Lookup tables
* Frequency counting
* Duplicate elimination

---

## 7️⃣ Pitfalls / Notes

* ❌ Poor hashCode() causes heavy collisions
* ❌ Not overriding equals() properly
* ❌ Using mutable keys
* ❌ Ignoring hashCode–equals contract
* ❌ Performance degrades to O(n) in worst case
* ❌ Not understanding treeification in JDK 8

---

## 8️⃣ Real-World Analogy

📦 Parcel Sorting

* Each parcel gets code (hash)
* Code decides sorting bin (bucket)
* If many parcels go to same bin → crowded (collision)
* If too crowded → structured arrangement (tree)

---

## 9️⃣ Best Practices

* Always override equals() & hashCode()
* Ensure both are consistent
* Use immutable keys
* Avoid constant hashCode
* Understand load factor
* Use good hashing strategy

---

## 🔟 Tricky Questions

1. What is hashing?
   ➜ Converting key into hash value for bucket placement.

2. What is collision?
   ➜ When two keys map to same bucket.

3. How is bucket index calculated?
   ➜ hash & (n - 1).

4. What method is used for hashing in Java?
   ➜ hashCode().

5. What method resolves collision equality?
   ➜ equals().

6. What happens during heavy collision?
   ➜ Performance degrades.

7. What change introduced in JDK 8?
   ➜ LinkedList converts to Red-Black Tree after 8 nodes.

8. What is time complexity with good hashing?
   ➜ O(1).

9. What is worst-case complexity?
   ➜ O(n).

10. Why capacity is power of 2?
    ➜ Efficient index calculation using bitwise AND.

11. Can two unequal objects have same hashCode?
    ➜ Yes.

12. Can two equal objects have different hashCode?
    ➜ No (violates contract).

13. What happens if equals overridden but hashCode not?
    ➜ Map behavior breaks.

14. Which collections use hashing?
    ➜ HashMap, HashSet, Hashtable, ConcurrentHashMap.

15. How to reduce collisions?
    ➜ Use good hashCode implementation.

---

## 🧾 Quick Recap / Cheat Sheet

* Hashing = Key → Bucket mapping
* Uses hashCode()
* Bucket index = hash & (n - 1)
* Collision = Same bucket for multiple keys
* Handled by chaining
* JDK 8 → Tree after 8 nodes
* O(1) average lookup
* O(n) worst case
* Override equals & hashCode
* Use immutable keys
* Capacity power of 2
* Poor hashing reduces performance
* Used in HashMap & HashSet
* Very important interview topic
* Core concept in collections

---
