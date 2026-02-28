## 1️⃣ Definition

**GC Algorithms** are the internal strategies used by the JVM to identify and remove unreachable objects from Heap memory.

They determine:

* How objects are marked
* How unused objects are removed
* How memory is compacted
* How performance is optimized

---

## 2️⃣ Visual Representation

### 🔹 Basic Reachability

```text id="gca1"
GC Roots
   ↓
Reachable Objects  →  Keep
Unreachable Objects → Remove
```

---

### 🔹 Memory Before and After GC

Before:

```text id="gca2"
Heap
--------------------------------
| A (used) | B (unused) | C (used) |
--------------------------------
```

After:

```text id="gca3"
Heap
--------------------------------
| A (used) | C (used) |
--------------------------------
```

---

## 3️⃣ Key GC Algorithms

---

# 🔹 1️⃣ Mark and Sweep

---

## How It Works

Step 1: Mark

* GC marks all reachable objects.

Step 2: Sweep

* Removes unmarked (unreachable) objects.

---

### Visual

```text id="gca4"
Step 1 (Mark):
[A ✓] [B ✗] [C ✓]

Step 2 (Sweep):
Remove B
```

---

## Advantages

* Simple
* Easy to implement

---

## Disadvantages

* Leaves memory fragmentation
* Slower over time

---

# 🔹 2️⃣ Mark and Compact

---

## How It Works

Step 1: Mark reachable objects
Step 2: Remove unreachable
Step 3: Shift remaining objects together (compact)

---

### Visual

Before:

```text id="gca5"
[A] [ ] [C] [ ] [D]
```

After Compaction:

```text id="gca6"
[A] [C] [D]
```

---

## Advantages

* No fragmentation
* Better memory usage

---

## Disadvantages

* Object movement cost
* Slightly slower than Mark-Sweep

---

# 🔹 3️⃣ Copying Algorithm

---

## How It Works

* Heap divided into two regions
* Active region + Empty region
* Live objects copied to empty region
* Old region cleared

---

### Visual

```text id="gca7"
Region A (Active):   [A] [B] [C]
Region B (Empty):    [   ]

After GC:
Region A: cleared
Region B: [A] [C]
```

(B is unreachable)

---

## Advantages

* No fragmentation
* Fast allocation

---

## Disadvantages

* Uses extra memory
* Not ideal for large heaps

Used mainly in:

```text id="gca8"
Young Generation (Minor GC)
```

---

# 🔹 4️⃣ Generational GC (Concept)

---

## Idea

Most objects die young.

So heap divided into:

```text id="gca9"
Young Generation
Old Generation
```

* New objects → Young
* Survive multiple GC → Move to Old
* Minor GC → Young
* Major GC → Old

---

## Why Efficient?

Because:

```text id="gca10"
Most objects die early → Clean only Young → Faster
```

---

# 4️⃣ Syntax

No direct syntax.

GC triggered automatically.

Optional request:

```java
System.gc();
```

(Not guaranteed)

---

# 5️⃣ Code Example

```java
class Demo {
    public static void main(String[] args) {
        Demo d1 = new Demo();
        Demo d2 = new Demo();
        d1 = null;
    }
}
```

Explanation:

```text
d1 object → Unreachable → Eligible for GC
d2 object → Still reachable → Not removed
```

Algorithm internally:

* Mark reachable
* Remove unmarked

---

# 6️⃣ Use Cases

* Enterprise systems
* Server applications
* Large memory systems
* Performance-critical apps
* JVM memory optimization

---

# 7️⃣ Pitfalls / Notes

* Mark-Sweep → Fragmentation problem
* Copying → Needs extra memory
* Compacting → Object relocation overhead
* Full GC → Stop-The-World pause
* Excessive object creation → Frequent GC

Important:

```text id="gca11"
Modern JVM uses combination of algorithms.
```

(Not just one)

---

# 8️⃣ Real-World Analogy

Mark-Sweep →
Mark items being used, throw away unused items.

Mark-Compact →
Throw unused items and rearrange remaining neatly.

Copying →
Move useful items to new room, empty old room.

Generational →
Separate “new items” room and “old items” room.

---

# 9️⃣ Best Practices

* Avoid excessive object creation
* Reuse objects where possible
* Avoid memory leaks
* Use profiling tools
* Understand Young vs Old GC behavior
* Choose proper GC type in production

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ What is Mark and Sweep?

👉 Marks reachable objects, removes unmarked ones.

---

### 2️⃣ What problem does Mark-Sweep cause?

👉 Memory fragmentation.

---

### 3️⃣ Which algorithm avoids fragmentation?

👉 Mark-Compact and Copying.

---

### 4️⃣ Which algorithm is used in Young Generation?

👉 Copying Algorithm.

---

### 5️⃣ Why is Generational GC efficient?

👉 Because most objects die young.

---

### 6️⃣ What happens during compaction?

👉 Live objects are shifted together.

---

### 7️⃣ What is fragmentation?

👉 Free memory scattered in small blocks.

---

### 8️⃣ Why not use Copying for entire heap?

👉 Requires double memory space.

---

### 9️⃣ What triggers object promotion?

👉 Surviving multiple Minor GC cycles.

---

### 🔟 Does GC use only one algorithm?

👉 No. Modern JVM uses hybrid approach.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Mark-Sweep → Mark then delete
Problem → Fragmentation

Mark-Compact → Mark, delete, shift
No fragmentation

Copying → Copy live objects to new region
Used in Young Generation

Generational → Young + Old separation
Most objects die young
```

Important Rule:

```text
Modern JVM = Hybrid GC algorithms
```

---
