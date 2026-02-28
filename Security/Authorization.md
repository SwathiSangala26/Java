## 1️⃣ Definition

**Authorization** is the process of determining what an authenticated user is allowed to access or perform.

It answers:

> ❓ **“What are you allowed to do?”**

Authentication must happen **before** Authorization.

---

## 2️⃣ Visual Representation

### Basic Flow

```id="authz1"
User ----> Authentication ----> Identity Established
                                 |
                                 v
                          Authorization Check
                                 |
                    -----------------------------
                    |                           |
                 Allowed                      Denied
```

---

### Role-Based Authorization

```id="authz2"
User (Role: Admin)
        |
        v
Accessing: /delete-user
        |
        v
Policy Check --> Role == Admin ?
        |
      Yes ----> Access Granted
```

---

### Claim-Based Authorization

```id="authz3"
User Claims:
- Name: Swathi
- Department: Finance
- Level: 3

Request: Access Budget API

Policy: Department == Finance AND Level >= 2

--> Access Granted
```

---

## 3️⃣ Key Features / Properties

* Happens after authentication
* Uses:

  * Roles
  * Claims
  * Policies
* Determines access to:

  * APIs
  * Controllers
  * Methods
  * Resources
* Can be:

  * Role-Based
  * Claim-Based
  * Policy-Based
  * Resource-Based
* Enforced via attributes or middleware

---

## 4️⃣ Syntax (ASP.NET Core)

### Enable Authorization

```csharp
builder.Services.AddAuthorization();
```

```csharp
app.UseAuthentication();
app.UseAuthorization();
```

---

### Role-Based

```csharp
[Authorize(Roles = "Admin")]
public IActionResult DeleteUser()
{
    return Ok();
}
```

---

### Policy-Based

```csharp
builder.Services.AddAuthorization(options =>
{
    options.AddPolicy("FinanceOnly",
        policy => policy.RequireClaim("Department", "Finance"));
});
```

```csharp
[Authorize(Policy = "FinanceOnly")]
public IActionResult Budget()
{
    return Ok();
}
```

---

### Multiple Roles

```csharp
[Authorize(Roles = "Admin,Manager")]
```

(Comma means OR)

---

## 5️⃣ Code Example (Full Example)

### 1. Add Policy

```csharp
builder.Services.AddAuthorization(options =>
{
    options.AddPolicy("SeniorEmployee",
        policy => policy.RequireAssertion(context =>
            context.User.HasClaim("Level", "3") ||
            context.User.HasClaim("Level", "4")));
});
```

### 2. Apply Policy

```csharp
[Authorize(Policy = "SeniorEmployee")]
public IActionResult ApproveLoan()
{
    return Ok("Approved");
}
```

---

## 6️⃣ Use Cases

* Admin dashboard access
* Restrict delete operations
* Banking transaction limits
* Department-based data visibility
* Feature access control
* API access in microservices
* Subscription-based content access

---

## 7️⃣ Pitfalls / Notes

* ❌ Confusing Authentication with Authorization
* ❌ Forgetting `UseAuthorization()`
* ❌ Incorrect middleware order
* ❌ Hardcoding roles everywhere
* ❌ Using roles when claims are better
* ❌ Not validating policies properly
* ❌ Over-permissioned users
* ❌ Assuming role == permission

Correct order:

```csharp
app.UseAuthentication();
app.UseAuthorization();
```

---

## 8️⃣ Real-World Analogy

🏢 Corporate Office

* Security checks ID → Authentication
* HR checks if you are allowed in Finance floor → Authorization
* Admin badge → Role-Based
* Access card with specific permissions → Claim-Based
* Special clearance document → Policy-Based

---

## 9️⃣ Best Practices

* Prefer Policy-Based over Role-Based for flexibility
* Keep authorization logic centralized
* Avoid magic strings for roles
* Follow least-privilege principle
* Combine roles and claims when needed
* Use custom handlers for complex logic
* Log authorization failures
* Test policies separately

---

# 🔟 Tricky Questions (Interview Level)

1. What is the difference between Authentication and Authorization?
   ➜ Authentication verifies identity; Authorization verifies permissions.

2. Can Authorization work without Authentication?
   ➜ No. Identity must exist first.

3. What happens if `UseAuthorization()` is missing?
   ➜ `[Authorize]` attributes will not enforce access restrictions.

4. What is the difference between Role-Based and Claim-Based authorization?
   ➜ Roles group users; Claims store specific user attributes.

5. What does `[Authorize(Roles="Admin,Manager")]` mean?
   ➜ Logical OR.

6. How do you implement AND logic between roles?
   ➜ Use policy with custom assertion.

7. What is Policy-Based Authorization?
   ➜ Authorization based on rules defined in `AddPolicy`.

8. What is Resource-Based Authorization?
   ➜ Authorization depending on specific resource ownership.

9. Where are roles stored in JWT?
   ➜ As claims inside the token.

10. What is `RequireClaim()` used for?
    ➜ Enforces claim existence/value in policy.

11. What is custom authorization handler?
    ➜ A class implementing `IAuthorizationHandler` for complex logic.

12. Why is policy-based better for enterprise systems?
    ➜ More flexible and scalable than static roles.

13. What happens if user has no required claim?
    ➜ Access denied.

14. Can multiple `[Authorize]` attributes be applied?
    ➜ Yes, and they are combined logically (AND).

15. What is least privilege principle?
    ➜ Grant minimum permissions necessary.

---

# 🧾 Quick Recap / Cheat Sheet

* Authorization = What can you do?
* Happens after Authentication
* Types:

  * Role-Based
  * Claim-Based
  * Policy-Based
  * Resource-Based
* `[Authorize]` enforces rules
* Middleware order matters
* Roles = groups
* Claims = user data
* Policies = rules
* Follow least privilege
* Prefer policies for complex systems
* Can combine multiple attributes

---
