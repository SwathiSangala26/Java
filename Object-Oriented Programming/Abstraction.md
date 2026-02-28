## 1️⃣ Definition

**Abstraction** is the OOP principle of hiding implementation details and exposing only essential features of an object.

It answers:

👉 *What an object does*
❌ Not *how it does it*

In Java, abstraction is achieved using:

* Abstract classes
* Interfaces

---

## 2️⃣ Visual Representation

### Abstract Class Structure

```id="abs_v1"
abstract class Service
        |
        |-- abstract execute()
        |
Concrete Class
        |
        |-- execute() implementation
```

---

### Interface-Based Abstraction

```id="abs_v2"
Interface: Payment
        |
        |-- pay()
        |
        |-- CardPayment
        |-- UPIPayment
        |-- NetBankingPayment
```

Same method → Different hidden implementations.

---

### Caller Perspective

```id="abs_v3"
User
   |
   |-- calls method()
   |
Implementation hidden internally
```

---

## 3️⃣ Key Features / Properties

* Hides internal implementation
* Shows only essential methods
* Achieved via abstract classes & interfaces
* Cannot instantiate abstract class
* Abstract methods have no body
* Enables runtime polymorphism
* Supports loose coupling
* Promotes maintainability

---

## 4️⃣ Syntax

### Abstract Class

```java id="abs_s1"
abstract class Processor {

    abstract void process();

    void log() {
        System.out.println("Logging...");
    }
}
```

---

### Interface

```java id="abs_s2"
interface Notification {
    void send();
}
```

---

## 5️⃣ Code Example

```java id="abs_ex1"
abstract class Account {

    abstract void calculateInterest();

    void bankName() {
        System.out.println("ABC Bank");
    }
}

class SavingsAccount extends Account {

    @Override
    void calculateInterest() {
        System.out.println("Savings Interest Calculated");
    }

    public static void main(String[] args) {

        Account acc = new SavingsAccount();
        acc.calculateInterest();
        acc.bankName();
    }
}
```

Explanation:

* Abstract method declared in parent
* Implemented in child
* Parent reference holds child object
* Runtime polymorphism achieved

---

## 6️⃣ Use Cases

* Framework development
* API design
* Strategy pattern
* Payment systems
* Plugin architecture
* Standardizing behavior
* Large-scale enterprise systems

---

## 7️⃣ Pitfalls / Notes

* ❌ Trying to instantiate abstract class
* ❌ Not implementing abstract methods
* ❌ Confusing abstraction with encapsulation
* ❌ Overusing abstract classes unnecessarily
* ❌ Designing too many abstraction layers
* ❌ Breaking method contract in subclass

---

## 8️⃣ Real-World Analogy

🎛 Remote Control

* You press “Power On”
* You don’t know internal circuitry
* Only essential operation visible

Abstraction hides complexity.

---

## 9️⃣ Best Practices

* Use interface for complete abstraction
* Use abstract class for partial abstraction
* Keep abstraction meaningful
* Follow Liskov Substitution Principle
* Avoid deep inheritance trees
* Design clean and minimal contracts
* Prefer composition when suitable

---

## 🔟 Tricky Questions

1. What is abstraction?
   ➜ Hiding implementation details and exposing only essential behavior.

2. How is abstraction achieved in Java?
   ➜ Using abstract classes and interfaces.

3. Can abstract class have concrete methods?
   ➜ Yes.

4. Can abstract class be instantiated?
   ➜ No.

5. Can interface have implemented methods?
   ➜ Yes (default and static methods).

6. Does abstraction support runtime polymorphism?
   ➜ Yes.

7. Can constructor be abstract?
   ➜ No.

8. Can abstract class have constructor?
   ➜ Yes.

9. Must subclass implement all abstract methods?
   ➜ Yes, unless subclass is also abstract.

10. Can abstract method be private?
    ➜ No.

11. Can abstract method be static?
    ➜ No.

12. Which provides 100% abstraction conceptually?
    ➜ Interface.

13. What is difference between abstraction and encapsulation?
    ➜ Abstraction hides implementation; encapsulation hides data.

14. Why is abstraction important in system design?
    ➜ Reduces complexity and improves flexibility.

15. Is abstraction compile-time or runtime concept?
    ➜ Both (design-time concept + runtime polymorphism).

---

## 🧾 Quick Recap / Cheat Sheet

* Abstraction = Hide implementation
* Show only essential behavior
* Achieved via abstract class & interface
* Abstract class cannot be instantiated
* Abstract methods must be implemented
* Supports runtime polymorphism
* Promotes loose coupling
* Improves scalability
* Interface → full abstraction
* Abstract class → partial abstraction
* Important OOP pillar
* Used in frameworks
* Helps reduce complexity
* Clean contract design
* Common interview topic

---
