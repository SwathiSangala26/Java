# 1️⃣ Definition

`ReentrantLock` is a class from `java.util.concurrent.locks` that provides an explicit locking mechanism similar to `synchronized`, but with more flexibility and control.

It allows:

* Manual lock/unlock
* Fairness policy
* Interruptible locking
* Try-lock with timeout

It is called *reentrant* because the same thread can acquire the lock multiple times.

---

# 2️⃣ Visual Representation

## 🔹 Basic Lock Flow

```text id="rl1"
Thread A  ---> lock() ---> Critical Section ---> unlock()
Thread B  ---> waits until unlock()
```

---

## 🔹 Reentrancy

```text id="rl2"
Thread A:
   lock()
      |
      lock()  (allowed)
      |
   unlock()
   unlock()
```

Lock must be released same number of times it was acquired.

---

# 3️⃣ Key Features / Properties

* Explicit locking (`lock()` / `unlock()`)
* Reentrant (same thread can re-acquire)
* Supports fairness (FIFO option)
* Supports interruptible locking
* Supports tryLock()
* Provides Condition object (advanced wait/notify)

---

# 4️⃣ Syntax

---

## 🔹 Basic Usage

```java id="4px3e0"
ReentrantLock lock = new ReentrantLock();

lock.lock();
try {
    // critical section
} finally {
    lock.unlock();
}
```

Always unlock in `finally` block.

---

## 🔹 Fair Lock

```java id="oy9s3c"
ReentrantLock lock = new ReentrantLock(true);
```

`true` → fairness policy enabled.

---

## 🔹 tryLock()

```java id="5ps0cl"
if (lock.tryLock()) {
    try {
        // critical section
    } finally {
        lock.unlock();
    }
}
```

---

## 🔹 tryLock with Timeout

```java id="8q17k0"
if (lock.tryLock(2, TimeUnit.SECONDS)) {
    try {
        // critical section
    } finally {
        lock.unlock();
    }
}
```

---

# 5️⃣ Code Example

```java id="j9yq3d"
import java.util.concurrent.locks.ReentrantLock;

class Counter {

    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

    int getCount() {
        return count;
    }
}
```

---

# 6️⃣ Use Cases

| Scenario                | Why ReentrantLock              |
| ----------------------- | ------------------------------ |
| Need tryLock            | Avoid blocking                 |
| Need fairness           | Prevent starvation             |
| Interruptible lock      | Handle cancellation            |
| Complex synchronization | More control than synchronized |

---

# 7️⃣ Pitfalls / Notes

⚠️ Must manually unlock
⚠️ Forgetting unlock → deadlock
⚠️ Slightly more verbose than synchronized
⚠️ Fair lock reduces performance
⚠️ Not automatically released like synchronized

---

# 8️⃣ Real-World Analogy

Think of a locker with a key:

* You take the key (lock)
* Do your work
* Return the key (unlock)

If you forget to return the key → nobody else can enter.

---

# 9️⃣ Best Practices

✔ Always use try-finally
✔ Use tryLock() to avoid deadlock
✔ Avoid long critical sections
✔ Use fairness only if required
✔ Prefer synchronized for simple cases

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Difference between synchronized and ReentrantLock?

**Answer:**

| synchronized          | ReentrantLock          |
| --------------------- | ---------------------- |
| Implicit lock         | Explicit lock          |
| Auto release          | Manual unlock          |
| No fairness option    | Supports fairness      |
| No tryLock            | Supports tryLock       |
| No interruptible lock | Supports interruptible |

---

### 2️⃣ Why is it called ReentrantLock?

**Answer:**
Same thread can acquire the same lock multiple times.

---

### 3️⃣ What happens if unlock() is not called?

**Answer:**
Other threads will block → deadlock.

---

### 4️⃣ What is fairness policy?

**Answer:**
Threads acquire lock in FIFO order.

---

### 5️⃣ Does fair lock guarantee strict ordering?

**Answer:**
Mostly FIFO, but not absolute guarantee.

---

### 6️⃣ What is tryLock() advantage?

**Answer:**
Prevents indefinite blocking.

---

### 7️⃣ Is ReentrantLock faster than synchronized?

**Answer:**
Performance depends on scenario. Modern JVM optimizes synchronized well.

---

### 8️⃣ Can lock() be interrupted?

**Answer:**
Yes, using `lockInterruptibly()`.

---

### 9️⃣ Does ReentrantLock support multiple conditions?

**Answer:**
Yes, using `Condition` objects.

---

### 🔟 Is ReentrantLock reentrant across threads?

**Answer:**
No. Reentrant only for same thread.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="rl3"
ReentrantLock:
- Explicit lock/unlock
- Reentrant
- Fairness option
- tryLock()
- lockInterruptibly()

Always:
lock()
try {
   // critical section
}
finally {
   unlock();
}

Use when:
- Need more control than synchronized
```

---
