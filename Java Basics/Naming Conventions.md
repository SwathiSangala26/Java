# 1️⃣ Definition

**Naming conventions** are standard rules followed while naming:

* Classes
* Variables
* Methods
* Packages
* Constants

They improve:

* Code readability
* Maintainability
* Professional quality

⚠ Not compiler rules — but industry standards.

---

# 2️⃣ Visual Representation

```text
Java Naming Structure
│
├── Class        → PascalCase
├── Method       → camelCase
├── Variable     → camelCase
├── Constant     → UPPER_CASE
├── Package      → lowercase
└── Interface    → PascalCase
```

---

# 3️⃣ Rules & Standards

---

# 🟢 1. Class Naming

✔ Use **PascalCase** (First letter of every word capital)

```java
class StudentDetails { }
class BankAccount { }
```

❌ Wrong:

```java
class studentdetails { }
class student_details { }
```

---

# 🔵 2. Interface Naming

✔ Same as class (PascalCase)

```java
interface Printable { }
interface RunnableTask { }
```

---

# 🟣 3. Method Naming

✔ Use **camelCase**
✔ First letter lowercase
✔ Should be verb-based

```java
void calculateTotal() { }
void printDetails() { }
```

❌ Wrong:

```java
void CalculateTotal() { }
void total_calculation() { }
```

---

# 🟡 4. Variable Naming

✔ camelCase
✔ Meaningful names
✔ Nouns

```java
int studentAge;
double accountBalance;
```

❌ Wrong:

```java
int a;
double x1;
```

(Except loop counters like i, j)

---

# 🔴 5. Constant Naming

✔ UPPER_CASE
✔ Words separated by underscore
✔ Usually static final

```java
static final double PI = 3.14;
static final int MAX_SIZE = 100;
```

---

# ⚫ 6. Package Naming

✔ All lowercase
✔ Reverse domain style preferred

```java
package com.company.project;
package org.bank.management;
```

❌ Wrong:

```java
package BankProject;
```

---

# 4️⃣ Identifier Rules (Must Follow)

Naming convention follows identifier rules:

✔ Can contain letters, digits, _, $
✔ Cannot start with digit
✔ Cannot use keywords
✔ Case-sensitive

Valid:

```java
int totalMarks;
int _count;
int $value;
```

Invalid:

```java
int 1value;     // starts with digit
int class;      // keyword
```

---

# 5️⃣ Code Example

```java
package com.company.project;

public class StudentDetails {

    static final int MAX_MARKS = 100;

    private int studentAge;

    public void calculateGrade() {
        int totalMarks = 90;
        System.out.println(totalMarks);
    }
}
```

✔ Follows all naming conventions.

---

# 6️⃣ Why Naming Conventions Matter

✔ Makes code readable
✔ Helps teamwork
✔ Makes debugging easier
✔ Professional coding practice
✔ Important in interviews

---

# 7️⃣ Pitfalls / Notes (Important)

---

### ⚠ 1. Case Sensitivity

```java
int age;
int Age;  // Different variable
```

---

### ⚠ 2. Meaningful Naming

Avoid:

```java
int x;
```

Prefer:

```java
int totalAmount;
```

---

### ⚠ 3. Boolean Naming

Use:

```java
boolean isActive;
boolean hasPermission;
boolean canExecute;
```

Not:

```java
boolean active;
```

---

### ⚠ 4. Avoid Single Letter Variables (Except Loops)

```java
for (int i = 0; i < 10; i++)
```

✔ Acceptable

---

# 8️⃣ Real-World Analogy

Naming conventions are like grammar rules in English.

Even if sentence is grammatically correct,
good wording makes it professional and understandable.

---

# 9️⃣ Best Practices

✔ Use descriptive names
✔ Avoid abbreviations unless common (id, url)
✔ Follow consistent style
✔ Keep package names lowercase
✔ Use verbs for methods

---

# 🔟 Tricky Questions (With Answers)

---

### ❓ 1. Does Java enforce naming conventions?

No. They are standards, not rules.

---

### ❓ 2. Can class name start with lowercase?

Yes (compiles), but not recommended.

---

### ❓ 3. Why constants are uppercase?

To differentiate them from variables.

---

### ❓ 4. Is variable name case-sensitive?

Yes.

---

### ❓ 5. Can we use $ in variable name?

Yes, but not recommended in normal coding.

---

### ❓ 6. What is standard naming for boolean variable?

Use prefix:

* is
* has
* can

---

# 🧾 Quick Recap / Cheat Sheet

```text
Naming Conventions
------------------

Class → PascalCase
Method → camelCase (verb)
Variable → camelCase
Constant → UPPER_CASE
Package → lowercase
Interface → PascalCase

Important:
• Case-sensitive
• Use meaningful names
• Follow industry standards
```

---
