# 1️⃣ Definition

**Synchronization** is a mechanism used to control access to shared resources in a multithreaded environment to prevent data inconsistency.

It ensures:

* Mutual exclusion (only one thread at a time)
* Thread safety
* Prevents race conditions

---

# 2️⃣ Visual Representation

## 🔹 Without Synchronization (Race Condition)

```text id="unsync1"
Thread A  ----\
               >---- Shared Variable (balance = 1000)
Thread B  ----/
Both modify at same time → Incorrect result
```

---

## 🔹 With Synchronization

```text id="sync1"
Thread A  ----> [ LOCK ACQUIRED ]
                     |
                     v
               Shared Resource
                     |
                     v
               [ LOCK RELEASED ]
                     |
Thread B  ---- waits until lock free
```

---

# 3️⃣ Key Features / Properties

* Uses **monitor lock (intrinsic lock)**
* Every object has one lock
* Only one thread can hold a lock at a time
* Works at:

  * Method level
  * Block level
  * Static level
* Reentrant (same thread can acquire lock multiple times)

---

# 4️⃣ Syntax

---

## 🔹 1. Synchronized Method

```java
synchronized void display() {
    // critical section
}
```

Lock → current object (`this`)

---

## 🔹 2. Synchronized Block

```java
synchronized(this) {
    // critical section
}
```

Custom lock:

```java
Object lock = new Object();

synchronized(lock) {
    // critical section
}
```

---

## 🔹 3. Static Synchronized Method

```java
static synchronized void show() {
    // critical section
}
```

Lock → Class object

---

# 5️⃣ Code Example

## 🔹 Without Synchronization

```java
class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}
```

Multiple threads → incorrect count.

---

## 🔹 With Synchronization

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

Now only one thread increments at a time.

---

# 6️⃣ Use Cases

| Scenario            | Why Synchronize                |
| ------------------- | ------------------------------ |
| Shared variables    | Prevent data corruption        |
| Banking systems     | Prevent incorrect transactions |
| Inventory systems   | Avoid duplicate updates        |
| Logging shared file | Avoid mixed output             |

---

# 7️⃣ Pitfalls / Notes

⚠️ Over-synchronization reduces performance
⚠️ Can cause deadlock
⚠️ Lock is object-based, not method-based
⚠️ Static synchronized locks class, not object
⚠️ Only protects critical section inside block
⚠️ Sleep does NOT release lock
⚠️ wait() releases lock

---

# 8️⃣ Real-World Analogy

Think of a bathroom with a key:

* Only one person can use it at a time
* Others must wait
* When key returned → next person enters

The key = lock
Bathroom = shared resource

---

# 9️⃣ Best Practices

✔ Synchronize only critical section
✔ Prefer synchronized block over method
✔ Avoid nested locks
✔ Keep lock duration short
✔ Use private lock object when possible

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Is synchronization method-based or object-based?

**Answer:**
Object-based. Lock is acquired on object (or class for static).

---

### 2️⃣ What happens if two threads call synchronized method on different objects?

**Answer:**
No blocking. Each object has separate lock.

---

### 3️⃣ What lock is used in static synchronized method?

**Answer:**
Class object lock.

---

### 4️⃣ Is synchronization reentrant?

**Answer:**
Yes. Same thread can acquire same lock multiple times.

---

### 5️⃣ Does sleep() release lock?

**Answer:**
No.

---

### 6️⃣ Does wait() release lock?

**Answer:**
Yes.

---

### 7️⃣ Can constructors be synchronized?

**Answer:**
No. Constructor cannot be synchronized.

---

### 8️⃣ Can we synchronize local variables?

**Answer:**
No. Only objects can be locked.

---

### 9️⃣ What happens if synchronized block throws exception?

**Answer:**
Lock is automatically released.

---

### 🔟 Why is block-level synchronization preferred over method-level?

**Answer:**
It reduces scope of locking → better performance.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Synchronization:
- Prevents race condition
- Uses intrinsic lock (monitor)
- Object-level locking
- Static → class-level locking
- Reentrant

Types:
1) synchronized method
2) synchronized block
3) static synchronized

Important:
sleep() → does NOT release lock
wait() → releases lock
```

---
