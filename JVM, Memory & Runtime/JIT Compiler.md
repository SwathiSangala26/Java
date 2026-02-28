## 1️⃣ Definition

The **JIT (Just-In-Time) Compiler** is a part of the JVM Execution Engine that converts frequently executed bytecode into native machine code at runtime.

Instead of interpreting bytecode line by line every time, JIT compiles “hot” code once and reuses it for faster execution.

---

## 2️⃣ Visual Representation

```text id="jit1"
          Java Source Code
                 ↓
            Bytecode (.class)
                 ↓
          Execution Engine
         --------------------
         |   Interpreter     |
         |        ↓          |
         |   Hot Code Found  |
         |        ↓          |
         |   JIT Compiler    |
         --------------------
                 ↓
         Native Machine Code
                 ↓
                CPU
```

---

## 3️⃣ Key Features / Properties

* Part of Execution Engine
* Works at runtime
* Compiles only frequently used methods (HotSpot)
* Stores compiled code in Code Cache
* Improves performance significantly
* Reduces repeated interpretation

---

### 🔹 How JIT Works

```text id="jit2"
Step 1: Bytecode executed by Interpreter
Step 2: JVM detects frequently used method (Hot method)
Step 3: JIT compiles method into native code
Step 4: Native code stored in cache
Step 5: Future calls use compiled native code
```

---

### 🔹 Types of JIT Compilers (HotSpot JVM)

1️⃣ C1 Compiler (Client Compiler)

* Faster compilation
* Less optimization

2️⃣ C2 Compiler (Server Compiler)

* Slower compilation
* Highly optimized code

3️⃣ Tiered Compilation

* Combines C1 + C2
* Default in modern JVM

---

## 4️⃣ Syntax

No direct syntax.

Triggered automatically when:

```java id="jit3"
Method is called repeatedly
Loops run frequently
Heavy computation occurs
```

---

## 5️⃣ Code Example

```java id="jit4"
class Test {
    public static void main(String[] args) {
        for(int i = 0; i < 100000; i++) {
            calculate();
        }
    }

    static void calculate() {
        int a = 10;
        int b = 20;
        int c = a + b;
    }
}
```

Execution:

```text id="jit5"
Initially → Interpreter runs calculate()
After many calls → JIT compiles calculate()
Later → Native code runs directly (faster)
```

---

## 6️⃣ Use Cases

* High-performance applications
* Server-side systems
* Long-running applications
* Microservices
* Financial systems
* Enterprise applications

---

## 7️⃣ Pitfalls / Notes

* First execution may be slower (warm-up phase)
* JIT increases startup time slightly
* More memory usage (Code Cache)
* Small programs may not benefit much
* Aggressive optimization can sometimes change timing behavior

Important:

```text id="jit6"
JIT compiles methods, not entire program at once.
```

---

## 8️⃣ Real-World Analogy

Interpreter → Reading instructions every time from a book.

JIT → Memorizing frequently used instructions and performing them instantly.

Or:

Interpreter → Typing same message manually every time.
JIT → Creating a shortcut macro for it.

---

## 9️⃣ Best Practices

* Warm up application before benchmarking
* Avoid premature optimization
* Use proper JVM flags in production
* Monitor Code Cache size
* Let JVM optimize automatically

---

# 🔟 Tricky Interview Questions (With Answers)

---

### 1️⃣ What is JIT Compiler?

👉 A runtime compiler that converts frequently executed bytecode into native machine code.

---

### 2️⃣ Does JIT compile entire program at once?

👉 No. Only frequently used methods (hot methods).

---

### 3️⃣ Why is Java slower at startup but faster later?

👉 Because JIT compiles hot code during runtime (warm-up time).

---

### 4️⃣ What is HotSpot JVM?

👉 JVM implementation that detects hot methods and compiles them using JIT.

---

### 5️⃣ Difference between Interpreter and JIT?

Interpreter → Executes line by line
JIT → Compiles method into native code

---

### 6️⃣ Where is compiled native code stored?

👉 In Code Cache memory area.

---

### 7️⃣ Is JIT compile-time or runtime?

👉 Runtime.

---

### 8️⃣ Does JIT remove bytecode?

👉 No. Bytecode remains. Native code is additionally stored.

---

### 9️⃣ What is Tiered Compilation?

👉 Combination of C1 and C2 compilers for balanced performance.

---

### 🔟 Why long-running apps benefit most from JIT?

👉 Because frequently used code gets optimized and reused.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="jit7"
JIT = Just-In-Time Compiler
Part of Execution Engine
Compiles hot methods at runtime
Stores native code in cache
Improves performance
```

Flow:

```text id="jit8"
Bytecode → Interpreter → Hot Method → JIT → Native Code
```

Important Points:

```text id="jit9"
✔ Runtime compilation
✔ Faster repeated execution
✔ Startup warm-up required
✔ Used in HotSpot JVM
```

---
