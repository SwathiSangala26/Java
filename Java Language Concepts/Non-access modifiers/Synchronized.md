## 🔹 What is `synchronized`?

> `synchronized` is used to **control access to shared resources** in a **multi-threaded environment**.

It ensures:

* **Only one thread executes a block/method at a time**
* Prevents **race conditions**
* Maintains **data consistency**

---

## 🧠 Why `synchronized` is Needed

![Image](https://cdn.hashnode.com/res/hashnode/image/upload/v1699077536524/05254500-d691-41f3-bce1-678f323b0c22.png)

![Image](https://codingnomads.com/images/2ffbaf37-92e0-4c98-716c-96d8a6ca8700/public)

Without synchronization:

* Multiple threads access shared data
* Results become **unpredictable**

---

## 🧱 What Does `synchronized` Lock?

![Image](https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/java-intrinsic-locks/images/lock.png)

![Image](https://miro.medium.com/v2/resize%3Afit%3A1400/1%2AFWqsw7ZRpRGuHf50dLhi8Q.png)

Java uses a **monitor lock (intrinsic lock)**:

* Every **object** has one lock
* Every **class** has one lock (Class object)

---

## 1️⃣ `synchronized` Method

### 🔹 Instance synchronized method

```java
class Counter {
    int count = 0;

    synchronized void increment() {
        count++;
    }
}
```

### ✔ Lock Used

* **Object-level lock**
* Only one thread per object can execute it

---

### 🔹 Static synchronized method

```java
class Counter {
    static int count = 0;

    static synchronized void increment() {
        count++;
    }
}
```

### ✔ Lock Used

* **Class-level lock**
* Lock is on `Counter.class`

---

## 2️⃣ `synchronized` Block (Preferred)

```java
class Counter {
    int count = 0;

    void increment() {
        synchronized (this) {
            count++;
        }
    }
}
```

### ✔ Advantages

* Smaller critical section
* Better performance
* More control over locking

---

## 🔐 Object Lock vs Class Lock (VERY IMPORTANT)

| Type                          | Lock On         |
| ----------------------------- | --------------- |
| synchronized instance method  | Object (`this`) |
| synchronized(this)            | Object          |
| static synchronized method    | Class           |
| synchronized(ClassName.class) | Class           |

---

## 📦 Memory & Visibility (Happens-Before)

![Image](https://i.sstatic.net/ymS7O.png)

![Image](https://www.logicbig.com/tutorials/core-java-tutorial/java-multi-threading/java-memory-model/images/jmm.png)

`synchronized` ensures:

* Changes by one thread are **visible** to others
* Flushes variables from thread cache to main memory

---

## ⚠ Important Rules (INTERVIEW FAVORITES)

* `synchronized` is **re-entrant**
* A thread can acquire the **same lock multiple times**
* `synchronized` methods can call other synchronized methods (same lock)

---

## 🔁 What `synchronized` Does NOT Do

❌ Does not guarantee fairness
❌ Does not stop deadlocks
❌ Does not improve performance

---

## 🔄 `synchronized` vs `volatile`

| Feature          | synchronized | volatile |
| ---------------- | ------------ | -------- |
| Mutual exclusion | ✅            | ❌        |
| Visibility       | ✅            | ✅        |
| Atomicity        | ✅            | ❌        |
| Performance      | Slower       | Faster   |

---

## ⚠ Common Interview Traps

❌ synchronized makes code thread-safe completely
✔ Only **critical section** is safe

❌ synchronized works on variables
✔ It works on **objects / blocks / methods**

❌ synchronized avoids deadlock
✔ Deadlock is still possible

---

## 🎯 Interview One-Liners (MEMORIZE)

* synchronized ensures **mutual exclusion**
* Uses **monitor lock**
* Object-level vs Class-level locking
* Re-entrant by default
* Ensures visibility & atomicity

---

## 🧠 Memory Trick

> **One lock → One thread → Critical section**

---

## 📝 Ultra-Short Revision Notes

* synchronized → thread safety
* Lock based
* Object lock / Class lock
* Prevents race condition
* Re-entrant
