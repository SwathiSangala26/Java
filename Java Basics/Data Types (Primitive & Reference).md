# 1️⃣ Definition

A **Data Type** specifies:

* What kind of value a variable can store
* The memory size allocated
* The range of values allowed
* The operations that can be performed

In Java, data types are divided into:

```
Data Types
│
├── Primitive
└── Reference
```

---

# 2️⃣ Visual Representation

## 🔹 Primitive Type (Stores Value Directly)

```
Stack Memory
----------------
int a = 10;

a  ───► 10
```

✔ Variable holds actual value.

---

## 🔹 Reference Type (Stores Address)

```
Stack Memory                 Heap Memory
-----------------           -------------------
Person p  ───────►          [ Person Object ]
                             name = "Swathi"
```

✔ Variable holds memory address.
✔ Object stored in heap.

---

# 3️⃣ Key Features / Properties

---

## 🟢 Primitive Data Types (8 Types)

| Type    | Size          | Default Value | Range (Important for Interview) |
| ------- | ------------- | ------------- | ------------------------------- |
| byte    | 1 byte        | 0             | -128 to 127                     |
| short   | 2 bytes       | 0             | -32,768 to 32,767               |
| int     | 4 bytes       | 0             | -2³¹ to 2³¹-1                   |
| long    | 8 bytes       | 0L            | -2⁶³ to 2⁶³-1                   |
| float   | 4 bytes       | 0.0f          | ~6-7 decimal digits             |
| double  | 8 bytes       | 0.0d          | ~15 decimal digits              |
| char    | 2 bytes       | '\u0000'      | 0 to 65,535                     |
| boolean | JVM dependent | false         | true / false                    |

### ✔ Properties

* Stored in stack
* Fixed memory size
* Faster access
🟧 * Cannot be null
* Not objects

---

## 🔵 Reference Data Types

Examples:

* String
* Arrays
* Classes
* Interfaces
* Enums

### ✔ Properties

* Stored in heap
* Variable stores address
* Default value = null
* Can call methods
* Can be null

---

# 4️⃣ Syntax

## Primitive

```java
int age = 25;
double salary = 50000.50;
char grade = 'A';
boolean isPassed = true;
```

---

## Reference

```java
String name = "Swathi";
int[] arr = new int[5];
Person p = new Person();
```

---

# 5️⃣ Code Example

## 🔹 Primitive – Copy by Value

```java
int a = 10;
int b = a;
b = 20;

System.out.println(a); // 10
System.out.println(b); // 20
```

✔ Changing b does not affect a.

---

## 🔹 Reference – Copy of Address

```java
class Person {
    String name;
}

Person p1 = new Person();
p1.name = "Swathi";

Person p2 = p1;
p2.name = "Anirudh";

System.out.println(p1.name); // Anirudh
```

✔ Both refer to same object.

---

# 6️⃣ Use Cases

## Primitive

* Counters
* Mathematical calculations
* Flags
* Performance-critical variables

## Reference

* Object modeling
* Collections
* Large data structures
* Real-world entities

---

# 7️⃣ Pitfalls / Notes (Interview Important)

### ⚠ 🟧 Default Values (Only for instance variables)

```
Instance Variable → Gets default value
Local Variable → Must initialize manually
```

---

### ⚠ Wrapper Classes

Primitive types have corresponding wrapper classes:

| Primitive | Wrapper   |
| --------- | --------- |
| int       | Integer   |
| double    | Double    |
| char      | Character |
| boolean   | Boolean   |

✔ Needed for Collections (e.g., ArrayList<Integer>)
✔ Supports null
✔ Supports methods

---

### ⚠ Autoboxing / Unboxing

```java
Integer x = 10;  // Autoboxing
int y = x;       // Unboxing
```

---

### ⚠ Comparison Difference

```java
int a = 10;
int b = 10;
System.out.println(a == b); // true
```

```java
Integer x = 100;
Integer y = 100;
System.out.println(x == y); // true (cached)

Integer m = 200;
Integer n = 200;
System.out.println(m == n); // false (outside cache range)
```

✔ Integer cache range = -128 to 127

---

# 8️⃣ Real-World Analogy

### Primitive

Like writing a number on a paper.
You directly see the value.

### Reference

Like writing a house address.
You must go to that address to see the actual object.

---

# 9️⃣ Best Practices

✔ Use primitive types when possible (better performance)
✔ Use wrapper types when working with Collections
✔ Always initialize local variables
✔ Avoid unnecessary object creation

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. Where are primitive variables stored?

✔ In stack memory (if local variable).
✔ Instance primitives stored inside object in heap.

---

### ❓ 2. Can primitive types be null?

❌ No.

---

### ❓ 3. Why is boolean size JVM dependent?

Because Java specification does not define exact memory size.

---

### ❓ 4. Why does Integer 100 == 100 return true but 200 == 200 returns false?

Because of Integer caching (-128 to 127).

---

### ❓ 5. What happens if you compare two reference variables using == ?

✔ It compares memory addresses, not values.

---

### ❓ 6. Why can't we store primitives in ArrayList?

Because collections store objects, not primitive types.

---

### 🟧 7. What is the default value of local variables?

❌ No default value. Must initialize.

---

### ❓ 8. Difference between int and Integer?

| int            | Integer         |
| -------------- | --------------- |
| Primitive      | Object          |
| Cannot be null | Can be null     |
| Faster         | Slightly slower |
| No methods     | Has methods     |

---

# 🧾 Quick Recap / Cheat Sheet

```
Primitive
---------
• 8 types
• Stores value directly
• Faster
• Cannot be null
• Stack (local)

Reference
---------
• Stores address
• Objects in heap
• Can be null
• Supports methods
• Used in collections
```

---
