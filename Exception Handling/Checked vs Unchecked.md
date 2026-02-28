## 1️⃣ Definition

### ✅ Checked Exceptions

Exceptions that are **checked at compile time**.
The compiler forces you to **handle or declare** them.

They are subclasses of:

```
Exception (but NOT RuntimeException)
```

---

### ✅ Unchecked Exceptions

Exceptions that occur at **runtime**.
The compiler does **NOT force** you to handle them.

They are subclasses of:

```
RuntimeException
```

---

## 2️⃣ Visual Representation

```
Throwable
   |
   └── Exception
         |
         ├── Checked Exceptions
         |     ├── IOException
         |     ├── SQLException
         |     └── ClassNotFoundException
         |
         └── RuntimeException  (Unchecked)
               ├── NullPointerException
               ├── ArithmeticException
               ├── ArrayIndexOutOfBoundsException
               └── IllegalArgumentException
```

---

## 3️⃣ Key Features / Properties

### 🔹 Checked Exceptions

✔ Checked at compile time
✔ Must be handled using `try-catch` OR declared using `throws`
✔ Represent external problems
✔ Compiler ensures safer code

Examples:

* `IOException`
* `SQLException`
* `FileNotFoundException`

---

### 🔹 Unchecked Exceptions

✔ Occur at runtime
✔ Not mandatory to handle
✔ Usually caused by programming mistakes
✔ Subclass of `RuntimeException`

Examples:

* `NullPointerException`
* `ArithmeticException`
* `IndexOutOfBoundsException`

---

## 4️⃣ Syntax

### Checked Exception Example

```java
import java.io.*;

class Test {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("file.txt");
    }
}
```

OR

```java
try {
    FileReader fr = new FileReader("file.txt");
} catch (IOException e) {
    e.printStackTrace();
}
```

---

### Unchecked Exception Example

```java
class Test {
    public static void main(String[] args) {
        int a = 10 / 0;   // ArithmeticException
    }
}
```

No compile-time error.

---

## 5️⃣ Code Example

### Checked → Compile-time error if not handled

```java
import java.io.*;

class Demo {
    public static void main(String[] args) {
        FileReader fr = new FileReader("file.txt"); // Compile-time error
    }
}
```

Compiler says: *Unhandled exception*

---

### Unchecked → Compiles, fails at runtime

```java
class Demo {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s.length()); // NullPointerException
    }
}
```

Compiles successfully.

---

## 6️⃣ Use Cases

### Checked Exceptions

Used when:

* File handling
* Database access
* Networking
* External systems

Reason: External issues are predictable but not controllable.

---

### Unchecked Exceptions

Used when:

* Invalid arguments
* Logic errors
* Programming mistakes

Reason: These should be fixed, not forced to handle.

---

## 7️⃣ Pitfalls / Notes

✔ If a method throws a checked exception, caller must handle or declare.

✔ If you throw a checked exception manually:

```java
throw new Exception(); // Must handle
```

✔ You can create custom checked exception by extending:

```
Exception
```

✔ You can create custom unchecked exception by extending:

```
RuntimeException
```

✔ Overusing checked exceptions makes code cluttered.

✔ Unchecked exceptions propagate automatically.

---

## 8️⃣ Real-World Analogy

```
Checked → Rain forecast
You are warned in advance → You carry umbrella.

Unchecked → Slipping on floor
Happens suddenly due to carelessness.
```

Checked = predictable external condition
Unchecked = your mistake

---

## 9️⃣ Best Practices

✔ Use checked for recoverable conditions.
✔ Use unchecked for programming errors.
✔ Don’t convert every exception into RuntimeException blindly.
✔ Catch specific exceptions, not generic `Exception`.
✔ Keep method signatures clean — avoid too many checked exceptions.

---

## 🔟 Tricky Questions (With Answers)

---

### 1. Are all exceptions checked?

**Answer:** No. Exceptions extending `RuntimeException` are unchecked.

---

### 2. Why does compiler force checked exceptions?

**Answer:** To ensure external recoverable issues are handled properly.

---

### 3. Is NullPointerException checked?

**Answer:** No. It is unchecked.

---

### 4. Can we throw unchecked exceptions manually?

**Answer:** Yes.

```java
throw new RuntimeException("Error");
```

---

### 5. Can main() throw checked exception?

**Answer:** Yes.

```java
public static void main(String[] args) throws IOException
```

---

### 6. Which is better — checked or unchecked?

**Answer:** Depends on scenario.

* Recoverable → Checked
* Programming mistake → Unchecked

---

### 7. What happens if checked exception is not handled?

**Answer:** Compile-time error.

---

### 8. What happens if unchecked exception is not handled?

**Answer:** Program compiles but may crash at runtime.

---

### 9. Can a method declare unchecked exception using throws?

**Answer:** Yes, but not mandatory.

---

### 10. Why are RuntimeExceptions unchecked?

**Answer:** Because they indicate bugs in code and should be fixed rather than enforced handling.

---

# 🧾 Quick Recap / Cheat Sheet

```
Checked
--------
✔ Compile-time
✔ Must handle or declare
✔ External problems
✔ Subclass of Exception

Unchecked
----------
✔ Runtime
✔ No mandatory handling
✔ Programming mistakes
✔ Subclass of RuntimeException
```

---
