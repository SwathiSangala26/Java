## 1️⃣ Definition

**JVM (Java Virtual Machine) Architecture** defines the internal structure and working components of the JVM that enable Java programs to execute platform-independent bytecode.

It specifies:

* How bytecode is loaded
* How memory is organized
* How execution happens
* How garbage collection works
* How native code integration happens

It is part of the **JRE** and follows the **Java Virtual Machine Specification**.

---

## 2️⃣ Visual Representation

```
                +------------------------+
                |      Class Loader      |
                +------------------------+
                           |
                           v
                +------------------------+
                |   Method Area (Meta)   |
                +------------------------+
                |        Heap            |
                +------------------------+
                |   Java Stack (Thread)  |
                +------------------------+
                |   PC Register (Thread) |
                +------------------------+
                | Native Method Stack    |
                +------------------------+
                           |
                           v
                +------------------------+
                |  Execution Engine      |
                |  - Interpreter         |
                |  - JIT Compiler        |
                |  - GC                  |
                +------------------------+
                           |
                           v
                +------------------------+
                |    Native Libraries    |
                +------------------------+
```

---

## 3️⃣ Key Features / Properties

### 1. Class Loader Subsystem

* Loads `.class` files into memory
* Performs:

  * Loading
  * Linking (Verification, Preparation, Resolution)
  * Initialization
* Follows Parent Delegation Model

---

### 2. Runtime Data Areas

#### 🔹 Method Area (Shared)

* Stores:

  * Class metadata
  * Static variables
  * Method bytecode
* One per JVM

---

#### 🔹 Heap (Shared)

* Stores objects
* Managed by Garbage Collector
* Largest memory area

---

#### 🔹 Java Stack (Per Thread)

* Stores:

  * Stack frames
  * Local variables
  * Method calls
* Each thread has its own stack

---

#### 🔹 PC Register (Per Thread)

* Holds address of current instruction
* One per thread

---

#### 🔹 Native Method Stack (Per Thread)

* Used for native (C/C++) methods

---

### 3. Execution Engine

#### Interpreter

* Executes bytecode line by line
* Slower

#### JIT (Just-In-Time Compiler)

* Converts frequently used bytecode to native machine code
* Improves performance

#### Garbage Collector

* Removes unused objects from heap
* Automatic memory management

---

### 4. JNI (Java Native Interface)

* Allows Java to call native C/C++ code

---

## 4️⃣ Syntax

There is no direct syntax for JVM architecture, but related keywords:

```java
static
native
synchronized
```

Example of native method declaration:

```java
public native void display();
```

---

## 5️⃣ Code Example

```java
class Demo {
    static int x = 10;

    public static void main(String[] args) {
        int y = 20;
        Demo obj = new Demo();
    }
}
```

### What happens internally?

* `Demo.class` → Loaded into Method Area
* `static x` → Stored in Method Area
* `obj` → Stored in Stack
* Object → Stored in Heap
* `main()` → Stack frame created
* PC Register → Points to current instruction

---

## 6️⃣ Use Cases

* Platform independent execution
* Automatic memory management
* Multithreading support
* Secure execution (bytecode verifier)
* Optimized performance using JIT

---

## 7️⃣ Pitfalls / Notes

* StackOverflowError → Stack memory full
* OutOfMemoryError → Heap memory full
* Static variables are stored in Method Area, not Heap
* Objects are always stored in Heap
* Local variables are stored in Stack
* Each thread has separate stack but shared heap
* Garbage Collector works only on Heap

---

## 8️⃣ Real-World Analogy

Think of JVM like a **factory**:

* Class Loader → Raw material receiver
* Method Area → Blueprint storage room
* Heap → Object warehouse
* Stack → Worker’s personal desk
* Execution Engine → Machine operator
* GC → Cleaning staff
* JNI → Outsourcing department

---

## 9️⃣ Best Practices

* Avoid unnecessary object creation
* Use proper memory management
* Avoid deep recursion (StackOverflow)
* Close resources properly
* Understand heap vs stack difference
* Monitor memory using JVM tools

---

## 🔟 Tricky Questions (With Answers)

### 1️⃣ Where are static variables stored?

👉 Method Area.

---

### 2️⃣ Where are objects stored?

👉 Heap.

---

### 3️⃣ Where are local variables stored?

👉 Stack.

---

### 4️⃣ Is Heap shared between threads?

👉 Yes.

---

### 5️⃣ Is Stack shared between threads?

👉 No. Each thread has its own stack.

---

### 6️⃣ What causes StackOverflowError?

👉 Deep or infinite recursion.

---

### 7️⃣ What causes OutOfMemoryError?

👉 Heap memory exhaustion.

---

### 8️⃣ Does Garbage Collector clean Stack?

👉 No. Only Heap.

---

### 9️⃣ What is stored inside Stack Frame?

👉 Local variables, operand stack, method call data.

---

### 🔟 Difference between Interpreter and JIT?

Interpreter → Line by line execution
JIT → Converts bytecode to native code for faster execution

---

# 🧾 Quick Recap / Cheat Sheet

```
JVM Architecture =
    Class Loader
    Runtime Data Areas
        - Method Area (Shared)
        - Heap (Shared)
        - Stack (Per Thread)
        - PC Register (Per Thread)
        - Native Stack (Per Thread)
    Execution Engine
        - Interpreter
        - JIT
        - GC
    JNI
```

Memory Summary:

```
Heap        → Objects
Stack       → Local variables
Method Area → Class metadata + static variables
PC Register → Current instruction
```

Errors:

```
StackOverflowError → Stack full
OutOfMemoryError   → Heap full
```

---
