# 1️⃣ Definition

A **Thread Pool** is a collection of pre-created worker threads that are reused to execute multiple tasks.

Instead of creating a new thread for every task, tasks are submitted to a pool, and available threads execute them.

Purpose:

* Improve performance
* Reduce thread creation overhead
* Control concurrency

---

# 2️⃣ Visual Representation

## 🔹 Without Thread Pool

```text id="tp1"
Task1 → new Thread → start()
Task2 → new Thread → start()
Task3 → new Thread → start()

Problem:
Too many threads → memory & CPU overhead
```

---

## 🔹 With Thread Pool

```text id="tp2"
             Task Queue
                 |
                 v
        -------------------
        |  Thread Pool    |
        |  Worker-1       |
        |  Worker-2       |
        |  Worker-3       |
        -------------------
                 |
                 v
            Executes Tasks
```

Threads are reused instead of recreated.

---

# 3️⃣ Key Features / Properties

* Pre-created worker threads
* Uses a task queue
* Threads are reused
* Controlled concurrency
* Managed by `ExecutorService`
* Reduces context switching overhead

---

# 4️⃣ Syntax

---

## 🔹 Create Fixed Thread Pool

```java id="k9g1sx"
ExecutorService executor =
        Executors.newFixedThreadPool(3);
```

---

## 🔹 Submit Task

```java id="l3u0ew"
executor.submit(() -> {
    System.out.println("Task running");
});
```

---

## 🔹 Shutdown Pool

```java id="f0a7lk"
executor.shutdown();
```

---

# 5️⃣ Code Example

```java id="1rm8a4"
import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService executor =
                Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 5; i++) {

            int taskId = i;

            executor.submit(() -> {
                System.out.println("Task " + taskId +
                        " executed by " +
                        Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
```

Output shows same threads reused.

---

# 6️⃣ Types of Thread Pools

---

## 🔹 1️⃣ Fixed Thread Pool

```java id="p1q3ld"
Executors.newFixedThreadPool(n);
```

* Fixed number of threads
* Tasks wait in queue if busy

---

## 🔹 2️⃣ Cached Thread Pool

```java id="q4xklo"
Executors.newCachedThreadPool();
```

* Creates threads as needed
* Reuses idle threads
* Can grow unlimited

---

## 🔹 3️⃣ Single Thread Pool

```java id="w2rt8y"
Executors.newSingleThreadExecutor();
```

* Only one worker thread
* Sequential execution

---

## 🔹 4️⃣ Scheduled Thread Pool

```java id="b6vm7t"
Executors.newScheduledThreadPool(n);
```

* Delayed / periodic tasks

---

# 7️⃣ Use Cases

| Scenario                   | Pool Type         |
| -------------------------- | ----------------- |
| Web server                 | Fixed thread pool |
| Short async jobs           | Cached            |
| Background sequential task | Single            |
| Cron jobs                  | Scheduled         |

---

# 8️⃣ Pitfalls / Notes

⚠️ Must call `shutdown()`
⚠️ Cached pool may cause OOM if too many tasks
⚠️ Too large pool → context switching overhead
⚠️ Too small pool → tasks delayed
⚠️ Unhandled exception may terminate worker thread

---

# 9️⃣ Real-World Analogy

Think of a restaurant kitchen:

* Orders = Tasks
* Chefs = Threads
* Kitchen staff = Thread Pool

Instead of hiring a new chef for every order, existing chefs handle orders efficiently.

---

# 🔟 Best Practices

✔ Choose correct pool size (CPU-bound vs IO-bound)
✔ Use fixed pool in production
✔ Always shutdown pool
✔ Handle exceptions inside tasks
✔ Avoid unbounded queues

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Why is thread pool better than creating threads manually?

**Answer:**
Thread reuse reduces creation cost and improves performance.

---

### 2️⃣ What happens if all threads are busy?

**Answer:**
Tasks are placed in the queue until a thread becomes available.

---

### 3️⃣ What is danger of CachedThreadPool?

**Answer:**
It can create unlimited threads → memory issue.

---

### 4️⃣ Difference between Thread Pool and Executor Framework?

**Answer:**
Thread Pool = Concept
Executor Framework = API that manages thread pools.

---

### 5️⃣ What happens if shutdown() is not called?

**Answer:**
Application may not terminate.

---

### 6️⃣ Can we reuse thread pool after shutdown()?

**Answer:**
No.

---

### 7️⃣ Does thread pool guarantee task execution order?

**Answer:**
Only in SingleThreadExecutor.

---

### 8️⃣ Where are tasks stored before execution?

**Answer:**
In a blocking task queue.

---

### 9️⃣ Is thread pool suitable for long-running blocking tasks?

**Answer:**
Depends on size; blocking tasks can exhaust pool.

---

### 🔟 How to decide pool size?

**Answer:**

* CPU-bound → number of cores
* IO-bound → more than cores

---

# 🧾 Quick Recap / Cheat Sheet

```text id="tp3"
Thread Pool:
- Reuses threads
- Uses task queue
- Managed by ExecutorService

Types:
- Fixed
- Cached
- Single
- Scheduled

Benefits:
- Performance
- Controlled concurrency
- Reduced overhead

Important:
Always call shutdown()
```

---
