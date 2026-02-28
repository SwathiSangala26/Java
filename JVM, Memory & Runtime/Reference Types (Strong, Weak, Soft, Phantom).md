# 1️⃣ Definition

Java provides **four types of references** to control how objects behave during Garbage Collection.

They determine:

* When an object becomes eligible for GC
* How aggressively GC removes it

Types:

```text id="ref1"
1. Strong Reference
2. Weak Reference
3. Soft Reference
4. Phantom Reference
```

---

# 2️⃣ Visual Representation

```text id="ref2"
GC Roots
   ↓
Strong  → Never collected (while referenced)
Soft    → Collected when memory low
Weak    → Collected in next GC cycle
Phantom → Collected after finalization (cleanup tracking)
```

---

# 3️⃣ Key Features / Properties

---

# 🔹 1️⃣ Strong Reference

## Definition

Default reference type in Java.

If an object has a strong reference → GC will NOT remove it.

Example:

```java id="ref3"
String s = new String("Java");
```

`s` is a strong reference.

---

## Properties

* Most common reference
* Prevents GC
* Object survives as long as strong reference exists

---

## Important

```text id="ref4"
Strong reference exists → Object NOT eligible for GC
```

---

# 🔹 2️⃣ Weak Reference

Package:

```java
java.lang.ref.WeakReference
```

## Definition

Object referenced only by WeakReference becomes eligible for GC during the next GC cycle.

---

## Example

```java id="ref5"
import java.lang.ref.WeakReference;

Demo d = new Demo();
WeakReference<Demo> weakRef = new WeakReference<>(d);

d = null;
```

Now:

* Only weak reference exists
* Object removed in next GC

---

## Properties

* GC removes it aggressively
* Used in caches (WeakHashMap)
* Cleared during minor GC

---

# 🔹 3️⃣ Soft Reference

Package:

```java
java.lang.ref.SoftReference
```

## Definition

Object referenced only by SoftReference is removed **only when memory is low**.

---

## Example

```java id="ref6"
import java.lang.ref.SoftReference;

Demo d = new Demo();
SoftReference<Demo> softRef = new SoftReference<>(d);

d = null;
```

Object:

* Survives normal GC
* Removed only when JVM needs memory

---

## Properties

* Less aggressive than Weak
* Used for memory-sensitive caches

Important:

```text id="ref7"
Soft → Survive until memory pressure
Weak → Removed in next GC
```

---

# 🔹 4️⃣ Phantom Reference

Package:

```java
java.lang.ref.PhantomReference
```

## Definition

PhantomReference is used to track object after it becomes eligible for GC.

* `get()` always returns null
* Used with ReferenceQueue
* Used for cleanup actions

---

## Example

```java id="ref8"
import java.lang.ref.*;

ReferenceQueue<Demo> queue = new ReferenceQueue<>();
Demo d = new Demo();
PhantomReference<Demo> phantom =
        new PhantomReference<>(d, queue);

d = null;
```

Used for:

* Post-GC cleanup
* Resource deallocation

---

## Properties

* Weakest reference type
* Used for advanced memory management
* Replacement for finalize()

---

# 4️⃣ Syntax Summary

```java id="ref9"
Strong:  Demo d = new Demo();

Weak:    new WeakReference<>(d);

Soft:    new SoftReference<>(d);

Phantom: new PhantomReference<>(d, queue);
```

---

# 5️⃣ Use Cases

Strong:

* Normal object usage

Weak:

* WeakHashMap
* Prevent memory leaks

Soft:

* Caching systems

Phantom:

* Resource cleanup
* Advanced memory tracking

---

# 6️⃣ Pitfalls / Notes

* Strong references cause memory leaks if misused
* Weak references disappear quickly
* Soft references not guaranteed to survive
* Phantom requires ReferenceQueue
* finalize() is deprecated → Use PhantomReference instead

Important:

```text id="ref10"
Reference strength:
Strong > Soft > Weak > Phantom
```

---

# 7️⃣ Real-World Analogy

Strong → Locked in safe (cannot remove)
Soft → Keep until storage full
Weak → Remove immediately if not needed
Phantom → Used only to track disposal

---

# 8️⃣ Best Practices

* Use Strong references normally
* Use WeakReference for maps
* Use SoftReference for caches
* Avoid overusing PhantomReference
* Do not rely on GC timing
* Avoid memory leaks with static references

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ Which reference prevents GC?

👉 Strong reference.

---

### 2️⃣ Which reference is cleared first?

👉 WeakReference.

---

### 3️⃣ When are SoftReferences cleared?

👉 When JVM is low on memory.

---

### 4️⃣ What does PhantomReference.get() return?

👉 Always null.

---

### 5️⃣ Which reference is used in WeakHashMap?

👉 WeakReference.

---

### 6️⃣ Which is stronger: Soft or Weak?

👉 Soft is stronger than Weak.

---

### 7️⃣ Can object with WeakReference survive GC?

👉 No. It will be removed in next GC cycle.

---

### 8️⃣ Why use PhantomReference instead of finalize()?

👉 Better control and safer cleanup.

---

### 9️⃣ Order of reference strength?

👉 Strong > Soft > Weak > Phantom.

---

### 🔟 Which reference type is best for cache?

👉 SoftReference.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="ref11"
Strong  → Never GC (while referenced)
Soft    → GC when memory low
Weak    → GC in next cycle
Phantom → Post-GC tracking
```

Hierarchy:

```text id="ref12"
Strong > Soft > Weak > Phantom
```

Memory Rule:

```text id="ref13"
Only strong references guarantee survival.
```

---
