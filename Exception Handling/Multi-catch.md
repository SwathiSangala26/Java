## 1️⃣ Definition

**Multi-catch** allows handling **multiple exception types in a single catch block**.

Introduced in:

```text
Java 7
```

It reduces duplicate catch blocks when handling logic is same.

---

## 2️⃣ Visual Representation

### Before Java 7 (Multiple Catch Blocks)

```text
try
  ↓
Exception?
  ↓
catch A
catch B
catch C
```

---

### With Multi-catch

```text
try
  ↓
Exception?
  ↓
catch (A | B | C)
```

Single handling block.

---

## 3️⃣ Key Features / Properties

✔ Introduced in Java 7
✔ Use pipe symbol `|`
✔ Works only in catch block
✔ All exceptions share same handling logic
✔ Exception variable becomes **implicitly final**
✔ Cannot combine parent and child together

---

## 4️⃣ Syntax

```java
try {
    // risky code
} catch (ExceptionType1 | ExceptionType2 e) {
    // common handling
}
```

---

## 5️⃣ Code Example

---

### Example 1 — Basic Multi-catch

```java
class Demo {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[10] = 50;   // ArrayIndexOutOfBoundsException
            int x = 10 / 0; // ArithmeticException
        } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception occurred");
        }
    }
}
```

Both exceptions handled by same block.

---

### Example 2 — With Checked Exceptions

```java
import java.io.*;
import java.sql.*;

class Demo {
    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (IOException | SQLException e) {
            System.out.println("Handled");
        }
    }
}
```

---

## 6️⃣ Use Cases

✔ When multiple exceptions need same handling
✔ Logging errors
✔ Wrapping into custom exception
✔ Reducing repetitive code
✔ Cleaner try-catch structure

---

## 7️⃣ Pitfalls / Notes

---

### ❗ 1. Cannot Combine Parent & Child

Invalid:

```java
catch (Exception | IOException e)  // compile-time error
```

Reason:

* IOException is subclass of Exception
* Redundant / unreachable

---

### ❗ 2. Exception Variable is Implicitly Final

```java
catch (IOException | SQLException e) {
    e = new IOException();  // compile-time error
}
```

You cannot reassign `e`.

---

### ❗ 3. Only Works for Same Handling Logic

If handling differs → use separate catch blocks.

---

### ❗ 4. Order Does Not Matter Inside Multi-catch

```java
catch (IOException | SQLException e)
```

No child-parent relationship allowed.

---

### ❗ 5. After Multi-catch, You Can Still Add General Catch

```java
try {
} catch (IOException | SQLException e) {
} catch (Exception e) {
}
```

This is valid.

---

## 8️⃣ Real-World Analogy

```text
Security guard at gate

If issue is:
- No ID
- Wrong ID
- Expired ID

All → Deny entry

One rule handles multiple problems.
```

Same handling → single block.

---

## 9️⃣ Best Practices

✔ Use when handling logic is identical
✔ Do not combine unrelated exceptions unnecessarily
✔ Avoid mixing parent-child
✔ Keep multi-catch clean and readable
✔ Add general catch at end if needed

---

## 🔟 Tricky Questions (With Answers)

---

### 1. When was Multi-catch introduced?

**Answer:** Java 7

---

### 2. Which symbol is used?

**Answer:** `|` (pipe operator)

---

### 3. Can we combine parent and child exception?

**Answer:** No. Compile-time error.

---

### 4. Is exception variable modifiable?

**Answer:** No. It is implicitly final.

---

### 5. Can we declare multiple multi-catch blocks?

**Answer:** Yes.

---

### 6. Can multi-catch handle checked exceptions?

**Answer:** Yes.

---

### 7. What happens if handling logic differs?

**Answer:** Use separate catch blocks.

---

### 8. Is this valid?

```java
catch (ArithmeticException | RuntimeException e)
```

**Answer:** No. ArithmeticException is subclass of RuntimeException.

---

### 9. Does multi-catch reduce performance?

**Answer:** No. It is only compile-time syntactic improvement.

---

### 10. Can we rethrow inside multi-catch?

**Answer:** Yes.

```java
catch (IOException | SQLException e) {
    throw e;
}
```

---

# 🧾 Quick Recap / Cheat Sheet

```text
Multi-catch (Java 7)

✔ catch (A | B | C e)
✔ Pipe symbol |
✔ Same handling logic
✔ Cannot mix parent-child
✔ Exception variable is implicitly final
✔ Cleaner than multiple catch blocks
```

---
