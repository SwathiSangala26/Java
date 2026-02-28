# 1️⃣ Definition

### 🔹 Default Method

A **default method** is a method inside an interface that has a **method body** and is marked with the `default` keyword.

It allows adding new methods to interfaces **without breaking existing implementations**.

---

### 🔹 Static Method

A **static method** in an interface belongs to the interface itself and is accessed using the interface name.

---

# 2️⃣ Visual Representation

---

### Before Java 8

```text
Interface
   ↓
Only Abstract Methods
   ↓
Implementing Class MUST implement all methods
```

---

### After Java 8

```text
Interface
   ↓
Abstract Methods
Default Methods (with body)
Static Methods (with body)
```

---

### Default Method Flow

```text
Interface
   ↓
Default Method
   ↓
Implementing Class
   ↓
(Optional Override)
```

---

### Static Method Flow

```text
Interface
   ↓
Static Method
   ↓
Called using InterfaceName.method()
```

---

# 3️⃣ Key Features / Properties

### Default Methods

1. Have method body
2. Use `default` keyword
3. Can be overridden
4. Allow backward compatibility
5. Help evolve interfaces
6. Support multiple inheritance of behavior
7. Access other interface methods

---

### Static Methods

1. Belong to interface
2. Cannot be overridden
3. Accessed using Interface name
4. Used for utility/helper methods
5. Not inherited by implementing class

---

# 4️⃣ Syntax

---

### Default Method

```java
interface A {
    default void show() {
        System.out.println("Default method");
    }
}
```

---

### Static Method

```java
interface A {
    static void display() {
        System.out.println("Static method");
    }
}
```

---

# 5️⃣ Code Example

---

### Default Method Example

```java
interface Vehicle {
    default void start() {
        System.out.println("Vehicle starting...");
    }
}

class Car implements Vehicle {
}
```

Usage:

```java
Car c = new Car();
c.start();
```

---

### Overriding Default Method

```java
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car starting...");
    }
}
```

---

### Static Method Example

```java
interface MathUtil {
    static int add(int a, int b) {
        return a + b;
    }
}
```

Usage:

```java
int result = MathUtil.add(10, 20);
```

---

# 6️⃣ Use Cases

1. Adding new methods to existing interfaces
2. Providing common behavior
3. Avoid breaking legacy code
4. Utility/helper methods in interfaces
5. Multiple inheritance of behavior
6. API evolution
7. Backward compatibility (e.g., Collection interface in Java 8)

---

# 7️⃣ Pitfalls / Notes

1. Default methods can cause **diamond problem**
2. Static methods cannot be overridden
3. Static methods are not inherited
4. Class methods take priority over default methods
5. Must explicitly resolve conflict if two interfaces define same default method
6. Cannot declare default method as abstract
7. Cannot use `super` outside resolution context
8. Static method cannot access instance members

---

### 🔹 Diamond Problem Scenario

```java
interface A {
    default void show() { }
}

interface B {
    default void show() { }
}

class C implements A, B {
}
```

Compilation error.

---

### Resolution

```java
class C implements A, B {
    @Override
    public void show() {
        A.super.show();
    }
}
```

---

# 8️⃣ Real-World Analogy

Think of interface like a **rule book**.

Before Java 8:
Only rules (abstract methods).

After Java 8:
Rule book also gives **standard instructions (default methods)**
and **utility functions (static methods)**.

---

# 9️⃣ Best Practices

1. Use default methods for backward compatibility
2. Avoid too much logic in default methods
3. Use static methods for utilities
4. Always resolve conflicts explicitly
5. Keep interface clean and minimal
6. Avoid complex inheritance chains
7. Prefer composition over multiple interface behavior conflicts
8. Document default method behavior clearly

---

# 🔥 Tricky Questions (Interview Level)

(Continuous numbering)

---

### 1️⃣ Why were default methods introduced?

To allow interface evolution without breaking existing implementations.

---

### 2️⃣ Can default method be overridden?

Yes.

---

### 3️⃣ Can static method be overridden?

No.

---

### 4️⃣ Are static methods inherited?

No.

---

### 5️⃣ What happens if class and interface both have same method?

Class method gets priority.

---

### 6️⃣ What is diamond problem in interfaces?

When two interfaces provide same default method and class implements both.

---

### 7️⃣ How to resolve default method conflict?

Override in implementing class and specify:

```java
InterfaceName.super.method();
```

---

### 8️⃣ Can default method be abstract?

No.

---

### 9️⃣ Can default method be private?

Default → No
Private methods allowed (Java 9+) but not default.

---

### 🔟 Can interface static method access default method?

Yes, but must use instance reference passed.

---

### 1️⃣1️⃣ Can we call static method using object?

No. Must use interface name.

---

### 1️⃣2️⃣ What is priority order?

1. Class method
2. Sub-interface default
3. Parent interface default

---

### 1️⃣3️⃣ Can default method access static method?

Yes.

---

### 1️⃣4️⃣ Can interface have constructor?

No.

---

### 1️⃣5️⃣ Can default method use this keyword?

Yes. Refers to implementing class instance.

---

### 1️⃣6️⃣ Can we have final default method?

No. Cannot use final modifier.

---

### 1️⃣7️⃣ Can abstract class override default method?

Yes.

---

### 1️⃣8️⃣ Is default method part of object class?

No. It belongs to interface.

---

### 1️⃣9️⃣ Why static methods are not inherited?

To avoid ambiguity and maintain clarity.

---

### 2️⃣0️⃣ Can default method call private method inside interface?

Yes (Java 9+).

---

# 🧾 Quick Recap / Cheat Sheet

* Introduced in Java 8
* default → method with body
* static → belongs to interface
* Default methods support backward compatibility
* Static methods are not inherited
* Class method overrides default method
* Diamond problem possible
* Resolve using InterfaceName.super.method()
* Cannot override static method
* Private methods allowed (Java 9+)
* Used for API evolution

---
