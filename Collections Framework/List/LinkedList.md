## 1️⃣ Definition

`LinkedList` is a class in Java that implements:

* `List` interface
* `Deque` interface

It is based on a **doubly linked list** data structure.

It:

* Maintains insertion order
* Allows duplicate elements
* Allows null values
* Supports fast insertion and deletion

Part of `java.util` package.

---

## 2️⃣ Visual Representation

### Doubly Linked Structure

```id="ll_v1"
[Prev | Data | Next] <--> [Prev | Data | Next] <--> [Prev | Data | Next]
```

Each node contains:

* Data
* Reference to previous node
* Reference to next node

---

### Memory View

```id="ll_v2"
Heap
   |
   |-- LinkedList Object
          |
          |-- Node1 <--> Node2 <--> Node3
```

---

### Insertion Concept

```id="ll_v3"
Before:
A <--> B <--> C

Insert X after A:

A <--> X <--> B <--> C
```

No shifting like ArrayList.

---

## 3️⃣ Key Features / Properties

* Implements List and Deque
* Doubly linked list
* Maintains insertion order
* Allows duplicates
* Allows null values
* Not synchronized
* Fast insertion/deletion (O(1) at ends)
* Slow random access (O(n))

---

## 4️⃣ Syntax

```java id="ll_s1"
List<String> list = new LinkedList<>();
```

Or as Deque:

```java id="ll_s2"
Deque<String> deque = new LinkedList<>();
```

---

## 5️⃣ Code Example

```java id="ll_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");

        list.addFirst("Start");
        list.addLast("End");

        System.out.println(list);

        list.remove("Python");

        System.out.println(list);
    }
}
```

---

## 6️⃣ Use Cases

* Frequent insertions/deletions
* Implementing Queue
* Implementing Deque
* Implementing Stack
* Undo/Redo operations
* Navigation systems

---

## 7️⃣ Pitfalls / Notes

* ❌ Slow random access
* ❌ Higher memory usage (extra references)
* ❌ Not thread-safe
* ❌ Not suitable for read-heavy scenarios
* ❌ Confusing with ArrayList
* ❌ Inefficient for large index-based operations

---

## 8️⃣ Real-World Analogy

🚂 Train Compartments

* Each compartment connected to next & previous
* Easy to attach/detach compartments
* Slow to jump directly to middle compartment

---

## 9️⃣ Best Practices

* Use when frequent insert/delete needed
* Avoid when heavy index-based access required
* Use List reference type
* Use Deque methods when needed
* Avoid unnecessary traversal
* Choose based on performance needs

---

## 🔟 Tricky Questions

1. What is LinkedList?
   ➜ Doubly linked list implementation of List.

2. Does LinkedList allow duplicates?
   ➜ Yes.

3. Does LinkedList allow null?
   ➜ Yes.

4. Is LinkedList synchronized?
   ➜ No.

5. What data structure is used internally?
   ➜ Doubly linked list.

6. What is time complexity of get(index)?
   ➜ O(n).

7. What is time complexity of insertion at beginning?
   ➜ O(1).

8. Which is better for random access: ArrayList or LinkedList?
   ➜ ArrayList.

9. Which is better for frequent insertions: ArrayList or LinkedList?
   ➜ LinkedList.

10. Does LinkedList implement Deque?
    ➜ Yes.

11. Can LinkedList be used as Stack?
    ➜ Yes.

12. Can LinkedList be used as Queue?
    ➜ Yes.

13. Does LinkedList use more memory than ArrayList?
    ➜ Yes.

14. Why is LinkedList slower for search?
    ➜ Requires traversal.

15. When should LinkedList be preferred?
    ➜ When frequent insertions/deletions are required.

🟧 16. Why is delete function faster in Linked list than array?
   ➜ In a Linked List, deletion only requires changing references (pointers) of adjacent nodes.
     In an Array, deleting an element requires shifting all subsequent elements to maintain order, which takes more time.

---

## 🧾 Quick Recap / Cheat Sheet

* Doubly linked list
* Implements List & Deque
* Maintains order
* Allows duplicates & null
* Fast insertion/deletion
* Slow random access
* Higher memory usage
* Not synchronized
* Good for Queue/Deque
* O(1) insertion at ends
* O(n) access by index
* Use when modification-heavy
* Part of java.util
* Common interview topic
* Choose based on use case

---
