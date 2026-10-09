<div align="center">

# ☕ Java Practices - Payroll with the Strategy Pattern

**A compact Java exercise that models a company payroll using clean OOP and the Strategy design pattern.**

![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)
![OOP](https://img.shields.io/badge/OOP-Strategy_pattern-informational)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?logo=intellijidea&logoColor=white)

</div>

---

## ✨ Overview

`src/Main.java` demonstrates a small but extensible design:

| Class / interface | Role |
|---|---|
| `SalaryCalculationStrategy` | Strategy interface - how a worker's total salary is computed |
| `StandardSalaryStrategy` | Default strategy: base salary + complement |
| `Worker` | Immutable entity with name, base salary and complement |
| `Company` | Keeps workers in a dynamic `ArrayList`, swaps strategies at runtime and prints a formatted payroll report |

The report lists every worker's base salary, complement and total, plus the number of workers and the global payroll. Because the salary rule is a strategy, new calculation rules (bonuses, taxes, ...) can be added without touching `Worker` or `Company`.

**Sample output**

```text
Name                 | Base Salary     | Complement      | Total Salary
Alice Smith          | 3200.00         | 450.00          | 3650.00
Bob Johnson          | 2800.00         | 300.00          | 3100.00
Clara Evans          | 4100.00         | 600.00          | 4700.00
Total Workers: 3 | Global Payroll: $11450.00
```

## 🚀 Getting Started

```bash
git clone https://github.com/Arashomranpour/java__practices.git
cd java__practices
javac -d out src/Main.java
java -cp out Main
```

Or open the folder in IntelliJ IDEA and run `Main`.

## 📁 Project Structure

```
.
└── src/
    └── Main.java
```

## 🛠️ Tech Stack

`Java` · `Collections / Streams` · `Strategy design pattern`
