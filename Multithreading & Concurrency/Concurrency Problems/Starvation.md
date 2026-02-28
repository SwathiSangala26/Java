## 1️⃣ Definition

Starvation is a concurrency problem where a thread **never gets CPU time or resource access** because other threads continuously dominate the available resources.

The thread is not blocked permanently by circular wait — it is simply **never scheduled or never granted access**.

---

## 2️⃣ Visual Representation

```text id="stv1"
High Priority Thread  → keeps getting CPU
Medium Thread         → runs sometimes
Low Priority Thread   → keeps waiting forever

→ Low Priority Thread starved
```

---

## 3️⃣ Key Features / Properties

* Thread remains in **WAITING / RUNNABLE but not scheduled**
* Caused by unfair scheduling
* Often due to priority misuse
* Can happen without deadlock
* May occur in thread pools or locks

---

## 4️⃣ Syntax

There is no specific syntax for starvation.
It occurs due to scheduling or unfair locking.

Example risky pattern:

```java id="stx1"
ReentrantLock lock = new ReentrantLock(false); // unfair lock
```

If many threads continuously acquire the lock, some threads may never get it.

---

## 5️⃣ Code Example (Conceptual)

```java id="stx2"
class StarvationExample {

    public static void main(String[] args) {

        Thread highPriority = new Thread(() -> {
            while (true) {
                System.out.println("High priority running");
            }
        });

        Thread lowPriority = new Thread(() -> {
            while (true) {
                System.out.println("Low priority running");
            }
        });

        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        lowPriority.start();
    }
}
```

Low priority thread may rarely execute → starvation possible.

---

## 6️⃣ Use Cases (Where It Commonly Occurs)

* Improper thread priority usage
* Unfair locks
* Thread pools overloaded with high-priority tasks
* Systems with continuous high CPU load

---

## 7️⃣ Pitfalls / Notes

* No exception is thrown
* Hard to detect
* Thread appears alive but rarely executes
* Fair scheduling reduces risk but doesn’t guarantee elimination
* Different from deadlock (no circular wait)

---

## 8️⃣ Real-World Analogy

In an office:

* One employee always gets urgent tasks
* Another employee never gets assigned work

The second employee is starved.

---

## 9️⃣ Best Practices

* Avoid unnecessary priority changes
* Use fair locks when required
* Balance thread pool size
* Avoid infinite loops without yielding
* Monitor thread states

---

# 🔟 Tricky Questions

---

## 1️⃣ What is starvation?

A thread never gets CPU time or resource access due to unfair scheduling.

---

## 2️⃣ Is starvation the same as deadlock?

No.

---

## 3️⃣ What state is a starved thread in?

WAITING or RUNNABLE (not scheduled).

---

## 4️⃣ Can starvation occur without locks?

Yes.

---

## 5️⃣ Does thread priority cause starvation?

Yes, if misused.

---

## 6️⃣ Does fairness guarantee no starvation?

No, but it reduces probability.

---

## 7️⃣ Does starvation freeze the whole system?

No. Only certain threads are affected.

---

## 8️⃣ Can starvation lead to livelock?

No. They are different issues.

---

## 9️⃣ Is starvation always permanent?

Not necessarily. It may be temporary.

---

## 🔟 How can starvation be reduced?

Using fair locks and balanced scheduling.

---

# 🟢 Quick Recap / Cheat Sheet

```text id="stv2"
Starvation:
- Unfair scheduling
- Thread ignored
- No circular wait
- May occur without locks

Prevention:
- Fair locks
- Avoid priority misuse
- Balanced thread pools
```

---
