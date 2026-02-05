## 1️⃣ What is a Set?

```
Set = Collection that stores UNIQUE elements
```

### Key rules

```
✔ No duplicate elements
✔ At most one null (depends on implementation)
✔ Order depends on implementation
✔ Part of Java Collection Framework
```

---

## 2️⃣ Where is Set defined?

```
Package  : java.util
Type     : Interface
```

### Definition (simplified)

```java
public interface Set<E> extends Collection<E>
```

### Important point

```
❌ Set does NOT store data
✔ Set only defines rules (contract)
```

---

## 3️⃣ Core methods in Set

```
add(E e)
remove(Object o)
contains(Object o)
size()
isEmpty()
iterator()
clear()
```

---

## 4️⃣ Set hierarchy (VISUAL)

```
Iterable
   |
Collection
   |
Set   (interface)
   |
---------------------------------
|              |                |
HashSet     LinkedHashSet     TreeSet
(class)        (class)         (class)
```

---

## 5️⃣ Set implementations (BIG PICTURE)

```
HashSet        → fastest, no order
LinkedHashSet  → insertion order
TreeSet        → sorted order
```

---

## 6️⃣ HashSet

### Definition

```
Package : java.util
Type    : Class
```

```java
public class HashSet<E>
    extends AbstractSet<E>
    implements Set<E>, Cloneable, Serializable
```

### Internal working

```
HashSet DOES NOT extend HashMap
HashSet HAS-A HashMap (composition)
```

```java
private transient HashMap<E, Object> map;
```

### How add() works

```
set.add(10)
→ map.put(10, PRESENT)
```

### Properties

```
✔ No duplicates
✔ No order guaranteed
✔ Allows ONE null
✔ Very fast
```

### Time complexity

```
add()      → O(1) average
remove()   → O(1) average
contains() → O(1) average
Worst case → O(n) (hash collisions)
```

### When to use

```
✔ Order not required
✔ Performance is priority
```

---

## 7️⃣ LinkedHashSet

### Definition

```
Package : java.util
Type    : Class
```

```java
public class LinkedHashSet<E>
    extends HashSet<E>
```

### Internal working

```
Uses LinkedHashMap internally
(HashMap + Doubly Linked List)
```

### Properties

```
✔ No duplicates
✔ Maintains INSERTION order
✔ Allows ONE null
✔ Slightly slower than HashSet
```

### Time complexity

```
add()      → O(1)
remove()   → O(1)
contains() → O(1)
```

### When to use

```
✔ Need uniqueness
✔ Need insertion order
```

---

## 8️⃣ TreeSet

### Definition

```
Package : java.util
Type    : Class
```

```java
public class TreeSet<E>
    extends AbstractSet<E>
    implements NavigableSet<E>
```

### Internal working

```
Uses TreeMap internally
TreeMap is based on Red-Black Tree
```

### Properties

```
✔ No duplicates
✔ Always SORTED
❌ Null NOT allowed
✔ Supports range operations
```

### Sorting rules

```
Natural order OR Custom Comparator
```

### Time complexity (IMPORTANT)

```
add()      → O(log n)
remove()   → O(log n)
contains() → O(log n)
```

### Why O(log n)?

```
• Data stored as balanced tree
• Each comparison removes HALF the data
• Tree height ≈ log n
```

### When to use

```
✔ Sorted data required
✔ Need first(), last(), higher(), lower()
```

---

## 9️⃣ Comparison Table (VERY IMPORTANT)

```
--------------------------------------------------------
Feature        HashSet   LinkedHashSet   TreeSet
--------------------------------------------------------
Order          ❌ No        ✔ Insertion     ✔ Sorted
Duplicates     ❌           ❌               ❌
Null allowed   ✔ One        ✔ One            ❌
Internal DS    HashMap     LinkedHashMap    TreeMap
Time           O(1)        O(1)             O(log n)
--------------------------------------------------------
```

---

## 🔟 Why Set does NOT allow duplicates?

```
HashSet / LinkedHashSet
→ Uses Map keys (keys are unique)

TreeSet
→ Uses compareTo / Comparator
→ If compare() == 0 → duplicate
```

---

## 1️⃣1️⃣ equals() & hashCode() (VERY IMPORTANT)

### Used by

```
HashSet
LinkedHashSet
```

### Rule

```
If equals() is same
→ hashCode() MUST be same
```

If not implemented correctly:

```
❌ Duplicate elements may appear
```

---

## 1️⃣2️⃣ Comparable vs Comparator (TreeSet)

```
Comparable → natural sorting (inside class)
Comparator → custom sorting (outside class)
```

TreeSet NEEDS one of them.

---

## 1️⃣3️⃣ Why TreeSet does NOT allow null?

```
TreeSet must compare elements
null cannot be compared
→ NullPointerException
```

---

## 1️⃣4️⃣ AbstractSet – why it exists?

```
Provides default implementations:
size(), isEmpty(), removeAll(), etc.

Avoids duplicate code
```

---

## 1️⃣5️⃣ Program to Interface (BEST PRACTICE)

```
Set<Integer> set = new HashSet<>();
Set<Integer> set = new LinkedHashSet<>();
Set<Integer> set = new TreeSet<>();
```

Why?

```
✔ Easy to change implementation
✔ Loose coupling
```

---

## 1️⃣6️⃣ Real-life analogy

```
HashSet        → Box of keys (fast, random)
LinkedHashSet  → Keys on hook (order preserved)
TreeSet        → Keys arranged smallest → largest
```

---

## 1️⃣7️⃣ One-line interview answers

```
Set → Collection that does not allow duplicates
HashSet → Uses HashMap, O(1)
LinkedHashSet → Maintains insertion order
TreeSet → Sorted set using Red-Black Tree, O(log n)
```

---

## 1️⃣8️⃣ Most important memory lines 🧠

```
Set = uniqueness
HashSet = fastest
LinkedHashSet = ordered
TreeSet = sorted
