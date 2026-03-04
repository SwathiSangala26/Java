## 1️⃣ Definition

An **Enum (Enumeration)** is a special type in Java used to define a fixed set of constants.

It is used when:

* Values are predefined
* Values are limited
* Type safety is required

Example: Days of week, Status codes, Roles, Directions.

---

## 2️⃣ Visual Representation

### Basic Enum

```id="en_v1"
enum Day
   |
   |-- MONDAY
   |-- TUESDAY
   |-- WEDNESDAY
```

---

### Enum Internally

```id="en_v2"
enum Status
   |
   |-- SUCCESS
   |-- FAILED
   |-- PENDING
```

Each constant is an object of enum type.

---

### Usage Flow

```id="en_v3"
Status s = Status.SUCCESS;
```

---

## 3️⃣ Key Features / Properties

* Declared using `enum` keyword
* Represents fixed constants
* Type-safe
* Each constant is an object
* Can have fields and methods
* Can have constructors (private)
* Can implement interfaces
* Cannot extend classes
* Implicitly extends `java.lang.Enum`

---

## 4️⃣ Syntax

### Basic Enum

```java id="en_s1"
enum Day {
    MONDAY, TUESDAY, WEDNESDAY;
}
```

---

### Enum with Fields and Constructor

```java id="en_s2"
enum Status {

    SUCCESS(200),
    ERROR(500);

    private int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
```

---

## 5️⃣ Code Example

```java id="en_ex1"
enum Level {

    LOW,
    MEDIUM,
    HIGH
}

public class Main {

    public static void main(String[] args) {

        Level level = Level.HIGH;

        switch (level) {
            case LOW:
                System.out.println("Low Level");
                break;
            case MEDIUM:
                System.out.println("Medium Level");
                break;
            case HIGH:
                System.out.println("High Level");
                break;
        }
    }
}
```

---

## 6️⃣ Use Cases

* Days of week
* Status codes
* Role definitions
* Direction values
* State machines
* Configuration types
* Replacing int constants

---

## 7️⃣ Pitfalls / Notes

* ❌ Cannot instantiate enum using `new`
* ❌ Cannot extend another class
* ❌ Constructors are always private
* ❌ Enum constants are implicitly static and final
* ❌ Overusing enum for dynamic data

---

## 8️⃣ Real-World Analogy

🎛 Traffic Light

* RED
* YELLOW
* GREEN

Fixed set of states. Cannot create new colors randomly.

---

## 9️⃣ Best Practices

* Use enum instead of int constants
* Keep enum meaningful
* Add fields if additional data needed
* Override `toString()` if required
* Use switch-case with enum
* Avoid dynamic usage

---

## 🔟 Tricky Questions

1. What is enum in Java?
   ➜ Special type representing fixed constants.

2. Can enum extend another class?
   ➜ No.

3. Which class does enum implicitly extend?
   ➜ `java.lang.Enum`.

4. Can enum have methods?
   ➜ Yes.

5. Can enum have constructors?
   ➜ Yes (private).

6. Can enum implement interface?
   ➜ Yes.

7. Can we create enum object using new?
   ➜ No.

8. Are enum constants objects?
   ➜ Yes.

9. Are enum constants static?
   ➜ Yes.

10. Are enum constants final?
    ➜ Yes.

11. Can enum be abstract?
    ➜ No.

12. Can enum be used in switch?
    ➜ Yes.

13. Is enum type-safe?
    ➜ Yes.

14. Can enum override methods?
    ➜ Yes.

15. Why prefer enum over constants?
    ➜ Type safety and better readability.

---

## 🧾 Quick Recap / Cheat Sheet

* Enum = Fixed set of constants
* Declared using `enum`
* Type-safe
* Each constant is an object
* Cannot extend class
* Can implement interface
* Constructors are private
* Extends java.lang.Enum
* Used in switch-case
* Replaces int constants
* Constants are static & final
* Cannot instantiate with new
* Improves readability
* Common interview topic
* Good for state representation

---
