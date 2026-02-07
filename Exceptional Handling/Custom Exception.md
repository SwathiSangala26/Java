## 🟢 Custom Exceptions

* Custom exceptions are **user-defined exceptions**
* Used to represent **application-specific / business errors**
* Improve **readability, clarity, and maintainability**
* Help avoid using generic exceptions like `Exception` or `RuntimeException`

### Examples where custom exceptions are useful

* Invalid age
* Insufficient balance
* User not found
* Order processing failure

---

## 🟢 How to Create a Custom Exception

* Custom exceptions are created by **extending an existing exception class**
* Two main choices are available

### Option 1: Extend `RuntimeException`

* Creates an **unchecked custom exception**
* Compiler does **not** force handling

### Option 2: Extend `Exception`

* Creates a **checked custom exception**
* Compiler **forces handling or declaration**

---

## 🟢 Custom Unchecked Exception

* Created by extending `RuntimeException`
* Compiler does **not** enforce try-catch or throws
* Best used for **validation errors and programming mistakes**

### Custom unchecked exception class

```java
class InvalidAgeException extends RuntimeException {
    InvalidAgeException(String message) {
        super(message);
    }
}
```

### Using the custom unchecked exception

```java
void vote(int age) {
    if (age < 18) {
        throw new InvalidAgeException("Age must be 18 or above");
    }
    System.out.println("Eligible to vote");
}
```

### Caller without handling

```java
public static void main(String[] args) {
    vote(16);
    System.out.println("After vote");
}
```

* Code compiles successfully
* Exception is thrown at runtime
* No catch block is found
* Program terminates

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

* Exception is caught
* Program continues normally

### Key points

* `throws` is **not required**
* try-catch is **optional**
* Used mainly for **input validation and logical errors**

---

## 🟢 Custom Checked Exception

* Created by extending `Exception`
* Compiler **forces handling or declaration**
* Best used for **business rules and recoverable conditions**

### Custom checked exception class

```java
class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}
```

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

### Caller without handling or declaring

```java
public static void main(String[] args) {
    withdraw(5000, 2000);
}
```

* Compilation fails
* Checked exception must be handled or declared

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

* Exception is handled
* Program continues

### Caller with throws

```java
public static void main(String[] args)
        throws InsufficientBalanceException {
    withdraw(5000, 2000);
}
```

* Code compiles successfully
* Exception propagates to JVM
* Program terminates

### Key points

* `throws` is **mandatory** for checked custom exceptions
* Compiler strictly enforces this rule

---

## 🟢 Throw and Throws with Custom Exceptions

* `throw` is used to **create and throw** the custom exception object
* `throws` is used to **declare** the exception in the method signature

### Example

```java
void test() throws InvalidAgeException {
    throw new InvalidAgeException("Invalid age");
}
```

---

## 🟢 Exception Chaining with Custom Exceptions

* Used to wrap a **lower-level exception** inside a custom exception
* Preserves the **original cause**
* Common in layered applications (service → controller → UI)

### Custom exception with cause

```java
class BusinessException extends Exception {
    BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### Usage

```java
void process() throws BusinessException {
    try {
        int x = 10 / 0;
    } catch (ArithmeticException e) {
        throw new BusinessException("Processing failed", e);
    }
}
```

* Original exception is preserved
* Debugging becomes easier

---

## 🟢 Best Practices for Custom Exceptions

* Use **meaningful and specific names**
* Prefer unchecked custom exceptions for validation errors
* Prefer checked custom exceptions for recoverable business logic
* Avoid throwing generic `Exception`
* Always provide clear error messages
* Use exception chaining when wrapping exceptions
