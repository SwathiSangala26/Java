## 1️⃣ Definition

Deadlock is a situation where two or more threads are permanently blocked because each thread is waiting for a resource held by another thread.

No thread can proceed.

---

## 2️⃣ Visual Representation

```text
Thread A holds Lock 1
Thread B holds Lock 2

Thread A → waiting for Lock 2
Thread B → waiting for Lock 1

→ Circular Wait → Both BLOCKED forever
```

---

## 3️⃣ Key Features / Properties

* Threads remain in **BLOCKED** state
* Circular dependency between threads
* No progress possible
* Requires at least two threads
* Caused by inconsistent lock ordering
* All Coffman conditions must exist

---

## 4️⃣ Syntax

Deadlock has no specific syntax.
It occurs due to improper locking order.

Example pattern:

```java
synchronized(lock1) {
    synchronized(lock2) {
        // critical section
    }
}
```

If another thread locks `lock2` then `lock1`, deadlock risk exists.

---

## 5️⃣ Code Example

```java
class DeadlockExample {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (lock1) {
                try { Thread.sleep(100); } catch (Exception e) {}
                synchronized (lock2) {
                    System.out.println("Thread 1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock2) {
                try { Thread.sleep(100); } catch (Exception e) {}
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

## 6️⃣ Use Cases (Where It Commonly Occurs)

* Multiple resource locking
* Nested synchronized blocks
* Database transactions
* Banking systems
* Microservice calls waiting on each other

---

## 7️⃣ Pitfalls / Notes

* Nested locks increase risk
* Inconsistent lock ordering causes circular wait
* No exception is thrown
* Program appears frozen
* Hard to reproduce in testing

---

## 8️⃣ Real-World Analogy

Two people:

* Person A holds pen and needs paper
* Person B holds paper and needs pen

Neither releases what they hold → both stuck.

---

## 9️⃣ Best Practices

* Maintain consistent lock ordering
* Avoid nested locking
* Use `tryLock()` with timeout
* Keep critical sections small
* Prefer higher-level concurrency utilities

---

# 🔟 Tricky Questions

---

## 1️⃣ What are the four necessary conditions for deadlock?

Mutual exclusion, Hold and wait, No preemption, Circular wait.

---

## 2️⃣ Can deadlock occur if one condition is removed?

No. All four must be present.

---

## 3️⃣ What state are threads in during deadlock?

BLOCKED state.

---

## 4️⃣ Can deadlock happen with a single thread?

No.

---

## 5️⃣ Does JVM automatically resolve deadlock?

No.

---

## 6️⃣ Is deadlock detected at compile time?

No. It occurs at runtime.

---

## 7️⃣ Can static synchronized methods cause deadlock?

Yes, if multiple class-level locks are involved.

---

## 8️⃣ What is circular wait?

A chain where each thread waits for a resource held by another.

---

## 9️⃣ Does fairness eliminate deadlock?

No.

---

## 1️⃣0️⃣ Why is deadlock difficult to debug?

Because threads are blocked silently without throwing exceptions.

---

# 🔴 Quick Recap / Cheat Sheet

```text
Deadlock:
- Circular wait
- Threads BLOCKED
- Needs 4 Coffman conditions
- No automatic recovery

Prevention:
- Lock ordering
- Avoid nested locks
- tryLock with timeout
- Small critical sections
```

---
