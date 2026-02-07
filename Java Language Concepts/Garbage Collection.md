## 🟢 Definition of Garbage Collection

**Garbage Collection (GC)** is an **automatic memory management process** in Java where the **JVM identifies and removes objects that are no longer reachable** to free heap memory.

* Managed by the **JVM**
* Developers do **not manually free memory**
* Improves application stability
* Prevents heap exhaustion

---

## 🟢 Why Garbage Collection is Needed

* Objects are created dynamically at runtime
* Many objects are **temporary**
* Without GC:

  * Heap fills up
  * Application crashes (`OutOfMemoryError`)
* GC reclaims unused heap memory automatically

---

## 🟢 What is Garbage?

An object becomes garbage when:

* No active reference points to it
* It is **not reachable from GC Roots**

Examples:

* Local objects after method execution
* Reassigned object references
* Explicitly set to `null`
* Unreachable object graphs

---

## 🟢 How JVM Identifies Garbage (Reachability Analysis)

Java GC uses **reachability analysis**, not reference counting.

### GC Roots include:

* Local variables (stack)
* Active threads
* Static variables
* JNI references

Rule:

```
Reachable from GC Roots → Alive
Not reachable → Garbage
```

---

## 🟢 Java Heap Memory Structure

```
Heap
├── Young Generation
│    ├── Eden Space
│    ├── Survivor Space S0
│    └── Survivor Space S1
│
└── Old Generation (Tenured)
```

Outside heap:

```
Metaspace → Class metadata
```

---

## 🟢 Why Java Uses Generations

Java GC follows the **Generational Hypothesis**:

* Most objects **die young**
* Few objects **live long**

So JVM:

* Cleans young objects frequently (fast)
* Cleans old objects rarely (slow)

---

## 🟢 Young Generation

### Purpose

* Stores **short-lived objects**
* Optimized for **fast allocation & cleanup**

---

## 🟢 Eden Space

* All **new objects** are allocated here
* Very fast allocation
* Fills quickly

Example:

```java
Object a = new Object();
Object b = new Object();
```

Memory:

```
Eden: [ a  b ]
S0:   [ empty ]
S1:   [ empty ]
```

---

## 🟢 Minor GC (Young GC)

Triggered when **Eden becomes full**.

Characteristics:

* Stop-The-World (STW)
* Cleans **only Young Generation**
* Old Generation not affected
* Very fast

---

## 🟢 Survivor Spaces (Why Two?)

Java has **two Survivor spaces (S0 & S1)** to support **copying GC**.

Key rules:

* Only **one Survivor space is active** at a time
* Other Survivor is always empty
* They **swap roles after each Minor GC**
* Names S0 / S1 are just labels

---

## 🟢 Minor GC — Step-by-Step Flow

### Before Minor GC

```
Eden: [ A  B  C  D ]
S0:   [ E  F ]   ← Active (From-space)
S1:   [ empty ] ← Empty (To-space)
```

Assume:

* A, C, E are alive
* Others are dead

---

### During Minor GC

1. JVM scans **Eden + active Survivor**
2. Finds **live objects**
3. Copies live objects to **empty Survivor**
4. Increments object age
5. Clears Eden completely
6. Clears active Survivor completely
7. Swaps Survivor roles

---

### After Minor GC

```
Eden: [ empty ]
S0:   [ empty ]
S1:   [ A  C  E ]   ← New active Survivor
```

Key rule:

> JVM **copies live objects and discards the rest**

---

## 🟢 Object Aging

* Each object has an **age counter**
* Age = number of Minor GCs survived
* Default max age ≈ **15**

Meaning:

```
If object survives ~15 Minor GCs
→ promoted to Old Generation
```

Age is:

* GC-cycle based
* Not time-based

---

## 🟢 Why Copying GC is Used in Young Generation

Instead of cleaning memory in place, JVM:

* Copies only live objects
* Ignores dead objects
* Clears entire memory region

Benefits:

* Faster
* No fragmentation
* Ideal for small number of survivors

---

## 🟢 Promotion to Old Generation

An object is promoted to **Old Generation** when **any one** condition is met:

* Object age reaches tenuring threshold
* Survivor space does not have enough room
* Object is very large

Promotion is **independent** of S0/S1 fullness.

---

## 🟢 Old Generation (Tenured Generation)

### Purpose

* Stores **long-lived objects**

Examples:

* Static objects
* Singletons
* Caches
* Application-wide data

Characteristics:

* Large memory region
* GC happens less frequently
* GC is slower than Minor GC

---

## 🟢 Major GC / Full GC

Triggered when **Old Generation fills up**.

Characteristics:

* Stop-The-World
* Scans large heap area
* Slower and expensive
* Impacts application performance

---

## 🟢 Metaspace

* Stores **class metadata**
* Not part of heap
* Uses native memory
* Replaced PermGen (Java 8+)
* Grows dynamically

---

## 🟢 Can Developers Control GC?

* Developers **cannot force GC**
* Can only **request** GC

```java
System.gc();
```

JVM may ignore the request.

GC behavior is mainly controlled using **JVM options**, not code.

---

## 🟢 Stop-The-World (STW)

* JVM pauses all application threads
* GC runs
* Application resumes after GC

Occurs during:

* Minor GC
* Major GC
* Full GC

Modern collectors reduce pause duration.

---

## 🟢 Comparison with .NET (For Understanding)

| .NET        | Java               |
| ----------- | ------------------ |
| Gen 0       | Eden               |
| Gen 1       | Survivor           |
| Gen 2       | Old Generation     |
| LOH         | Old Gen / special  |
| IDisposable | try-with-resources |

Concept is same, internal handling differs.

---

## 🟢 Object Lifecycle Summary (Visual)

```
New Object
   ↓
Eden
   ↓ Minor GC
Survivor (S0 / S1)
   ↓ Aging
Old Generation
```

Dead objects:

* Not copied
* Automatically removed
