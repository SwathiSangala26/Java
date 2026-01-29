# 📘 `final` Keyword

## 🔹 Definition

> `final` means **cannot be changed**.

Depending on usage, `final` prevents:

* **Reassignment** → variables
* **Overriding** → methods
* **Inheritance** → classes

---

## 🧭 Where `final` Can Be Used

![Image](https://d8it4huxumps7.cloudfront.net/uploads/images/67207422b6356_final_keyword_in_java_1.jpg?d=2000x2000)

![Image](https://i.sstatic.net/LiIss.png)

* `final` variable
* `final` method
* `final` class

---

## 1️⃣ `final` Variable

### 🔹 Meaning

* Can be assigned **only once**
* Must be initialized before use

```java
final int a = 10;
a = 20; // ❌ compile-time error
```

---

### 🔹 Types of Final Variables

#### ✅ Final Instance Variable

```java
class Test {
    final int x;

    Test() {
        x = 10;   // ✅ initialized in constructor
    }
}
```

* One copy per object
* Stored in **Heap**

---

#### ✅ Final Static Variable (Constant)

```java
class Test {
    static final int MAX = 100;
}
```

* One copy per class
* Stored in **Method Area**
* Naming convention: **UPPER_CASE**

---

#### ✅ Final Local Variable

```java
void show() {
    final int y = 5;
}
```

* Stored in **Stack**
* Must be initialized before use

---

### ⚠ Important Rule (INTERVIEW FAVORITE)

```java
final List<Integer> list = new ArrayList<>();
list.add(10);          // ✅ allowed
list = new ArrayList<>(); // ❌ not allowed
```

> `final` applies to the **reference**, not the object

---

## 2️⃣ `final` Method

### 🔹 Meaning

* Cannot be **overridden**
* Can be **inherited**
* Can be **overloaded**

```java
class Parent {
    final void show() {
        System.out.println("Hello");
    }
}

class Child extends Parent {
    // void show() { } ❌ NOT allowed
}
```

---

### 🧠 Why use final methods?

* Prevent behavior change
* Improve security
* Used in frameworks

---

## 3️⃣ `final` Class

### 🔹 Meaning

* Cannot be **extended**
* Prevents inheritance

```java
final class Utility {
    static void help() {}
}
```

```java
class Test extends Utility {} // ❌ error
```

📌 Example: `String` class

---

## 📦 Memory Perspective (VERY IMPORTANT)

![Image](https://i.sstatic.net/4Ttvc.png)

![Image](https://scaler.com/topics/images/memory-management-in-static-variable-in-java-1536x907.webp)

| Final Variable Type     | Memory Location |
| ----------------------- | --------------- |
| final local variable    | Stack           |
| final instance variable | Heap            |
| static final variable   | Method Area     |

---

## 🔁 `final` vs `static`

| Keyword      | Meaning       |
| ------------ | ------------- |
| final        | Cannot change |
| static       | Class-level   |
| static final | Constant      |

---

## ⚠ What Cannot Be `final`

| Item             | Allowed? |
| ---------------- | -------- |
| Constructor      | ❌        |
| Abstract method  | ❌        |
| Interface method | ❌        |
| Local class      | ❌        |

---

## 🎯 Interview One-Liners (MEMORIZE)

* Final variables → assign once
* Final methods → no override
* Final classes → no inheritance
* Final reference ≠ immutable object
* `static final` → constant

---

## 🧠 Memory Trick

> **Final = STOP**
> Value STOP | Override STOP | Inheritance STOP

---

## 📝 Ultra-Short Revision Notes

* `final` variable → constant
* `final` method → no override
* `final` class → no extend
* `static final` → constant

---
