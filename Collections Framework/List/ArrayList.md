## 1️⃣ Definition

`ArrayList` is a resizable array implementation of the `List` interface in Java.

It:

* Maintains insertion order
* Allows duplicate elements
* Allows null values
* Provides fast random access

It is part of `java.util` package.

---

## 2️⃣ Visual Representation

### Internal Structure

```id="al_v1"
ArrayList
    |
    |-- Dynamic Array
    |
Index → 0   1   2   3
        A   B   C   D
```

---

### Dynamic Resizing

```id="al_v2"
Capacity = 10
Add 11th element
     |
New capacity ≈ 15 (grows by 50%)
```

---

### Memory View

```id="al_v3"
Heap
   |
   |-- ArrayList Object
          |
          |-- Object[] elementData
```

---

## 3️⃣ Key Features / Properties

* Implements `List` interface
* Backed by dynamic array
* Maintains insertion order
* Allows duplicates
* Allows multiple null values
* Not synchronized
* Fast random access (O(1))
* Slow insertion/deletion in middle (O(n))

---

## 4️⃣ Syntax

```java id="al_s1"
List<String> list = new ArrayList<>();
```

---

## 5️⃣ Code Example

```java id="al_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("Java");  // duplicate allowed
        list.add(null);    // null allowed

        System.out.println(list);
        System.out.println("Element at index 1: " + list.get(1));

        list.remove("Python");

        System.out.println(list);
    }
}
```

---

## 6️⃣ Use Cases

* Dynamic data storage
* When frequent read operations required
* Storing ordered data
* UI data handling
* API result storage
* Replacing arrays

---

## 7️⃣ Pitfalls / Notes

* ❌ Slow insertion/deletion in middle
* ❌ Not thread-safe
* ❌ Frequent resizing impacts performance
* ❌ Not suitable for heavy insert operations
* ❌ Confusing capacity with size
* ❌ Not overriding equals() properly for custom objects

---

## 8️⃣ Real-World Analogy

📒 Expandable Notebook

* Pages arranged in order
* Can add more pages when full
* Can access any page quickly by number

---

## 9️⃣ Best Practices

* Use initial capacity if size known
* Use List reference type
* Prefer ArrayList for read-heavy operations
* Avoid frequent middle insertions
* Use Collections.synchronizedList if needed
* Use generics always

---

## 🔟 Tricky Questions

1. What is ArrayList?
   ➜ Resizable array implementation of List.

2. Does ArrayList allow duplicates?
   ➜ Yes.

3. Does ArrayList allow null?
   ➜ Yes.

4. Is ArrayList synchronized?
   ➜ No.

5. What is default capacity of ArrayList?
   ➜ 10.

6. How does ArrayList grow?
   ➜ Increases by 50% of current capacity.

7. What is time complexity of get()?
   ➜ O(1).

8. What is time complexity of remove() in middle?
   ➜ O(n).

9. What is difference between size and capacity?
   ➜ Size = elements count; Capacity = internal array length.

10. Is ArrayList thread-safe?
    ➜ No.

11. How to make ArrayList thread-safe?
    ➜ Using Collections.synchronizedList().

12. Which is faster for search: ArrayList or LinkedList?
    ➜ ArrayList.

13. Can ArrayList store primitive types?
    ➜ No (uses wrapper classes).

14. What happens when capacity exceeds?
    ➜ New larger array created and elements copied.

15. Is ArrayList good for frequent insertions at beginning?
    ➜ No.

---

## 🧾 Quick Recap / Cheat Sheet

* Dynamic array
* Implements List
* Maintains order
* Allows duplicates & null
* Fast random access O(1)
* Slow insert/delete O(n)
* Default capacity = 10
* Grows by 50%
* Not synchronized
* Use generics
* Good for read-heavy operations
* Backed by Object[]
* Resizable
* Common interview topic
* Part of java.util

---
