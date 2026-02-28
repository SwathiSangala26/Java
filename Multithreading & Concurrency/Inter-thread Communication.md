# 1️⃣ Definition

Inter-thread communication is a mechanism that allows multiple threads to communicate with each other to coordinate execution.

It is used when:

* One thread depends on another thread’s result
* Threads must wait and notify each other
* Producer–Consumer pattern is implemented

In Java, it is achieved using:

* `wait()`
* `notify()`
* `notifyAll()`

These methods are defined in the `Object` class.

---

# 2️⃣ Visual Representation

## 🔹 Basic Flow

```text id="itc1"
Thread A (Producer)
        |
        v
Adds data → notify()
        |
        v
Thread B (Consumer)
        |
        v
wait() until notified
```

---

## 🔹 State Transition

```text id="itc2"
RUNNING
   |
   | wait()
   v
WAITING
   |
   | notify()
   v
BLOCKED (waiting for lock)
   |
   v
RUNNING
```

Important:
After notify(), thread does NOT immediately run.
It must reacquire the lock.

---

# 3️⃣ Key Features / Properties

* Must be used inside synchronized block/method
* Belongs to `Object` class
* Releases monitor lock when calling `wait()`
* Does NOT release lock when calling `notify()`
* Used for thread coordination

---

# 4️⃣ Syntax

---

## 🔹 wait()

```java
synchronized(obj) {
    obj.wait();
}
```

Thread:

* Releases lock
* Moves to WAITING state

---

## 🔹 notify()

```java
synchronized(obj) {
    obj.notify();
}
```

Wakes one waiting thread.

---

## 🔹 notifyAll()

```java
synchronized(obj) {
    obj.notifyAll();
}
```

Wakes all waiting threads.

---

# 5️⃣ Code Example (Producer-Consumer)

```java
class Shared {

    private int data;
    private boolean hasData = false;

    synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();
        }
        data = value;
        hasData = true;
        notify();
    }

    synchronized int consume() throws InterruptedException {
        while (!hasData) {
            wait();
        }
        hasData = false;
        notify();
        return data;
    }
}
```

Key Point:
Use `while`, not `if`, to prevent spurious wakeups.

---

# 6️⃣ Use Cases

| Scenario             | Why Needed               |
| -------------------- | ------------------------ |
| Producer-Consumer    | Coordinate data exchange |
| Task dependency      | Wait for result          |
| Resource pool        | Wait until resource free |
| Event-driven systems | Notify waiting threads   |

---

# 7️⃣ Pitfalls / Notes

⚠️ Must call inside synchronized block
⚠️ Calling wait() without lock → IllegalMonitorStateException
⚠️ notify() does NOT release lock immediately
⚠️ Use while instead of if
⚠️ Can cause deadlock if misused
⚠️ notify() may wake wrong thread

---

# 8️⃣ Real-World Analogy

Think of a restaurant:

Customer (Consumer):

* Orders food
* Waits (wait())

Chef (Producer):

* Prepares food
* Rings bell (notify())

Customer wakes up and eats.

---

# 9️⃣ Best Practices

✔ Always use wait() inside while loop
✔ Prefer notifyAll() in complex systems
✔ Keep synchronized block small
✔ Handle InterruptedException properly
✔ Use higher-level concurrency utilities in production

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Why must wait() be called inside synchronized block?

**Answer:**
Because thread must own monitor lock before releasing it.

---

### 2️⃣ What happens if wait() is called outside synchronized block?

**Answer:**
Throws `IllegalMonitorStateException`.

---

### 3️⃣ Does notify() release lock immediately?

**Answer:**
No. Lock is released only after synchronized block ends.

---

### 4️⃣ Difference between notify() and notifyAll()?

**Answer:**

| notify()                    | notifyAll()              |
| --------------------------- | ------------------------ |
| Wakes one thread            | Wakes all threads        |
| Risk of wrong thread waking | Safer in complex systems |

---

### 5️⃣ Why use while instead of if in wait loop?

**Answer:**
To handle spurious wakeups and recheck condition.

---

### 6️⃣ What state does thread go into after wait()?

**Answer:**
WAITING (or TIMED_WAITING if timeout used).

---

### 7️⃣ After notify(), what state does waiting thread enter?

**Answer:**
BLOCKED (waiting to reacquire lock).

---

### 8️⃣ Can wait() be called on Thread class?

**Answer:**
No. It belongs to Object class.

---

### 9️⃣ Does sleep() release lock?

**Answer:**
No.

---

### 🔟 Can notify() wake a specific thread?

**Answer:**
No. JVM chooses randomly.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="itc3"
Inter-thread Communication:

Methods (Object class):
- wait()
- notify()
- notifyAll()

Rules:
- Must be inside synchronized
- wait() releases lock
- notify() does NOT release lock
- Use while, not if

Flow:
Thread → wait() → WAITING
Other Thread → notify()
Thread → BLOCKED → RUNNING
```

---
