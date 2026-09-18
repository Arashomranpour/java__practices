import java.util.ArrayList;
import java.util.List;

// 1. Strategy interface to allow flexible salary calculation
interface SalaryCalculationStrategy {
    double calculateTotalSalary(double baseSalary, double complement);
}

// 2. Default calculation strategy: base + complement
class StandardSalaryStrategy implements SalaryCalculationStrategy {
    @Override
    public double calculateTotalSalary(double baseSalary, double complement) {
        return baseSalary + complement;
    }
}

// 3. Worker entity
class Worker {
    private final String name;
    private final double baseSalary;
    private final double complement;

    public Worker(String name, double baseSalary, double complement) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.complement = complement;
    }

    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public double getComplement() { return complement; }

    public double calculateTotalSalary(SalaryCalculationStrategy strategy) {
        return strategy.calculateTotalSalary(this.baseSalary, this.complement);
    }
}

// 4. Company manager
class Company {
    // Dynamic capacity: handles 20, 100, or 10,000+ workers without wasted memory
    private final List<Worker> workers = new ArrayList<>();
    private SalaryCalculationStrategy salaryStrategy;

    public Company(SalaryCalculationStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }

    public void setSalaryStrategy(SalaryCalculationStrategy salaryStrategy) {
        this.salaryStrategy = salaryStrategy;
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public double getGlobalTotalSalary() {
        return workers.stream()
                .mapToDouble(w -> w.calculateTotalSalary(salaryStrategy))
                .sum();
    }

    public void printWorkersReport() {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-20s | %-15s | %-15s | %-15s%n", "Name", "Base Salary", "Complement", "Total Salary");
        System.out.println("----------------------------------------------------------------------------------");

        for (Worker worker : workers) {
            double total = worker.calculateTotalSalary(salaryStrategy);
            System.out.printf("%-20s | %-15.2f | %-15.2f | %-15.2f%n",
                    worker.getName(),
                    worker.getBaseSalary(),
                    worker.getComplement(),
                    total);
        }

        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("Total Workers: %d | Global Payroll: $%.2f%n", workers.size(), getGlobalTotalSalary());
        System.out.println("----------------------------------------------------------------------------------");
    }
}

// 5. Main entry point
public class Main {
    public static void main(String[] args) {
        Company company = new Company(new StandardSalaryStrategy());

        // Example: Adding workers (can scale to 100+ seamlessly)
        company.addWorker(new Worker("Alice Smith", 3200.00, 450.00));
        company.addWorker(new Worker("Bob Johnson", 2800.00, 300.00));
        company.addWorker(new Worker("Clara Evans", 4100.00, 600.00));

        company.printWorkersReport();
    }
}