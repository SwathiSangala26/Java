## 1️⃣ Definition

`Stack` is a legacy class in Java that represents a **Last-In-First-Out (LIFO)** data structure.

It extends `Vector` class.

Operations follow:

* Push → Add element
* Pop → Remove top element
* Peek → View top element

Part of `java.util` package.

---

## 2️⃣ Visual Representation

### LIFO Structure

```id="stck_v1"
      TOP
       |
      [C]
      [B]
      [A]
```

Push order: A → B → C
Pop order: C → B → A

---

### Push Operation

```id="stck_v2"
Before:
[A]
[B]

Push C:

[C]
[A]
[B]
```

---

### Pop Operation

```id="stck_v3"
Before:
[C]
[A]
[B]

Pop:

[A]
[B]
```

---

## 3️⃣ Key Features / Properties

* Extends `Vector`
* Follows LIFO principle
* Synchronized (thread-safe)
* Allows duplicate elements
* Allows null values
* Legacy class
* Slower due to synchronization

---

## 4️⃣ Syntax

```java id="stck_s1"
Stack<String> stack = new Stack<>();
```

---

## 5️⃣ Code Example

```java id="stck_ex1"
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Top: " + stack.peek());

        stack.pop();

        System.out.println(stack);
    }
}
```

---

## 6️⃣ Use Cases

* Undo/Redo operations
* Expression evaluation
* Syntax parsing
* Backtracking algorithms
* Browser history
* Function call stack

---

## 7️⃣ Pitfalls / Notes

* ❌ Legacy class
* ❌ Slower due to synchronization
* ❌ Not preferred in modern Java
* ❌ Better alternative: `Deque` (ArrayDeque)
* ❌ Extends Vector unnecessarily

---

## 8️⃣ Real-World Analogy

📦 Stack of Plates

* Last plate placed → First plate removed
* LIFO behavior

---

## 9️⃣ Best Practices

* Prefer `Deque` (ArrayDeque) for stack implementation
* Avoid legacy Stack in modern applications
* Use generics
* Avoid synchronization unless required
* Use appropriate data structure for performance

---

## 🔟 Tricky Questions

1. What is Stack in Java?
   ➜ LIFO data structure.

2. Which class does Stack extend?
   ➜ Vector.

3. Is Stack synchronized?
   ➜ Yes.

4. What principle does Stack follow?
   ➜ LIFO.

5. What method adds element?
   ➜ push().

6. What method removes element?
   ➜ pop().

7. What method views top element?
   ➜ peek().

8. Is Stack legacy class?
   ➜ Yes.

9. Which is preferred instead of Stack?
   ➜ ArrayDeque.

10. Does Stack allow duplicates?
    ➜ Yes.

11. Does Stack allow null values?
    ➜ Yes.

12. Is Stack thread-safe?
    ➜ Yes.

13. What exception occurs when popping empty stack?
    ➜ EmptyStackException.

14. Which package contains Stack?
    ➜ java.util.

15. Why is Stack slower than ArrayDeque?
    ➜ Due to synchronization.

---

## 🧾 Quick Recap / Cheat Sheet

* Stack = LIFO structure
* Extends Vector
* Synchronized
* Methods: push, pop, peek
* Allows duplicates & null
* Legacy class
* Slower than ArrayDeque
* Used in recursion & parsing
* Better alternative → Deque
* Throws EmptyStackException
* Part of java.util
* Thread-safe
* Not preferred in modern Java
* Important interview topic
* Understand LIFO clearly

---
