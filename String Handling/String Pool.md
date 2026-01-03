## 1️⃣ What is String Constant Pool?

🎯 **Start with this:**

> “The String Constant Pool is a special memory area inside the heap where Java stores unique string literals.”

Pause. This sets the base clearly.

---

## 2️⃣ Where is SCP located?

> “Since Java 7, the String Constant Pool is part of the heap memory.
> Before Java 7, it was stored in PermGen.”

This shows **version awareness**.

---

## 3️⃣ Why does SCP exist?

> “Strings are used very frequently in Java.
> If every identical string created a new object, it would waste a lot of memory.
> So Java stores only one copy of each unique string literal in the pool.”

Key idea: **memory optimization**.

---

## 4️⃣ How SCP works (with example)

```java
String s1 = "java";
String s2 = "java";
```

### JVM behavior:

1. JVM checks the String Constant Pool
2. If `"java"` exists → reuse it
3. If not → create it once and store it

```java
s1 == s2   // true
```

🎯 Key line:

> “Multiple references can point to the same pooled string.”

---

## 5️⃣ Why sharing is safe

> “Strings are immutable, so pooled strings can be safely shared across the application and across threads.”

This links **immutability + SCP** (very important).

---

## 6️⃣ SCP vs normal heap objects (clarity)

| Feature    | String Constant Pool | Normal Heap |
| ---------- | -------------------- | ----------- |
| Stores     | String literals      | All objects |
| Duplicates | Not allowed          | Allowed     |
| Managed by | JVM                  | Application |

🎯 Strong line:

> “SCP is part of heap but enforces uniqueness of string literals.”

---

## 7️⃣ Common interviewer follow-up

### Q: Are strings in SCP garbage collected?

> “Yes. Since SCP is inside the heap in Java 7+, pooled strings are eligible for garbage collection.”

---

## 🔥 Final Interview-Ready Answer (MEMORIZE)

> “The String Constant Pool is a special area inside the heap that stores unique string literals.
> It exists to reduce memory usage by avoiding duplicate string objects.
> When a literal is created, the JVM checks the pool and reuses it if present.
> Because strings are immutable, sharing pooled strings is safe and efficient.”
