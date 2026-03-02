## 1️⃣ Definition

A **Memory Leak** in Java occurs when objects are no longer needed but are still referenced, so the Garbage Collector cannot remove them.

Because they are still reachable from **GC Roots**, they are **not eligible for GC**.

Result:

* Heap memory keeps increasing
* Eventually → `OutOfMemoryError`

---

## 2️⃣ Visual Representation

### 🔹 Normal Case (No Leak)

```text id="ml1"
GC Roots
   ↓
Object A
   ↓
Object B

If A reference removed →
B becomes unreachable → GC removes
```

---

### 🔹 Memory Leak Case

```text id="ml2"
Static List (GC Root)
   ↓
Object A
Object B
Object C
```

Even if not used anymore:

* Objects still referenced
* GC cannot remove
* Memory keeps growing

---

## 3️⃣ Key Features / Properties

* Happens in Heap
* Objects remain reachable unintentionally
* GC cannot remove reachable objects
* Usually caused by poor reference handling
* Leads to performance degradation
* Eventually causes OutOfMemoryError

Important Rule:

```text id="ml3"
Leak = Unused but Still Referenced
```

---

## 4️⃣ Syntax (Common Leak Pattern)

### 🔹 Static Collection Leak

```java id="ml4"
import java.util.*;

class Demo {
    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        while(true) {
            list.add(new Object());
        }
    }
}
```

Problem:

* Static list is GC Root
* Objects never removed
* Heap fills up

---

## 5️⃣ Code Example (Classic Leak)

```java id="ml5"
class Employee {
    String name;
    Employee(String name) {
        this.name = name;
    }
}

public class Test {
    static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        employees.add(new Employee("John"));
    }
}
```

Even if employee not needed:

* Still stored in static list
* Not eligible for GC

---

## 6️⃣ Common Causes of Memory Leaks

---

### 1️⃣ Static Variables

Static references live until JVM stops.

---

### 2️⃣ Unclosed Resources

* Streams
* Database connections
* File handles

Example:

```java id="ml6"
FileInputStream fis = new FileInputStream("file.txt");
// Not closed
```

---

### 3️⃣ Long-Lived Collections

Collections that keep growing without cleanup.

---

### 4️⃣ Listeners / Callbacks Not Removed

Objects registered but never deregistered.

---

### 5️⃣ Inner Classes Holding Outer Class Reference

Non-static inner classes hold reference to outer object.

---

### 6️⃣ ThreadLocal Misuse

If not cleared properly, causes memory retention.

---

## 7️⃣ Use Cases (Where Leaks Commonly Occur)

* Web applications
* Caching systems
* Long-running server apps
* Microservices
* Background threads

---

## 8️⃣ Pitfalls / Notes

* Java does NOT prevent memory leaks automatically
* GC cannot remove reachable objects
* Cyclic references are NOT leaks (if unreachable)
* Static references are dangerous
* Large caches must have eviction policy
* Memory leaks are different from memory fragmentation

Important:

```text id="ml7"
GC failure ≠ Memory Leak
Reference retention = Memory Leak
```

---

## 9️⃣ Real-World Analogy

Imagine a warehouse:

You stop using some boxes.
But you keep their entry in the inventory system.

Since system says “in use”, cleaning staff won’t remove them.

Static variable = Inventory system.

---

## 🔟 Best Practices

* Remove unused references
* Avoid unnecessary static variables
* Use try-with-resources
* Clear collections properly
* Use WeakReference for cache
* Monitor heap using profiling tools
* Close threads properly
* Use proper cache eviction

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ Can memory leak happen in Java?

👉 Yes. If objects remain referenced unintentionally.

---

### 2️⃣ Does GC prevent memory leaks?

👉 No. GC removes only unreachable objects.

---

### 3️⃣ Are cyclic references memory leaks?

👉 No, if unreachable from GC Roots.

---

### 4️⃣ Why are static variables dangerous?

👉 They remain until JVM stops.

---

### 5️⃣ What is difference between memory leak and OutOfMemoryError?

Leak → Gradual memory retention
OutOfMemoryError → Result of memory exhaustion

---

### 6️⃣ How to detect memory leaks?

👉 Using heap dump analysis tools (VisualVM, etc.)

---

### 7️⃣ What is a common real-world leak cause?

👉 Long-lived collections.

---

### 8️⃣ Does nulling reference guarantee GC?

👉 Only if no other references exist.

---

### 9️⃣ What happens if we never remove items from cache?

👉 Memory leak.

---

### 🔟 How to prevent leaks in long-running apps?

👉 Proper cleanup, resource closing, weak references, monitoring.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="ml8"
Memory Leak = Object still referenced but not used
```

Common Causes:

```text id="ml9"
✔ Static variables
✔ Growing collections
✔ Unclosed resources
✔ Listeners not removed
✔ ThreadLocal misuse
```

Important:

```text id="ml10"
GC removes unreachable objects
Leak = Still reachable
```

---
