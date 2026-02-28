## 1️⃣ Definition

**Cryptography** is the science of securing data by transforming it into an unreadable format so that only authorized parties can access it.

It ensures:

* Confidentiality
* Integrity
* Authentication
* Non-repudiation

---

## 2️⃣ Visual Representation

### Encryption & Decryption

```id="crypto1"
Plain Text ----(Encryption + Key)----> Cipher Text
Cipher Text ----(Decryption + Key)----> Plain Text
```

---

### Symmetric Encryption

```id="crypto2"
           Shared Secret Key
                |
Sender ---- Encrypt ----> Cipher Text ----> Decrypt ---- Receiver
```

---

### Asymmetric Encryption

```id="crypto3"
Public Key (Encrypt)
        |
Sender ----> Cipher Text ----> Receiver
                                 |
                           Private Key (Decrypt)
```

---

### Hashing

```id="crypto4"
Password ----> Hash Function ----> Fixed Length Hash

Same input  ---> Same hash
Small change ---> Completely different hash
```

---

## 3️⃣ Key Features / Properties

* Uses mathematical algorithms
* Works with keys
* One-way (hashing)
* Two-way (encryption)
* Deterministic (same input → same output in hashing)
* Avalanche effect (small change → huge output change)
* Secure against brute force (if properly implemented)

---

## 4️⃣ Core Concepts

### 1. Encryption

Converts readable data into unreadable form.

### 2. Decryption

Converts encrypted data back to original.

### 3. Key

Secret value used in algorithm.

### 4. Hashing

One-way transformation (cannot be reversed).

### 5. Digital Signature

Verifies authenticity using private key.

---

## 5️⃣ Types of Cryptography

### 1️⃣ Symmetric Key Cryptography

* Same key for encryption and decryption
* Fast
* Used for bulk data

Examples:

* AES
* DES

---

### 2️⃣ Asymmetric Key Cryptography

* Public key + Private key
* Slower than symmetric
* Used for secure key exchange

Examples:

* RSA
* ECC

---

### 3️⃣ Hash Functions

* One-way
* Fixed length output
* Used for password storage

Examples:

* SHA-256
* SHA-512

---

## 6️⃣ Code Example (C#)

### Symmetric Encryption (AES)

```csharp id="aes1"
using System.Security.Cryptography;
using System.Text;

var key = Encoding.UTF8.GetBytes("1234567890123456");
using var aes = Aes.Create();
aes.Key = key;

var encryptor = aes.CreateEncryptor();
```

---

### Hashing (SHA256)

```csharp id="hash1"
using System.Security.Cryptography;
using System.Text;

var sha = SHA256.Create();
var bytes = Encoding.UTF8.GetBytes("password");
var hash = sha.ComputeHash(bytes);
```

---

## 7️⃣ Use Cases

* Password storage (hashing)
* HTTPS (TLS uses asymmetric + symmetric)
* JWT signatures
* Digital signatures
* Banking transactions
* Secure API communication
* Data encryption at rest
* Secure messaging apps

---

## 8️⃣ Pitfalls / Notes

* ❌ Storing passwords without hashing
* ❌ Using MD5 (weak)
* ❌ Hardcoding encryption keys
* ❌ Using weak random number generators
* ❌ Reusing IV (Initialization Vector)
* ❌ Confusing hashing with encryption
* ❌ Using symmetric encryption for digital signatures

---

## 9️⃣ Real-World Analogy

📦 Sealed Box Example

* Encryption → Locking box
* Key → Secret key to open box
* Hash → Unique fingerprint of document
* Digital Signature → Signing document with personal seal
* Public Key → Open mailbox anyone can use
* Private Key → Only you can open mailbox

---

## 🔟 Tricky Questions (Interview Level)

1. What is the difference between encryption and hashing?
   ➜ Encryption is reversible; hashing is one-way.

2. Why can’t hashed passwords be decrypted?
   ➜ Hashing is a one-way function.

3. What is avalanche effect?
   ➜ Small input change causes large output change.

4. Why is symmetric encryption faster than asymmetric?
   ➜ Less computationally expensive.

5. Why do we use asymmetric encryption in HTTPS first?
   ➜ To securely exchange symmetric key.

6. What happens if private key is leaked?
   ➜ Security is compromised completely.

7. Can two different inputs produce same hash?
   ➜ Yes, called collision.

8. Why is SHA256 better than MD5?
   ➜ Stronger, resistant to collisions.

9. What is digital signature used for?
   ➜ Authenticity and non-repudiation.

10. What is IV in encryption?
    ➜ Initialization Vector to randomize encryption.

11. Why should IV not be reused?
    ➜ Can weaken encryption security.

12. What ensures data integrity?
    ➜ Hash functions.

13. What ensures confidentiality?
    ➜ Encryption.

14. What ensures non-repudiation?
    ➜ Digital signatures.

15. Why should keys be long?
    ➜ Harder to brute force.

---

# 🧾 Quick Recap / Cheat Sheet

* Cryptography secures data
* Encryption = reversible
* Hashing = one-way
* Symmetric = same key
* Asymmetric = public/private keys
* Hash ensures integrity
* Encryption ensures confidentiality
* Digital signature ensures authenticity
* Never store plain passwords
* Use SHA-256 or stronger
* AES for symmetric encryption
* RSA/ECC for asymmetric
* Never reuse IV
* Protect private keys
* Avoid weak algorithms like MD5

---
