## 🟢 **CUSTOM EXCEPTIONS IN JAVA**

---

• Custom exceptions are **user-defined exceptions**
• Used to represent **application-specific / business errors**
• Improve **readability, clarity, and maintainability**
• Help avoid using generic exceptions like `Exception` or `RuntimeException`

Examples of where custom exceptions are useful
• Invalid age
• Insufficient balance
• User not found
• Order processing failure

---

## 🟢 **HOW TO CREATE A CUSTOM EXCEPTION**

---

• Custom exceptions are created by **extending an existing exception class**
• Two main choices are available

👉 Extend `RuntimeException` → **Unchecked custom exception**
👉 Extend `Exception` → **Checked custom exception**

---

## 🟢 **CUSTOM UNCHECKED EXCEPTION**

---

• Created by extending `RuntimeException`
• Compiler does **not** force handling
• Best suited for **validation errors and programming mistakes**

### Custom unchecked exception class

```java
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String message) {
        super(message);
    }
}
```

---

### Using the custom unchecked exception

```java
void vote(int age) {
    if (age < 18) {
        throw new InvalidAgeException("Age must be 18 or above");
    }
    System.out.println("Eligible to vote");
}
```

---

### Caller without handling

```java
public static void main(String[] args) {
    vote(16);
    System.out.println("After vote");
}
```

• Code compiles successfully
• Exception is thrown at runtime
• No catch block found
• Program terminates

---

### Caller with handling (optional)

```java
public static void main(String[] args) {
    try {
        vote(16);
    } catch (InvalidAgeException e) {
        System.out.println(e.getMessage());
    }
}
```

• Exception is caught
• Program continues normally

---

• `throws` is **not required**
• try-catch is **optional**
• Recommended for input validation and logical errors

---

## 🟢 **CUSTOM CHECKED EXCEPTION**

---

• Created by extending `Exception`
• Compiler **forces handling or declaration**
• Used for **business rules and recoverable conditions**

### Custom checked exception class

```java
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}
```

---

### Using the custom checked exception

```java
void withdraw(double amount, double balance)
        throws InsufficientBalanceException {

    if (amount > balance) {
        throw new InsufficientBalanceException("Insufficient balance");
    }
    System.out.println("Withdrawal successful");
}
```

---

### Caller without handling or declaring

```java
public static void main(String[] args) {
    withdraw(5000, 2000);
}
```

• Compilation fails
• Checked exception must be handled or declared

---

### Caller with try-catch

```java
public static void main(String[] args) {
    try {
        withdraw(5000, 2000);
    } catch (InsufficientBalanceException e) {
        System.out.println(e.getMessage());
    }
}
```

• Exception is handled
• Program continues

---

### Caller with throws

```java
public static void main(String[] args)
        throws InsufficientBalanceException {
    withdraw(5000, 2000);
}
```

• Code compiles successfully
• Exception reaches JVM
• Program terminates

---

• `throws` is **mandatory** for checked custom exceptions
• Compiler strictly enforces this rule

---

## 🟢 **THROW AND THROWS WITH CUSTOM EXCEPTIONS**

---

• `throw` is used to **create and throw** a custom exception object
• `throws` is used to **declare** the exception in the method signature

Example

```java
void test() throws InvalidAgeException {
    throw new InvalidAgeException("Invalid age");
}
```

---

## 🟢 **EXCEPTION CHAINING WITH CUSTOM EXCEPTIONS**

---

• Used to wrap a **lower-level exception** inside a custom exception
• Preserves the **original cause**
• Common in layered applications

Custom exception with cause

```java
class BusinessException extends Exception {
    BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

Usage

```java
void process() throws BusinessException {
    try {
        int x = 10 / 0;
    } catch (ArithmeticException e) {
        throw new BusinessException("Processing failed", e);
    }
}
```

• Original exception is preserved
• Debugging becomes easier

---

## 🟢 **BEST PRACTICES FOR CUSTOM EXCEPTIONS**

---

• Use **meaningful and specific names**
• Prefer unchecked custom exceptions for validation errors
• Prefer checked custom exceptions for recoverable business logic
• Avoid throwing generic `Exception`
• Always include a clear error message
• Use exception chaining when wrapping exceptions
