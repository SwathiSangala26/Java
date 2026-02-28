## 1️⃣ Definition

`try–catch–finally` is a mechanism used to:

* Handle exceptions
* Prevent abnormal program termination
* Ensure cleanup code always executes

Structure:

```text
try → risky code
catch → handle exception
finally → always executes (cleanup)
```

---

## 2️⃣ Visual Representation

### Flow Without Exception

```text
Start
  ↓
try block
  ↓
(no exception)
  ↓
finally block
  ↓
Program continues
```

---

### Flow With Exception (Handled)

```text
Start
  ↓
try block
  ↓
Exception occurs
  ↓
matching catch block
  ↓
finally block
  ↓
Program continues
```

---

### Flow With Exception (Not Handled)

```text
Start
  ↓
try block
  ↓
Exception occurs
  ↓
No matching catch
  ↓
finally block
  ↓
Program terminates
```

---

## 3️⃣ Key Features / Properties

### 🔹 try Block

* Contains risky code
* Must be followed by either:

  * `catch`
  * `finally`
  * or both

---

### 🔹 catch Block

* Handles specific exception
* Multiple catch blocks allowed
* Order: child → parent

---

### 🔹 finally Block

✔ Always executes
✔ Used for cleanup
✔ Executes even if:

* return statement is present
* exception occurs
* catch block executes

❗ Does NOT execute only if:

* JVM crashes
* System.exit() is called

---

## 4️⃣ Syntax

### Basic Syntax

```java
try {
    // risky code
} catch (ExceptionType e) {
    // handling
} finally {
    // cleanup
}
```

---

### Multiple Catch

```java
try {
    // risky code
} catch (ArithmeticException e) {
    // handle arithmetic
} catch (Exception e) {
    // handle general
}
```

---

## 5️⃣ Code Example

### Example 1: Normal Execution

```java
class Demo {
    public static void main(String[] args) {
        try {
            System.out.println("Inside try");
        } catch (Exception e) {
            System.out.println("Inside catch");
        } finally {
            System.out.println("Inside finally");
        }
    }
}
```

Output:

```
Inside try
Inside finally
```

---

### Example 2: Exception Occurs

```java
class Demo {
    public static void main(String[] args) {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Handled");
        } finally {
            System.out.println("Cleanup");
        }
    }
}
```

Output:

```
Handled
Cleanup
```

---

### Example 3: Return in try

```java
class Demo {
    static int test() {
        try {
            return 10;
        } finally {
            System.out.println("Finally executed");
        }
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
```

Output:

```
Finally executed
10
```

---

## 6️⃣ Use Cases

✔ File closing
✔ Database connection closing
✔ Network resource cleanup
✔ Releasing locks
✔ Logging errors

---

## 7️⃣ Pitfalls / Notes

### ❗ 1. Catch Order Matters

Wrong:

```java
catch (Exception e)
catch (ArithmeticException e) // compile-time error
```

Correct:

```java
catch (ArithmeticException e)
catch (Exception e)
```

---

### ❗ 2. finally overrides return

```java
static int test() {
    try {
        return 10;
    } finally {
        return 20;
    }
}
```

Output:

```
20
```

Finally block overrides previous return.

---

### ❗ 3. Finally always executes (almost)

It executes even if:

* exception is thrown
* return is used

Does NOT execute if:

* System.exit(0)
* JVM crash

---

### ❗ 4. try without catch is allowed only if finally exists

Valid:

```java
try {
}
finally {
}
```

Invalid:

```java
try {
}
```

---

## 8️⃣ Real-World Analogy

Imagine:

```text
try → Driving car
catch → Accident handling
finally → Locking car & removing key (must happen)
```

No matter what happens during driving, you must lock the car.

---

## 9️⃣ Best Practices

✔ Keep try block minimal
✔ Catch specific exceptions
✔ Do not leave catch empty
✔ Use finally for resource cleanup
✔ Avoid returning inside finally
✔ Use try-with-resources when possible

---

## 🔟 Tricky Questions (With Answers)

---

### 1. Can we have try without catch?

**Answer:** Yes, if finally is present.

---

### 2. Can we have try without finally?

**Answer:** Yes, if catch is present.

---

### 3. Can finally execute without catch?

**Answer:** Yes.

---

### 4. Does finally execute after return?

**Answer:** Yes.

---

### 5. What happens if both try and finally have return?

**Answer:** Finally return overrides try return.

---

### 6. Can we write multiple finally blocks?

**Answer:** No.

---

### 7. What happens if exception is not caught?

**Answer:** Finally executes, then program terminates.

---

### 8. Is finally mandatory?

**Answer:** No.

---

### 9. Can we catch multiple exceptions in single catch? (Java 7+)

**Answer:** Yes.

```java
catch (IOException | SQLException e)
```

---

### 10. Does finally execute if System.exit() is called?

**Answer:** No.

---

# 🧾 Quick Recap / Cheat Sheet

```text
try → risky code
catch → handle exception
finally → always executes (cleanup)

Rules:
✔ Child catch first
✔ finally executes even after return
✔ finally overrides return
✔ try must have catch or finally
✔ No multiple finally blocks
```

---
