# 1️⃣ Definition

The **Date & Time API** introduced in **Java 8** (`java.time` package) is a modern, immutable, thread-safe API designed to replace the old:

* `java.util.Date`
* `java.util.Calendar`
* `SimpleDateFormat`

It provides better clarity, immutability, timezone handling, and ISO-8601 standard support.

---

# 2️⃣ Visual Representation

---

### Old API Problems

```text
Mutable
Not Thread-safe
Poor Timezone Handling
Confusing Design
```

---

### New API Structure

```text
java.time
   |
   |-- LocalDate
   |-- LocalTime
   |-- LocalDateTime
   |-- ZonedDateTime
   |-- Instant
   |-- Period
   |-- Duration
   |-- DateTimeFormatter
```

---

### Timeline Representation

```text
Instant  →  Machine Time (UTC)
LocalDateTime → Human readable (No timezone)
ZonedDateTime → DateTime + Timezone
```

---

# 3️⃣ Key Features / Properties

1. Immutable
2. Thread-safe
3. ISO-8601 compliant
4. Clear separation of date/time concepts
5. Better timezone support
6. Fluent API design
7. No more month indexing confusion
8. Supports arithmetic operations
9. Supports parsing/formatting
10. Backward compatible via conversion methods

---

# 4️⃣ Syntax

---

### Getting Current Date

```java
LocalDate date = LocalDate.now();
```

---

### Getting Current Time

```java
LocalTime time = LocalTime.now();
```

---

### Getting Date & Time

```java
LocalDateTime dt = LocalDateTime.now();
```

---

### With Timezone

```java
ZonedDateTime zdt = ZonedDateTime.now();
```

---

# 5️⃣ Code Examples

---

### 🔹 LocalDate

```java
LocalDate date = LocalDate.of(2026, 2, 28);
int year = date.getYear();
```

---

### 🔹 LocalTime

```java
LocalTime time = LocalTime.of(10, 30);
```

---

### 🔹 LocalDateTime

```java
LocalDateTime dt = LocalDateTime.of(2026, 2, 28, 10, 30);
```

---

### 🔹 ZonedDateTime

```java
ZonedDateTime zdt =
    ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
```

---

### 🔹 Instant (Machine Time)

```java
Instant instant = Instant.now();
```

---

### 🔹 Date Arithmetic

```java
LocalDate nextWeek = date.plusWeeks(1);
LocalDate previousMonth = date.minusMonths(1);
```

---

### 🔹 Period (Date difference)

```java
Period period =
    Period.between(LocalDate.of(2025,1,1), LocalDate.now());
```

---

### 🔹 Duration (Time difference)

```java
Duration duration =
    Duration.between(LocalTime.now(), LocalTime.now().plusHours(2));
```

---

### 🔹 Formatting

```java
DateTimeFormatter formatter =
    DateTimeFormatter.ofPattern("dd-MM-yyyy");

String formatted = date.format(formatter);
```

---

### 🔹 Parsing

```java
LocalDate parsed =
    LocalDate.parse("28-02-2026", formatter);
```

---

# 6️⃣ Important Classes

* LocalDate
* LocalTime
* LocalDateTime
* ZonedDateTime
* OffsetDateTime
* Instant
* Duration
* Period
* ZoneId
* DateTimeFormatter

---

# 7️⃣ Use Cases

1. Handling user input dates
2. Timezone-based applications
3. Logging timestamps
4. Date arithmetic
5. Scheduling systems
6. Financial calculations
7. Duration measurement
8. API responses
9. Database conversions
10. Event tracking

---

# 8️⃣ Pitfalls / Notes

1. LocalDateTime has NO timezone
2. Use ZonedDateTime for timezone-sensitive apps
3. Period is for date (years/months/days)
4. Duration is for time (seconds/nanos)
5. Always use DateTimeFormatter (not SimpleDateFormat)
6. Instant is UTC-based
7. Converting old Date requires toInstant()
8. Be careful with daylight saving changes
9. Month is NOT zero-indexed
10. API is immutable (operations return new object)

---

### Conversion Example (Old → New)

```java
Date date = new Date();
Instant instant = date.toInstant();
```

---

# 9️⃣ Real-World Analogy

Think of the new Date API like a **modern digital clock system**:

```text
LocalDate      → Calendar page
LocalTime      → Clock time
LocalDateTime  → Calendar + Clock
ZonedDateTime  → Calendar + Clock + Timezone
Instant        → Atomic clock (UTC)
```

Each class has a clear responsibility.

---

# 🔟 Best Practices

1. Use LocalDate for date-only values
2. Use ZonedDateTime for timezone logic
3. Use Instant for machine timestamps
4. Use Period for date difference
5. Use Duration for time difference
6. Avoid LocalDateTime in distributed systems
7. Always use DateTimeFormatter
8. Avoid old Date/Calendar
9. Prefer ISO formats
10. Keep timezone explicit in APIs

---

# 🔥 Tricky Questions (Interview Level)

(Continuous numbering)

---

### 1️⃣ Why was new Date API introduced?

To fix mutability, thread-safety, and design issues of old API.

---

### 2️⃣ Is LocalDate mutable?

No.

---

### 3️⃣ Difference between Period and Duration?

* Period → years, months, days
* Duration → seconds, nanoseconds

---

### 4️⃣ Does LocalDateTime store timezone?

No.

---

### 5️⃣ What should be used in distributed systems?

Instant or ZonedDateTime.

---

### 6️⃣ How to get current UTC time?

```java
Instant.now();
```

---

### 7️⃣ Is DateTimeFormatter thread-safe?

Yes.

---

### 8️⃣ What happens when adding months to Jan 31?

It adjusts date accordingly (e.g., Feb 28/29).

---

### 9️⃣ What is ZoneId?

Represents timezone ID like "Asia/Kolkata".

---

### 🔟 What is difference between ZonedDateTime and OffsetDateTime?

* ZonedDateTime → full timezone rules
* OffsetDateTime → fixed offset only

---

### 1️⃣1️⃣ How to convert LocalDate to LocalDateTime?

```java
date.atStartOfDay();
```

---

### 1️⃣2️⃣ Can Instant store date without timezone?

No. Always UTC.

---

### 1️⃣3️⃣ Is DateTimeFormatter mutable?

No.

---

### 1️⃣4️⃣ How to calculate age?

Use Period.between().

---

### 1️⃣5️⃣ Does Duration support days?

No. It uses seconds.

---

### 1️⃣6️⃣ Can LocalDateTime cause timezone bugs?

Yes, because it lacks timezone.

---

### 1️⃣7️⃣ What is ChronoUnit?

Enum for time units (DAYS, HOURS, etc.)

---

### 1️⃣8️⃣ What happens during daylight saving change?

ZonedDateTime adjusts automatically.

---

### 1️⃣9️⃣ How to format ISO date?

```java
DateTimeFormatter.ISO_DATE
```

---

### 2️⃣0️⃣ Is new Date API backward compatible?

Yes, via conversion methods.

---

# 🧾 Quick Recap / Cheat Sheet

* Introduced in Java 8 (`java.time`)
* Immutable & thread-safe
* LocalDate → date only
* LocalTime → time only
* LocalDateTime → no timezone
* ZonedDateTime → with timezone
* Instant → UTC machine time
* Period → date difference
* Duration → time difference
* DateTimeFormatter → formatting/parsing
* Avoid old Date/Calendar
* Always consider timezone in distributed systems

---
