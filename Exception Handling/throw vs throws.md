## 1️⃣ Definition

### 🔹 `throw`

Used to **explicitly throw an exception object**.

👉 Used inside method body.

---

### 🔹 `throws`

Used to **declare exceptions** that a method might throw.

👉 Used in method signature.

---

## 2️⃣ Visual Representation

```text
Method Signature Area
----------------------
public void readFile() throws IOException
                         ↑
                      throws


Method Body Area
----------------------
throw new IOException();
 ↑
throw
```

---

### Flow Diagram

```text
Caller
  ↓
Method (declares throws)
  ↓
Inside method → throw exception
  ↓
Caller must handle (if checked)
```

---

## 3️⃣ Key Features / Properties

### 🔹 throw

✔ Used to throw single exception at a time
✔ Followed by object creation
✔ Used inside method
✔ Can throw checked or unchecked
✔ After throw → code becomes unreachable

Syntax structure:

```text
throw new ExceptionType();
```

---

### 🔹 throws

✔ Used in method declaration
✔ Can declare multiple exceptions
✔ Mainly used for checked exceptions
✔ Transfers responsibility to caller

Syntax structure:

```text
returnType methodName() throws ExceptionType
```

---

## 4️⃣ Syntax

### Using `throw`

```java
throw new ArithmeticException("Error");
```

---

### Using `throws`

```java
public void readFile() throws IOException {
}
```

---

### Multiple exceptions with throws

```java
public void test() throws IOException, SQLException {
}
```

---

## 5️⃣ Code Example

### Example 1 — throw

```java
class Demo {
    public static void main(String[] args) {
        throw new ArithmeticException("Invalid");
    }
}
```

Program compiles and crashes at runtime.

---

### Example 2 — throws

```java
import java.io.*;

class Demo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("file.txt");
    }
}
```

Here:

* `throws` declares
* JVM throws actual exception internally

---

### Example 3 — Both Together

```java
class Demo {

    static void checkAge(int age) throws Exception {
        if (age < 18) {
            throw new Exception("Not eligible");
        }
    }

    public static void main(String[] args) throws Exception {
        checkAge(15);
    }
}
```

Flow:

```text
main() → calls checkAge()
checkAge() → throw new Exception()
Exception propagates back to main()
```

---

## 6️⃣ Use Cases

### 🔹 throw

✔ Validating input
✔ Custom exception logic
✔ Business rule enforcement

---

### 🔹 throws

✔ When method cannot handle exception
✔ Passing responsibility upward
✔ Checked exception propagation

---

## 7️⃣ Pitfalls / Notes

### ❗ 1. throw needs object

Correct:

```java
throw new Exception();
```

Wrong:

```java
throw Exception;  // compile error
```

---

### ❗ 2. throws does not throw

It only declares.

This is common interview confusion.

---

### ❗ 3. Only one exception per throw

You cannot write:

```java
throw new IOException(), new SQLException(); // invalid
```

---

### ❗ 4. throw works with unchecked also

```java
throw new NullPointerException();
```

No need for throws.

---

### ❗ 5. After throw, code is unreachable

```java
throw new Exception();
System.out.println("Hello"); // compile error
```

---

## 8️⃣ Real-World Analogy

```text
throw → You actively throw a ball.
throws → You warn someone: "I might throw the ball."
```

* throw = action
* throws = declaration

---

## 9️⃣ Best Practices

✔ Use throw for validation failures
✔ Use throws when caller should decide handling
✔ Don’t blindly declare throws Exception (bad practice)
✔ Prefer specific exceptions
✔ Avoid excessive throws in API design

---

## 🔟 Tricky Questions (With Answers)

---

### 1. What is difference between throw and throws?

**Answer:**

* throw → used to throw exception object
* throws → used to declare exception in method signature

---

### 2. Can we use throw without throws?

**Answer:** Yes, for unchecked exceptions.

---

### 3. Can we use throws without throw?

**Answer:** Yes. Method may not throw explicitly but can declare.

---

### 4. Can throws declare multiple exceptions?

**Answer:** Yes.

```java
throws IOException, SQLException
```

---

### 5. How many exceptions can throw throw at a time?

**Answer:** Only one.

---

### 6. Is throws mandatory for RuntimeException?

**Answer:** No.

---

### 7. What happens if checked exception is thrown but not declared?

**Answer:** Compile-time error.

---

### 8. Can main method use throws?

**Answer:** Yes.

```java
public static void main(String[] args) throws Exception
```

---

### 9. Does throws handle exception?

**Answer:** No. It only declares.

---

### 10. Which keyword is used for custom exception triggering?

**Answer:** throw

---

# 🧾 Quick Recap / Cheat Sheet

```text
throw
------
✔ Used inside method
✔ Throws exception object
✔ Only one at a time
✔ Causes immediate termination

throws
-------
✔ Used in method signature
✔ Declares exception
✔ Can declare multiple
✔ Transfers handling responsibility
```

---
