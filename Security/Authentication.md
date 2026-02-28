## 1️⃣ Definition

**Authentication** is the process of verifying the identity of a user, system, or service before granting access to resources.

It answers the question:

> ❓ **“Who are you?”**

It does **NOT** decide what you can access — that is **Authorization**.

---

## 2️⃣ Visual Representation

### Basic Authentication Flow

```
User ----(Credentials)----> Application ----> Authentication Server
   |                                               |
   |<---- Access Token / Session ID --------------|
   |
Access Granted
```

### Token-Based Flow (JWT Example)

```
[Login Request]
     |
     v
User --> Server --> Validate Credentials
                    |
                    v
                Generate Token (JWT)
                    |
                    v
User <---- JWT Token ---- Server

Subsequent Requests:
User ---- JWT ----> Server ----> Validate Signature ----> Allow Access
```

---

## 3️⃣ Key Features / Properties

* Identity Verification
* Uses credentials (password, OTP, biometric, token, certificate)
* Can be:

  * Stateful (Session-based)
  * Stateless (Token-based)
* Supports multi-factor authentication (MFA)
* Can integrate with external identity providers
* Uses cryptographic validation (hashing, signatures)

---

## 4️⃣ Syntax (ASP.NET Core Example)

### Add Authentication Service

```csharp
builder.Services.AddAuthentication("Bearer")
    .AddJwtBearer("Bearer", options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true
        };
    });
```

### Enable Middleware

```csharp
app.UseAuthentication();
app.UseAuthorization();
```

### Protect Controller

```csharp
[Authorize]
public class SecureController : ControllerBase
{
}
```

---

## 5️⃣ Code Example (JWT Authentication Flow)

### 1. User Login

```csharp
public IActionResult Login(LoginModel model)
{
    if (IsValidUser(model))
    {
        var token = GenerateJwtToken(model.Username);
        return Ok(new { token });
    }

    return Unauthorized();
}
```

### 2. Generate JWT Token

```csharp
private string GenerateJwtToken(string username)
{
    var claims = new[]
    {
        new Claim(ClaimTypes.Name, username)
    };

    var key = new SymmetricSecurityKey(
        Encoding.UTF8.GetBytes("YourSecretKey"));

    var creds = new SigningCredentials(
        key, SecurityAlgorithms.HmacSha256);

    var token = new JwtSecurityToken(
        issuer: "MyApp",
        audience: "MyAppUsers",
        claims: claims,
        expires: DateTime.Now.AddMinutes(30),
        signingCredentials: creds);

    return new JwtSecurityTokenHandler().WriteToken(token);
}
```

---

## 6️⃣ Use Cases

* Login system (Username + Password)
* API Security (Bearer Token)
* Microservices communication
* Banking OTP login
* Enterprise SSO
* Biometric login systems
* Social login (Google, Microsoft, etc.)

---

## 7️⃣ Pitfalls / Notes

* ❌ Storing passwords in plain text
* ❌ Hardcoding secret keys
* ❌ Not validating token expiration
* ❌ Not enabling HTTPS
* ❌ Long-lived tokens without refresh
* ❌ Confusing Authentication with Authorization
* ❌ Missing `UseAuthentication()` middleware
* ❌ Wrong middleware order

Correct order:

```csharp
app.UseAuthentication();
app.UseAuthorization();
```

---

## 8️⃣ Real-World Analogy

🏢 Office Security

* You show ID card at entrance → Authentication
* Security checks if you can enter server room → Authorization
* Temporary visitor pass → Session
* Digital QR pass with expiry → JWT Token
* Fingerprint scanner → Biometric Authentication

---

## 9️⃣ Best Practices

* Hash passwords using strong algorithm (e.g., bcrypt, PBKDF2)
* Always use HTTPS
* Keep token expiration short
* Use refresh tokens securely
* Store secrets in secure vault (not in code)
* Implement MFA for sensitive systems
* Validate issuer, audience, lifetime
* Rotate signing keys periodically

---

# 🔟 Tricky Questions (Interview Level)

1. What is the difference between Authentication and Authorization?
   ➜ Authentication verifies identity. Authorization verifies permissions.

2. What happens if `UseAuthentication()` is not added in middleware?
   ➜ `[Authorize]` attribute will not work properly because the user identity is never set.

3. Why is JWT called stateless authentication?
   ➜ Server does not store session; token contains all required claims.

4. Where is JWT stored on client side?
   ➜ Typically in local storage, session storage, or HTTP-only cookies.

5. What is the structure of JWT?
   ➜ Header.Payload.Signature

6. What happens if someone modifies JWT payload?
   ➜ Signature validation fails and token becomes invalid.

7. Why should secret key be strong?
   ➜ Weak key can allow attackers to forge valid tokens.

8. What is token expiration used for?
   ➜ Prevents reuse of stolen tokens.

9. What is the difference between session-based and token-based authentication?
   ➜ Session-based stores state on server; token-based does not.

10. Why is HTTPS mandatory for authentication?
    ➜ Prevents credential/token interception (man-in-the-middle attack).

11. Can JWT be revoked?
    ➜ Not easily in pure stateless systems. Requires blacklist or short expiry + refresh token strategy.

12. What is MFA?
    ➜ Multi-Factor Authentication — using two or more identity verification factors.

13. What is a Claim in JWT?
    ➜ Key-value pair representing user information (e.g., username, role).

14. Why is password hashing necessary instead of encryption?
    ➜ Hashing is one-way; encryption is reversible.

15. What happens if `ValidateLifetime` is false?
    ➜ Expired tokens will still be accepted (security risk).

---

# 🧾 Quick Recap / Cheat Sheet

* Authentication = Who are you?
* Verifies identity
* Can be Session-based or Token-based
* JWT = Header.Payload.Signature
* Middleware order matters
* Use HTTPS always
* Hash passwords
* Keep token expiry short
* Validate issuer, audience, signature
* Don’t hardcode secrets
* Use MFA for better security
* Stateless = no server session storage

---
