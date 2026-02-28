## 1️⃣ Definition

`ArrayDeque` is a resizable-array implementation of the `Deque` interface.

It:

* Supports both Stack (LIFO) and Queue (FIFO) operations
* Does NOT allow null elements
* Is NOT synchronized
* Is faster than `Stack` and `LinkedList` for stack/queue usage

It is part of `java.util` package.

---

## 2️⃣ Visual Representation

### Internal Structure (Circular Array)

```id="ad_v1"
Index: 0   1   2   3   4
       A   B   C   D   _
```

Uses circular array concept.

---

### Queue Mode (FIFO)

```id="ad_v2"
Front → [A][B][C][D] ← Rear

Remove → A first
```

---

### Stack Mode (LIFO)

```id="ad_v3"
Top → [D]
       [C]
       [B]
       [A]

Remove → D first
```

---

## 3️⃣ Key Features / Properties

* Implements `Deque`
* Based on dynamic circular array
* Supports both FIFO and LIFO
* No null elements allowed
* Not synchronized
* Faster than Stack
* Faster than LinkedList (for stack/queue ops)
* Time complexity:

  * add/remove at ends → O(1)

---

## 4️⃣ Syntax

### As Queue

```java id="ad_s1"
Deque<Integer> deque = new ArrayDeque<>();
```

---

### As Stack

```java id="ad_s2"
Deque<Integer> stack = new ArrayDeque<>();
```

---

## 5️⃣ Code Example

```java id="ad_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        // Queue operations
        deque.addLast(10);
        deque.addLast(20);
        deque.addLast(30);

        System.out.println("Queue Poll: " + deque.pollFirst());

        // Stack operations
        deque.push(40);
        System.out.println("Stack Pop: " + deque.pop());

        System.out.println(deque);
    }
}
```

---

## 6️⃣ Use Cases

* Implementing Stack (recommended)
* Implementing Queue
* Sliding window algorithms
* Expression evaluation
* Undo/Redo operations
* BFS/DFS traversal

---

## 7️⃣ Pitfalls / Notes

* ❌ Does not allow null
* ❌ Not thread-safe
* ❌ No random access by index
* ❌ Iteration not priority-based
* ❌ Capacity resizing cost occasionally

---

## 8️⃣ Real-World Analogy

🔄 Double-Ended Line

* Can enter from front or back
* Can remove from front or back
* Flexible structure

---

## 9️⃣ Best Practices

* Prefer ArrayDeque over Stack
* Prefer ArrayDeque over LinkedList for stack/queue
* Use Deque reference type
* Avoid null values
* Choose based on required operations
* Use concurrent alternative if thread safety needed

---

## 🔟 Tricky Questions

1. What is ArrayDeque?
   ➜ Resizable-array implementation of Deque.

2. Does ArrayDeque allow null?
   ➜ No.

3. Is ArrayDeque synchronized?
   ➜ No.

4. Which interface does ArrayDeque implement?
   ➜ Deque.

5. Can ArrayDeque be used as Stack?
   ➜ Yes.

6. Can ArrayDeque be used as Queue?
   ➜ Yes.

7. Which is faster: Stack or ArrayDeque?
   ➜ ArrayDeque.

8. Which is better for stack: LinkedList or ArrayDeque?
   ➜ ArrayDeque.

9. What is time complexity of addFirst()?
   ➜ O(1).

10. Does ArrayDeque maintain insertion order?
    ➜ Yes (for iteration).

11. What data structure backs ArrayDeque?
    ➜ Circular array.

12. Can ArrayDeque be used in BFS?
    ➜ Yes.

13. Why is ArrayDeque preferred over Stack?
    ➜ No synchronization overhead.

14. Is ArrayDeque thread-safe?
    ➜ No.

15. When should ArrayDeque be used?
    ➜ For efficient stack and queue operations.

---

## 🧾 Quick Recap / Cheat Sheet

* ArrayDeque = Resizable Deque
* Based on circular array
* No null allowed
* Not synchronized
* Supports FIFO & LIFO
* Faster than Stack
* Faster than LinkedList (for stack/queue)
* O(1) add/remove at ends
* Implements Deque
* Preferred stack implementation
* Good for BFS/DFS
* Not index-based
* Part of java.util
* Common interview topic
* Efficient double-ended operations

---
