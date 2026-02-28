## 1️⃣ Definition

**Exception Hierarchy** in Java is the structured class relationship of all error and exception types under the root class:

```
java.lang.Object
        ↓
    java.lang.Throwable
        ↓
   -----------------------
   |                     |
 java.lang.Error     java.lang.Exception
                          |
                -----------------------
                |                     |
       Checked Exceptions     Unchecked Exceptions
```

It defines how Java classifies runtime problems and how they must be handled.

---

## 2️⃣ Visual Representation

```
Object
  |
  └── Throwable
        |
        ├── Error
        |     ├── VirtualMachineError
        |     ├── StackOverflowError
        |     └── OutOfMemoryError
        |
        └── Exception
              |
              ├── Checked Exceptions
              |     ├── IOException
              |     ├── SQLException
              |     └── ClassNotFoundException
              |
              └── RuntimeException (Unchecked)
                    ├── NullPointerException
                    ├── ArithmeticException
                    ├── ArrayIndexOutOfBoundsException
                    └── IllegalArgumentException
```

---

## 3️⃣ Key Features / Properties

### 1. Root Class → `Throwable`

* Only objects of type `Throwable` can be thrown.
* Provides methods:

  * `getMessage()`
  * `printStackTrace()`
  * `getCause()`

### 2. Two Main Branches

* `Error`
* `Exception`

### 3. Error

* Serious JVM-level issues.
* Not meant to be handled.
* Example: `OutOfMemoryError`

### 4. Exception

* Application-level problems.
* Meant to be handled.

### 5. Checked Exceptions

* Checked at compile time.
* Must be handled using `try-catch` or `throws`.

### 6. Unchecked Exceptions

* Subclass of `RuntimeException`
* Occur at runtime.
* Not mandatory to handle.

---

## 4️⃣ Syntax

### Throwing Exception

```java
throw new ArithmeticException("Error");
```

### Declaring Exception

```java
public void readFile() throws IOException {
}
```

### Handling Exception

```java
try {
    // risky code
} catch (IOException e) {
}
```

---

## 5️⃣ Code Example

```java
class Test {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;   // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Handled");
        }
    }
}
```

Hierarchy Flow Here:

```
ArithmeticException
      ↓
RuntimeException
      ↓
Exception
      ↓
Throwable
      ↓
Object
```

---

## 6️⃣ Use Cases

### Checked Exceptions

* File handling
* Database operations
* Networking

### Unchecked Exceptions

* Programming errors
* Invalid arguments
* Null access

### Error

* JVM crashes
* Memory exhaustion

---

## 7️⃣ Pitfalls / Notes

✔ `Error` should NOT be caught normally.
✔ `RuntimeException` is unchecked.
✔ All checked exceptions must be handled or declared.
✔ Catch order must be from child → parent.

Wrong:

```java
catch (Exception e)
catch (IOException e)  // unreachable
```

Correct:

```java
catch (IOException e)
catch (Exception e)
```

✔ If you catch parent class, child exceptions are also caught.

---

## 8️⃣ Real-World Analogy

Imagine:

```
Problem (Throwable)
   |
   |-- System Failure (Error) → Machine breakdown
   |
   |-- User Mistake (Exception)
           |
           |-- Predictable issue (Checked)
           |-- Careless mistake (Unchecked)
```

* Error → factory explosion
* Checked → Missing file
* Unchecked → Dividing by zero

---

## 9️⃣ Best Practices

✔ Handle specific exceptions first.
✔ Never catch generic `Exception` unnecessarily.
✔ Use custom exceptions when required.
✔ Do not suppress errors silently.
✔ Keep exception hierarchy meaningful when creating custom exceptions.
✔ Prefer unchecked for programming errors.
✔ Use `finally` for cleanup.

---

## 🔟 Tricky Questions (With Answers)

---

### 1. What is the root class of exception hierarchy?

**Answer:** `Throwable`

---

### 2. Can we throw an object that does not extend Throwable?

**Answer:** No. Only objects extending `Throwable` can be thrown.

---

### 3. Is RuntimeException checked or unchecked?

**Answer:** Unchecked.

---

### 4. Is Error checked or unchecked?

**Answer:** Unchecked.

---

### 5. Difference between Error and Exception?

**Answer:**

* Error → JVM problem, not recoverable.
* Exception → Application problem, recoverable.

---

### 6. Are all exceptions checked?

**Answer:** No. RuntimeException and its subclasses are unchecked.

---

### 7. Why is NullPointerException unchecked?

**Answer:** Because it is a programming mistake and should be fixed, not forced to handle.

---

### 8. What happens if child catch block is placed after parent?

**Answer:** Compile-time error – unreachable catch block.

---

### 9. Can we catch Throwable?

**Answer:** Yes, but not recommended because it also catches Errors.

---

### 10. Where does custom exception fit in hierarchy?

```
Object
  ↓
Throwable
  ↓
Exception (or RuntimeException)
  ↓
YourCustomException
```

---

# 🧾 Quick Recap / Cheat Sheet

```
Root → Throwable

Two branches:
   1. Error (Unchecked, JVM level)
   2. Exception
        → Checked
        → RuntimeException (Unchecked)

Checked → Must handle
Unchecked → Not mandatory

Catch Order → Child → Parent

Only Throwable objects can be thrown.
```

---
