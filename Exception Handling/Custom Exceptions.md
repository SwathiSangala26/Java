## 1️⃣ Definition

A **Custom Exception** is a user-defined exception class created by extending:

```text
Exception           → for Checked Exception
RuntimeException    → for Unchecked Exception
```

Used to represent **application-specific errors**.

---

## 2️⃣ Visual Representation

```text
Object
  ↓
Throwable
  ↓
Exception
  ↓
-------------------------
|                       |
Checked Custom     Unchecked Custom
(extends Exception) (extends RuntimeException)
```

---

### Example Hierarchy

```text
Throwable
   ↓
Exception
   ↓
MyCheckedException

Throwable
   ↓
RuntimeException
   ↓
MyUncheckedException
```

---

## 3️⃣ Key Features / Properties

✔ Must extend `Exception` or `RuntimeException`
✔ Can define custom constructors
✔ Can add custom fields & methods
✔ Helps in meaningful error handling
✔ Improves readability and debugging

---

### Types of Custom Exceptions

| Type      | Extend             | Mandatory Handling? |
| --------- | ------------------ | ------------------- |
| Checked   | `Exception`        | Yes                 |
| Unchecked | `RuntimeException` | No                  |

---

## 4️⃣ Syntax

### 1️⃣ Custom Checked Exception

```java
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
```

---

### 2️⃣ Custom Unchecked Exception

```java
class MyRuntimeException extends RuntimeException {
    public MyRuntimeException(String message) {
        super(message);
    }
}
```

---

## 5️⃣ Code Example

---

### Example 1 — Custom Checked Exception

```java
class AgeNotValidException extends Exception {
    public AgeNotValidException(String message) {
        super(message);
    }
}

class Demo {

    static void checkAge(int age) throws AgeNotValidException {
        if (age < 18) {
            throw new AgeNotValidException("Age must be 18+");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (AgeNotValidException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

Flow:

```text
checkAge() → throw AgeNotValidException
main() → catches it
```

---

### Example 2 — Custom Unchecked Exception

```java
class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class Demo {
    static void withdraw(int amount) {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid amount");
        }
    }

    public static void main(String[] args) {
        withdraw(-100);
    }
}
```

No need for `throws` or try-catch.

---

## 6️⃣ Use Cases

✔ Business rule validation
✔ Domain-specific errors
✔ Banking system errors
✔ E-commerce order validation
✔ Authentication failures

Example scenarios:

* InsufficientBalanceException
* InvalidOrderException
* UserNotFoundException

---

## 7️⃣ Pitfalls / Notes

### ❗ 1. Always call super(message)

Correct:

```java
super(message);
```

Otherwise message won't propagate.

---

### ❗ 2. Choose correct parent

* Recoverable → extend `Exception`
* Programming error → extend `RuntimeException`

---

### ❗ 3. Don't overcreate exceptions

Too many custom exceptions make system complex.

---

### ❗ 4. Checked custom exception must be handled

```java
static void test() throws MyException
```

Otherwise compile-time error.

---

### ❗ 5. You can add extra fields

```java
class ErrorCodeException extends Exception {
    private int errorCode;

    public ErrorCodeException(String message, int code) {
        super(message);
        this.errorCode = code;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
```

---

## 8️⃣ Real-World Analogy

```text
Hospital System

General problem → Exception
Specific diagnosis → Custom Exception

Example:
Exception → "Health issue"
Custom → "HighBloodPressureException"
```

Instead of generic problem, you give specific reason.

---

## 9️⃣ Best Practices

✔ Name ends with "Exception"
✔ Extend correct superclass
✔ Provide constructors with message
✔ Keep exception lightweight
✔ Use meaningful messages
✔ Avoid using checked for every validation
✔ Prefer unchecked for programming errors

---

## 🔟 Tricky Questions (With Answers)

---

### 1. How do you create custom exception?

**Answer:** Extend `Exception` or `RuntimeException`.

---

### 2. Difference between custom checked and unchecked?

**Answer:**

* Checked → must handle or declare
* Unchecked → not mandatory

---

### 3. Why call super(message)?

**Answer:** To pass message to parent `Throwable` class.

---

### 4. Can custom exception have methods?

**Answer:** Yes.

---

### 5. Can we override toString()?

**Answer:** Yes, to customize error output.

---

### 6. Can we create custom exception without constructor?

**Answer:** Yes, but not recommended.

---

### 7. When should we extend RuntimeException?

**Answer:** When exception is caused by programming error or invalid usage.

---

### 8. Can custom exception be abstract?

**Answer:** Yes.

---

### 9. Where does custom exception fit in hierarchy?

```text
Throwable
   ↓
Exception or RuntimeException
   ↓
YourCustomException
```

---

### 10. Is it good to declare throws Exception?

**Answer:** No. Use specific exception types.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Custom Exception = User-defined exception

Checked  → extends Exception → must handle
Unchecked → extends RuntimeException → no mandatory handling

Best Practice:
✔ Call super(message)
✔ Use meaningful names
✔ Extend correct parent
✔ Keep lightweight
```

---
