## 1️⃣ Definition

An **Interface** is a reference type in Java that defines a contract.

It contains:

* Abstract methods (by default public & abstract)
* Constants (public static final)
* Default methods (Java 8+)
* Static methods (Java 8+)
* Private methods (Java 9+)

A class implements an interface using the `implements` keyword.

---

## 2️⃣ Visual Representation

### Basic Structure

```id="int_v1"
interface Payment
      |
      |-- pay()
      |
Class
      |
      |-- implements pay()
```

---

### Multiple Implementation

```id="int_v2"
Interface A
Interface B
      |
      |-- Class implements A, B
```

---

### Runtime Polymorphism

```id="int_v3"
Payment ref = new CardPayment();
ref.pay();   --> CardPayment version executes
```

---

## 3️⃣ Key Features / Properties

* Declared using `interface` keyword
* Cannot be instantiated
* Methods are public by default
* Variables are public static final
* Supports multiple inheritance
* Enables 100% abstraction (conceptually)
* Supports default and static methods (Java 8+)
* Promotes loose coupling

---

## 4️⃣ Syntax

```java id="int_s1"
interface Notification {

    void send();   // public abstract by default
}
```

---

### Implementing Interface

```java id="int_s2"
class EmailNotification implements Notification {

    @Override
    public void send() {
        System.out.println("Email sent");
    }
}
```

---

## 5️⃣ Code Example

```java id="int_ex1"
interface Payment {

    void pay();
}

class UPIPayment implements Payment {

    @Override
    public void pay() {
        System.out.println("Payment via UPI");
    }
}

public class Main {

    public static void main(String[] args) {

        Payment p = new UPIPayment();
        p.pay();   // Runtime polymorphism
    }
}
```

Explanation:

* Interface defines contract
* Class implements it
* Parent reference holds child object
* Runtime method selection

---

## 6️⃣ Use Cases

* API design
* Strategy pattern
* Plugin systems
* Microservices architecture
* Loose coupling
* Dependency injection
* Multiple inheritance support

---

## 7️⃣ Pitfalls / Notes

* ❌ Cannot create object of interface
* ❌ All variables are constants
* ❌ Methods must be implemented (unless default)
* ❌ Cannot have constructors
* ❌ Overusing interfaces unnecessarily
* ❌ Confusing interface with abstract class

---

## 8️⃣ Real-World Analogy

📄 Contract Agreement

* Interface → Contract
* Implementing class → Party fulfilling contract
* Contract defines rules
* Implementation defines execution

---

## 9️⃣ Best Practices

* Use interface for full abstraction
* Keep interface minimal
* Follow Interface Segregation Principle
* Use default methods carefully
* Prefer interface for loose coupling
* Avoid large “God” interfaces

---

## 🔟 Tricky Questions

1. What is an interface?
   ➜ A contract that defines abstract methods.

2. Can interface be instantiated?
   ➜ No.

3. What are default access modifiers of interface methods?
   ➜ Public and abstract.

4. What are interface variables by default?
   ➜ Public static final.

5. Can interface have constructors?
   ➜ No.

6. Can interface extend another interface?
   ➜ Yes.

7. Can class implement multiple interfaces?
   ➜ Yes.

8. Does interface support multiple inheritance?
   ➜ Yes (via interfaces).

9. Can interface have concrete methods?
   ➜ Yes (default and static methods).

10. Can interface have private methods?
    ➜ Yes (Java 9+).

11. Can interface have main method?
    ➜ Yes (static method).

12. What keyword is used to implement interface?
    ➜ `implements`.

13. Difference between abstract class and interface?
    ➜ Interface supports multiple inheritance; abstract class does not.

14. Must implementing class override all methods?
    ➜ Yes, unless class is abstract.

15. Does interface support runtime polymorphism?
    ➜ Yes.

---

## 🧾 Quick Recap / Cheat Sheet

* Interface = Contract
* Declared using `interface`
* Cannot instantiate
* Methods public abstract by default
* Variables public static final
* Supports multiple inheritance
* Use `implements` keyword
* Supports default & static methods
* Promotes loose coupling
* Used in API design
* Enables runtime polymorphism
* Important OOP concept
* Frequently asked in interviews
* Prefer for abstraction
* Keep interfaces small and focused

---
