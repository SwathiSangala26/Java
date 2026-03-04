## 1️⃣ Definition

The **Thread Lifecycle** defines the different states a thread goes through from creation to termination during its execution in a Java program.

A thread does not run continuously. It transitions between predefined states controlled by the JVM and scheduler.

---

## 2️⃣ Visual Representation

```
        +-------+
        |  NEW  |
        +-------+
            |
            | start()
            v
     +--------------+
     |  RUNNABLE    |
     +--------------+
        |        |
        |        | CPU Scheduler selects
        |        v
        |    +----------+
        |    | RUNNING  |
        |    +----------+
        |        |
        |        | sleep(), wait(), join(), lock
        |        v
        |   +------------+
        |   | WAITING /  |
        |   | BLOCKED /  |
        |   | TIMED_WAIT |
        |   +------------+
        |        |
        |        | notify()/lock released/time over
        +--------+
                 |
                 v
          +-------------+
          | TERMINATED  |
          +-------------+
```

---

## 3️⃣ Key Features / Properties

### 🔹 1. NEW

* Thread object created
* `start()` not yet called
* No OS resources allocated

---

### 🔹 2. RUNNABLE

* `start()` called
* Eligible for CPU execution
* JVM scheduler decides when to run

> In Java, RUNNABLE includes both ready-to-run and running states.

---

### 🔹 3. RUNNING

* Thread is currently executing `run()` method
* Only one thread per CPU core executes at a time

---

### 🔹 4. BLOCKED

* Waiting to acquire a monitor lock
* Happens during synchronized block entry

---

### 🔹 5. WAITING

* Waiting indefinitely for another thread action
* Caused by:

  * `wait()`
  * `join()`
  * `LockSupport.park()`

---

### 🔹 6. TIMED_WAITING

* Waiting for a specific time
* Caused by:

  * `sleep(time)`
  * `wait(time)`
  * `join(time)`

---

### 🔹 7. TERMINATED (Dead)

* `run()` method completed
* Or exception occurred
* Cannot restart thread

---

## 4️⃣ Syntax

### Creating Thread

```java
Thread t = new Thread(() -> {
    System.out.println("Thread Running");
});
```

### Starting Thread

```java
t.start();
```

### Checking State

```java
Thread.State state = t.getState();
System.out.println(state);
```

---

## 5️⃣ Code Example

```java
class MyThread extends Thread {

    public void run() {
        try {
            Thread.sleep(2000);  // TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished");
    }

    public static void main(String[] args) throws Exception {

        MyThread t = new MyThread();

        System.out.println(t.getState()); // NEW

        t.start();

        System.out.println(t.getState()); // RUNNABLE

        Thread.sleep(500);

        System.out.println(t.getState()); // TIMED_WAITING

        t.join();

        System.out.println(t.getState()); // TERMINATED
    }
}
```

---

## 6️⃣ Use Cases

| State         | Practical Use                   |
| ------------- | ------------------------------- |
| NEW           | Thread prepared but not started |
| RUNNABLE      | Performing background tasks     |
| WAITING       | Producer-Consumer communication |
| BLOCKED       | Resource synchronization        |
| TIMED_WAITING | Delay / timeout operations      |
| TERMINATED    | Task completed                  |

---

## 7️⃣ Pitfalls / Notes

⚠️ Calling `run()` directly does NOT create a new thread
⚠️ A thread cannot be restarted once terminated
⚠️ `sleep()` does NOT release locks
⚠️ `wait()` releases the monitor lock
⚠️ `BLOCKED` only happens for synchronized locks
⚠️ JVM handles scheduling (not developer)
⚠️ State transitions are not manually controlled

---

## 8️⃣ Real-World Analogy

Think of a thread like a student in an exam hall:

| Thread State  | Analogy                             |
| ------------- | ----------------------------------- |
| NEW           | Student entered exam hall           |
| RUNNABLE      | Sitting and ready to write          |
| RUNNING       | Writing exam                        |
| WAITING       | Waiting for teacher’s clarification |
| BLOCKED       | Waiting for answer sheet            |
| TIMED_WAITING | Short break (time-based)            |
| TERMINATED    | Exam finished                       |

---

## 9️⃣ Best Practices

✔ Always use `start()` to begin thread
✔ Prefer `ExecutorService` in real applications
✔ Handle `InterruptedException` properly
✔ Avoid long blocking operations
✔ Minimize synchronized blocks

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ Can a thread go from BLOCKED directly to RUNNING?

**Answer:**
No. It must first go to RUNNABLE state. Scheduler then moves it to RUNNING.

---

### 2️⃣ What is the difference between RUNNABLE and RUNNING in Java?

**Answer:**
Java does not distinguish them separately. Both are part of RUNNABLE state internally.

---

### 3️⃣ What happens if you call start() twice?

**Answer:**
`IllegalThreadStateException` is thrown.

---

### 4️⃣ Does sleep() release lock?

**Answer:**
No. Thread retains monitor lock.

---

### 5️⃣ Does wait() release lock?

**Answer:**
Yes. It releases monitor lock and moves to WAITING state.

---

### 6️⃣ Can we move a thread back to NEW state?

**Answer:**
No. Once started, cannot return to NEW.

---

### 7️⃣ What state is a thread in after calling join()?

**Answer:**
WAITING (or TIMED_WAITING if timeout used).

---

### 8️⃣ What state after run() completes?

**Answer:**
TERMINATED.

---

### 9️⃣ Is thread scheduling controlled by Java program?

**Answer:**
No. Controlled by JVM + OS scheduler.

---

### 🔟 Difference between BLOCKED and WAITING?

**Answer:**

| BLOCKED                  | WAITING                           |
| ------------------------ | --------------------------------- |
| Waiting for monitor lock | Waiting for another thread action |
| Caused by synchronized   | Caused by wait(), join()          |
| Lock not acquired        | Lock released                     |

---

# 🧾 Quick Recap / Cheat Sheet

```
NEW → start() → RUNNABLE → RUNNING
RUNNING → sleep() → TIMED_WAITING
RUNNING → wait() → WAITING
RUNNING → synchronized lock → BLOCKED
RUNNING → run() ends → TERMINATED
```

### Important Rule

👉 Thread cannot be restarted
👉 sleep() keeps lock
👉 wait() releases lock
👉 run() ≠ start()

---
