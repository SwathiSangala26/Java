## 1️⃣ Definition

A **Wrapper Class** in Java is a class that wraps (converts) a primitive data type into an object.

Java provides wrapper classes for all primitive types so they can be used in:

* Collections
* Generics
* Object-based APIs

Primitive → Wrapper mapping:

```
byte    → Byte
short   → Short
int     → Integer
long    → Long
float   → Float
double  → Double
char    → Character
boolean → Boolean
```

All wrapper classes are in `java.lang` package.

---

## 2️⃣ Visual Representation

### Primitive vs Wrapper

```
Primitive (int)
      |
      |  Boxing
      v
Wrapper (Integer)
```

---

### Autoboxing & Unboxing

```
int x = 10;

Integer obj = x;     // Autoboxing
int y = obj;         // Unboxing
```

---

### Memory View

```
Stack:  x = 10
Heap:   Integer object → 10
```

---

## 3️⃣ Key Features / Properties

* Wrap primitive into object
* Immutable classes
* Support autoboxing & unboxing
* Provide utility methods
* Used in Collections
* Extend `Number` (except Character & Boolean)
* Cached values (Integer: -128 to 127)
* Cannot modify internal value

---

## 4️⃣ Syntax

### Manual Boxing

```java
Integer obj = Integer.valueOf(10);
```

---

### Autoboxing

```java
Integer obj = 10;
```

---

### Unboxing

```java
int x = obj;
```

---

## 5️⃣ Code Example

```java
public class Main {

    public static void main(String[] args) {

        int primitive = 100;

        // Autoboxing
        Integer wrapper = primitive;

        // Unboxing
        int value = wrapper;

        System.out.println(wrapper);
        System.out.println(value);
    }
}
```

---

## 6️⃣ Use Cases

* Using primitives in Collections
* Generics
* Utility methods (parseInt, compare, etc.)
* Null handling
* Framework APIs
* Reflection usage

---

## 7️⃣ Pitfalls / Notes

* ❌ NullPointerException during unboxing
* ❌ Comparing using `==` instead of equals()
* ❌ Performance overhead (object creation)
* ❌ Integer caching confusion
* ❌ Wrapper objects are immutable
* ❌ Unnecessary boxing/unboxing

---

## 8️⃣ Real-World Analogy

📦 Gift Wrapping

* Primitive = raw item
* Wrapper = packed item
* Needed to use in certain systems

---

## 9️⃣ Best Practices

* Prefer primitives when possible
* Use equals() for comparison
* Avoid unnecessary boxing
* Be careful with null values
* Understand Integer caching
* Use valueOf() instead of new

---

## 🔟 Tricky Questions

1. What is wrapper class?
   ➜ Class that converts primitive into object.

2. Why wrapper classes needed?
   ➜ To use primitives in Collections and Generics.

3. What is autoboxing?
   ➜ Automatic conversion of primitive to wrapper.

4. What is unboxing?
   ➜ Wrapper object to primitive conversion.

5. Are wrapper classes immutable?
   ➜ Yes.

6. Does Integer cache values?
   ➜ Yes (-128 to 127).

7. What happens if Integer a = null; int b = a;?
   ➜ NullPointerException.

8. Can wrapper classes extend other classes?
   ➜ They extend Number (except Boolean & Character).

9. Which package contains wrapper classes?
   ➜ java.lang.

10. Difference between Integer and int?
    ➜ Integer is object; int is primitive.

11. Why equals() instead of ==?
    ➜ == compares reference; equals compares value.

12. Can wrapper class be used as Map key?
    ➜ Yes.

13. Is new Integer(10) recommended?
    ➜ No (use valueOf).

14. What is performance impact of boxing?
    ➜ Slight overhead.

15. Are wrapper classes thread-safe?
    ➜ Yes (immutable).

---

## 🧾 Quick Recap / Cheat Sheet

* Wrapper = Primitive → Object
* Used in Collections
* Autoboxing & Unboxing
* Immutable
* Integer cache (-128 to 127)
* valueOf() preferred
* equals() for comparison
* Can cause NPE during unboxing
* Extend Number (except Boolean, Character)
* Part of java.lang
* Required for Generics
* Object-based APIs need wrapper
* Slight performance overhead
* Important interview topic
* Understand caching behavior

---
