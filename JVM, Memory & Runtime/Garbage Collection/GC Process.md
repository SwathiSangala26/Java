# 🔹 GC Process (Garbage Collection Process)

---

## 1️⃣ Definition

The **Garbage Collection (GC) Process** is the mechanism by which the JVM automatically identifies and removes unused objects from the Heap memory.

Purpose:

* Free memory
* Prevent memory leaks
* Avoid OutOfMemoryError

Important:

```text
GC works only on Heap memory.
```

---

## 2️⃣ Visual Representation

### 🔹 Before GC

```text
Heap Memory
--------------------------------
| Object A (Referenced)       |
| Object B (Referenced)       |
| Object C (Unreferenced)     |
--------------------------------
```

### 🔹 After GC

```text
Heap Memory
--------------------------------
| Object A (Referenced)       |
| Object B (Referenced)       |
--------------------------------
(Object C removed)
```

---

## 3️⃣ Key Features / Properties

* Automatic memory management
* Runs in background
* Removes unreachable objects
* Works only on Heap
* Cannot force GC (System.gc() is just a request)
* Based on reachability analysis

---

## 🔹 How GC Identifies Objects

GC checks whether object is reachable from:

```text
GC Roots:
   - Local variables (Stack)
   - Static variables
   - Active threads
   - JNI references
```

If object is NOT reachable → eligible for GC.

---

## 🔹 Heap Generations

Heap is divided into:

```text
Heap
--------------------------------
Young Generation
   - Eden
   - Survivor (S0, S1)

Old Generation
--------------------------------
```

### Young Generation

* New objects created here
* Minor GC happens here

### Old Generation

* Long-living objects moved here
* Major GC happens here

---

## 🔹 Types of GC

### 1️⃣ Minor GC

* Cleans Young Generation
* Faster
* Frequent

### 2️⃣ Major GC

* Cleans Old Generation
* Slower

### 3️⃣ Full GC

* Cleans entire Heap
* Most expensive

---

## 4️⃣ Syntax

GC is automatic.

Request GC (not guaranteed):

```java
System.gc();
```

---

## 5️⃣ Code Example

```java
class Demo {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        d1 = null;   // Eligible for GC
    }
}
```

Explanation:

```text
d1 reference removed → Object becomes unreachable → GC may remove it.
d2 still referenced → Not removed.
```

---

## 6️⃣ Use Cases

* Automatic memory management
* Large enterprise applications
* Long-running server applications
* Microservices
* High-memory systems

---

## 7️⃣ Pitfalls / Notes

* GC does NOT free Stack memory
* Cannot predict exact GC timing
* Excessive object creation → Frequent GC
* Full GC causes performance pause
* Memory leaks still possible if references remain
* finalize() method is deprecated (avoid using)

Important:

```text
Unreferenced ≠ Immediately deleted
Eligible for GC ≠ Immediately collected
```

---

## 8️⃣ Real-World Analogy

Think of GC like a **cleaning robot in a warehouse**:

* It removes items that no one is using.
* It checks what is still being used.
* It cleans in cycles.
* It doesn’t clean your desk (Stack), only warehouse (Heap).

---

## 9️⃣ Best Practices

* Avoid unnecessary object creation
* Remove unused references
* Use try-with-resources
* Avoid memory leaks
* Use profiling tools (JVisualVM, etc.)
* Prefer object reuse in performance-critical apps

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ Does GC work on Stack?

👉 No. Only Heap.

---

### 2️⃣ What makes an object eligible for GC?

👉 When it becomes unreachable from GC Roots.

---

### 3️⃣ Can we force GC?

👉 No. System.gc() is only a request.

---

### 4️⃣ Difference between Minor and Major GC?

Minor → Young Generation
Major → Old Generation

---

### 5️⃣ What is Full GC?

👉 Cleans entire Heap.

---

### 6️⃣ What are GC Roots?

👉 Stack variables, static variables, active threads, JNI references.

---

### 7️⃣ When does object move to Old Generation?

👉 When it survives multiple Minor GC cycles.

---

### 8️⃣ Is memory freed immediately after object becomes null?

👉 No. Only when GC runs.

---

### 9️⃣ What happens if GC cannot free enough memory?

👉 OutOfMemoryError.

---

### 🔟 Why is excessive GC bad?

👉 Causes performance pauses.

---

# 🧾 Quick Recap / Cheat Sheet

```text
GC → Automatic Heap cleanup
Works only on Heap
Based on reachability
```

Heap Structure:

```text
Young Generation → Minor GC
Old Generation → Major GC
Full GC → Entire Heap
```

Key Rule:

```text
No reference → Eligible for GC
Eligible ≠ Immediately removed
```

Errors:

```text
OutOfMemoryError → GC unable to free memory
```

---
