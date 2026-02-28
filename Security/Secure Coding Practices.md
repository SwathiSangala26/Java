## 1️⃣ Definition

**Secure Coding Practices** are techniques and principles used during software development to prevent security vulnerabilities and protect applications from attacks.

Goal:

* Prevent exploitation
* Protect data
* Reduce attack surface
* Ensure secure behavior by design

---

## 2️⃣ Visual Representation

### Secure Development Flow

```id="scp1"
Design --> Secure Design Review
        |
Coding --> Input Validation + Secure APIs
        |
Testing --> Security Testing
        |
Deployment --> Secure Configuration
```

---

### Attack Surface Concept

```id="scp2"
User Input --> Application --> Database

If input NOT validated:
User Input --> Injection Attack --> Database Compromised
```

---

### Defense in Depth

```id="scp3"
Layer 1: Input Validation
Layer 2: Authentication
Layer 3: Authorization
Layer 4: Encryption
Layer 5: Logging & Monitoring
```

Multiple layers = stronger protection.

---

## 3️⃣ Key Features / Principles

* Input validation
* Output encoding
* Least privilege
* Secure authentication
* Proper error handling
* Secure configuration
* Dependency management
* Logging & monitoring
* Avoid hardcoded secrets
* Use secure cryptography

---

## 4️⃣ Core Practices

### 1️⃣ Input Validation

Validate:

* Length
* Type
* Format
* Range
* Whitelisting over blacklisting

Example:

```csharp id="scpcode1"
if (!int.TryParse(input, out int value))
{
    return BadRequest("Invalid input");
}
```

---

### 2️⃣ Prevent SQL Injection

Use parameterized queries.

❌ Unsafe:

```csharp id="scpcode2"
var query = "SELECT * FROM Users WHERE Name = '" + name + "'";
```

✅ Safe:

```csharp id="scpcode3"
var command = new SqlCommand(
    "SELECT * FROM Users WHERE Name = @name", conn);
command.Parameters.AddWithValue("@name", name);
```

---

### 3️⃣ Password Security

* Hash passwords
* Use salt
* Use strong algorithms

Never:

```csharp id="scpcode4"
storePassword = "mypassword";
```

---

### 4️⃣ Secure Error Handling

❌ Exposing stack trace

```id="scp4"
System.NullReferenceException at line 25
```

✅ Generic message

```id="scp5"
Something went wrong. Please try again.
```

---

### 5️⃣ Avoid Hardcoded Secrets

❌

```csharp id="scpcode5"
string apiKey = "123456SECRET";
```

✅ Use environment variables / vault.

---

### 6️⃣ Use HTTPS

```id="scp6"
Client ---- HTTPS ----> Server
Encrypted Communication
```

---

### 7️⃣ Principle of Least Privilege

```id="scp7"
User Role: Viewer
Access Allowed: Read Only
Access Denied: Delete / Update
```

---

## 5️⃣ Use Cases

* Banking applications
* Enterprise systems
* Public APIs
* Authentication systems
* Payment processing
* Healthcare systems
* Government applications

---

## 6️⃣ Common Vulnerabilities to Prevent

* SQL Injection
* Cross-Site Scripting (XSS)
* Cross-Site Request Forgery (CSRF)
* Broken Authentication
* Insecure Deserialization
* Sensitive Data Exposure
* Security Misconfiguration
* Hardcoded Secrets

---

## 7️⃣ Pitfalls / Notes

* ❌ Trusting user input
* ❌ Logging sensitive data
* ❌ Weak password policies
* ❌ Ignoring dependency vulnerabilities
* ❌ Disabling security headers
* ❌ Using outdated libraries
* ❌ Excessive privileges
* ❌ Skipping security testing

---

## 8️⃣ Real-World Analogy

🏠 Building a Secure House

* Strong doors → Authentication
* Restricted rooms → Authorization
* CCTV → Logging
* Safe locker → Encryption
* Security guard → Monitoring
* Multiple locks → Defense in depth

One weak door → Entire house at risk.

---

## 9️⃣ Best Practices

* Validate all external input
* Encode output properly
* Use parameterized queries
* Hash and salt passwords
* Use HTTPS always
* Keep dependencies updated
* Apply least privilege
* Enable security headers
* Store secrets securely
* Perform regular security testing
* Log suspicious activity
* Implement rate limiting
* Follow OWASP guidelines

---

# 🔟 Tricky Questions (Interview Level)

1. Why should we use whitelisting instead of blacklisting?
   ➜ Whitelisting allows only known safe inputs; blacklisting misses unknown attacks.

2. What is SQL Injection?
   ➜ Attacker injects malicious SQL via input fields.

3. How do parameterized queries prevent injection?
   ➜ They treat input as data, not executable SQL.

4. Why shouldn’t detailed errors be shown to users?
   ➜ Reveals internal structure and vulnerabilities.

5. What is defense in depth?
   ➜ Multiple security layers protecting system.

6. Why is least privilege important?
   ➜ Limits damage if account is compromised.

7. What is XSS?
   ➜ Injecting malicious scripts into web pages.

8. Why should secrets not be hardcoded?
   ➜ Source code exposure leaks secrets.

9. What is CSRF?
   ➜ Unauthorized commands executed on behalf of user.

10. Why must dependencies be updated?
    ➜ Prevent exploitation of known vulnerabilities.

11. What is output encoding used for?
    ➜ Prevent XSS attacks.

12. Why is HTTPS mandatory?
    ➜ Protects data in transit.

13. What is rate limiting used for?
    ➜ Prevent brute force attacks.

14. Why should sensitive data not be logged?
    ➜ Logs may be exposed or accessed.

15. What is secure configuration?
    ➜ Disabling unused services, secure defaults, proper settings.

---

# 🧾 Quick Recap / Cheat Sheet

* Validate all inputs
* Use parameterized queries
* Hash + salt passwords
* Avoid hardcoded secrets
* Use HTTPS
* Follow least privilege
* Don’t expose detailed errors
* Encode output
* Keep dependencies updated
* Defense in depth
* Log securely
* Prevent SQL Injection & XSS
* Use secure headers
* Secure configuration
* Regular security testing

---
