## 1️⃣ Definition

A **Wildcard** in Java generics is represented by `?` and is used to represent an unknown type.

It is mainly used in:

* Method parameters
* Generic APIs
* Flexible type relationships

Wildcards provide **flexibility** while maintaining **type safety**.

---

## 2️⃣ Visual Representation (Line Diagram)

---

### 🔹 Unbounded Wildcard

```text
List<?>

Can hold:
List<Integer>
List<String>
List<Double>
List<Object>
```

Meaning → "List of unknown type"

---

### 🔹 Upper Bounded Wildcard

```text
List<? extends Number>

            Number
           /   |    \
     Integer  Double  Float

Allowed:
List<Integer>
List<Double>
List<Float>
```

Restriction → Must be Number or subclass

---

### 🔹 Lower Bounded Wildcard

```text
List<? super Integer>

        Object
           ↑
        Number
           ↑
        Integer

Allowed:
List<Integer>
List<Number>
List<Object>
```

Restriction → Must be Integer or its parent

---

## 3️⃣ Key Features / Properties

---

### 1️⃣ Unbounded Wildcard `<?>`

```java
List<?> list;
```

* Accepts any type
* Cannot add elements (except null)
* Can only read as Object

---

### 2️⃣ Upper Bound `? extends Type`

```java
List<? extends Number>
```

* Read allowed
* Add NOT allowed
* Safe for covariance

---

### 3️⃣ Lower Bound `? super Type`

```java
List<? super Integer>
```

* Add allowed
* Read only as Object
* Safe for contravariance

---

### 4️⃣ Wildcards Used Only in Reference

❌ Not allowed in class declaration

```java
class Test<?> ❌
```

✔ Only used in usage side

---

## 4️⃣ Syntax

---

### Unbounded

```java
List<?> list;
```

---

### Upper Bound

```java
List<? extends Number> list;
```

---

### Lower Bound

```java
List<? super Integer> list;
```

---

## 5️⃣ Code Example

---

### Example 1 – Unbounded Wildcard

```java
import java.util.*;

public class Main {

    public static void printList(List<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
```

✔ Can read
❌ Cannot add

---

### Example 2 – Upper Bounded Wildcard

```java
import java.util.*;

public class Main {

    public static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number num : list) {
            sum += num.doubleValue();
        }
        return sum;
    }
}
```

✔ Can read as Number
❌ Cannot add new element

---

### Example 3 – Lower Bounded Wildcard

```java
import java.util.*;

public class Main {

    public static void addNumbers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }
}
```

✔ Can add Integer
❌ Reading gives Object

---

## 6️⃣ Use Cases

* Collection APIs
* Copy methods
* Read-only methods
* Write-only methods
* Framework design
* Generic utilities

---

## 7️⃣ Pitfalls / Notes

---

### ❌ 1️⃣ Cannot Add to `? extends`

```java
List<? extends Number> list = new ArrayList<Integer>();
list.add(10); ❌
```

Reason: Compiler doesn't know exact subtype.

---

### ❌ 2️⃣ Reading from `? super` Gives Object

```java
List<? super Integer> list;
Object obj = list.get(0);
```

---

### ❌ 3️⃣ Cannot Use Wildcard in Class Declaration

```java
class Test<?> ❌
```

---

### ❌ 4️⃣ Wildcards and Type Erasure

All wildcard info removed at runtime.

---

## 8️⃣ Real-World Analogy

Think of Wildcards like **Parking Rules** 🚗

---

### `? extends Number`

"Only small cars allowed"

You can observe cars
But you cannot insert a new unknown car

---

### `? super Integer`

"Parking space reserved for Integer or bigger vehicles"

You can park Integer
But when you take out vehicle, you only know it’s Object

---

### Unbounded `?`

"Any vehicle allowed"

You can see vehicle
But can't safely insert one

---

## 9️⃣ Best Practices

✔ Use `? extends` when only reading
✔ Use `? super` when only writing
✔ Remember PECS principle
✔ Avoid raw types
✔ Prefer bounded wildcards over Object

---

# 🔥 Tricky Interview Questions (With Answers)

Only related to Wildcards

---

### Q1: What is difference between `<T>` and `?`?

**Answer:**

`<T>` → Type parameter (declares new type)
`?` → Wildcard (unknown existing type)

---

### Q2: Why can’t we add to `List<? extends Number>`?

**Answer:**
Because compiler doesn't know exact subtype.

Example:

If it is `List<Double>`, adding Integer breaks type safety.

---

### Q3: Why can we add to `List<? super Integer>`?

**Answer:**
Because Integer is guaranteed to be compatible with its parent types.

---

### Q4: What does PECS stand for?

**Answer:**

Producer → Extends
Consumer → Super

If data is produced (read) → use extends
If data is consumed (write) → use super

---

### Q5: Which is more flexible?

```java
List<Object>
List<?>
```

Answer: `List<?>` is more flexible.

---

### Q6: Can wildcard be used in return type?

Yes.

```java
public List<?> method()
```

---

### Q7: What is difference between:

```java
List<Object>
List<?>
```

**Answer:**

* `List<Object>` → Only accepts Object list
* `List<?>` → Accepts list of any type

---

# 🧾 Quick Recap / Cheat Sheet

```text
Wildcard = ?

Types:
1. Unbounded  → List<?>
2. Upper      → List<? extends Type>
3. Lower      → List<? super Type>

Rules:
✔ extends → Read only
✔ super   → Write allowed
✔ Unbounded → Read as Object
❌ Cannot use in class declaration
❌ Cannot add to extends
❌ Cannot read specific type from super

PECS:
Producer → Extends
Consumer → Super
```

---
