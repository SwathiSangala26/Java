# 1️⃣ Definition

### 🔹 Callable

`Callable` is a functional interface used to define a task that:

* Returns a result
* Can throw checked exceptions

It is part of `java.util.concurrent`.

---

### 🔹 Future

`Future` represents the result of an asynchronous computation.
It acts as a placeholder for the result returned by a `Callable`.

---

# 2️⃣ Visual Representation

```text
Callable Task
      |
      v
Submitted to ExecutorService
      |
      v
Runs in separate Thread
      |
      v
Produces Result
      |
      v
Future Object holds Result
      |
      v
future.get() → Retrieve Result
```

---

# 3️⃣ Key Features / Properties

## 🔹 Callable

* Located in `java.util.concurrent`
* Method: `V call()`
* Returns value
* Can throw checked exceptions
* Generic (Callable<V>)

---

## 🔹 Future

* Represents pending result
* Methods:

  * `get()`
  * `isDone()`
  * `cancel()`
  * `isCancelled()`
* Blocking by default (`get()` blocks)

---

# 4️⃣ Syntax

## 🔹 Callable Declaration

```java
Callable<Integer> task = () -> {
    return 10;
};
```

---

## 🔹 Submitting Callable

```java
ExecutorService executor = Executors.newSingleThreadExecutor();

Future<Integer> future = executor.submit(task);

Integer result = future.get();

executor.shutdown();
```

---

# 5️⃣ Code Example

```java
import java.util.concurrent.*;

public class CallableExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 100;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Task submitted");

        Integer result = future.get();  // Blocks

        System.out.println("Result: " + result);

        executor.shutdown();
    }
}
```

---

# 6️⃣ Use Cases

| Scenario                        | Why Callable/Future    |
| ------------------------------- | ---------------------- |
| Need return value from thread   | Runnable cannot return |
| Need checked exception handling | Runnable cannot throw  |
| Async computation               | Future holds result    |
| Task cancellation               | Future.cancel()        |

---

# 7️⃣ Pitfalls / Notes

⚠️ `Future.get()` blocks until result available
⚠️ If task throws exception → `ExecutionException`
⚠️ Must shutdown ExecutorService
⚠️ Cancelling does not guarantee immediate stop
⚠️ Callable cannot be directly started like Thread

---

# 8️⃣ Real-World Analogy

Think of:

* **Callable** = Ordering food
* **ExecutorService** = Restaurant kitchen
* **Future** = Token number
* **future.get()** = Collecting your order

You wait until the food is ready.

---

# 9️⃣ Best Practices

✔ Always shutdown ExecutorService
✔ Use timeout version of `get()`
✔ Handle `ExecutionException` properly
✔ Avoid blocking main thread unnecessarily
✔ Prefer thread pool over manual thread creation

Example with timeout:

```java
future.get(3, TimeUnit.SECONDS);
```

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Difference between Runnable and Callable?

**Answer:**

| Runnable                       | Callable                    |
| ------------------------------ | --------------------------- |
| void run()                     | V call()                    |
| No return value                | Returns value               |
| Cannot throw checked exception | Can throw checked exception |

---

### 2️⃣ What happens if Callable throws exception?

**Answer:**
Exception is wrapped inside `ExecutionException` and thrown by `future.get()`.

---

### 3️⃣ Does Future.get() block?

**Answer:**
Yes. It blocks until result is available.

---

### 4️⃣ Can we get result without blocking?

**Answer:**
Use:

* `isDone()`
* or timeout version of `get()`

---

### 5️⃣ What does cancel(true) do?

**Answer:**
Attempts to interrupt the running thread.

---

### 6️⃣ Can Callable run without ExecutorService?

**Answer:**
No. It must be submitted to ExecutorService.

---

### 7️⃣ What happens if you call get() twice?

**Answer:**
Returns same result. It does not re-execute.

---

### 8️⃣ Is Future reusable?

**Answer:**
No. One Future corresponds to one task.

---

### 9️⃣ Can multiple threads call get() on same Future?

**Answer:**
Yes. They will all receive same result.

---

### 🔟 What is difference between submit() and execute()?

**Answer:**

* `execute()` → Runnable only, no result
* `submit()` → Returns Future

---

# 🧾 Quick Recap / Cheat Sheet

```text
Callable:
- V call()
- Returns value
- Throws checked exception

Future:
- get()
- isDone()
- cancel()
- Blocks by default

Flow:
Callable → submit() → ExecutorService → Future → get()
```

---
