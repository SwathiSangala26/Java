# 1️⃣ Definition

**JVM Tuning** is the process of adjusting JVM memory and garbage collection settings to improve application performance, stability, and resource usage.

Goal:

```text
✔ Reduce GC pauses
✔ Prevent OutOfMemoryError
✔ Improve throughput
✔ Optimize response time
```

---

# 2️⃣ Visual Representation

```text
                Application
                     ↓
                JVM Settings
        --------------------------------
        | Heap Size (-Xms, -Xmx)       |
        | GC Algorithm                 |
        | Stack Size (-Xss)            |
        | Metaspace Size               |
        --------------------------------
                     ↓
                Performance
```

---

# 3️⃣ Key Features / Properties

JVM tuning mainly focuses on:

1️⃣ Heap Size
2️⃣ Garbage Collector Selection
3️⃣ Stack Size
4️⃣ Metaspace Size
5️⃣ GC Logging & Monitoring

---

# 🔹 1️⃣ Heap Size Tuning

Heap memory is controlled using:

```bash
-Xms  → Initial Heap Size
-Xmx  → Maximum Heap Size
```

Example:

```bash
-Xms512m -Xmx2g
```

Best Practice:

```text
Set Xms = Xmx in production (avoids resizing overhead)
```

---

# 🔹 2️⃣ Stack Size Tuning

Each thread has its own stack.

```bash
-Xss512k
```

If too small → StackOverflowError
If too large → Fewer threads can be created

---

# 🔹 3️⃣ Metaspace Tuning (Java 8+)

```bash
-XX:MaxMetaspaceSize=256m
```

Used when:

* Too many classes
* Dynamic class loading

---

# 🔹 4️⃣ Garbage Collector Selection

Common GC options:

```bash
-XX:+UseSerialGC
-XX:+UseParallelGC
-XX:+UseG1GC
```

Most common in modern systems:

```text
G1GC (default in modern JVMs)
```

---

# 🔹 5️⃣ GC Logging

Enable GC logs for analysis:

```bash
-Xlog:gc
```

Used to:

* Analyze GC frequency
* Detect memory pressure
* Identify long pauses

---

# 4️⃣ Syntax (Common JVM Flags)

```bash
java -Xms1g -Xmx1g -Xss512k -XX:+UseG1GC MyApp
```

---

# 5️⃣ Code Example (Memory Pressure Example)

```java
import java.util.*;

public class Demo {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        while(true) {
            list.add(new byte[1024 * 1024]); // 1MB objects
        }
    }
}
```

If heap too small:

```text
java.lang.OutOfMemoryError: Java heap space
```

Fix:

Increase heap size:

```bash
-Xmx2g
```

---

# 6️⃣ Use Cases

* High-traffic web applications
* Microservices
* Financial systems
* Batch processing systems
* Long-running server applications

---

# 7️⃣ Pitfalls / Notes

* Increasing heap blindly is bad practice
* Large heap → Longer GC pauses
* Too many threads → Native memory issue
* GC tuning depends on workload
* Memory leak ≠ tuning problem
* Always analyze before tuning

Important:

```text
Tuning without monitoring = Guessing
```

---

# 8️⃣ Real-World Analogy

Think of JVM like a warehouse:

Heap size → Warehouse size
GC → Cleaning staff
Stack size → Desk space per worker

Too small warehouse → No storage
Too large warehouse → Cleaning takes longer

Balance is key.

---

# 9️⃣ Best Practices

✔ Set Xms = Xmx in production
✔ Use G1GC for most modern apps
✔ Avoid unnecessary object creation
✔ Monitor GC logs
✔ Use profiling tools
✔ Fix memory leaks before increasing heap
✔ Limit thread count
✔ Test under real load

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ What is -Xms?

👉 Initial heap size.

---

### 2️⃣ What is -Xmx?

👉 Maximum heap size.

---

### 3️⃣ Why set Xms = Xmx?

👉 Avoid dynamic resizing overhead.

---

### 4️⃣ What is -Xss?

👉 Stack size per thread.

---

### 5️⃣ Can increasing heap always fix OOME?

👉 No. Memory leak must be fixed first.

---

### 6️⃣ Which GC is commonly used today?

👉 G1GC.

---

### 7️⃣ What happens if heap is too large?

👉 Longer GC pauses.

---

### 8️⃣ What causes "Unable to create new native thread"?

👉 Too many threads / native memory exhaustion.

---

### 9️⃣ How to analyze GC behavior?

👉 Enable GC logs.

---

### 🔟 Is JVM tuning same for all applications?

👉 No. Depends on workload and traffic pattern.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Heap → -Xms / -Xmx
Stack → -Xss
Metaspace → -XX:MaxMetaspaceSize
GC Type → -XX:+UseG1GC
```

Golden Rules:

```text
✔ Balance heap size
✔ Monitor before tuning
✔ Fix leaks first
✔ Avoid excessive threads
```

---
