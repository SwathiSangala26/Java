## 🟢 Try-with-resources in Java (AutoCloseable)

* Try-with-resources is a feature introduced in **Java 7**
* It is used to **automatically close resources**
* Eliminates the need to explicitly close resources in `finally`
* Prevents **resource leaks**
* Works with any class that implements `AutoCloseable`

---

## 🟢 What is a Resource?

* A resource is an object that must be closed after use
* Common examples:

  * File streams
  * Database connections
  * BufferedReader / Scanner
  * Socket connections

---

## 🟢 AutoCloseable Interface

* `AutoCloseable` is a **functional interface**
* It contains one method

```java
void close() throws Exception;
```

* Any class implementing `AutoCloseable` can be used in try-with-resources
* `close()` is called **automatically** when the try block ends

---

## 🟢 Traditional try–catch–finally (Old Way)

```java
FileReader fr = null;

try {
    fr = new FileReader("test.txt");
    // read file
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (fr != null) {
        try {
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

Problems with this approach:

* Too much boilerplate code
* Easy to forget `close()`
* Nested try-catch blocks
* Harder to read and maintain

---

## 🟢 Try-with-resources Syntax (New Way)

```java
try (ResourceType resource = new ResourceType()) {
    // use resource
} catch (Exception e) {
    // handle exception
}
```

* Resource is declared **inside the try parentheses**
* Resource is closed **automatically**
* No `finally` block required for closing

---

## 🟢 Simple Example with FileReader

```java
try (FileReader fr = new FileReader("test.txt")) {
    int data;
    while ((data = fr.read()) != -1) {
        System.out.print((char) data);
    }
} catch (IOException e) {
    e.printStackTrace();
}
```

* `FileReader` implements `AutoCloseable`
* `fr.close()` is called automatically
* Even if an exception occurs, the resource is closed

---

## 🟢 Multiple Resources in Try-with-resources

```java
try (
    FileReader fr = new FileReader("input.txt");
    BufferedReader br = new BufferedReader(fr)
) {
    System.out.println(br.readLine());
} catch (IOException e) {
    e.printStackTrace();
}
```

* Multiple resources are separated by semicolons
* Resources are closed **in reverse order**

  * `BufferedReader` closes first
  * `FileReader` closes next

---

## 🟢 Order of Resource Closing

```java
try (
    ResourceA a = new ResourceA();
    ResourceB b = new ResourceB()
) {
    // use resources
}
```

Closing order:

* `ResourceB.close()` is called first
* `ResourceA.close()` is called next

This follows **LIFO (Last In, First Out)** order.

---

## 🟢 Custom Resource Using AutoCloseable

```java
class MyResource implements AutoCloseable {

    void doWork() {
        System.out.println("Working...");
    }

    @Override
    public void close() {
        System.out.println("Resource closed");
    }
}
```

Using the custom resource:

```java
try (MyResource r = new MyResource()) {
    r.doWork();
}
```

Output:

```
Working...
Resource closed
```

* `close()` is called automatically
* No explicit call needed

---

## 🟢 Try-with-resources with Checked Exceptions

```java
try (FileReader fr = new FileReader("test.txt")) {
    // read file
}
```

* `FileReader` constructor throws `IOException`
* You must handle or declare the exception
* Try-with-resources does **not remove exception handling rules**

---

## 🟢 Suppressed Exceptions

* If both:

  * an exception occurs in the try block, and
  * an exception occurs while closing the resource
* The closing exception is **suppressed**

Example concept:

* Main exception is thrown
* Closing exception is attached as a **suppressed exception**

This improves debugging.

---

## 🟢 Try-with-resources vs finally

| Aspect       | Try-with-resources | finally      |
| ------------ | ------------------ | ------------ |
| Code length  | Short              | Long         |
| Auto close   | Yes                | No           |
| Readability  | High               | Lower        |
| Error-prone  | No                 | Yes          |
| Java version | Java 7+            | All versions |

---

## 🟢 When to Use Try-with-resources

* When working with:

  * Files
  * Streams
  * Database connections
  * Network resources
* When resource cleanup is mandatory
* When you want clean and safe code
