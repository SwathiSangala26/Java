## 1️⃣ Definition

**Polymorphism** means “many forms”.

In Java, polymorphism allows one method, object, or interface to take multiple forms.

It enables:

* Flexibility
* Reusability
* Runtime behavior change

Two types:

* Compile-time polymorphism (Method Overloading)
* Runtime polymorphism (Method Overriding)

---

## 2️⃣ Visual Representation

### Compile-Time Polymorphism

```id="poly1"
add(int, int)
add(double, double)

Method decided at compile time
```

---

### Runtime Polymorphism

```id="poly2"
Parent ref = new Child();
ref.display();

Method decided at runtime
```

---

### One Interface, Multiple Implementations

```id="poly3"
Shape
   |
   |-- Circle
   |-- Rectangle
```

Same method → Different behavior.

---

## 3️⃣ Key Features / Properties

* Supports multiple behaviors
* Enables dynamic method dispatch
* Promotes loose coupling
* Improves extensibility
* Based on inheritance or interfaces
* Achieved using method overloading and overriding

---

## 4️⃣ Syntax

### Compile-Time Polymorphism

```java id="polycode1"
int add(int a, int b) { return a + b; }
double add(double a, double b) { return a + b; }
```

---

### Runtime Polymorphism

```java id="polycode2"
class Parent {
    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    void show() {
        System.out.println("Child");
    }
}
```

---

## 5️⃣ Code Example

```java id="polycode3"
class Payment {

    void pay() {
        System.out.println("Generic payment");
    }
}

class CreditCard extends Payment {

    @Override
    void pay() {
        System.out.println("Payment via Credit Card");
    }
}

public class Main {

    public static void main(String[] args) {

        Payment p = new CreditCard();
        p.pay();   // Runtime polymorphism
    }
}
```

Explanation:

* Reference type → Payment
* Object type → CreditCard
* Executed method → CreditCard version

---

## 6️⃣ Use Cases

* Strategy pattern
* Framework design
* Payment systems
* Plugin architecture
* API flexibility
* Dynamic behavior selection

---

## 7️⃣ Pitfalls / Notes

* ❌ Confusing overloading with overriding
* ❌ Not understanding runtime binding
* ❌ Forgetting inheritance requirement for runtime polymorphism
* ❌ Trying to override static methods
* ❌ Deep inheritance chains
* ❌ Misusing type casting

---

## 8️⃣ Real-World Analogy

🔌 Universal Charger

* One charger type
* Multiple device behaviors
* Same interface, different internal working

---

## 9️⃣ Best Practices

* Use interfaces for flexibility
* Follow Liskov Substitution Principle
* Avoid unnecessary casting
* Keep hierarchy simple
* Use @Override
* Prefer composition when appropriate

---

## 🔟 Tricky Questions

1. What is polymorphism?
   ➜ Ability of an object to take multiple forms.

2. How many types of polymorphism in Java?
   ➜ Two.

3. What are they?
   ➜ Compile-time and runtime.

4. Which concept enables compile-time polymorphism?
   ➜ Method overloading.

5. Which concept enables runtime polymorphism?
   ➜ Method overriding.

6. Is polymorphism compile-time or runtime concept?
   ➜ Both.

7. What is dynamic method dispatch?
   ➜ Runtime selection of overridden method.

8. Does overloading support runtime polymorphism?
   ➜ No.

9. Can static methods support polymorphism?
   ➜ No (method hiding).

10. Why is polymorphism important?
    ➜ Improves flexibility and extensibility.

11. Can constructors be polymorphic?
    ➜ No.

12. What is reference type vs object type in polymorphism?
    ➜ Reference type determines accessible methods; object type determines executed method.

13. Does polymorphism reduce coupling?
    ➜ Yes.

14. Is inheritance required for compile-time polymorphism?
    ➜ No.

15. Is inheritance required for runtime polymorphism?
    ➜ Yes.

---

## 🧾 Quick Recap / Cheat Sheet

* Polymorphism = Many forms
* Two types: Compile-time & Runtime
* Overloading → Compile-time
* Overriding → Runtime
* Enables dynamic method dispatch
* Improves flexibility
* Promotes loose coupling
* Based on inheritance/interfaces
* Reference type ≠ object type
* Static methods not polymorphic
* Important OOP pillar
* Frequently asked in interviews
* Enables extensibility
* Reduces tight coupling
* Core Java concept

---
