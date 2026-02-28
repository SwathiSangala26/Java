## 1️⃣ Definition

**ClassLoader** is a subsystem of the JVM responsible for loading `.class` files into memory and making them available for execution.

The **Class Loading Process** describes the steps JVM follows to bring a class from disk into runtime memory and prepare it for execution.

---

## 2️⃣ Visual Representation

### 🔹 Class Loader Hierarchy (Parent Delegation Model)

```
                Bootstrap ClassLoader
                        ↑
                Extension ClassLoader
                        ↑
                Application ClassLoader
                        ↑
                 User Defined ClassLoader
```

---

### 🔹 Class Loading Process

```
1. Loading
      ↓
2. Linking
      - Verification
      - Preparation
      - Resolution
      ↓
3. Initialization
```

---

## 3️⃣ Key Features / Properties

---

## 🔹 A. Types of ClassLoaders

### 1️⃣ Bootstrap ClassLoader

* Loads core Java classes
* Loads from: `JAVA_HOME/lib`
* Example: `java.lang.*`
* Written in native code (C/C++)
* No parent

---

### 2️⃣ Extension ClassLoader

* Loads classes from extension directory
* Path: `JAVA_HOME/lib/ext`
* Parent: Bootstrap

---

### 3️⃣ Application (System) ClassLoader

* Loads classes from classpath
* Loads user-defined classes
* Parent: Extension

---

### 4️⃣ Custom ClassLoader

* Created by extending `ClassLoader`
* Used in frameworks, servers

---

## 🔹 B. Parent Delegation Model

When a class is requested:

1. Check if already loaded
2. Ask parent to load
3. Parent asks its parent
4. Bootstrap tries first
5. If not found → child loads

### Why?

* Security
* Avoid duplicate loading
* Ensure core classes aren’t overridden

---

## 🔹 C. Class Loading Process

---

### 1️⃣ Loading Phase

* JVM reads `.class` file
* Creates Class object in Method Area
* Loads binary data into memory

Output:

```
Class<?> object created
```

---

### 2️⃣ Linking Phase

#### 🔸 a) Verification

* Ensures bytecode is valid
* Checks:

  * Format
  * Security
  * Stack operations
  * Data types

Prevents:

```
Illegal memory access
Invalid bytecode execution
```

---

#### 🔸 b) Preparation

* Allocates memory for static variables
* Assigns default values

Example:

```java
static int x = 10;
```

During preparation:

```
x = 0   (default value)
```

---

#### 🔸 c) Resolution

* Replaces symbolic references with actual memory addresses
* Converts:

```
Class names → Direct references
```

---

### 3️⃣ Initialization Phase

* Executes static blocks
* Assigns actual values to static variables

Example:

```java
static int x = 10;
```

Now:

```
x = 10
```

Static blocks execute in order.

---

## 4️⃣ Syntax

Example triggering class loading:

```java
Class.forName("Demo");
```

Custom ClassLoader:

```java
class MyLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) {
        // custom loading logic
    }
}
```

---

## 5️⃣ Code Example

```java
class Test {
    static int x = 10;

    static {
        System.out.println("Static Block");
    }

    public static void main(String[] args) {
        System.out.println(x);
    }
}
```

### Execution Flow:

1. Class loaded
2. Linking happens
3. Initialization:

   * static x = 10
   * static block runs
4. main() executes

Output:

```
Static Block
10
```

---

## 6️⃣ Use Cases

* Dynamic class loading
* Plugin systems
* Application servers
* Frameworks (Spring, Hibernate)
* Database drivers loading

---

## 7️⃣ Pitfalls / Notes

* A class is loaded only once per ClassLoader
* Static block runs only once
* Parent delegation prevents overriding core classes
* ClassNotFoundException → class not found during loading
* NoClassDefFoundError → class found at compile time but missing at runtime
* Multiple ClassLoaders can load same class → treated as different classes

---

## 8️⃣ Real-World Analogy

Think of ClassLoader like a **library manager**:

* Bootstrap → Main national library
* Extension → State library
* Application → Local library
* If book not in local → ask state → ask national
* If nowhere → error

---

## 9️⃣ Best Practices

* Do not break Parent Delegation unless necessary
* Use custom ClassLoader carefully
* Avoid duplicate class loading
* Understand difference between compile-time and runtime loading errors
* Use `Class.forName()` carefully (triggers initialization)

---

## 🔟 Tricky Questions (With Answers)

---

### 1️⃣ When does class loading happen?

👉 When class is first actively used:

* Creating object
* Accessing static variable
* Calling static method
* Using Class.forName()

---

### 2️⃣ Difference between ClassNotFoundException and NoClassDefFoundError?

ClassNotFoundException → During loading
NoClassDefFoundError → Loaded earlier but missing during runtime

---

### 3️⃣ During preparation, is static variable assigned real value?

👉 No. Only default value.

---

### 4️⃣ When are static blocks executed?

👉 During Initialization phase.

---

### 5️⃣ Can a class be loaded twice?

👉 Yes, by different ClassLoaders.

---

### 6️⃣ What ensures core Java classes cannot be overridden?

👉 Parent Delegation Model.

---

### 7️⃣ Does Class.forName() trigger initialization?

👉 Yes.

---

### 8️⃣ What is stored in Method Area during loading?

👉 Class metadata, method info, static variables.

---

## 🧾 Quick Recap / Cheat Sheet

```
ClassLoader Types:
    Bootstrap
    Extension
    Application
    Custom

Class Loading Process:
    1. Loading
    2. Linking
        - Verification
        - Preparation
        - Resolution
    3. Initialization
```

Memory During Phases:

```
Preparation → static variables = default value
Initialization → static variables = actual value
```

Errors:

```
ClassNotFoundException
NoClassDefFoundError
```

Parent Delegation:

```
Child → Parent → Bootstrap
```

---
