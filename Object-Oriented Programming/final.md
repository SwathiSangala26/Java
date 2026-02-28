## 1️⃣ Definition

`final` is a keyword in Java used to restrict modification.

It can be applied to:

* Variables
* Methods
* Classes

Meaning depends on where it is used.

---

## 2️⃣ Visual Representation

### final Variable

```id="fn_v1"
final int x = 10;

x = 20;   ❌ Not allowed
```

---

### final Method

```id="fn_v2"
Parent
   |
   |-- final display()

Child
   |
   |-- display()   ❌ Cannot override
```

---

### final Class

```id="fn_v3"
final class A

class B extends A   ❌ Not allowed
```

---

## 3️⃣ Key Features / Properties

### final Variable

* Value cannot be changed once assigned
* Must be initialized
* Can be initialized at declaration or constructor

### final Method

* Cannot be overridden
* Can be inherited

### final Class

* Cannot be extended
* Prevents inheritance

---

## 4️⃣ Syntax

### final Variable

```java id="fn_s1"
final int MAX = 100;
```

---

### final Method

```java id="fn_s2"
class Demo {
    final void show() {
        System.out.println("Final method");
    }
}
```

---

### final Class

```java id="fn_s3"
final class Utility {
}
```

---

## 5️⃣ Code Example

```java id="fn_ex1"
class Parent {

    final void display() {
        System.out.println("Cannot override this method");
    }
}

class Child extends Parent {

    // display()  ❌ Compilation error if overridden
}

public class Main {

    public static void main(String[] args) {

        final int number = 10;
        // number = 20;  ❌ Not allowed

        System.out.println(number);
    }
}
```

---

## 6️⃣ Use Cases

* Defining constants
* Preventing method overriding
* Securing classes from inheritance
* Creating immutable classes
* Ensuring design integrity

---

## 7️⃣ Pitfalls / Notes

* ❌ Confusing final with finally
* ❌ Confusing final with finalize()
* ❌ Assuming final object reference makes object immutable
* ❌ Forgetting to initialize final variable
* ❌ Trying to override final method

---

## 8️⃣ Real-World Analogy

🔐 Locked Property

* final variable → Locked value
* final method → Locked behavior
* final class → Locked blueprint

Cannot modify once locked.

---

## 9️⃣ Best Practices

* Use final for constants
* Make variables final when they should not change
* Use final methods to protect core logic
* Use final classes for security-sensitive design
* Combine final with immutability

---

## 🔟 Tricky Questions

1. What is final keyword?
   ➜ Used to restrict modification.

2. Can final variable be changed?
   ➜ No.

3. Must final variable be initialized?
   ➜ Yes.

4. Can final variable be initialized in constructor?
   ➜ Yes.

5. Can final method be overridden?
   ➜ No.

6. Can final method be overloaded?
   ➜ Yes.

7. Can final class be inherited?
   ➜ No.

8. Is String class final?
   ➜ Yes.

9. Does final make object immutable?
   ➜ No, it makes reference immutable.

10. What is difference between final and finally?
    ➜ final is keyword; finally is block in exception handling.

11. What is difference between final and finalize()?
    ➜ finalize() is method; final is keyword.

12. Can constructor be final?
    ➜ No.

13. Can abstract method be final?
    ➜ No.

14. Can static method be final?
    ➜ Yes.

15. When should we use final class?
    ➜ When we want to prevent inheritance.

---

## 🧾 Quick Recap / Cheat Sheet

* `final` restricts modification
* Final variable → cannot reassign
* Final method → cannot override
* Final class → cannot extend
* Must initialize final variables
* Constructor can initialize final variables
* Final reference ≠ immutable object
* Cannot combine abstract & final method
* Used for constants
* Protects core logic
* Improves security
* Common interview topic
* Frequently confused with finally
* Used in immutable design
* Important OOP keyword

---
