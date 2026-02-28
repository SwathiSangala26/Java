## 1️⃣ Definition

**Class** is a blueprint or template used to create objects.

**Object** is a real-world entity and instance of a class that contains:

* State (variables)
* Behavior (methods)

Class defines structure; Object represents actual implementation.

---

## 2️⃣ Visual Representation

### Blueprint Concept

```id="co1"
Class (Blueprint)
   |
   |-- variables
   |-- methods
   |
Object (Instance)
   |
   |-- actual values
```

---

### Multiple Objects from One Class

```id="co2"
Class: Car
   |
   |-- color
   |-- speed
   |
Objects:
   Car1 (Red, 100)
   Car2 (Blue, 120)
   Car3 (Black, 90)
```

---

### Memory Representation

```id="co3"
Stack                Heap
-----                -----
objRef  ---------->  Object Data
                     (variables + methods)
```

---

## 3️⃣ Key Features / Properties

* Class is a logical entity
* Object is a physical entity
* Class does not consume memory (until object created)
* Object consumes memory in heap
* Class can contain:

  * Variables
  * Methods
  * Constructors
  * Blocks
* Multiple objects can be created from same class

---

## 4️⃣ Syntax

### Class Declaration

```java id="cocode1"
class Student {
    int roll;
    String name;

    void display() {
        System.out.println(roll + " " + name);
    }
}
```

### Object Creation

```java id="cocode2"
Student s1 = new Student();
```

---

## 5️⃣ Code Example

```java id="cocode3"
class Student {

    int roll;
    String name;

    void display() {
        System.out.println(roll + " " + name);
    }

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.roll = 101;
        s1.name = "Swathi";
        s1.display();
    }
}
```

---

## 6️⃣ Use Cases

* Represent real-world entities
* Model business logic
* Encapsulation
* Data storage
* Object-Oriented Programming
* Application development
* System design

---

## 7️⃣ Pitfalls / Notes

* ❌ Not initializing object properly
* ❌ Forgetting to use constructor
* ❌ Confusing reference with object
* ❌ Memory leaks due to unused objects
* ❌ Not understanding heap vs stack
* ❌ Using too many global objects

---

## 8️⃣ Real-World Analogy

🏗 Blueprint & House

* Class → Blueprint
* Object → Actual house built using blueprint
* Blueprint does not occupy land
* House occupies land (memory)

---

## 9️⃣ Best Practices

* Follow naming conventions (Class → PascalCase)
* Initialize objects properly
* Use constructors
* Keep variables private (encapsulation)
* Avoid unnecessary object creation
* Use meaningful class design

---

## 🔟 Tricky Questions

1. What is a class?
   ➜ A blueprint for creating objects.

2. What is an object?
   ➜ An instance of a class.

3. Where are objects stored?
   ➜ Heap memory.

4. Where are references stored?
   ➜ Stack memory.

5. Does class consume memory?
   ➜ Only when loaded; object consumes heap memory.

6. Can multiple objects be created from one class?
   ➜ Yes.

7. What keyword creates object?
   ➜ `new`.

8. What happens when object is created?
   ➜ Memory allocated and constructor invoked.

9. Difference between object and reference?
   ➜ Reference points to object; object stores data.

10. Can class exist without object?
    ➜ Yes.

11. Can object exist without class?
    ➜ No.

12. What is instance variable?
    ➜ Variable defined inside class but outside method.

13. What is state of object?
    ➜ Values of instance variables.

14. What is behavior of object?
    ➜ Methods.

15. What happens if object reference is null?
    ➜ NullPointerException when accessed.

---

## 🧾 Quick Recap / Cheat Sheet

* Class = Blueprint
* Object = Instance
* Object stored in heap
* Reference stored in stack
* Created using `new`
* Class contains variables & methods
* Object has state & behavior
* Multiple objects per class
* Constructor initializes object
* Follow OOP principles
* Encapsulation recommended
* Avoid unnecessary object creation
* Core OOP concept
* Frequently asked in interviews
* Foundation of Java

---
