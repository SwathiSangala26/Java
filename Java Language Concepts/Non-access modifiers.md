# 📘 `static` Keyword

## 🔹 Definition

> `static` means **class-level**.
> Static members belong to the **class**, not to individual objects.

* Memory allocated **once**
* Shared by **all objects**
* Can be accessed **without creating an object**

---

## 🧠 Core Idea (Visual Understanding)

![Image](https://www.sitesbay.com/java/images/basic-java/Static-and-non-Static-Variable.png)

![Image](https://miro.medium.com/0%2A1may78ibZPnfE8KF.png)

* **Non-static** → object-specific
* **Static** → class-specific

---

## 1️⃣ Static Variables (Class Variables)

### ✔ Characteristics

* One copy shared among all objects
* Created when class is loaded
* Stored in **Method Area**

### 📌 Example

```java
class Employee {
    static String company = "Lilly";
    int id;
}
```

```java
Employee e1 = new Employee();
Employee e2 = new Employee();

e1.company = "Pfizer";
System.out.println(e2.company); // Pfizer
```

### 🧠 Notes

* Changes affect **all objects**
* Used for constants, counters, shared data

---

## 2️⃣ Static Methods

### ✔ Characteristics

* Can be called using **class name**
* Do NOT need object
* Can access **only static members**

### 📌 Example

```java
class Utility {
    static void printMsg() {
        System.out.println("Hello");
    }
}
```

Usage:

```java
Utility.printMsg();
```

### ❌ Restrictions

* Cannot access non-static variables directly
* `this` and `super` ❌ not allowed

---

## 3️⃣ Static Block

### ✔ Purpose

* Used to initialize static data
* Executes **once**
* Runs **before `main()`**

### 📌 Example

```java
class Test {
    static {
        System.out.println("Static block");
    }

    public static void main(String[] args) {
        System.out.println("Main method");
    }
}
```

### 🧠 Output

```
Static block
Main method
```

---

## 4️⃣ Static Nested Class

⚠ Only **inner (nested) classes** can be static

### 📌 Example

```java
class Outer {
    static class Inner {
        void show() {
            System.out.println("Static nested class");
        }
    }
}
```

Usage:

```java
Outer.Inner obj = new Outer.Inner();
obj.show();
```

### 🧠 Notes

* No outer class object required
* Cannot access non-static outer members

---

## 📦 Memory Allocation (IMPORTANT)

![Image](https://scaler.com/topics/images/memory-management-in-static-variable-in-java-1536x907.webp)

![Image](https://i.sstatic.net/IyXbF.gif)

| Member Type          | Memory Location   |
| -------------------- | ----------------- |
| static variables     | Method Area       |
| static methods       | Method Area       |
| non-static variables | Heap (per object) |

---

## 🔁 Static vs Non-static (Comparison)

| Feature     | static           | non-static    |
| ----------- | ---------------- | ------------- |
| Belongs to  | Class            | Object        |
| Copies      | One              | Multiple      |
| Access      | ClassName.member | Object.member |
| Uses `this` | ❌                | ✅             |

---

## 🎯 Important Interview Rules

* Static methods **cannot be overridden** (method hiding)
* Static members are **shared**
* `main()` is static → JVM calls it without object
* Static variables are **NOT thread-safe by default**

---

## ⚠ Common Interview Traps

❌ Static methods are overridden
✔ They are **hidden**, not overridden

❌ Static means constant
✔ Only `final static` means constant

---

## 🧠 One-Line Memory Trick

> **Static = class-level = one copy = no object needed**

---
