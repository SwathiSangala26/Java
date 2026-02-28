# 1️⃣ Definition

`OutOfMemoryError` is a runtime error that occurs when the JVM cannot allocate memory for an object because the required memory area is exhausted.

It is a subclass of:

```text id="oom1"
java.lang.Error
```

Important:

```text id="oom2"
It is NOT an Exception.
It usually indicates serious memory problem.
```

---

# 2️⃣ Visual Representation

### 🔹 Normal Heap

```text id="oom3"
Heap
--------------------------------
| Object A | Object B | Free   |
--------------------------------
```

### 🔹 Heap Full

```text id="oom4"
Heap
--------------------------------
| Object A | Object B | Object C |
--------------------------------
No Free Space → OOME
```

---

# 3️⃣ Key Features / Properties

* Occurs at runtime
* Caused by memory exhaustion
* GC cannot free enough memory
* Program may crash
* Can occur in different memory areas

Important:

```text id="oom5"
OOME happens when GC cannot recover memory.
```

---

# 4️⃣ Types of OutOfMemoryError

---

## 🔹 1️⃣ Java Heap Space

Cause:

* Too many objects
* Memory leaks
* Large data structures

Example:

```java id="oom6"
import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while(true) {
            list.add(new Object());
        }
    }
}
```

---

## 🔹 2️⃣ Metaspace

Cause:

* Too many classes loaded
* Dynamic class generation
* ClassLoader leaks

Error:

```text id="oom7"
java.lang.OutOfMemoryError: Metaspace
```

---

## 🔹 3️⃣ GC Overhead Limit Exceeded

Cause:

* JVM spends too much time in GC
* Very little memory recovered

Meaning:

```text id="oom8"
98% time in GC
< 2% memory freed
```

---

## 🔹 4️⃣ Unable to Create New Native Thread

Cause:

* Too many threads created
* OS thread limit exceeded

---

## 🔹 5️⃣ Direct Buffer Memory

Cause:

* Excessive use of NIO direct buffers
* Native memory exhaustion

---

# 5️⃣ Syntax (Not Catchable Normally)

You can technically catch it:

```java id="oom9"
try {
    // memory heavy code
} catch (OutOfMemoryError e) {
    System.out.println("Memory exhausted");
}
```

But:

```text id="oom10"
Not recommended to handle in production.
```

---

# 6️⃣ Code Example (Heap OOME)

```java id="oom11"
class Demo {
    public static void main(String[] args) {
        int[] arr = new int[Integer.MAX_VALUE];
    }
}
```

Result:

```text id="oom12"
java.lang.OutOfMemoryError: Java heap space
```

---

# 7️⃣ Use Cases (Where It Happens)

* Large caching systems
* File processing apps
* Streaming systems
* Microservices under heavy load
* Poor memory management apps
* Long-running servers

---

# 8️⃣ Pitfalls / Notes

* GC does NOT guarantee no OOME
* Memory leaks cause gradual OOME
* Static references can cause OOME
* Large collections without cleanup
* Too many threads can cause native OOME
* Increasing heap size is not always solution

Important Interview Difference:

```text id="oom13"
StackOverflowError → Stack full
OutOfMemoryError → Heap / Metaspace full
```

---

# 9️⃣ Real-World Analogy

Imagine warehouse full of boxes.

Cleaning staff (GC) tries removing unused boxes.

If:

* All boxes still marked as “in use”
* Or warehouse completely full

New box cannot be stored → OutOfMemoryError.

---

# 🔟 Best Practices

* Avoid memory leaks
* Remove unused references
* Use proper cache eviction
* Close resources
* Avoid unnecessary object creation
* Monitor heap using profiling tools
* Set proper JVM memory limits
* Avoid creating too many threads

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ Is OutOfMemoryError an Exception?

👉 No. It is an Error.

---

### 2️⃣ Can GC prevent OOME?

👉 GC tries, but if insufficient memory → OOME.

---

### 3️⃣ Difference between Heap OOME and Metaspace OOME?

Heap → Object memory full
Metaspace → Class metadata memory full

---

### 4️⃣ What causes GC Overhead Limit Exceeded?

👉 JVM spending too much time in GC with little recovery.

---

### 5️⃣ Can we recover from OOME?

👉 Rarely safe. Usually application should restart.

---

### 6️⃣ What is difference between memory leak and OOME?

Memory Leak → Cause
OOME → Result

---

### 7️⃣ Does increasing heap always solve OOME?

👉 No. If leak exists, problem remains.

---

### 8️⃣ Can too many threads cause OOME?

👉 Yes. Native thread memory exhaustion.

---

### 9️⃣ What is Direct Buffer OOME?

👉 Native memory exhaustion due to NIO buffers.

---

### 🔟 Which memory areas can throw OOME?

👉 Heap, Metaspace, Native memory, Thread memory.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="oom14"
OutOfMemoryError = JVM cannot allocate memory
Subclass of Error
```

Common Types:

```text id="oom15"
✔ Java heap space
✔ Metaspace
✔ GC overhead limit exceeded
✔ Unable to create new native thread
✔ Direct buffer memory
```

Important:

```text id="oom16"
Leak → GC fails → OOME
```

Difference:

```text id="oom17"
StackOverflowError → Stack full
OutOfMemoryError → Heap/Metaspace full
```

---
