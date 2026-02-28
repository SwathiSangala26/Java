# 1️⃣ Definition

Thread creation is the process of defining and starting a new independent path of execution in a Java program.

In Java, a thread can be created in **two standard ways**:

1. By extending the `Thread` class
2. By implementing the `Runnable` interface

---

# 2️⃣ Visual Representation

### 🔹 Method 1: Extending Thread

```
Class MyThread
        |
        v
extends Thread
        |
        v
Override run()
        |
        v
Call start()
        |
        v
New Thread Executes run()
```

---

### 🔹 Method 2: Implementing Runnable

```
Class MyTask
        |
        v
implements Runnable
        |
        v
Override run()
        |
        v
Pass object to Thread
        |
        v
Call start()
        |
        v
New Thread Executes run()
```

---

# 3️⃣ Key Features / Properties

## 🔹 Method 1: Extending Thread

* Inherits from `Thread` class
* Must override `run()` method
* Cannot extend another class (single inheritance limitation)
* Direct access to thread methods

---

## 🔹 Method 2: Implementing Runnable

* Implements `Runnable` interface
* Must override `run()` method
* Can extend another class
* Better design (separates task from thread)
* Recommended approach in interviews

---

# 4️⃣ Syntax

---

## 🔹 1. Extending Thread

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

MyThread t = new MyThread();
t.start();
```

---

## 🔹 2. Implementing Runnable

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }
}

Thread t = new Thread(new MyTask());
t.start();
```

---

# 5️⃣ Code Example

## 🔹 Example 1: Extending Thread

```java
class MyThread extends Thread {

    public void run() {
        System.out.println("Executing Thread class method");
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
```

---

## 🔹 Example 2: Implementing Runnable

```java
class MyTask implements Runnable {

    public void run() {
        System.out.println("Executing Runnable interface method");
    }

    public static void main(String[] args) {
        Thread t = new Thread(new MyTask());
        t.start();
    }
}
```

---

# 6️⃣ Use Cases

| Approach     | When to Use                              |
| ------------ | ---------------------------------------- |
| Thread class | Simple testing / learning                |
| Runnable     | Real-world applications                  |
| Runnable     | When class already extends another class |
| Runnable     | Better object-oriented design            |

---

# 7️⃣ Pitfalls / Notes

⚠️ Calling `run()` directly does NOT create a new thread
⚠️ Must call `start()` to create new thread
⚠️ Java does NOT support multiple inheritance → extending Thread blocks other inheritance
⚠️ Runnable does not have `start()` method
⚠️ `run()` contains thread logic only
⚠️ Thread class implements Runnable internally

---

# 8️⃣ Real-World Analogy

Think of:

* **Runnable** = The task (like a cooking recipe)
* **Thread** = The cook executing that recipe

You can give the same recipe (Runnable) to multiple cooks (Thread objects).

Better separation. Better design.

---

# 9️⃣ Best Practices

✔ Prefer Runnable over Thread class
✔ Use lambda expression for simple tasks
✔ Keep thread logic small
✔ Avoid heavy logic inside constructor
✔ Name threads for debugging

Example with Lambda:

```java
Thread t = new Thread(() -> {
    System.out.println("Lambda Thread");
});
t.start();
```

---

# 🔥 Tricky Interview Questions (With Answers)

---

### 1️⃣ What happens if you call run() instead of start()?

**Answer:**
It executes like a normal method call in the same thread. No new thread is created.

---

### 2️⃣ Can we extend Thread and implement Runnable together?

**Answer:**
Yes technically, but unnecessary. Thread already implements Runnable.

---

### 3️⃣ Which is better: Thread or Runnable?

**Answer:**
Runnable is better because:

* Supports multiple inheritance
* Separates task from thread
* More flexible

---

### 4️⃣ Why is Runnable preferred in real applications?

**Answer:**
Because it promotes loose coupling and better object-oriented design.

---

### 5️⃣ Can a single Runnable object be used by multiple threads?

**Answer:**
Yes. Multiple Thread objects can share the same Runnable instance.

---

### 6️⃣ Does extending Thread create multiple threads automatically?

**Answer:**
No. Each object requires calling `start()`.

---

### 7️⃣ What is the return type of run() method?

**Answer:**
`void`

---

### 8️⃣ Can run() throw checked exception?

**Answer:**
No. It cannot declare checked exceptions.

---

### 9️⃣ Is Thread a functional interface?

**Answer:**
No. Runnable is a functional interface.

---

### 🔟 Where is actual thread created?

**Answer:**
Inside `start()` method (native method handled by JVM).

---

# 🧾 Quick Recap / Cheat Sheet

```
Two Ways to Create Thread:

1) extends Thread
   → override run()
   → call start()

2) implements Runnable
   → override run()
   → pass object to Thread
   → call start()

Important:
run() ≠ start()
Runnable preferred in interviews
Thread implements Runnable
```

---
