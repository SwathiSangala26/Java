# 1️⃣ Definition

A **variable** is a named memory location used to store data.

In Java, variables are classified based on **where they are declared and how they behave**:

```
Variables
│
├── Local
├── Instance
└── Static
```

---

# 2️⃣ Visual Representation

---

## 🔹 Local Variable

Declared inside a method.

```
class Test {
    void display() {
        int x = 10;   ← Local
    }
}
```

Memory:

```
Stack Frame (Method Call)
-------------------------
x  ───► 10
```

✔ Created when method is called
✔ Destroyed when method ends

---

## 🔹 Instance Variable

Declared inside class but outside methods.

```
class Person {
    int age;   ← Instance
}
```

Memory:

```
Stack              Heap
-----             ----------------
p  ───────►       [ Person Object ]
                   age = 0
```

✔ Stored inside object
✔ Each object gets separate copy

---

## 🔹 Static Variable

Declared with `static` keyword.

```
class Person {
    static String country = "India";
}
```

Memory:

```
Method Area (Class Level)
--------------------------
country = "India"
```

✔ One copy per class
✔ Shared across all objects

---

# 3️⃣ Key Features / Properties

---

## 🟢 Local Variables

* Declared inside method/constructor/block
* Stored in stack
* No default value
* Must be initialized before use
* Cannot use access modifiers
* Lifetime = method execution

---

## 🔵 Instance Variables

* Declared inside class (outside methods)
* Stored in heap (inside object)
* Get default values
* Each object has separate copy
* Accessed using object reference

---

## 🟣 Static Variables

* Declared using `static`
* Stored in Method Area (Class area)
* Only one copy shared by all objects
* Loaded when class loads
* Access using class name

---

# 4️⃣ Syntax

---

## 🔹 Local

```java
void show() {
    int x = 10;
}
```

---

## 🔹 Instance

```java
class Person {
    int age;
}
```

---

## 🔹 Static

```java
class Person {
    static String country = "India";
}
```

---

# 5️⃣ Code Example

```java
class Student {

    int rollNo;              // Instance
    static String college;   // Static

    void display() {
        int marks = 90;      // Local
        System.out.println(rollNo);
        System.out.println(college);
        System.out.println(marks);
    }
}
```

Usage:

```java
Student.college = "ABC College";

Student s1 = new Student();
s1.rollNo = 1;

Student s2 = new Student();
s2.rollNo = 2;
```

✔ `rollNo` → separate per object
✔ `college` → shared

---

# 6️⃣ Use Cases

### Local

* Temporary calculations
* Loop counters
* Method-level logic

### Instance

* Object-specific data
* Real-world modeling

### Static

* Common shared data
* Constants
* Counters shared across objects

---

# 7️⃣ Pitfalls / Notes (VERY IMPORTANT)

---

### ⚠ 1. Local Variables Have No Default Value

```java
void test() {
    int x;
    System.out.println(x); // Compile error
}
```

---

### ⚠ 2. Instance & Static Get Default Values

| Type    | Default |
| ------- | ------- |
| int     | 0       |
| boolean | false   |
| Object  | null    |

---

### ⚠ 3. Static Cannot Access Instance Directly

```java
class Test {
    int x = 10;

    static void show() {
        System.out.println(x); // Error
    }
}
```

✔ Because static belongs to class, not object.

Correct way:

```java
Test t = new Test();
System.out.println(t.x);
```

---

### ⚠ 4. Memory Allocation Timing

* Local → when method runs
* Instance → when object created
* Static → when class loads

---

### ⚠ 5. Shadowing (Local vs Instance)

```java
class Test {
    int x = 10;

    void show() {
        int x = 20;
        System.out.println(x);        // 20
        System.out.println(this.x);   // 10
    }
}
```

---

# 8️⃣ Real-World Analogy

Local → Like money in your pocket (temporary).

Instance → Like personal bank account (unique per person).

Static → Like country’s national currency (shared by everyone).

---

# 9️⃣ Best Practices

✔ Use local variables whenever possible
✔ Use instance variables for object state
✔ Use static only for shared data
✔ Access static variables using ClassName.variable
✔ Avoid overusing static

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. Can we declare static local variable in Java?

❌ No. Java does not allow static local variables.

---

### ❓ 2. Where are static variables stored?

In Method Area (Class Area).

---

### ❓ 3. Do static variables get default values?

Yes.

---

### ❓ 4. Can instance variable access static variable?

Yes. Directly.

---

### ❓ 5. Can static method access instance variable directly?

❌ No.

---

### ❓ 6. When are static variables created?

When class is loaded.

---

### ❓ 7. When are instance variables created?

When object is created.

---

### ❓ 8. What happens if we modify static variable using object?

```java
s1.college = "XYZ";
```

✔ It modifies the shared static variable for all objects.

---

# 🧾 Quick Recap / Cheat Sheet

```
Local
-----
• Inside method
• No default value
• Stored in stack
• Lifetime = method execution

Instance
--------
• Inside class
• Default value available
• Stored in heap
• One copy per object

Static
------
• Declared with static
• One copy per class
• Stored in Method Area
• Shared across objects
```

---
