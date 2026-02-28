## 1️⃣ Definition

Concurrency problems occur when multiple threads compete for shared resources and cause:

* Permanent blocking
* No progress
* Unfair execution

Main types:

* Deadlock
* Livelock
* Starvation

---

## 2️⃣ Visual Representation

### Deadlock

```text
Thread A holds Lock 1
Thread B holds Lock 2

Thread A → waiting for Lock 2
Thread B → waiting for Lock 1

→ Both BLOCKED forever
```

---

### Livelock

```text
Thread A: retrying...
Thread B: retrying...
Thread A: retrying...
Thread B: retrying...

→ Both RUNNING but no progress
```

---

### Starvation

```text
High Priority Thread → always gets CPU
Low Priority Thread  → never gets CPU

→ One thread ignored indefinitely
```

---

## 3️⃣ Key Features / Properties

### Deadlock

* Threads in BLOCKED state
* Circular dependency
* Requires 4 Coffman conditions
* No automatic recovery

### Livelock

* Threads in RUNNING state
* Continuous retry
* CPU usage high
* No forward progress

### Starvation

* Thread remains waiting
* Caused by unfair scheduling
* Often due to priority misuse

---

## 4️⃣ Syntax

There is no specific syntax for concurrency problems.

They occur due to improper locking or scheduling.

Example causing deadlock:

```java
synchronized(lock1) {
    synchronized(lock2) {
        // critical section
    }
}
```

---

## 5️⃣ Code Example (Deadlock)

```java
class DeadlockExample {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                synchronized (lock2) {
                    System.out.println("Thread 1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                synchronized (lock1) {
                    System.out.println("Thread 2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

Possible circular wait → Deadlock.

---

## 6️⃣ Use Cases (Where They Commonly Occur)

* Banking systems (multiple locks)
* Database transactions
* Multi-resource allocation
* Thread pools with poor configuration
* High-priority task scheduling

---

## 7️⃣ Pitfalls / Notes

* Nested locking increases deadlock risk
* Improper lock ordering causes circular wait
* Excessive retry logic causes livelock
* Thread priorities can cause starvation
* Fair locks reduce but do not eliminate starvation

---

## 8️⃣ Real-World Analogy

Deadlock → Two people holding two keys and waiting for each other’s key.

Livelock → Two people trying to pass in hallway but stepping same direction repeatedly.

Starvation → One employee always gets tasks; another never gets work.

---

## 9️⃣ Best Practices

* Maintain consistent lock ordering
* Avoid holding multiple locks
* Use tryLock() with timeout
* Avoid unnecessary priority changes
* Use fair locking when needed
* Keep critical sections small

---

# 🔟 Tricky Questions (Continuous Numbering)

---

## 1️⃣0️⃣ What are the four conditions required for deadlock?

Mutual exclusion, Hold and wait, No preemption, Circular wait.

---

## 1️⃣1️⃣ Can deadlock occur if one Coffman condition is removed?

No. All four must exist.

---

## 1️⃣2️⃣ What state are threads in during deadlock?

BLOCKED.

---

## 1️⃣3️⃣ What state are threads in during livelock?

RUNNING.

---

## 1️⃣4️⃣ Difference between deadlock and livelock?

Deadlock → Threads blocked permanently.
Livelock → Threads active but no progress.

---

## 1️⃣5️⃣ Does starvation involve circular waiting?

No.

---

## 1️⃣6️⃣ Can starvation occur without locks?

Yes. Due to unfair CPU scheduling.

---

## 1️⃣7️⃣ Does fairness guarantee no starvation?

No. It reduces the probability.

---

## 1️⃣8️⃣ Which concurrency issue completely freezes the program?

Deadlock.

---

## 1️⃣9️⃣ Which problem wastes CPU cycles?

Livelock.

---

## 2️⃣0️⃣ Can deadlock happen with one thread?

No.

---

# ⚠️ Quick Recap / Cheat Sheet

```text
Deadlock:
- Circular wait
- Threads BLOCKED
- Needs 4 conditions

Livelock:
- Threads RUNNING
- Continuous retry
- No progress

Starvation:
- Unfair scheduling
- Thread never executes

Prevention:
- Lock ordering
- tryLock with timeout
- Fair locks
```

---
