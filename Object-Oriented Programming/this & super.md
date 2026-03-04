## 1️⃣ Definition

### 🟧 `this`

`this` is a reference variable that refers to the **current object**.

Used to:

* Refer current class instance variables
* Call current class methods
* Invoke current class constructor
* Pass current object

---

### `super`

`super` is a reference variable that refers to the **parent class object**.

Used to:

* Access parent class variables
* Call parent class methods
* Invoke parent class constructor

---

## 2️⃣ Visual Representation

### this Reference

```id="ts_v1"
Current Object
     |
     |-- this.variable
     |-- this.method()
```

---

### super Reference

```id="ts_v2"
Child Class
     |
     |-- super.variable
     |-- super.method()
     |-- super()
```

---

### Constructor Flow

```id="ts_v3"
Create Child Object
       |
       |-- super()  --> Parent constructor
       |
       |-- Child constructor
```

---

## 3️⃣ Key Features / Properties

### this

* Refers to current object
* Resolves instance variable conflict
* Used in constructor chaining
* Cannot be used in static context

### super

* Refers to parent class object
* Used to access hidden parent members
* Used to call parent constructor
* Must be first statement in constructor

---

## 4️⃣ Syntax

### Using this

```java id="ts_s1"
class Student {

    int roll;

    Student(int roll) {
        this.roll = roll;
    }
}
```

---

### Using super

```java id="ts_s2"
class Parent {
    int value = 10;
}

class Child extends Parent {

    int value = 20;

    void display() {
        System.out.println(super.value);
    }
}
```

---

## 5️⃣ Code Example

```java id="ts_ex1"
class Person {

    Person() {
        System.out.println("Parent Constructor");
    }

    void show() {
        System.out.println("Parent Method");
    }
}

class Employee extends Person {

    Employee() {
        super();   // Calls parent constructor
        System.out.println("Child Constructor");
    }

    void show() {
        super.show();  // Calls parent method
        System.out.println("Child Method");
    }

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.show();
    }
}
```

---

## 6️⃣ Use Cases

* Resolving variable shadowing
* Constructor chaining
* Accessing parent methods
* Calling parent constructor
* Avoiding ambiguity
* Inheritance-based design

---

## 7️⃣ Pitfalls / Notes

* ❌ Cannot use `this` in static method
* ❌ `super()` must be first statement
* ❌ Cannot use both `this()` and `super()` in same constructor
* ❌ Forgetting parent constructor call
* ❌ Misunderstanding variable hiding

---

## 8️⃣ Real-World Analogy

🏢 Company Hierarchy

* `this` → Refers to current employee
* `super` → Refers to manager

Child can refer to its own data or parent's data.

---

## 9️⃣ Best Practices

* Use `this` to resolve naming conflicts
* Use `super` only when necessary
* Keep constructor chaining clean
* Avoid unnecessary shadowing
* Understand constructor execution order
* Maintain clear inheritance structure

---

## 🔟 Tricky Questions

1. What is `this` keyword?
   ➜ Reference to current object.

2. What is `super` keyword?
   ➜ Reference to parent class object.

3. Can `this` be used in static method?
   ➜ No.

4. Can `super` be used in static method?
   ➜ No.

5. Where must `super()` appear?
   ➜ First statement in constructor.

6. Can we use `this()` and `super()` in same constructor?
   ➜ No.

7. What is constructor chaining?
   ➜ Calling one constructor from another.

8. What happens if `super()` not written?
   ➜ Compiler adds it implicitly.

9. When do we use `this.variable`?
   ➜ To resolve variable shadowing.

10. Can `super` access private members?
    ➜ No (not directly).

11. What happens if parent has no default constructor?
    ➜ Must explicitly call parameterized `super()`.

12. Can `this` return current object?
    ➜ Yes.

13. Can `super` call overridden method?
    ➜ Yes.

14. What is execution order of constructors?
    ➜ Parent → Child.

15. Are `this` and `super` variables stored in memory?
    ➜ They are references handled by JVM.

---

## 🧾 Quick Recap / Cheat Sheet

* `this` → current object reference
* `super` → parent class reference
* Use `this` for variable conflict
* Use `super` to access parent members
* `super()` must be first statement
* Cannot use both `this()` & `super()` together
* Parent constructor executes first
* Not allowed in static context
* Used in inheritance
* Helps avoid ambiguity
* Supports constructor chaining
* Important OOP concept
* Frequently asked interview topic
* Understand execution flow
* Avoid unnecessary shadowing

---
