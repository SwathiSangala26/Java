### What is a package in Java?

A package is a namespace that groups related classes and interfaces.
It helps organize code, avoid class name conflicts, control access, and support reuse.

---

### Why are packages needed?

Packages are needed to:

* Avoid class name collisions (example: `java.util.Date` vs `java.sql.Date`)
* Organize large codebases logically
* Control access using access modifiers
* Reuse code across projects
* Improve maintainability

---

### When is a package created?

A package is created **at compile time**.
It is created when the compiler (`javac`) processes the `package` statement.

* Not created while writing code
* Not created during build
* Not created at runtime

---

### How is a package created?

A package is created by declaring the `package` statement at the top of a source file.
When the file is compiled, the compiler creates the corresponding folder structure and places the `.class` file inside it.

---

### What are the types of packages in Java?

There are two types:

* Built-in packages (provided by Java API)
* User-defined packages (created by developers)

Examples of built-in packages:

* `java.lang`
* `java.util`
* `java.io`
* `java.sql`
* `java.time`

---

### Why does `java.lang` not need to be imported?

`java.lang` does not need an import because the Java compiler automatically imports `java.lang.*` for every source file at compile time.

This behavior is defined by the Java Language Specification and implemented inside the compiler.

---

### Is `java.lang` handled by JDK or JRE?

It is handled by the **compiler (`javac`)**, which is part of the **JDK**.
The JRE and JVM are not involved in import handling.

---

### Does the JVM load packages?

No.
The JVM loads **classes**, not packages.
Packages are only a compile-time namespace and a folder structure on disk.

---

### What is the difference between a package and a folder?

* A package is a **logical namespace** in Java.
* A folder is a **physical directory** on the file system.
* Packages are resolved at compile time; folders exist on disk.

---

### How are packages imported in Java?

Packages are imported using the `import` statement.
Imports are only used by the compiler to resolve class names and have no effect at runtime.

---

### What is default access?

Default access (package-private) allows members to be accessed **only within the same package**.
It has no keyword.

---

### What is the difference between default and protected access?

* Default access: accessible only within the same package
* Protected access: accessible within the same package and also in subclasses outside the package

---

### Are sub-packages related to parent packages?

No.
Sub-packages are treated as **independent packages**.
There is no automatic access relationship between a package and its sub-package.

---

### Do packages exist at runtime?

No.
At runtime:

* Only classes exist
* Classes are loaded into Metaspace
* Packages do not occupy memory

---

### How can a package be reused in another project?

A package is reused by:

* Compiling its classes
* Packaging them into a JAR
* Adding the JAR to another project’s classpath or dependency manager

The JAR is the reusable unit, not the package itself.

---

### Do build tools like Maven or Gradle create packages?

No.
Build tools only compile code and bundle compiled classes.
They do not create packages.

---

### Can two classes with the same name exist in different packages?

Yes.
Packages provide namespace separation, so classes with the same name can exist in different packages.

---

### Where are package classes stored in memory?

At runtime, classes are stored in **Metaspace**.
Packages themselves are not stored in memory.

---

### Final one-line summary

A Java package is a compile-time namespace used to group related classes and interfaces, created during compilation, not present at runtime, and reused across projects through JAR files.
