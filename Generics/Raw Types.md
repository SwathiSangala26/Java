## 1️⃣ Definition

A **Raw Type** is a generic class or interface used **without specifying its type parameter**.

Example:

```java
List list;          // Raw type
Box box;            // Raw type
```

Instead of:

```java
List<String> list;
Box<Integer> box;
```

Raw types exist mainly for **backward compatibility (Java 1.4 and earlier)**.

⚠ Using raw types removes generic type safety.

---

## 2️⃣ Visual Representation (Line Diagram)

---

### 🔹 Generic Type

```text
List<String>

Compile-time:
Type safe

Runtime:
List
```

---

### 🔹 Raw Type

```text
List

Compile-time:
No type safety

Runtime:
List
```

---

### 🔹 What Happens Internally

```text
List<String>  →  Type erased → List
List<Integer> →  Type erased → List
List          →  Already raw → List
```

Raw type behaves as if generic type never existed.

---

## 3️⃣ Key Features / Properties

---

### 1️⃣ No Type Parameter

```java
List list = new ArrayList();
```

No `<T>` specified.

---

### 2️⃣ Allows Mixed Types

```java
List list = new ArrayList();
list.add("Hello");
list.add(10);
list.add(3.14);
```

✔ Compiles
❌ Unsafe

---

### 3️⃣ Causes Unchecked Warning

Compiler shows:

```text
Unchecked call to add(E)
```

Because generics safety is bypassed.

---

### 4️⃣ Breaks Compile-Time Safety

```java
List list = new ArrayList();
list.add("Hello");

Integer num = (Integer) list.get(0);  // Runtime error
```

❌ ClassCastException

---

### 5️⃣ Raw Type Can Be Assigned From Generic

```java
List<String> list1 = new ArrayList<>();
List list2 = list1;   // Allowed but unsafe
```

Compiler gives warning.

---

## 4️⃣ Syntax

---

### Generic Type

```java
List<String> list = new ArrayList<>();
```

---

### Raw Type

```java
List list = new ArrayList();
```

---

### Raw Custom Generic Class

```java
class Box<T> {
    T value;
}

Box box = new Box();  // Raw type
```

---

## 5️⃣ Code Example

---

### Example 1 – Raw Type Problem

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List list = new ArrayList();

        list.add("Java");
        list.add(100);

        String str = (String) list.get(1); // Runtime ClassCastException
    }
}
```

---

### Example 2 – Safe Generic Version

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Java");
        // list.add(100); ❌ Compile-time error

        String str = list.get(0);
    }
}
```

---

## 6️⃣ Use Cases

Raw types are mainly used for:

* Backward compatibility
* Interacting with legacy code (pre-Java 5)
* Rare reflection scenarios

⚠ Modern code should avoid raw types.

---

## 7️⃣ Pitfalls / Notes

---

### ❌ 1️⃣ Removes Type Safety

```java
List list = new ArrayList();
```

Allows any object type.

---

### ❌ 2️⃣ Causes Runtime Errors

ClassCastException possible.

---

### ❌ 3️⃣ Generates Unchecked Warning

```text
Note: uses unchecked or unsafe operations
```

---

### ❌ 4️⃣ Mixing Raw and Generic Types Is Dangerous

```java
List<String> list = new ArrayList<>();
List rawList = list;

rawList.add(100);  // Compiles

String str = list.get(0);  // Runtime error
```

Very important interview scenario.

---

### ❌ 5️⃣ Raw Type vs Wildcard Difference

Raw:

```java
List list;
```

Wildcard:

```java
List<?> list;
```

Raw → Unsafe
Wildcard → Type safe (read-only)

---

## 8️⃣ Real-World Analogy

Think of Raw Type like **a box without labeling** 📦

Generic box:

```text
Box<String>
```

Label says: Only Strings allowed.

Raw box:

```text
Box
```

No label.
Anyone can put anything inside.

Later when you take it out — you might get surprised 😅

---

## 9️⃣ Best Practices

✔ Avoid raw types in new code
✔ Always use parameterized types
✔ Never mix raw and generic types
✔ Use wildcard instead of raw if flexibility needed
✔ Fix unchecked warnings

---

# 🔥 Tricky Interview Questions (With Answers)

Only related to Raw Types.

---

### Q1: What is a Raw Type?

**Answer:**
A generic class or interface used without specifying its type parameter.

---

### Q2: Why are Raw Types allowed?

**Answer:**
For backward compatibility with Java versions before generics (Java 1.5).

---

### Q3: What is the risk of Raw Types?

**Answer:**
Loss of compile-time type safety → Runtime ClassCastException.

---

### Q4: What happens when we assign generic to raw?

```java
List<String> list = new ArrayList<>();
List raw = list;
```

**Answer:**
Allowed but compiler shows unchecked warning.
Raw reference can insert wrong type.

---

### Q5: Difference between Raw Type and `<?>`?

| Raw Type      | Wildcard                 |
| ------------- | ------------------------ |
| `List`        | `List<?>`                |
| Not type-safe | Type-safe (read-only)    |
| Allows add    | Cannot add (except null) |
| Unsafe        | Safer                    |

---

### Q6: What happens at runtime for raw type?

**Answer:**
It behaves exactly like erased type.
No generic type information exists.

---

### Q7: Is Raw Type same as Type Erasure?

**Answer:**
No.

* Type Erasure → Compiler process
* Raw Type → Programmer explicitly omits type parameter

---

# 🧾 Quick Recap / Cheat Sheet

```text
Raw Type = Generic type without type parameter

Example:
List list = new ArrayList();

Effects:
✔ Allowed for backward compatibility
❌ No type safety
❌ Unchecked warnings
❌ Possible ClassCastException

Avoid:
• Mixing raw & generic
• Using in modern code

Raw vs Wildcard:
List     → Unsafe
List<?>  → Safe (read-only)
```

---
