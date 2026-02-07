## 🟢 `final` (Keyword)

`final` is a **keyword** used to **restrict modification**.

It can be applied to:

* variables
* methods
* classes

---

### 🟢 `final` variable

A `final` variable **cannot be reassigned**.

```java
final int x = 10;
x = 20;   // ❌ compile-time error
```

For objects:

```java
final List<Integer> list = new ArrayList<>();
list.add(1);      // ✅ allowed
list = new ArrayList<>(); // ❌ not allowed
```

👉 Reference cannot change, object content can change.

---

### 🟢 `final` method

A `final` method **cannot be overridden**.

```java
class Parent {
    final void show() { }
}

class Child extends Parent {
    void show() { } // ❌ compile-time error
}
```

Used to **prevent behavior change in subclasses**.

---

### 🟢 `final` class

A `final` class **cannot be inherited**.

```java
final class A { }

class B extends A { } // ❌ compile-time error
```

Example:

* `String` is `final`

---

## 🟢 `finally` (Block)

`finally` is a **block** used with **exception handling**.

* Executes **always**
* Used for **cleanup code**
* Runs whether exception occurs or not

---

### 🟢 Example

```java
try {
    int a = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Exception");
} finally {
    System.out.println("Cleanup");
}
```

Output:

```
Exception
Cleanup
```

---

### 🟢 When `finally` does NOT execute

* `System.exit()`
* JVM crash
* Power failure

---

### 🟢 Common use cases

* Closing files
* Closing DB connections
* Releasing resources

---

## 🟢 `finalize()` (Method)

`finalize()` is a **method of `Object` class**.

```java
protected void finalize() throws Throwable { }
```

---

### 🟢 Purpose

* Called by **Garbage Collector**
* Before object is removed from memory
* Used for cleanup (historically)

---

### 🟢 Example

```java
class Test {
    protected void finalize() {
        System.out.println("Object destroyed");
    }
}
```

---

### 🟥 Why `finalize()` is BAD / deprecated

* Not guaranteed to run
* Runs only once (maybe never)
* Unpredictable timing
* Performance issues

👉 **Deprecated in Java 9+**
👉 **Should NOT be used**

Use instead:

* `try-with-resources`
* `AutoCloseable`

---

## 🟢 Key Differences (Side-by-Side)

| Feature            | `final`     | `finally` | `finalize()`     |
| ------------------ | ----------- | --------- | ---------------- |
| Type               | Keyword     | Block     | Method           |
| Used for           | Restriction | Cleanup   | GC cleanup       |
| Runs automatically | ❌           | ✅         | ❌ (GC-dependent) |
| Related to GC      | ❌           | ❌         | ✅                |
| Can be overridden  | ❌           | N/A       | ✅                |
| Reliability        | High        | High      | Low (deprecated) |
