## 1️⃣ `throw` KEYWORD (STARTING POINT)

### What `throw` does

* `throw` is used to **explicitly create and throw an exception**
* It is an **executable statement**
* Once executed:

  * Current method **stops immediately**
  * Remaining statements **do NOT execute**
  * Control goes to the **caller**

---

### Where `throw` is allowed

* Inside a method
* Inside a constructor
* Inside static / instance initializer blocks

❌ Not allowed outside executable code

---

### Syntax

```java
throw new ExceptionType("message");
```

---

## 2️⃣ `throw` with **UNCHECKED EXCEPTION**

### Method

```java
void vote(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Not eligible to vote");
    }
    System.out.println("Eligible to vote");
}
```

---

### Case 1: Caller does **NOT** handle

```java
public static void main(String[] args) {
    vote(16);
    System.out.println("After vote");
}
```

**Compile time**

* ✅ Compiles successfully
* No `throws`
* No `try-catch`

**Runtime**

* Exception thrown
* Goes to caller
* No handler found
* JVM terminates program

**Output**

```
Exception in thread "main" java.lang.IllegalArgumentException: Not eligible to vote
```

➡️ `"Eligible to vote"` → ❌ NOT executed
➡️ `"After vote"` → ❌ NOT executed

---

### Case 2: Caller **handles** using try-catch

```java
public static void main(String[] args) {
    try {
        vote(16);
        System.out.println("After vote");
    } catch (IllegalArgumentException e) {
        System.out.println("Handled in caller: " + e.getMessage());
    }
}
```

**Runtime**

* Exception caught in caller
* Program continues

**Output**

```
Handled in caller: Not eligible to vote
```

➡️ Code after `catch` → ✅ executes

---

### Case 3: No exception scenario

```java
public static void main(String[] args) {
    vote(20);
    System.out.println("After vote");
}
```

**Output**

```
Eligible to vote
After vote
```

---

### Key Rules — `throw` + unchecked

* Compiler does **NOT** force handling
* `throws` is **NOT required**
* try-catch is **OPTIONAL**
* Exception propagates automatically at runtime

---

## 3️⃣ `throw` with **CHECKED EXCEPTION**

### Method

```java
import java.io.IOException;

void readFile() throws IOException {
    throw new IOException("File not found");
}
```

---

### Case 1: Caller does NOT handle and does NOT declare

```java
public static void main(String[] args) {
    readFile();   // ❌
}
```

**Compile-time error**

```
Unhandled exception: IOException
```

➡️ Compiler **blocks execution**

---

### Case 2: Caller **handles** using try-catch

```java
public static void main(String[] args) {
    try {
        readFile();
        System.out.println("After readFile");
    } catch (IOException e) {
        System.out.println("Handled in caller: " + e.getMessage());
    }
}
```

**Runtime**

* Exception thrown
* Caught in caller
* Program continues

**Output**

```
Handled in caller: File not found
```

➡️ `"After readFile"` → ❌ NOT executed

---

### Case 3: Caller **declares `throws` again**

```java
public static void main(String[] args) throws IOException {
    readFile();
    System.out.println("After readFile");
}
```

**Compile time**

* ✅ Allowed

**Runtime**

* Exception thrown
* No handler found
* JVM terminates program

**Output**

```
Exception in thread "main" java.io.IOException: File not found
```

---

### Key Rules — `throw` + checked

* Checked exception **MUST** be:

  * handled using `try-catch`, OR
  * declared using `throws`
* Compiler **forces** this rule

---

## 4️⃣ `throws` KEYWORD

### What `throws` does

* `throws` is used to **declare that a method does NOT handle an exception**
* It **passes responsibility to the caller**
* It does **NOT throw** the exception

---

### Where `throws` is used

* In the **method signature only**

---

### Syntax

```java
returnType methodName() throws ExceptionType
```

---

## 5️⃣ `throws` with **UNCHECKED EXCEPTION**

### Method

```java
void divide(int a, int b) throws ArithmeticException {
    System.out.println(a / b);
}
```

---

### Case 1: Caller does NOT handle

```java
public static void main(String[] args) {
    divide(10, 0);
}
```

**Compile time**

* ✅ Allowed

**Runtime**

* Exception thrown
* No handler
* JVM terminates program

---

### Case 2: Caller handles using try-catch

```java
public static void main(String[] args) {
    try {
        divide(10, 0);
    } catch (ArithmeticException e) {
        System.out.println("Handled divide error");
    }
}
```

---

### Key Rules — `throws` + unchecked

* `throws` is **OPTIONAL**
* Compiler does **NOT** enforce it
* Does **NOT** change runtime behavior
* Mostly used for documentation

---

## 6️⃣ `throws` with **CHECKED EXCEPTION**

### Method

```java
import java.io.IOException;

void loadData() throws IOException {
    throw new IOException("Disk error");
}
```

---

### Case 1: Caller does NOT handle

```java
public static void main(String[] args) {
    loadData();   // ❌
}
```

**Compile-time error**

```
Unhandled exception: IOException
```

---

### Case 2: Caller handles using try-catch

```java
public static void main(String[] args) {
    try {
        loadData();
    } catch (IOException e) {
        System.out.println("Handled load error");
    }
}
```

---

### Case 3: Caller declares `throws` again

```java
public static void main(String[] args) throws IOException {
    loadData();
}
```

**Runtime**

* Exception thrown
* JVM terminates program

---

### Key Rules — `throws` + checked

* `throws` is **MANDATORY**
* Caller must:

  * handle, OR
  * re-declare
* Compiler enforces rule

---

## 7️⃣ MOST IMPORTANT CLARIFICATION (CORE CONCEPT)

> **Both checked and unchecked exceptions propagate to the caller.**

### Difference:

* **Unchecked** → compiler allows propagation automatically
* **Checked** → compiler blocks propagation unless `throws` or `try-catch` is used

---

## 8️⃣ FINAL COMPARISON TABLE (WRITE THIS)

| Case                 | Compiler Forces Handling | try-catch Required | throws Required |
| -------------------- | ------------------------ | ------------------ | --------------- |
| `throw` + unchecked  | ❌ No                     | ❌ No               | ❌ No            |
| `throw` + checked    | ✅ Yes                    | ✅ OR               | ✅ Yes           |
| `throws` + unchecked | ❌ No                     | ❌ No               | ❌ Optional      |
| `throws` + checked   | ✅ Yes                    | ✅ OR               | ✅ Yes           |

---

## 9️⃣ EXAM / INTERVIEW ONE-LINERS ⭐

* `throw` stops execution immediately
* `throws` transfers responsibility to caller
* Throwing is not handling
* Checked exceptions need compiler permission
* Unchecked exceptions fail at runtime

---

## 🔟 MEMORY RULES 🧠

* **throw → stop now**
* **throws → handle later**
* **Unchecked → JVM decides**
* **Checked → compiler decides**
