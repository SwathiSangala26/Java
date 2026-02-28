# 1️⃣ Definition

`ForkJoinPool` is a specialized thread pool designed for **parallel divide-and-conquer tasks**.

It is part of `java.util.concurrent` and is optimized for:

* Recursive tasks
* Large computational problems
* Parallel processing

It uses the **Work-Stealing Algorithm**.

---

# 2️⃣ Visual Representation

## 🔹 Divide and Conquer Model

```text id="fjp1"
Main Task
   |
   v
Split into Subtasks
   |       |
   v       v
 Sub1     Sub2
   |       |
   v       v
Compute  Compute
   \       /
    \     /
     \   /
      Merge Result
```

---

## 🔹 Work Stealing

```text id="fjp2"
Worker-1 Queue: [Task A, Task B]
Worker-2 Queue: []
Worker-3 Queue: []

Worker-2 steals Task B from Worker-1
```

Idle threads steal tasks from busy threads.

Improves CPU utilization.

---

# 3️⃣ Key Features / Properties

* Uses **ForkJoinPool**
* Uses **ForkJoinTask**
* Supports recursive splitting
* Uses **work-stealing**
* Default parallelism = number of CPU cores
* Efficient for CPU-bound tasks

---

# 4️⃣ Core Classes

### 🔹 ForkJoinPool

Thread pool for executing tasks.

### 🔹 ForkJoinTask (abstract)

Base class for tasks.

Two main subclasses:

* `RecursiveTask<V>` → returns result
* `RecursiveAction` → no return value

---

# 5️⃣ Syntax

---

## 🔹 Using RecursiveTask

```java
class MyTask extends RecursiveTask<Integer> {

    protected Integer compute() {
        // divide or compute
        return result;
    }
}
```

Submit to pool:

```java
ForkJoinPool pool = new ForkJoinPool();
int result = pool.invoke(new MyTask());
```

---

# 6️⃣ Code Example (Sum of Array)

```java
import java.util.concurrent.*;

class SumTask extends RecursiveTask<Integer> {

    private int[] arr;
    private int start, end;

    SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {

        if (end - start <= 2) {
            int sum = 0;
            for (int i = start; i < end; i++)
                sum += arr[i];
            return sum;
        }

        int mid = (start + end) / 2;

        SumTask left = new SumTask(arr, start, mid);
        SumTask right = new SumTask(arr, mid, end);

        left.fork();
        int rightResult = right.compute();
        int leftResult = left.join();

        return leftResult + rightResult;
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        ForkJoinPool pool = new ForkJoinPool();

        int result = pool.invoke(new SumTask(arr, 0, arr.length));

        System.out.println("Sum: " + result);
    }
}
```

---

# 7️⃣ How fork() and join() Work

```text id="fjp3"
fork()  → asynchronously submit subtask
join()  → wait for result
```

Flow:

1. Split task
2. fork left
3. compute right
4. join left
5. merge result

---

# 8️⃣ Use Cases

| Scenario                  | Why ForkJoin             |
| ------------------------- | ------------------------ |
| Large array processing    | Parallel splitting       |
| Merge sort                | Divide and conquer       |
| Matrix operations         | CPU parallelism          |
| Parallel streams (Java 8) | Uses common ForkJoinPool |

---

# 9️⃣ Pitfalls / Notes

⚠️ Best for CPU-bound tasks
⚠️ Not ideal for blocking I/O
⚠️ Recursive depth must be controlled
⚠️ Too small tasks → overhead
⚠️ join() blocks until result available
⚠️ Common pool is shared globally

---

# 🔟 Real-World Analogy

Think of solving a big project:

* Manager splits work into smaller tasks
* Assigns to team members
* Idle members help others
* Results combined

Work-stealing = helping overloaded teammate.

---

# ✅ Best Practices

✔ Define proper threshold for splitting
✔ Avoid blocking operations inside compute()
✔ Use commonPool() carefully
✔ Balance task size
✔ Prefer invoke() over manually managing threads

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ What problem does ForkJoinPool solve?

**Answer:**
Efficient parallel execution of recursive divide-and-conquer tasks.

---

### 2️⃣ What is Work-Stealing?

**Answer:**
Idle threads steal tasks from busy threads’ queues.

---

### 3️⃣ Difference between RecursiveTask and RecursiveAction?

**Answer:**

| RecursiveTask  | RecursiveAction |
| -------------- | --------------- |
| Returns result | No return value |

---

### 4️⃣ What is fork()?

**Answer:**
Asynchronously submits subtask to pool.

---

### 5️⃣ What is join()?

**Answer:**
Waits for task completion and returns result.

---

### 6️⃣ Is ForkJoinPool suitable for IO tasks?

**Answer:**
No. Designed for CPU-bound tasks.

---

### 7️⃣ What is commonPool()?

**Answer:**
Shared ForkJoinPool used by parallel streams.

---

### 8️⃣ What happens if task never splits?

**Answer:**
Runs like normal thread pool task.

---

### 9️⃣ What determines parallelism level?

**Answer:**
Number of available processor cores (by default).

---

### 🔟 Why compute one task directly instead of forking both?

**Answer:**
Reduces overhead and improves efficiency.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="fjp4"
ForkJoinPool:
- For divide & conquer
- Uses work-stealing
- Best for CPU-bound tasks

Classes:
- ForkJoinPool
- RecursiveTask<V>
- RecursiveAction

Key Methods:
- fork()
- join()
- compute()
- invoke()

Used in:
- Parallel Streams
```

---
