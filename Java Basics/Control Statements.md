# 1️⃣ Definition

**Control Statements** are used to control the flow of execution of a program.

They determine:

* Which statement executes
* How many times it executes
* When it stops

Java control statements are classified into:

```text
Control Statements
│
├── Selection (Decision Making)
├── Iteration (Looping)
└── Jump Statements
```

---

# 2️⃣ Visual Representation

---

## 🔹 Selection

```text
        Condition
            │
      ┌─────┴─────┐
    True         False
      │             │
  Execute A     Execute B
```

---

## 🔹 Iteration

```text
Condition → True → Execute → Repeat
                ↓
              False → Exit
```

---

## 🔹 Jump

```text
Loop Execution
      │
   break / continue / return
      │
   Control Transfers
```

---

# 3️⃣ Types of Control Statements

---

# 🟢 1. Selection Statements

---

## 🔹 if

```java
if (condition) {
    // code
}
```

Example:

```java
int a = 10;
if (a > 5) {
    System.out.println("Greater");
}
```

---

## 🔹 if-else

```java
if (condition) {
    // true block
} else {
    // false block
}
```

---

## 🔹 if-else-if ladder

```java
if (marks >= 90) {
    System.out.println("A");
} else if (marks >= 75) {
    System.out.println("B");
} else {
    System.out.println("C");
}
```

✔ Evaluates top to bottom.

---

## 🔹 switch

```java
switch (value) {
    case 1:
        System.out.println("One");
        break;
    case 2:
        System.out.println("Two");
        break;
    default:
        System.out.println("Other");
}
```

✔ Works with:

* byte
* short
* int
* char
* String
* enum

---

# 🔵 2. Iteration Statements (Loops)

---

## 🔹 for Loop

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}
```

Flow:

```text
Initialization → Condition → Body → Update → Repeat
```

---

## 🔹 while Loop

```java
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}
```

✔ Entry-controlled loop.

---

## 🔹 do-while Loop

```java
int i = 0;
do {
    System.out.println(i);
    i++;
} while (i < 5);
```

✔ Executes at least once.

---

# 🟣 3. Jump Statements

---

## 🔹 break

Exits loop or switch.

```java
for (int i = 0; i < 5; i++) {
    if (i == 3) break;
}
```

---

## 🔹 continue

Skips current iteration.

```java
for (int i = 0; i < 5; i++) {
    if (i == 3) continue;
    System.out.println(i);
}
```

---

## 🔹 return

Exits method.

```java
return value;
```

---

# 4️⃣ Key Features / Properties

| Statement | Purpose               |
| --------- | --------------------- |
| if        | Single condition      |
| if-else   | Two paths             |
| switch    | Multiple fixed cases  |
| for       | Known iterations      |
| while     | Unknown iterations    |
| do-while  | Execute at least once |
| break     | Exit loop             |
| continue  | Skip iteration        |
| return    | Exit method           |

---

# 5️⃣ Code Example (Combined)

```java
int number = 3;

if (number > 0) {
    for (int i = 0; i < number; i++) {
        if (i == 1) continue;
        System.out.println(i);
    }
} else {
    System.out.println("Invalid");
}
```

---

# 6️⃣ Use Cases

Selection → Decision making
Loop → Repeating tasks
break → Early exit
continue → Skip unwanted cases
switch → Menu-driven programs

---

# 7️⃣ Pitfalls / Notes (Very Important)

---

### ⚠ 1. Missing break in switch

```java
switch (x) {
    case 1:
        System.out.println("One");
    case 2:
        System.out.println("Two");
}
```

✔ Causes fall-through.

---

### ⚠ 2. Infinite Loop

```java
while (true) {
}
```

No exit condition.

---

### ⚠ 3. do-while Executes Once

Even if condition is false.

---

### ⚠ 4. switch Does NOT Work with:

* long
* float
* double
* boolean

---

### ⚠ 5. Condition Must Be boolean

```java
if (1)  // Compile error
```

Unlike C/C++.

---

# 8️⃣ Real-World Analogy

if → If it rains, take umbrella
for → Attend 5 classes
while → Study until tired
break → Leave meeting early
continue → Skip one question

---

# 9️⃣ Best Practices

✔ Always use break in switch (unless fall-through required)
✔ Prefer for loop when count known
✔ Avoid deeply nested if blocks
✔ Use meaningful conditions
✔ Avoid infinite loops without exit

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. Does switch work with String?

Yes (since Java 7).

---

### ❓ 2. What happens if break is missing in switch?

Fall-through occurs.

---

### ❓ 3. Which loop executes at least once?

do-while.

---

### ❓ 4. Can we use multiple conditions in switch?

No. Only constant expressions.

---

### ❓ 5. What is difference between break and continue?

break → exits loop
continue → skips current iteration

---

### ❓ 6. Can we use return inside loop?

Yes. It exits entire method.

---

### ❓ 7. Is while(true) valid?

Yes. It creates infinite loop unless break used.

---

# 🧾 Quick Recap / Cheat Sheet

```text
Control Statements
------------------

Selection
• if
• if-else
• if-else-if
• switch

Iteration
• for
• while
• do-while

Jump
• break
• continue
• return

Important:
• switch needs break
• do-while runs once
• Condition must be boolean
```

---
