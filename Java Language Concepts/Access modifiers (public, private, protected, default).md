## 🔐 What are Access Modifiers?

Access modifiers define **where a class, method, variable, or constructor can be accessed from**.

Java has **4 access levels**:

1. `public`
2. `protected`
3. `default` *(package-private, no keyword)*
4. `private`

---

## 🧭 Access Levels (Most → Least)

```
public  → protected → default → private
```

---

## 1️⃣ `public`

### ✔ Scope

* Same class
* Same package
* Subclass (any package)
* Any class anywhere

### 📌 Example

```java
public class Employee {
    public int id;
}
```

### 🧠 Use when

* Creating APIs
* Methods meant for external access

---

## 2️⃣ `private`

### ✔ Scope

* **Only within the same class**

### ❌ Not accessible

* Same package
* Subclass
* Other classes

### 📌 Example

```java
class Account {
    private double balance;
}
```

### 🧠 Key points

* Used for **encapsulation**
* Cannot be overridden
* Inner classes can access private members

---

## 3️⃣ `default` (Package-private)

> Applied when **no modifier is specified**

### ✔ Scope

* Same class
* Same package

### ❌ Not accessible

* Outside package (even subclasses)

### 📌 Example

```java
class Car {
    int speed;   // default access
}
```

### 🧠 Key points

* Java has **no `internal` keyword**
* Default ≠ C# internal
* Access depends ONLY on package

---

## 4️⃣ `protected`

### ✔ Scope

* Same class
* Same package
* Subclasses (even in different packages)

### ❌ Not accessible

* Non-subclass classes in other packages

### 📌 Example

```java
class Vehicle {
    protected int maxSpeed;
}
```

### ⚠ Important Rule

In another package, `protected` members are accessible **ONLY through inheritance**, not via object reference.

---

## 📊 Comparison Table (MEMORIZE)

| Modifier  | Same Class | Same Package | Subclass (diff pkg) | Anywhere |
| --------- | ---------- | ------------ | ------------------- | -------- |
| public    | ✅          | ✅            | ✅                   | ✅        |
| protected | ✅          | ✅            | ✅                   | ❌        |
| default   | ✅          | ✅            | ❌                   | ❌        |
| private   | ✅          | ❌            | ❌                   | ❌        |

---

## 🚫 Where Access Modifiers Are NOT Allowed

| Location          | Allowed?                   |
| ----------------- | -------------------------- |
| Local variables   | ❌                          |
| Method parameters | ❌                          |
| Top-level classes | ❌ `private`, ❌ `protected` |
| Inner classes     | ✅ All modifiers            |

---

## 🧠 Important Interview Rules

* You **cannot reduce visibility** while overriding
* `private` methods **cannot be overridden**
* `protected` is **more visible than default**
* Package name must **match exactly**

---

## 📦 Package vs Project (VERY IMPORTANT)

* Access modifiers depend on **package**
* Project / module / IDE does **not matter**

---

## 🧠 Memory Trick

> **Private → Class
> Default → Package
> Protected → Package + Child
> Public → World**
