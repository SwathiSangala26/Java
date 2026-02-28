## 1️⃣ Definition

**Exception Propagation** is the process by which an exception moves from the method where it occurs to the caller method, up the call stack, until it is handled.

If no method handles it → JVM terminates the program.

---

## 2️⃣ Visual Representation

### Call Stack Flow

```text
main()
  ↓
methodA()
  ↓
methodB()
  ↓
methodC()
```

If exception occurs in `methodC()`:

```text
methodC() → no catch
        ↑
methodB() → no catch
        ↑
methodA() → catches
        ↑
main()
```

If no one catches:

```text
methodC → methodB → methodA → main → JVM
Program terminates
```

---

## 3️⃣ Key Features / Properties

✔ Happens automatically
✔ Moves up the call stack
✔ Stops when matching catch block found
✔ Works for both checked & unchecked exceptions
✔ If not handled → default JVM handler executes

---

### Important Concept

Propagation follows **stack unwinding**.

When exception occurs:

* Current method stops execution
* Control transfers to caller
* Stack frames unwind upward

---

## 4️⃣ Syntax

Propagation happens naturally when:

* Exception is not caught
* Or method declares `throws`

Example declaration:

```java
void methodA() throws IOException
```

---

## 5️⃣ Code Example

---

### Example 1 — Unchecked Exception Propagation

```java
class Demo {

    static void methodC() {
        int a = 10 / 0;  // ArithmeticException
    }

    static void methodB() {
        methodC();
    }

    static void methodA() {
        methodB();
    }

    public static void main(String[] args) {
        methodA();
    }
}
```

Flow:

```text
methodC → methodB → methodA → main → JVM
```

No catch → program crashes.

---

### Example 2 — Propagation with Handling

```java
class Demo {

    static void methodC() {
        int a = 10 / 0;
    }

    static void methodB() {
        methodC();
    }

    static void methodA() {
        try {
            methodB();
        } catch (ArithmeticException e) {
            System.out.println("Handled in methodA");
        }
    }

    public static void main(String[] args) {
        methodA();
    }
}
```

Flow:

```text
methodC → methodB → methodA (catch found)
```

Stops at methodA.

---

### Example 3 — Checked Exception Propagation

```java
import java.io.*;

class Demo {

    static void methodB() throws IOException {
        throw new IOException();
    }

    static void methodA() throws IOException {
        methodB();
    }

    public static void main(String[] args) {
        try {
            methodA();
        } catch (IOException e) {
            System.out.println("Handled in main");
        }
    }
}
```

Flow:

```text
methodB → methodA → main → catch
```

---

## 6️⃣ Use Cases

✔ Centralized exception handling
✔ Logging at higher layer
✔ API design (service → controller)
✔ Transaction rollback management

Common real-world pattern:

```text
DAO → Service → Controller
```

Exception propagates upward and handled at controller level.

---

## 7️⃣ Pitfalls / Notes

---

### ❗ 1. Only Unchecked Automatically Propagate

Unchecked → no declaration required
Checked → must use `throws`

---

### ❗ 2. If Exception Caught, Propagation Stops

Once handled → does not go upward (unless rethrown).

---

### ❗ 3. Finally Executes During Propagation

Even if exception propagates, finally executes before moving upward.

---

### ❗ 4. Order of Handling

Nearest catch in call stack handles first.

---

### ❗ 5. Rethrow Causes Further Propagation

```java
catch (Exception e) {
    throw e;
}
```

Propagation continues upward.

---

## 8️⃣ Real-World Analogy

```text
Office hierarchy:

Employee → Team Lead → Manager → Director → CEO
```

If employee has issue:

* If Team Lead resolves → stops
* Else escalates upward
* If CEO cannot resolve → company issue

That is propagation.

---

## 9️⃣ Best Practices

✔ Handle exception at appropriate layer
✔ Avoid swallowing exceptions
✔ Log before rethrowing
✔ Do not catch too early unnecessarily
✔ Use meaningful exception chaining

---

## 🔟 Tricky Questions (With Answers)

---

### 1. What is exception propagation?

**Answer:** Movement of exception up the call stack until handled.

---

### 2. How does propagation occur?

**Answer:** Through stack unwinding.

---

### 3. Does propagation happen for checked exceptions?

**Answer:** Yes, but must declare using `throws`.

---

### 4. What happens if no method handles exception?

**Answer:** JVM default handler prints stack trace and terminates program.

---

### 5. Does finally execute during propagation?

**Answer:** Yes.

---

### 6. What is stack unwinding?

**Answer:** Removal of method calls from stack until matching catch found.

---

### 7. Can we stop propagation?

**Answer:** Yes, by catching the exception.

---

### 8. What if we catch and rethrow?

**Answer:** Propagation continues upward.

---

### 9. In which direction does propagation move?

**Answer:** Bottom → Top of call stack.

---

### 10. Does propagation work for RuntimeException?

**Answer:** Yes, automatically.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Exception Propagation

✔ Exception moves up call stack
✔ Stops when matching catch found
✔ Checked → requires throws
✔ Unchecked → automatic
✔ If not handled → JVM terminates
✔ Happens via stack unwinding
```

---
