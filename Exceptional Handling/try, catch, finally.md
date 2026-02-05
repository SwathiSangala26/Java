## 1. Definition

• Exception handling is a mechanism to **handle runtime errors**
• Prevents **abnormal termination** of program
• Maintains **normal flow of execution**
• Implemented using:
– `try`
– `catch`
– `finally`

---

## 2. What is an Exception?

• An exception is an **unexpected event at runtime**
• Occurs during program execution
• Causes program disruption if not handled

Examples:
• Divide by zero
• Null reference access
• Invalid array index
• File not found

---

## 3. `try` Block

• Contains **risky code**
• JVM monitors this block
• If exception occurs:
– Remaining code in `try` is skipped
– Control moves to `catch`

Syntax:

```java
try {
    // risky code
}
```

Rules:
• `try` cannot exist alone
• Must be followed by `catch` or `finally`
• Cannot have code outside blocks

---

## 4. `catch` Block

• Handles exception thrown from `try`
• Executes only when exception occurs
• Prevents program crash

Syntax:

```java
catch (ExceptionType e) {
    // handling code
}
```

Key points:
• Exception type must match
• If not matched → JVM checks next `catch`
• If none matches → program terminates

---

## 5. `finally` Block

• Executes **always**
• Executes whether exception occurs or not
• Used for **cleanup code**

Syntax:

```java
finally {
    // cleanup code
}
```

Common uses:
• Closing files
• Closing database connections
• Releasing resources

---

## 6. Complete try–catch–finally Example

```java
try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Divide by zero");
} finally {
    System.out.println("Cleanup");
}
```

Execution:
• Exception occurs
• `catch` executes
• `finally` executes
• Program continues

---

## 7. Execution Flow

### No Exception

• `try` executes fully
• `catch` skipped
• `finally` executes

### Exception Occurs and Caught

• `try` stops at exception
• Matching `catch` executes
• `finally` executes

### Exception Occurs and Not Caught

• `try` stops
• `finally` executes
• Program crashes

---

## 8. Important `finally` Rules

• Executes even if `return` is used
• Executes even if exception is thrown
• Does NOT execute if:
– `System.exit()` is called
– JVM crashes

Avoid:

```java
finally {
    return value;
}
```

Reason:
• Overrides return value from `try` or `catch`

---

## 9. Multiple `catch` Blocks

• Used to handle **different exception types**
• JVM checks `catch` blocks **top to bottom**
• First matching block executes

Syntax:

```java
try {
    // risky code
} catch (ExceptionType1 e) {
    // handle
} catch (ExceptionType2 e) {
    // handle
}
```

---

## 10. Order of Multiple `catch` Blocks

Rule:
• **Child exception first**
• **Parent exception last**

Correct:

```java
catch (NullPointerException e) { }
catch (Exception e) { }
```

Incorrect:

```java
catch (Exception e) { }
catch (NullPointerException e) { } // compile-time error
```

Reason:
• Parent catches all child exceptions
• Child becomes unreachable

---

## 11. Generic `catch (Exception e)`

• Handles all exceptions
• Should be placed **last**
• Used as fallback handler

Example:

```java
catch (Exception e) {
    System.out.println("General error");
}
```

---

## 12. Can We Have try Without catch?

Allowed:

```java
try {
    // code
} finally {
    // cleanup
}
```

Not Allowed:

```java
try {
    // code
}
```

Reason:
• `try` must be followed by `catch` or `finally`

---

## 13. Nested try–catch

• `try` inside another `try`
• Used for fine-grained exception handling

Example:

```java
try {
    try {
        int a = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Inner catch");
    }
} catch (Exception e) {
    System.out.println("Outer catch");
}
```

---

## 14. Throwing Exception from catch

• Exception can be re-thrown
• Control moves to caller

Example:

```java
catch (Exception e) {
    throw e;
}
```

• `finally` still executes

---

## 15. Exception Object (`e`)

• `e` contains exception details
• Common methods:
– `e.getMessage()`
– `e.printStackTrace()`
