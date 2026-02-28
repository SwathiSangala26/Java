# 1️⃣ Definition

Atomic classes provide **lock-free, thread-safe operations** on single variables.

They are part of:

```
java.util.concurrent.atomic
```

They use **CAS (Compare-And-Swap)** instead of `synchronized` or locks.

Purpose:

* Provide atomic operations
* Improve performance
* Avoid blocking

---

# 2️⃣ Visual Representation

## 🔹 Without Atomic (Race Condition)

```text id="ac1"
Thread A: read count (5)
Thread B: read count (5)

Thread A: count++
Thread B: count++

Final value = 6  (Wrong, expected 7)
```

---

## 🔹 With Atomic (CAS Mechanism)

```text id="ac2"
Thread A: compare 5 with 5 → success → update to 6
Thread B: compare 5 with 6 → fail → retry
Thread B: compare 6 with 6 → success → update to 7
```

Correct result achieved.

---

# 3️⃣ Key Features / Properties

* Lock-free
* Non-blocking
* Thread-safe
* Uses CAS internally
* Better performance than synchronized (in many cases)
* Works for single-variable operations

---

# 4️⃣ Common Atomic Classes

| Class                  | Purpose             |
| ---------------------- | ------------------- |
| AtomicInteger          | int operations      |
| AtomicLong             | long operations     |
| AtomicBoolean          | boolean             |
| AtomicReference        | Object reference    |
| AtomicIntegerArray     | Atomic array        |
| AtomicStampedReference | Prevent ABA problem |

---

# 5️⃣ Syntax

---

## 🔹 AtomicInteger Example

```java id="9j6mck"
AtomicInteger count = new AtomicInteger(0);

count.incrementAndGet();
count.get();
```

---

## 🔹 Compare and Set

```java id="pjx41g"
count.compareAndSet(5, 10);
```

Updates only if current value = 5.

---

# 6️⃣ Code Example

```java id="c5ek2r"
import java.util.concurrent.atomic.AtomicInteger;

class AtomicExample {

    static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                count.incrementAndGet();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + count.get());
    }
}
```

Correct result without synchronization.

---

# 7️⃣ Important Methods

### AtomicInteger

```java
get()
set()
incrementAndGet()
getAndIncrement()
addAndGet()
compareAndSet()
```

---

# 8️⃣ Use Cases

| Scenario                | Why Atomic       |
| ----------------------- | ---------------- |
| Counters                | Atomic increment |
| ID generators           | Thread-safe      |
| Flags                   | AtomicBoolean    |
| Object reference update | AtomicReference  |

---

# 9️⃣ Pitfalls / Notes

⚠️ Only single-variable atomicity
⚠️ Cannot replace synchronized for complex operations
⚠️ Multiple atomic variables together not atomic
⚠️ High contention → performance may degrade
⚠️ ABA problem possible

---

# 🔟 Real-World Analogy

Think of a token machine:

* Machine checks token number
* Updates only if matches expected
* If not, retry

No locking the entire counter room — only updating safely.

---

# ✅ Best Practices

✔ Use for counters and simple state
✔ Avoid for complex transactions
✔ Use AtomicReference for object swaps
✔ Use LongAdder for high contention counters
✔ Understand CAS mechanism

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ What is CAS?

**Answer:**
Compare-And-Swap. Updates value only if expected value matches current value.

---

### 2️⃣ Are Atomic classes completely lock-free?

**Answer:**
Yes (internally use CAS, not traditional locks).

---

### 3️⃣ Can AtomicInteger replace synchronized?

**Answer:**
Only for simple atomic operations.

---

### 4️⃣ What is ABA problem?

**Answer:**
Value changes A → B → A. CAS thinks no change happened.

---

### 5️⃣ How to solve ABA problem?

**Answer:**
Using `AtomicStampedReference`.

---

### 6️⃣ Difference between incrementAndGet() and getAndIncrement()?

**Answer:**

| incrementAndGet()     | getAndIncrement()     |
| --------------------- | --------------------- |
| Increment then return | Return then increment |

---

### 7️⃣ Are atomic operations blocking?

**Answer:**
No. Non-blocking.

---

### 8️⃣ Is AtomicInteger faster than synchronized?

**Answer:**
Generally yes for simple operations.

---

### 9️⃣ Can we use Atomic classes for double?

**Answer:**
Yes, using AtomicReference or DoubleAdder.

---

### 🔟 What happens under heavy contention?

**Answer:**
CAS retries increase → performance drop.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="ac3"
Atomic Classes:
- Lock-free
- Non-blocking
- Uses CAS

Common:
- AtomicInteger
- AtomicLong
- AtomicBoolean
- AtomicReference

Key:
compareAndSet(expected, new)
incrementAndGet()

Use for:
- Counters
- Flags
- Simple shared variables

Not for:
- Complex multi-variable logic
```

---
