# 1️⃣ Definition

The **Executor Framework** is a high-level API (from `java.util.concurrent`) used to manage and control thread execution efficiently using thread pools.

It separates:

* Task submission
* Thread management
* Task execution

Instead of manually creating threads, we submit tasks to an executor.

---

# 2️⃣ Visual Representation

## 🔹 Traditional Thread Creation

```text id="ex1"
Task 1 → new Thread() → start()
Task 2 → new Thread() → start()
Task 3 → new Thread() → start()

Problem:
Too many threads → performance issue
```

---

## 🔹 Using Executor Framework

```text id="ex2"
Tasks → ExecutorService → Thread Pool
                |
                v
        Worker Thread 1
        Worker Thread 2
        Worker Thread 3
```

Threads are reused. Efficient.

---

# 3️⃣ Key Features / Properties

* Uses **Thread Pool**
* Manages lifecycle of threads
* Improves performance
* Reduces overhead of thread creation
* Supports Callable & Future
* Provides shutdown mechanism

Core Interfaces:

* `Executor`
* `ExecutorService`
* `ScheduledExecutorService`

---

# 4️⃣ Syntax

---

## 🔹 Create ExecutorService

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
```

---

## 🔹 Submit Runnable

```java
executor.execute(() -> {
    System.out.println("Task running");
});
```

---

## 🔹 Submit Callable

```java
Future<Integer> future = executor.submit(() -> {
    return 100;
});
```

---

## 🔹 Shutdown

```java
executor.shutdown();
```

---

# 5️⃣ Code Example

```java
import java.util.concurrent.*;

public class ExecutorExample {

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

---

# 6️⃣ Types of Thread Pools

---

## 🔹 1. Fixed Thread Pool

```java
Executors.newFixedThreadPool(n);
```

* Fixed number of threads
* Reuses threads

---

## 🔹 2. Cached Thread Pool

```java
Executors.newCachedThreadPool();
```

* Creates threads as needed
* Reuses idle threads
* No fixed size

---

## 🔹 3. Single Thread Executor

```java
Executors.newSingleThreadExecutor();
```

* Only one worker thread
* Tasks executed sequentially

---

## 🔹 4. Scheduled Thread Pool

```java
Executors.newScheduledThreadPool(n);
```

* Used for delayed or periodic tasks

---

# 7️⃣ Use Cases

| Scenario                   | Executor Type          |
| -------------------------- | ---------------------- |
| Web server requests        | Fixed thread pool      |
| Short async tasks          | Cached thread pool     |
| Sequential background task | Single thread executor |
| Scheduled job              | Scheduled executor     |

---

# 8️⃣ Pitfalls / Notes

⚠️ Must call `shutdown()`
⚠️ Too many threads → memory issue
⚠️ Cached pool can grow unlimited
⚠️ Tasks queue if threads busy
⚠️ Unhandled exception terminates worker thread

---

# 9️⃣ Real-World Analogy

Think of a company:

* Tasks = Work requests
* ExecutorService = Manager
* Thread Pool = Employees
* Manager assigns work to available employee
* Employees reused instead of hiring new ones every time

Efficient resource management.

---

# 🔟 Best Practices

✔ Use fixed thread pool for controlled concurrency
✔ Always shutdown executor
✔ Handle exceptions inside task
✔ Use Callable when result needed
✔ Avoid creating new executor repeatedly

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Why use Executor instead of creating threads manually?

**Answer:**
Better performance, thread reuse, lifecycle management, scalability.

---

### 2️⃣ Difference between execute() and submit()?

**Answer:**

| execute()     | submit()            |
| ------------- | ------------------- |
| Runnable only | Runnable & Callable |
| No return     | Returns Future      |

---

### 3️⃣ What happens if we don’t call shutdown()?

**Answer:**
Application may not terminate because threads remain alive.

---

### 4️⃣ Which thread pool is dangerous?

**Answer:**
Cached thread pool — can create unlimited threads.

---

### 5️⃣ What happens if task throws exception?

**Answer:**
With submit() → exception wrapped in ExecutionException
With execute() → thread may terminate

---

### 6️⃣ Difference between Fixed and Single thread executor?

**Answer:**
Single → 1 thread only
Fixed → multiple threads

---

### 7️⃣ Can ExecutorService be reused after shutdown()?

**Answer:**
No.

---

### 8️⃣ What is ScheduledExecutorService used for?

**Answer:**
Delayed and periodic execution.

---

### 9️⃣ Does Executor create threads immediately?

**Answer:**
Depends on pool type. Fixed creates when needed.

---

### 🔟 What is core advantage of thread pool?

**Answer:**
Thread reuse → reduced creation overhead → better performance.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Executor Framework:

Interfaces:
- Executor
- ExecutorService
- ScheduledExecutorService

Common Pools:
- newFixedThreadPool(n)
- newCachedThreadPool()
- newSingleThreadExecutor()
- newScheduledThreadPool(n)

Methods:
- execute()
- submit()
- shutdown()

Benefits:
- Thread reuse
- Performance
- Better management
```

---
