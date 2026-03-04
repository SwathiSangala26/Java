## 1️⃣ Definition

A **Daemon Thread** is a **background thread that runs to support user threads**.

The JVM automatically **terminates daemon threads when all user threads finish execution**.

Examples in JVM:

* Garbage Collector
* Finalizer thread

Daemon threads are used for **background services**.

---

## 2️⃣ Visual Representation

### Thread Types

```
JVM
 |
 |---- User Threads
 |
 |---- Daemon Threads
```

User threads perform main work, daemon threads support them.

---

### JVM Shutdown Rule

```
Program Running
      |
User Threads Exist → JVM continues
      |
All User Threads End
      |
Daemon Threads Automatically Stop
```

---

### Background Support

```
User Thread → Main Task
Daemon Thread → Background Service
```

Example: Garbage collection.

---

## 3️⃣ Key Features / Properties

* Runs in background
* Supports user threads
* Automatically stops when JVM exits
* Lower priority tasks
* Created using `setDaemon(true)`
* Cannot keep JVM alive
* Inherited daemon status from parent thread

---

## 4️⃣ Syntax

Set daemon thread:

```java
thread.setDaemon(true);
```

Check daemon thread:

```java
thread.isDaemon();
```

---

## 5️⃣ Code Example

```java
class MyThread extends Thread {

    public void run() {
        while(true) {
            System.out.println("Daemon thread running");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread t = new MyThread();

        t.setDaemon(true);

        t.start();

        System.out.println("Main thread finished");
    }
}
```

When the main thread ends, JVM stops the daemon thread.

---

## 6️⃣ Use Cases

* Garbage collection
* Background monitoring
* Logging services
* Auto-save features
* Cache cleanup
* Timer tasks

---

## 7️⃣ Pitfalls / Notes

* ❌ Must set daemon **before starting thread**
* ❌ Cannot convert running thread into daemon
* ❌ Daemon threads may terminate abruptly
* ❌ Not suitable for critical tasks
* ❌ JVM does not wait for daemon threads

---

## 8️⃣ Real-World Analogy

🏨 Hotel Cleaning Staff

* Guests = User Threads
* Cleaning Staff = Daemon Threads

When all guests leave the hotel, the staff also stops working.

---

## 9️⃣ Best Practices

* Use daemon threads only for background tasks
* Avoid important operations in daemon threads
* Set daemon status before `start()`
* Handle interruptions carefully
* Use executor services for better thread management

---

## 🔟 Tricky Questions

1. What is daemon thread?
   ➜ Background thread supporting user threads.

2. When does daemon thread terminate?
   ➜ When all user threads finish.

3. Which JVM thread is daemon?
   ➜ Garbage Collector.

4. How to create daemon thread?
   ➜ `setDaemon(true)`.

5. When must daemon be set?
   ➜ Before `start()`.

6. Can daemon thread keep JVM alive?
   ➜ No.

7. How to check daemon status?
   ➜ `isDaemon()`.

8. Can we change daemon status after start()?
   ➜ No.

9. Are daemon threads low priority tasks?
   ➜ Yes.

10. What happens if only daemon threads remain?
    ➜ JVM exits.

11. Does daemon thread finish its task before JVM exits?
    ➜ Not guaranteed.

12. Do daemon threads inherit daemon status?
    ➜ Yes.

13. Can main thread be daemon?
    ➜ No.

14. Is garbage collector daemon thread?
    ➜ Yes.

15. Should critical tasks run in daemon threads?
    ➜ No.

---

## 🧾 Quick Recap / Cheat Sheet

* Daemon thread = Background support thread
* JVM stops them automatically
* Cannot keep JVM alive
* Used for service tasks
* Example: Garbage Collector
* Created using setDaemon(true)
* Must set before start()
* JVM does not wait for daemon threads
* Not suitable for critical tasks
* Inherit daemon status
* Runs alongside user threads
* Terminates when user threads end
* Used for monitoring & cleanup
* Important multithreading concept
* Common interview topic
