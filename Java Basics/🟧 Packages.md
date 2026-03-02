# 1️⃣ Definition

A **package** is a namespace used to group related classes and interfaces together.

It helps to:

* Organize code
* Avoid name conflicts
* Provide access control
* Improve maintainability

---

# 2️⃣ Visual Representation

---

## 🔹 Without Package (Problem)

```text id="7h8v2m"
Project
│
├── Test.java
├── Test.java   ❌ (Name conflict)
```

Two classes with same name → conflict.

---

## 🔹 With Package (Solution)

```text id="1g9tzk"
Project
│
├── com.bank.user
│     └── Test.java
│
├── com.bank.admin
│     └── Test.java
```

✔ Same class name allowed in different packages.

---

# 3️⃣ Syntax

Package declaration must be **first statement** in file.

```java id="nxr3bo"
package com.company.project;

public class Test {
}
```

---

# 4️⃣ Types of Packages

---

## 🟢 1. Built-in Packages

Provided by Java.

Examples:

```java id="q91apw"
import java.util.*;
import java.lang.*;
import java.io.*;
```

Common built-in packages:

| Package   | Purpose                             |
| --------- | ----------------------------------- |
| java.lang | Core classes (String, Math, System) |
| java.util | Collections, Scanner                |
| java.io   | File handling                       |
| java.sql  | Database connectivity               |

⚠ `java.lang` is imported automatically.

---

## 🔵 2. User-Defined Packages

Created by programmer.

Example:

```java id="owm2fe"
package com.bank.management;
```

---

# 5️⃣ Folder Structure Rule

Package name must match folder structure.

Example:

```java id="2p7v3x"
package com.bank.management;
```

Folder structure:

```text id="w1k8dc"
com/
 └── bank/
      └── management/
           └── Test.java
```

---

# 6️⃣ Compilation & Execution with Package

Suppose:

```java id="1o0yza"
package com.test;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
```

Compile:

```text id="s6ptxf"
javac -d . Demo.java
```

Run:

```text id="g6y7kk"
java com.test.Demo
```

✔ Use fully qualified name while running.

---

# 7️⃣ Import Statement

Used to access classes from another package.

---

## 🔹 Import Specific Class

```java id="p4sy1b"
import java.util.Scanner;
```

---

## 🔹 Import All Classes

```java id="u1gksp"
import java.util.*;
```

---

## 🔹 Fully Qualified Name (Without Import)

```java id="4d4qsc"
java.util.Scanner sc = new java.util.Scanner(System.in);
```

---

# 8️⃣ Access Control & Package

Access modifiers behave differently across packages.

| Modifier  | Same Class | Same Package | Different Package   |
| --------- | ---------- | ------------ | ------------------- |
| private   | ✔          | ❌            | ❌                   |
| default   | ✔          | ✔            | ❌                   |
| protected | ✔          | ✔            | ✔ (via inheritance) |
| public    | ✔          | ✔            | ✔                   |

Package is important for access control.

---

# 9️⃣ Naming Conventions

✔ All lowercase
✔ Reverse domain style preferred

Example:

```java id="8p9q6n"
package com.company.project;
```

❌ Avoid:

```java id="j7b2mk"
package BankProject;
```

---

# 🔟 Pitfalls / Notes (Interview Important)

---

### ⚠ 1. Only One Package Statement Allowed

```java id="b8o7h1"
package a;
package b;   // Error
```

---

### ⚠ 2. Package Must Be First Line (Before import)

```java id="n7sdv4"
import java.util.*;  // ❌ wrong place
package com.test;
```

✔ Package must come first.

---

### ⚠ 3. Default Package

If no package declared:

```java id="l3yt1q"
public class Test {}
```

It belongs to **default package**.

⚠ Not recommended in real projects.

---

### ⚠ 4. Class Name Conflict

Two classes with same name in different packages:

Must use fully qualified name if both imported.

---

# 1️⃣1️⃣ Code Example (Complete)

```java id="b6ux0a"
package com.bank;

public class Account {
    public void show() {
        System.out.println("Account Details");
    }
}
```

Another file:

```java id="y8k5n3"
import com.bank.Account;

public class Test {
    public static void main(String[] args) {
        Account a = new Account();
        a.show();
    }
}
```

---

# 1️⃣2️⃣ Real-World Analogy

Package = Folder in your computer.

Classes = Files inside that folder.

It helps organize large projects cleanly.

---

# 1️⃣3️⃣ Best Practices

✔ Always declare package
✔ Use meaningful hierarchy
✔ Follow reverse domain naming
✔ Avoid default package
✔ Keep related classes in same package

---

# 1️⃣4️⃣ Tricky Questions (With Answers)

---

### ❓ 1. Is java.lang imported automatically?

Yes.

---

### ❓ 2. Can we declare multiple packages in one file?

No.

---

### ❓ 3. What happens if no package declared?

Class goes to default package.

---

### ❓ 4. Can two classes with same name exist?

Yes, in different packages.

---

### ❓ 5. What is fully qualified class name?

`packageName.ClassName`

Example:

```text id="sm7wvd"
com.bank.Account
```

---

### ❓ 6. Can we access default package class from another package?

No.

---

# 🧾 Quick Recap / Cheat Sheet

```text id="g2v4mf"
Package
-------

• Groups related classes
• Avoids name conflicts
• Helps access control
• First line in file
• Matches folder structure
• Reverse domain naming
• java.lang imported automatically

Compile → javac -d .
Run → java packageName.ClassName
```

---
