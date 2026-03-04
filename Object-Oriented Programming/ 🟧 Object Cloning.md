## 1️⃣ Definition

**Object Cloning** is the process of creating an **exact copy of an existing object**.

In Java, cloning is done using:

* `Cloneable` interface (marker interface)
* `clone()` method from `Object` class

The cloned object contains the **same values as the original object but exists in a different memory location**.

---

## 2️⃣ Visual Representation

### Cloning Concept

```
Original Object
name = "Swathi"
age = 25
      |
      | clone()
      v
Cloned Object
name = "Swathi"
age = 25
```

Two different objects with the same values.

---

### Memory View

```
Heap
  |
  |-- Object A → {id=1, name="Java"}
  |
  |-- Object B → {id=1, name="Java"}  (clone)
```

---

### Shallow vs Deep Copy

```
Shallow Copy
ObjectA ----> Address1
ObjectB ----^

Deep Copy
ObjectA ----> Address1
ObjectB ----> Address2
```

---

## 3️⃣ Key Features / Properties

* Creates duplicate object
* Uses `clone()` method
* Class must implement `Cloneable`
* Default cloning is **shallow copy**
* Object class provides `clone()` method
* Throws `CloneNotSupportedException` if not implemented
* Faster than manual copying

---

## 4️⃣ Syntax

Class must implement Cloneable:

```java
class Student implements Cloneable
```

Clone method call:

```java
Student s2 = (Student) s1.clone();
```

---

## 5️⃣ Code Example

```java
class Student implements Cloneable {

    int id;
    String name;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws Exception {

        Student s1 = new Student(1, "Swathi");

        Student s2 = (Student) s1.clone();

        System.out.println(s1.id + " " + s1.name);
        System.out.println(s2.id + " " + s2.name);
    }
}
```

---

## 6️⃣ Use Cases

* Object duplication
* Copying configuration objects
* Snapshot creation
* Game state copying
* Performance optimization
* Prototype design pattern

---

## 7️⃣ Pitfalls / Notes

* ❌ Default clone performs shallow copy
* ❌ Mutable objects may share references
* ❌ Must implement `Cloneable` interface
* ❌ clone() returns Object (needs casting)
* ❌ Throws CloneNotSupportedException
* ❌ Often replaced by copy constructors

---

## 8️⃣ Real-World Analogy

📄 Photocopy Machine

* Original document → copy produced
* Both contain same content
* Stored in separate paper

---

## 9️⃣ Best Practices

* Prefer copy constructors in modern Java
* Implement deep copy if needed
* Override clone() properly
* Handle CloneNotSupportedException
* Avoid cloning mutable shared objects

---

## 🔟 Tricky Questions

1. What is object cloning?
   ➜ Creating exact copy of an object.

2. Which method is used for cloning?
   ➜ `clone()`.

3. Which interface required for cloning?
   ➜ `Cloneable`.

4. Is Cloneable a marker interface?
   ➜ Yes.

5. Where is clone() method defined?
   ➜ `Object` class.

6. What type does clone() return?
   ➜ `Object`.

7. Why casting required after cloning?
   ➜ Because clone() returns Object.

8. What happens if Cloneable not implemented?
   ➜ CloneNotSupportedException.

9. What type of copy clone() creates by default?
   ➜ Shallow copy.

10. What is deep copy?
    ➜ Copying all referenced objects.

11. Is clone() protected in Object class?
    ➜ Yes.

12. Why override clone() method?
    ➜ To make it accessible.

13. Is cloning faster than manual copying?
    ➜ Usually yes.

14. Is object cloning recommended today?
    ➜ Often replaced by copy constructors.

15. Which design pattern uses cloning?
    ➜ Prototype pattern.

---

## 🧾 Quick Recap / Cheat Sheet

* Cloning = Object duplication
* Uses clone() method
* Requires Cloneable interface
* Cloneable is marker interface
* clone() defined in Object class
* Default cloning = shallow copy
* Deep copy must be implemented manually
* clone() returns Object
* Casting required
* Throws CloneNotSupportedException
* Faster duplication method
* Used in Prototype pattern
* Often replaced by copy constructor
* Important interview topic
* Understand shallow vs deep copy clearly
