## 1️⃣ Definition

A **Copy Constructor** is a constructor used to create a new object by copying the values of another object of the same class.

Java does **not provide built-in copy constructors** like C++, but we can create one manually.

Purpose:

* Copy object state
* Create duplicate objects
* Avoid reference sharing

---

## 2️⃣ Visual Representation

### Object Copy Concept

```
Object A
name = "Swathi"
age = 25
      |
      | Copy Constructor
      v
Object B
name = "Swathi"
age = 25
```

Two separate objects with same data.

---

### Reference vs Copy

```
Reference Copy
A ------> Object
B ------^

Copy Constructor
A ----> Object1
B ----> Object2
```

---

## 3️⃣ Key Features / Properties

* Constructor takes **same class object as parameter**
* Used to **copy object values**
* Creates **separate object in memory**
* Prevents reference sharing
* Works for **shallow copy unless deep copy implemented**
* Not automatically provided by Java

---

## 4️⃣ Syntax

```
ClassName(ClassName obj) {
    this.variable = obj.variable;
}
```

---

## 5️⃣ Code Example

```java
class Student {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Copy Constructor
    Student(Student s) {
        this.id = s.id;
        this.name = s.name;
    }

    void display() {
        System.out.println(id + " " + name);
    }

    public static void main(String[] args) {

        Student s1 = new Student(1, "Swathi");

        Student s2 = new Student(s1);  // Copy constructor

        s1.display();
        s2.display();
    }
}
```

---

## 6️⃣ Use Cases

* Copying objects safely
* Cloning object state
* Preventing reference sharing
* Creating backup objects
* Immutable object creation
* Data transfer objects

---

## 7️⃣ Pitfalls / Notes

* ❌ Java does not provide automatic copy constructor
* ❌ Only shallow copy unless deep copy implemented
* ❌ Mutable objects may still share references
* ❌ Forgetting to copy all fields
* ❌ Confusing reference copy with object copy

---

## 8️⃣ Real-World Analogy

📄 Photocopy of Document

* Original document remains unchanged
* Copy contains same information
* Both are separate papers

---

## 9️⃣ Best Practices

* Copy all fields properly
* Use deep copy for mutable fields
* Avoid unnecessary copying
* Use immutable objects when possible
* Document copy behavior clearly

---

## 🔟 Tricky Questions

1. What is copy constructor?
   ➜ Constructor that copies another object's values.

2. Does Java provide default copy constructor?
   ➜ No.

3. What parameter does copy constructor take?
   ➜ Object of same class.

4. What type of copy does copy constructor create by default?
   ➜ Shallow copy.

5. Can copy constructor create deep copy?
   ➜ Yes (if implemented manually).

6. What is difference between reference copy and object copy?
   ➜ Reference copy shares object; object copy creates new object.

7. Is copy constructor mandatory in Java?
   ➜ No.

8. How is copy constructor different from clone()?
   ➜ clone() uses Cloneable interface.

9. Can copy constructor be overloaded?
   ➜ Yes.

10. Can copy constructor call another constructor?
    ➜ Yes using `this()`.

11. Does copy constructor create new memory?
    ➜ Yes.

12. Can immutable classes need copy constructor?
    ➜ Usually no.

13. What happens if mutable field not deeply copied?
    ➜ Objects share reference.

14. Is copy constructor faster than clone()?
    ➜ Usually yes (simpler).

15. When should copy constructor be used?
    ➜ When safe object duplication required.

---

## 🧾 Quick Recap / Cheat Sheet

* Copy constructor copies object values
* Takes same class object as parameter
* Creates new object in memory
* Prevents reference sharing
* Java does not provide automatic copy constructor
* Used for object duplication
* Default behavior = shallow copy
* Deep copy must be implemented manually
* Helps in immutable design
* Alternative to clone()
* Avoid reference copying issues
* Important OOP concept
* Common interview question
* Useful for safe object creation
* Ensures object independence
