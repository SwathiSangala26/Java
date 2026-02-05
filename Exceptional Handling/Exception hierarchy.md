## 1. Complete Exception Hierarchy

```
java.lang.Object
 └── java.lang.Throwable
      ├── java.lang.Error
      │    ├── java.lang.VirtualMachineError
      │    │    ├── java.lang.OutOfMemoryError
      │    │    └── java.lang.StackOverflowError
      │    ├── java.lang.AssertionError
      │    ├── java.lang.LinkageError
      │
      └── java.lang.Exception
           ├── java.lang.RuntimeException
           │    ├── java.lang.NullPointerException
           │    ├── java.lang.ArithmeticException
           │    ├── java.lang.ArrayIndexOutOfBoundsException
           │    ├── java.lang.ClassCastException
           │    ├── java.lang.IllegalArgumentException
           │    │    └── java.lang.NumberFormatException
           │    └── java.lang.IllegalStateException
           │
           ├── java.io.IOException
           │    ├── java.io.FileNotFoundException
           │    ├── java.io.EOFException
           │    └── java.net.SocketException
           │
           ├── java.sql.SQLException
           ├── java.lang.ClassNotFoundException
           ├── java.lang.InterruptedException
           └── java.text.ParseException
```

---

## 2. `java.lang.Object`

• Root class of **all Java classes**
• Every exception object ultimately extends `Object`
• Provides base methods like:
– `toString()`
– `equals()`
– `hashCode()`

---

## 3. `java.lang.Throwable`

• Superclass of **all errors and exceptions**
• Only objects of this class (or subclasses) can be:
– Thrown using `throw`
– Caught using `catch`

Common methods:
• `getMessage()`
• `printStackTrace()`
• `toString()`

---

## 4. `java.lang.Error`

• Represents **serious system-level problems**
• Caused by JVM or environment
• Not meant to be handled in application code
• Mostly **unchecked**

Examples:
• `java.lang.OutOfMemoryError`
• `java.lang.StackOverflowError`
• `java.lang.VirtualMachineError`

Characteristics:
• Occur at runtime
• Recovery not possible
• Program usually terminates

---

## 5. `java.lang.Exception`

• Represents **application-level problems**
• Can be handled using `try–catch`
• Divided into:
– Checked exceptions
– Unchecked exceptions

---

## 6. Checked Exceptions (Compile-Time)

• Checked at **compile time**
• Compiler forces handling
• Must be:
– Caught using `try–catch`, or
– Declared using `throws`

Examples (with full names):
• `java.io.IOException`
• `java.io.FileNotFoundException`
• `java.sql.SQLException`
• `java.lang.ClassNotFoundException`
• `java.text.ParseException`
• `java.lang.InterruptedException`

Reason:
• JVM assumes these are **recoverable conditions**

---

## 7. `java.lang.RuntimeException` (Unchecked Exceptions)

• Subclass of `java.lang.Exception`
• Parent of all unchecked exceptions
• Caused by **programming mistakes**
• Not checked at compile time

Examples:
• `java.lang.NullPointerException`
• `java.lang.ArithmeticException`
• `java.lang.ArrayIndexOutOfBoundsException`
• `java.lang.ClassCastException`
• `java.lang.IllegalArgumentException`
• `java.lang.NumberFormatException`

---

## 8. Checked vs Unchecked Exceptions

### Checked Exceptions

• Compile-time checking
• Mandatory handling
• Extend `java.lang.Exception`
• Recoverable

### Unchecked Exceptions

• Runtime checking
• Optional handling
• Extend `java.lang.RuntimeException`
• Programming errors

---

## 9. Why `RuntimeException` Exists

• Avoids excessive boilerplate code
• Common mistakes are obvious
• Programmer responsibility to fix logic
• Improves readability

---

## 10. Catching Order Based on Hierarchy

Rule:
• Catch **child classes first**
• Catch **parent classes last**

Correct:

```java
catch (NullPointerException e) { }
catch (Exception e) { }
```

Incorrect:

```java
catch (Exception e) { }
catch (NullPointerException e) { }  // unreachable
```

---

## 11. Catching `Throwable` or `Error`

Allowed but **not recommended**:

```java
catch (Throwable t) { }
```

Reason:
• Catches JVM errors
• Can hide serious problems
• Prevents proper JVM shutdown

Best practice:
• Catch specific exceptions
• Avoid catching `Error`

---

## 12. Custom Exceptions and Hierarchy

• Custom checked exception:

```java
class MyException extends Exception { }
```

• Custom unchecked exception:

```java
class MyRuntimeException extends RuntimeException { }
```

Placement:
• Custom exception becomes part of the same hierarchy

---

13. JVM Perspective

• Exception objects are created on heap
• Stack trace is maintained internally by JVM
• Runtime bounds checking is performed before array access
• Unhandled exceptions terminate the executing thread
