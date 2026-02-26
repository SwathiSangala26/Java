## 1️⃣ Definition

An Identifier is the **name given to a program element** such as:

* Class
* Variable
* Method
* Interface
* Package
* Object

It is used to uniquely identify these elements in a program.

---

## 2️⃣ Visual Representation

```
Identifier Used In:

Class Name     →  class Student
Variable Name  →  int age
Method Name    →  display()
Package Name   →  package com.demo
Object Name    →  Student s = new Student();
```

---

## 3️⃣ Rules for Identifiers

### ✅ Allowed Characters

* Letters (A–Z, a–z)
* Digits (0–9)
* Underscore (_)
* Dollar sign ($)

---

### ❌ Restrictions

1. Cannot start with a digit
   ❌ 1name
   ✔ name1

2. Cannot use Java keywords
   ❌ int class = 10;

3. No spaces
   ❌ student name
   ✔ studentName

4. No special characters
   ❌ name@
   ❌ total#

5. Case-sensitive
   age ≠ Age

6. Single underscore (_) is not allowed as identifier (Java 9+)

---

## 4️⃣ Syntax Examples

```java
int age;
String studentName;
double totalAmount;
class Employee {}
void calculateSalary() {}
```

All highlighted names are identifiers.

---

## 5️⃣ Code Example

```java
public class Student {

    int rollNumber;
    String name;

    void displayInfo() {
        System.out.println(name);
    }

    public static void main(String[] args) {
        Student obj = new Student();
        obj.name = "Swathi";
        obj.displayInfo();
    }
}
```

Identifiers used here:

* Student
* rollNumber
* name
* displayInfo
* obj

---

## 6️⃣ Use Cases

Identifiers are used to:

* Name classes
* Declare variables
* Define methods
* Create objects
* Define packages

Without identifiers, we cannot write a program.

---

## 7️⃣ Naming Conventions (Very Important for Interview)

### Class Name

PascalCase
✔ StudentDetails

### Variable / Method

camelCase
✔ totalAmount
✔ calculateSalary()

### Constant

UPPER_CASE
✔ MAX_VALUE

---

## 8️⃣ Pitfalls / Notes

* Java is case-sensitive
* Avoid using confusing names (l, O, 0)
* Avoid $ unless necessary
* Use meaningful names
* Identifier length has no strict limit

---

## 9️⃣ Real-World Analogy

Identifiers are like names given to people.

Without names, you cannot identify who is who.

---

## 🔟 Tricky Questions (With Answers)

Q1: Can identifier start with underscore?
Yes.

Q2: Can identifier start with $?
Yes (but not recommended).

Q3: Can identifier start with a digit?
No.

Q4: Can we use keyword as identifier?
No.

Q5: Is Java case-sensitive for identifiers?
Yes.

Q6: Is `_` alone valid identifier?
No (Java 9+).

Q7: Can identifiers contain Unicode characters?
Yes.

---

## 🧾 Quick Recap / Cheat Sheet

```
Identifier:
- Name of class, variable, method
- Cannot start with digit
- Cannot be keyword
- Case-sensitive
- No spaces
- Allowed: letters, digits, _, $
- Follow naming conventions
```

---
