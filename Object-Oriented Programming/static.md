## 1️⃣ Definition

`static` is a keyword in Java used to define class-level members.

It means:

* Belongs to the class
* Not to individual objects

Static members are shared among all objects of the class.

---

## 2️⃣ Visual Representation

### Memory Concept

```id="st_v1"
Class Area (Method Area)
   |
   |-- static variables
   |-- static methods
   |
Heap
   |
   |-- Object1
   |-- Object2
```

Static members exist once per class.

---

### Access

```id="st_v2"
ClassName.staticVariable
ClassName.staticMethod()
```

---

### Shared Behavior

```id="st_v3"
Object1 ----\
             ---> static variable (shared)
Object2 ----/
```

---

## 3️⃣ Key Features / Properties

* Belongs to class, not object
* Memory allocated once
* Shared across all instances
* Can be accessed without object
* Static methods cannot access non-static members directly
* Cannot use `this` or `super` inside static context
* Loaded when class is loaded

---

## 4️⃣ Syntax

### Static Variable

```java id="st_s1"
class Demo {
    static int count = 0;
}
```

---

### Static Method

```java id="st_s2"
class Demo {
    static void show() {
        System.out.println("Static Method");
    }
}
```

---

## 5️⃣ Code Example

```java id="st_ex1"
class Counter {

    static int count = 0;

    Counter() {
        count++;
    }

    static void displayCount() {
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {

        new Counter();
        new Counter();
        new Counter();

        Counter.displayCount();  // Output: 3
    }
}
```

Explanation:

* `count` is shared
* All objects modify same variable

---

## 6️⃣ Use Cases

* Shared counters
* Utility methods
* Constants
* Singleton pattern
* Static factory methods
* Common configuration

---

## 7️⃣ Pitfalls / Notes

* ❌ Accessing non-static members in static method
* ❌ Overusing static (reduces flexibility)
* ❌ Global state problems
* ❌ Hard to test static-heavy code
* ❌ Confusing static with instance variables

---

## 8️⃣ Real-World Analogy

🏢 Company Notice Board

* Static variable → Notice board
* All employees see same notice
* Not tied to any individual

---

## 9️⃣ Best Practices

* Use static for shared data only
* Avoid excessive static usage
* Use static for utility/helper methods
* Keep static variables immutable when possible
* Prefer dependency injection over static state

---

## 🔟 Tricky Questions

1. What is static keyword?
   ➜ Defines class-level members.

2. Where are static variables stored?
   ➜ Method Area (Class Area).

3. Can static method access non-static variable?
   ➜ No (without object reference).

4. Can static method use `this`?
   ➜ No.

5. When are static variables initialized?
   ➜ When class is loaded.

6. Are static variables shared?
   ➜ Yes.

7. Can constructor be static?
   ➜ No.

8. Can static methods be overridden?
   ➜ No (they are hidden).

9. Can static block exist?
   ➜ Yes.

10. What is static block used for?
    ➜ Static initialization.

11. Can interface have static methods?
    ➜ Yes (Java 8+).

12. Can static variables be private?
    ➜ Yes.

13. Can static method call another static method?
    ➜ Yes.

14. Is main method static?
    ➜ Yes.

15. Why main method is static?
    ➜ To run without creating object.

---

## 🧾 Quick Recap / Cheat Sheet

* `static` = class-level member
* Shared among objects
* Stored in Method Area
* Access using ClassName.member
* Static method cannot access instance members
* No `this` in static context
* Loaded at class loading time
* Used for utilities & constants
* Static block for initialization
* Not overridden (method hiding)
* Important memory concept
* Frequently asked interview topic
* Avoid global state misuse
* Main method is static
* Used for shared configuration

---
