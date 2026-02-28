## 1️⃣ Definition

`PriorityQueue` is a class in Java that implements the `Queue` interface and orders elements based on **priority**.

It:

* Does NOT allow null elements
* Allows duplicate elements
* Orders elements using natural ordering (default) or Comparator
* Is backed by a **binary heap**

It is part of `java.util` package.

---

## 2️⃣ Visual Representation

### Min-Heap Structure (Default)

```id="pq_v1"
        10
       /  \
     20    30
     / \
    40  50
```

Smallest element always at the root.

---

### Priority Behavior

```id="pq_v2"
Add: 30
Add: 10
Add: 20

Internal Order (Heap):
[10, 30, 20]

Remove (poll):
10 removed first
```

---

### Not Insertion Order

```id="pq_v3"
Inserted: 5, 1, 3
Output (poll order):
1, 3, 5
```

---

## 3️⃣ Key Features / Properties

* Implements `Queue`
* Based on binary heap
* Default → Min-Heap
* No null elements allowed
* Allows duplicates
* Not synchronized
* Time complexity:

  * add() → O(log n)
  * poll() → O(log n)
  * peek() → O(1)
* Uses `Comparable` or `Comparator`

---

## 4️⃣ Syntax

### Default (Min-Heap)

```java id="pq_s1"
Queue<Integer> pq = new PriorityQueue<>();
```

---

### Custom Comparator (Max-Heap)

```java id="pq_s2"
Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
```

---

## 5️⃣ Code Example

```java id="pq_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(30);
        pq.add(10);
        pq.add(20);

        System.out.println("Peek: " + pq.peek());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
```

Output:
10
20
30

---

## 6️⃣ Use Cases

* Task scheduling
* CPU scheduling algorithms
* Dijkstra’s algorithm
* Event-driven systems
* Priority-based processing
* Real-time systems

---

## 7️⃣ Pitfalls / Notes

* ❌ Does not maintain insertion order
* ❌ Iteration does not guarantee sorted order
* ❌ Does not allow null
* ❌ Not thread-safe
* ❌ Custom objects must implement Comparable or use Comparator
* ❌ Removing arbitrary element is O(n)

---

## 8️⃣ Real-World Analogy

🏥 Hospital Emergency Room

* Patients treated based on severity
* Not based on arrival order
* Highest priority treated first

---

## 9️⃣ Best Practices

* Use Comparator for custom priority
* Use when frequent priority-based retrieval needed
* Prefer for scheduling problems
* Avoid using for sorted iteration
* Use generics
* Consider thread-safe alternative if needed

---

## 🔟 Tricky Questions

1. What is PriorityQueue?
   ➜ Queue that orders elements based on priority.

2. Does PriorityQueue allow duplicates?
   ➜ Yes.

3. Does PriorityQueue allow null?
   ➜ No.

4. What data structure backs PriorityQueue?
   ➜ Binary heap.

5. What is default ordering?
   ➜ Natural ordering (min-heap).

6. What is time complexity of add()?
   ➜ O(log n).

7. What is time complexity of peek()?
   ➜ O(1).

8. Is PriorityQueue synchronized?
   ➜ No.

9. Does iteration give sorted order?
   ➜ No.

10. How to create max-heap?
    ➜ Use Comparator.reverseOrder().

11. What happens if custom object does not implement Comparable?
    ➜ ClassCastException.

12. Is PriorityQueue FIFO?
    ➜ No.

13. Which element is removed first?
    ➜ Smallest (default).

14. Can PriorityQueue be used for Dijkstra algorithm?
    ➜ Yes.

15. When should PriorityQueue be used?
    ➜ When priority-based processing required.

---

## 🧾 Quick Recap / Cheat Sheet

* PriorityQueue = Priority-based queue
* Backed by binary heap
* Default min-heap
* Allows duplicates
* No null allowed
* O(log n) add/remove
* O(1) peek
* Not insertion ordered
* Not synchronized
* Uses Comparable/Comparator
* Used in scheduling algorithms
* Not FIFO
* Iteration not sorted
* Common interview topic
* Use for priority-based retrieval

---
