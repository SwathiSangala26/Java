## 1️⃣ Definition

**GC Roots** are special references from which the Garbage Collector starts its reachability analysis.

Any object reachable (directly or indirectly) from GC Roots is **not eligible for garbage collection**.

If an object is **not reachable from any GC Root**, it becomes **eligible for GC**.

---

## 2️⃣ Visual Representation

### 🔹 Reachability Concept

```text id="gcr1"
GC Roots
   ↓
Object A
   ↓
Object B
   ↓
Object C
```

All A, B, C are reachable → Not eligible for GC.

---

### 🔹 Unreachable Example

```text id="gcr2"
GC Roots
   ↓
Object A

Object B  (No reference)
```

Object B → Unreachable → Eligible for GC.

---

## 3️⃣ Key Features / Properties

* GC starts from GC Roots
* Uses Reachability Analysis Algorithm
* Objects not reachable from roots are removed
* Works only on Heap objects
* Determines object lifetime

Important Rule:

```text id="gcr3"
Reachable → Survives
Unreachable → Eligible for GC
```

---

## 🔹 Types of GC Roots

---

### 1️⃣ Local Variables (Stack References)

Objects referenced by active method variables.

Example:

```java id="gcr4"
public static void main(String[] args) {
    Demo d = new Demo();
}
```

Here:

* `d` is in Stack
* It is a GC Root reference
* Object not eligible for GC

---

### 2️⃣ Static Variables

Objects referenced by static fields.

```java id="gcr5"
class Test {
    static Demo d = new Demo();
}
```

Static references are GC Roots.

---

### 3️⃣ Active Threads

Objects referenced by currently running threads.

Thread objects themselves are GC Roots.

---

### 4️⃣ JNI References (Native References)

Objects referenced by native (C/C++) code via JNI.

---

## 4️⃣ Syntax

No special syntax.

Triggered automatically during GC process.

Example:

```java id="gcr6"
System.gc();
```

(Request only, not guaranteed)

---

## 5️⃣ Code Example

```java id="gcr7"
class Demo {}

public class Test {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        d1 = null;
    }
}
```

Explanation:

```text id="gcr8"
d1 → reference removed → object unreachable → Eligible for GC
d2 → still referenced → Not eligible
```

GC checks:

* Is object reachable from Stack?
* Is object reachable from static field?
* Is object reachable from thread?
* Is object reachable from JNI?

If NO → remove.

---

## 6️⃣ Use Cases

* Determines object lifecycle
* Prevents accidental deletion of active objects
* Ensures memory safety
* Used in all GC algorithms

---

## 7️⃣ Pitfalls / Notes

* Setting object to null does not immediately delete it
* Object may still be reachable indirectly
* Static references prevent GC
* Memory leaks happen when references remain
* Cyclic references are NOT a problem (if unreachable from roots)

Important Interview Point:

```text id="gcr9"
GC does NOT use reference counting.
It uses reachability analysis.
```

---

## 8️⃣ Real-World Analogy

Think of GC Roots like **power sources**.

If a device is connected (directly or indirectly) to power → It stays ON.

If not connected → It can be removed.

GC Roots = Power source
Objects = Devices

---

## 9️⃣ Best Practices

* Remove unnecessary references
* Avoid static object misuse
* Close resources properly
* Avoid memory leaks
* Be careful with long-living static collections

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ What are GC Roots?

👉 Special references from which GC starts reachability analysis.

---

### 2️⃣ Is nulling reference enough for GC?

👉 Only if object becomes unreachable from all GC Roots.

---

### 3️⃣ Are cyclic references a problem?

👉 No. If cycle is unreachable from GC Roots, it will be collected.

---

### 4️⃣ Are static variables GC Roots?

👉 Yes.

---

### 5️⃣ Are local variables GC Roots?

👉 Yes (while method is active).

---

### 6️⃣ Does GC use reference counting?

👉 No. It uses reachability analysis.

---

### 7️⃣ Can object be eligible but not collected?

👉 Yes. GC timing is unpredictable.

---

### 8️⃣ What happens if object is referenced by active thread?

👉 It is not eligible for GC.

---

### 9️⃣ Do primitive variables act as GC Roots?

👉 No. Only object references matter.

---

### 🔟 Does GC check Stack?

👉 It checks references in Stack (as roots), but cleans only Heap.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="gcr10"
GC Roots:
   ✔ Local variables (Stack)
   ✔ Static variables
   ✔ Active threads
   ✔ JNI references
```

Rule:

```text id="gcr11"
Reachable from GC Root → Survive
Not reachable → Eligible for GC
```

Important:

```text id="gcr12"
GC uses Reachability Analysis
NOT reference counting
```

---
