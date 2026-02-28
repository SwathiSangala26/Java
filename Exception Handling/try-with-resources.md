## 1️⃣ Definition

`try-with-resources` is a feature introduced in **Java 7** that automatically closes resources after execution.

It eliminates the need for explicit `finally` blocks for cleanup.

It works only with objects that implement:

```text
AutoCloseable
```

---

## 2️⃣ Visual Representation

### Traditional try–finally

```text
try
  ↓
use resource
  ↓
finally
  ↓
resource.close()
```

---

### try-with-resources

```text
try (resource declared here)
  ↓
use resource
  ↓
Auto-close automatically
```

---

### Execution Flow

```text
Start
  ↓
Resource created
  ↓
try block executes
  ↓
Exception or not
  ↓
Resource auto-closed
  ↓
catch (if any)
```

---

## 3️⃣ Key Features / Properties

✔ Resource declared inside parentheses
✔ Resource must implement `AutoCloseable`
✔ Automatically closes resource
✔ Reduces boilerplate code
✔ Prevents resource leaks
✔ Can declare multiple resources
✔ Close happens in reverse order

---

### Important Interface

```text
AutoCloseable
     ↓
Closeable (extends AutoCloseable)
```

Common classes:

* FileReader
* BufferedReader
* FileInputStream
* Connection
* Scanner

---

## 4️⃣ Syntax

### Basic Syntax

```java
try (ResourceType resource = new ResourceType()) {
    // use resource
} catch (Exception e) {
}
```

---

### Multiple Resources

```java
try (
    FileReader fr = new FileReader("file.txt");
    BufferedReader br = new BufferedReader(fr)
) {
    // use resources
}
```

---

## 5️⃣ Code Example

---

### Example 1 — Traditional Way

```java
import java.io.*;

class Demo {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

Too much boilerplate.

---

### Example 2 — try-with-resources

```java
import java.io.*;

class Demo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("file.txt")) {
            System.out.println("File opened");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Cleaner and safer.

---

### Example 3 — Custom Resource

```java
class MyResource implements AutoCloseable {

    public void use() {
        System.out.println("Using resource");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}

class Demo {
    public static void main(String[] args) {
        try (MyResource r = new MyResource()) {
            r.use();
        }
    }
}
```

Output:

```
Using resource
Resource closed
```

---

## 6️⃣ Use Cases

✔ File handling
✔ Database connections
✔ Network streams
✔ Input/output streams
✔ Scanner usage

Prevents:

* Memory leaks
* Resource leaks
* Connection leaks

---

## 7️⃣ Pitfalls / Notes

---

### ❗ 1. Resource must implement AutoCloseable

Otherwise compile-time error.

---

### ❗ 2. Close order is reverse

```text
Resource1
Resource2
```

Close order:

```text
Resource2
Resource1
```

---

### ❗ 3. Exception during close()

If both:

* try block throws exception
* close() throws exception

👉 The close exception is **suppressed**

You can access it using:

```java
e.getSuppressed();
```

---

### ❗ 4. Variable scope limited

Resource declared inside try cannot be used outside.

---

### ❗ 5. Java 9 Improvement

Java 9 allows:

```java
FileReader fr = new FileReader("file.txt");

try (fr) {
}
```

Resource can be effectively final.

---

## 8️⃣ Real-World Analogy

```text
Borrowing a library book

Traditional:
Borrow book → read → remember to return manually

try-with-resources:
Borrow book → read → auto-return when leaving library
```

No forgetting.

---

## 9️⃣ Best Practices

✔ Always use try-with-resources for I/O
✔ Keep resource declaration minimal
✔ Avoid nested try blocks
✔ Prefer it over finally for closing resources
✔ Handle suppressed exceptions if required
✔ Keep close() lightweight

---

## 🔟 Tricky Questions (With Answers)

---

### 1. When was try-with-resources introduced?

**Answer:** Java 7

---

### 2. Which interface must resource implement?

**Answer:** AutoCloseable

---

### 3. Does it eliminate finally?

**Answer:** For resource closing, yes.

---

### 4. In what order are resources closed?

**Answer:** Reverse order of declaration.

---

### 5. What happens if both try and close throw exception?

**Answer:** Close exception is suppressed.

---

### 6. Can we use multiple resources?

**Answer:** Yes.

---

### 7. Can we use try-with-resources without catch?

**Answer:** Yes, if method declares throws.

---

### 8. Can we create custom resource for it?

**Answer:** Yes, by implementing AutoCloseable.

---

### 9. Is close() mandatory to override?

**Answer:** Yes, when implementing AutoCloseable.

---

### 10. Is resource accessible outside try block?

**Answer:** No.

---

# 🧾 Quick Recap / Cheat Sheet

```text
try-with-resources (Java 7)

✔ Resource declared inside ()
✔ Must implement AutoCloseable
✔ Auto-closes resource
✔ Reverse close order
✔ Suppressed exceptions possible
✔ Cleaner than finally
```

---
