## 1️⃣ Definition

**Composition** is a strong form of Aggregation that represents a **strong “has-a” relationship**.

In Composition:

* One class owns another class
* The contained object **cannot exist independently**
* Lifecycle of part depends on whole

It represents a **whole–part relationship (strong ownership)**.

---

## 2️⃣ Visual Representation

### Basic Composition

```id="cp_v1"
House  --------->  Room
 (whole)            (part)
```

Room cannot exist without House.

---

### Lifecycle Dependency

```id="cp_v2"
House deleted
     |
Room automatically destroyed
```

---

### UML Representation (Conceptual)

```id="cp_v3"
House ◆------ Room
(Filled diamond → Composition)
```

---

## 3️⃣ Key Features / Properties

* Strong relationship
* Type of Association
* Dependent lifecycle
* Strong ownership
* Part created inside whole
* Tight coupling
* Promotes encapsulation

---

## 4️⃣ Syntax

```java id="cp_s1"
class Engine {
}

class Car {

    private Engine engine = new Engine();   // Composition
}
```

Object created inside container class.

---

## 5️⃣ Code Example

```java id="cp_ex1"
class Heart {

    void beat() {
        System.out.println("Heart is beating");
    }
}

class Human {

    private Heart heart;

    Human() {
        heart = new Heart();   // Composition
    }

    void live() {
        heart.beat();
    }

    public static void main(String[] args) {

        Human h = new Human();
        h.live();
    }
}
```

Explanation:

* Heart created inside Human
* Heart cannot exist independently
* Strong ownership relationship

---

## 6️⃣ Use Cases

* Engine inside Car (strong ownership)
* Heart inside Human
* Room inside House
* Laptop and Processor
* Game and PlayerState
* Domain-driven design models

---

## 7️⃣ Pitfalls / Notes

* ❌ Confusing with aggregation
* ❌ Tight coupling reduces flexibility
* ❌ Hard to reuse part independently
* ❌ Overusing composition unnecessarily
* ❌ Circular references

---

## 8️⃣ Real-World Analogy

🏠 House and Foundation

* Foundation cannot exist without House
* If house is destroyed, foundation is gone
* Strong ownership

---

## 9️⃣ Best Practices

* Use when lifecycle dependency exists
* Keep internal objects private
* Avoid exposing internal structure
* Prefer composition over inheritance (design principle)
* Ensure strong ownership is logically correct
* Avoid deep object nesting

---

## 🔟 Tricky Questions

1. What is composition?
   ➜ Strong “has-a” relationship.

2. Is composition a type of association?
   ➜ Yes.

3. Does composed object depend on container lifecycle?
   ➜ Yes.

4. What UML symbol represents composition?
   ➜ Filled diamond.

5. What is difference between aggregation and composition?
   ➜ Aggregation is weak; composition is strong ownership.

6. Can composed object exist independently?
   ➜ No.

7. Does composition promote encapsulation?
   ➜ Yes.

8. Is composition tightly coupled?
   ➜ Yes.

9. Who creates composed object?
   ➜ Container class.

10. Is inheritance involved in composition?
    ➜ No.

11. When should composition be used?
    ➜ When strong ownership exists.

12. Does composition improve modularity?
    ➜ Yes.

13. Can composition be one-to-many?
    ➜ Yes.

14. Why prefer composition over inheritance?
    ➜ More flexible design.

15. Is lifecycle shared in composition?
    ➜ Yes.

---

## 🧾 Quick Recap / Cheat Sheet

* Composition = Strong has-a relationship
* Type of association
* Dependent lifecycle
* Strong ownership
* UML → Filled diamond
* Object created inside container
* Tight coupling
* Promotes encapsulation
* Cannot exist independently
* Different from aggregation
* No inheritance involved
* Prefer over inheritance in many designs
* Common in system design
* Important OOP concept
* Frequently asked interview topic

---
