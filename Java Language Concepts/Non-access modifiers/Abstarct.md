## 🔹 What does `abstract` mean?

> `abstract` means **incomplete / partially implemented**.

It is used when:

* You want to **define what to do**
* But let **child classes decide how to do it**

---

## 🧭 Where `abstract` Can Be Used

![Image](https://i.sstatic.net/j4slM.png)

![Image](https://scaler.com/topics/images/abstract-keyword.webp)

* `abstract` **class**
* `abstract` **method**

---

## 1️⃣ Abstract Class

### 🔹 Definition

An abstract class:

* **Cannot be instantiated** (cannot create object)
* May contain **abstract and non-abstract methods**
* Can have variables, constructors, static methods

```java
abstract class Vehicle {
    int speed;

    abstract void start();   // abstract method

    void stop() {            // concrete method
        System.out.println("Vehicle stopped");
    }
}
```

❌ Not allowed:

```java
Vehicle v = new Vehicle(); // ❌ error
```

---

### 🧠 Key Points (Abstract Class)

* Can have **constructors**
* Can have **instance variables**
* Can have **static methods**
* Used for **partial abstraction**

---

## 2️⃣ Abstract Method

### 🔹 Definition

An abstract method:

* Has **no body**
* Must be implemented by the **child class**

```java
abstract class Animal {
    abstract void sound();
}
```

```java
class Dog extends Animal {
    void sound() {
        System.out.println("Bark");
    }
}
```

---

### ⚠ Rules for Abstract Methods

* Cannot be `private`
* Cannot be `final`
* Cannot be `static`
* Must be overridden in subclass (unless subclass is abstract)

---

## 📊 Abstract Class vs Concrete Class

| Feature          | Abstract Class | Concrete Class |
| ---------------- | -------------- | -------------- |
| Object creation  | ❌ No           | ✅ Yes          |
| Abstract methods | ✅ Allowed      | ❌ Not allowed  |
| Constructors     | ✅ Yes          | ✅ Yes          |
| Method body      | Optional       | Mandatory      |

---

## 📦 Memory Perspective (Important)

![Image](https://i.sstatic.net/j4slM.png)

![Image](https://scaler.com/topics/images/why-do-we-need-an-abstract-class-in-java.webp)

* Abstract class **loads into Method Area**
* Object is created **only for concrete subclass**
* Reference can be of abstract type

```java
Vehicle v = new Car(); // ✅ allowed
```

---

## 🔁 Abstract Class vs Interface (Quick View)

![Image](https://journaldev.nyc3.cdn.digitaloceanspaces.com/2013/07/abstract-class-vs-interface.png)

![Image](https://www.technolush.com/uploads/2020-01-11/banner/technolush-interface-vs-abstract-class-in-java-banner.jpg)

| Feature              | Abstract Class      | Interface                  |
| -------------------- | ------------------- | -------------------------- |
| Methods              | Abstract + concrete | Abstract (default allowed) |
| Variables            | Instance + static   | public static final only   |
| Multiple inheritance | ❌                   | ✅                          |
| Constructors         | ✅                   | ❌                          |

---

## ⚠ Common Interview Traps

❌ Abstract class cannot have constructor
✔ **It CAN**

❌ Abstract method can be private
✔ **It CANNOT**

❌ Abstract class means 100% abstraction
✔ Only **partial abstraction**

---

## 🎯 Interview One-Liners (MEMORIZE)

* Abstract class **cannot be instantiated**
* Abstract method **has no body**
* Child class **must implement abstract methods**
* Abstract class supports **partial abstraction**
* Reference can be abstract, object cannot

---

## 🧠 Memory Trick

> **Abstract = idea / blueprint**
> **Concrete class = real object**

---

## 📝 Ultra-Short Revision Notes

* `abstract` class → incomplete class
* `abstract` method → no body
* Cannot create object
* Used when behavior varies
