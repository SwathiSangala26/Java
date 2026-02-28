# 1️⃣ Definition

`synchronized` is a keyword used to control access to a shared resource by allowing **only one thread at a time** to execute a critical section.

It ensures:

* Mutual exclusion
* Thread safety
* Data consistency

It works using an **intrinsic monitor lock** associated with every object in Java.

---

# 2️⃣ Visual Representation

## 🔹 Object-Level Lock

```text
Thread A  --->  [ Lock on Object X ]  --->  Critical Section  --->  Unlock
Thread B  --->  Waits until lock is free
```

---

## 🔹 Class-Level Lock (Static)

```text
Thread A  --->  [ Lock on Class object ]  --->  Critical Section
Thread B  --->  Waits
```

---

# 3️⃣ Key Features / Properties

* Every Java object has **one intrinsic lock**
* Only one thread can hold the lock at a time
* Lock is released automatically
* It is **reentrant**
* Works at:

  * Method level
  * Block level
  * Static method level

---

# 4️⃣ Syntax

---

## 🔹 1. Instance Method Synchronization

```java
synchronized void method() {
    // critical section
}
```

Lock → `this` (current object)

---

## 🔹 2. Static Method Synchronization

```java
static synchronized void method() {
    // critical section
}
```

Lock → Class object

---

## 🔹 3. Block-Level Synchronization

```java
synchronized(this) {
    // critical section
}
```

Custom lock object:

```java
Object lock = new Object();

synchronized(lock) {
    // critical section
}
```

---

# 5️⃣ Code Example

---

## 🔹 Example: Without synchronized

```java
class Counter {
    int count = 0;

    void increment() {
        count++;
    }
}
```

Multiple threads → inconsistent result.

---

## 🔹 Example: With synchronized

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

Now only one thread can execute `increment()` at a time.

---

# 6️⃣ Use Cases

| Scenario               | Why Use synchronized   |
| ---------------------- | ---------------------- |
| Shared counter         | Prevent race condition |
| Bank transaction       | Ensure correct balance |
| Shared file writing    | Avoid mixed output     |
| Shared resource access | Maintain consistency   |

---

# 7️⃣ Pitfalls / Notes

⚠️ Overuse reduces performance
⚠️ Can cause deadlock
⚠️ Lock is on object, not method
⚠️ Static synchronized locks Class object
⚠️ `sleep()` does NOT release lock
⚠️ `wait()` releases lock
⚠️ Cannot synchronize constructors
⚠️ Cannot use with local variables

---

# 8️⃣ Real-World Analogy

Imagine a meeting room with a key:

* Only one person can hold the key.
* Others must wait outside.
* When key is returned → next person enters.

Key = Lock
Room = Critical section

---

# 9️⃣ Best Practices

✔ Synchronize only critical section
✔ Prefer block-level over full method
✔ Use private lock object
✔ Keep synchronized code small
✔ Avoid nested locking

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Is synchronized method-level or object-level?

**Answer:**
Object-level. Lock is acquired on object (`this`).

---

### 2️⃣ What happens if two threads call synchronized method on different objects?

**Answer:**
They do NOT block each other because locks are different.

---

### 3️⃣ What lock does static synchronized use?

**Answer:**
Class object lock.

---

### 4️⃣ Is synchronized reentrant?

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

### 7️⃣ What happens if exception occurs inside synchronized block?

**Answer:**
Lock is automatically released.

---

### 8️⃣ Can synchronized be applied to variables?

**Answer:**
No. Only methods and blocks.

---

### 9️⃣ Can we override a synchronized method without synchronized?

**Answer:**
Yes. Synchronization is not inherited.

---

### 🔟 Why is block-level better than method-level?

**Answer:**
Reduces lock scope → improves performance.

---

# 🧾 Quick Recap / Cheat Sheet

```text
synchronized:
- Provides mutual exclusion
- Uses intrinsic lock (monitor)
- Object-level locking
- Static → Class-level locking
- Reentrant

Types:
1) synchronized method → locks object
2) static synchronized → locks class
3) synchronized block → locks specific object

Important:
sleep() → does NOT release lock
wait() → releases lock
```

---
