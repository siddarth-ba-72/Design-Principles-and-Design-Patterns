# Software Design Principles (**SOLID**)
- S - Single Responsibility Principle (SRP)
- O - Open Closed Principle (OCP)
- L - Liskov Substitution Principle (LSP)
- I - Interface Segregation Principle (ISP)
- D - Dependency Inversion Principle (DIP)

## **Single Responsibility Principle (SRP)**
- A class should have only one reason to change
- SRP is **NOT** “A class should do only one thing”
- SRP is “A class should have only one responsibility (one axis of change)”
- If tomorrow a requirement changes, how many different stakeholders would ask me to modify this class?
    - If the answer is more than one → SRP violation.
- Responsibility ≠ Method Count
    - A class can have 20 methods, Complex logic, Multiple helper functions
    - But if all of them support the same responsibility, it still follows SRP.
- Responsibilities Are About Roles
- Common responsibility categories:
    - Business logic
    - Data access
    - Validation
    - Logging
    - Notification
    - Fomatting
    - Persistence
    - Security
- Mixing them → SRP violation

### SRP violated code
```java
public class EmployeeService {

    public void saveEmployee(Employee emp) {
        // validate employee
        if (emp.getAge() < 18) {
            throw new RuntimeException("Invalid age");
        }

        // save to DB
        employeeRepository.save(emp);

        // send email
        sendWelcomeEmail(emp);

        // log activity
        logToFile(emp);
    }

    private void sendWelcomeEmail(Employee emp) {
        // email logic
    }

    private void logToFile(Employee emp) {
        // file logging
    }
}
```
- Why is this violated?
- This class changes if:
    - Validation rule changes
    - Database changes
    - Email format changes
    - Logging mechanism changes
- That’s 4 different reasons to change.

### Better version with SRP
```java
@Service
public class EmployeeService {

    private final EmployeeValidator validator;
    private final EmployeeRepository repository;
    private final NotificationService notificationService;

    public void saveEmployee(Employee emp) {
        validator.validate(emp);
        repository.save(emp);
        notificationService.sendWelcomeEmail(emp);
    }
}
```

### Important: Don't Over-Engineer
- SRP is not:
    - Every method → separate class
    - Every if-condition → separate class
- Too much splitting → unnecessary complexity

### SRP helps in:
- Writing clean testable services
- Easier unit testing (mock dependencies)
- Avoiding huge God classes
- Maintaining production systems safely

### SRP Violation in Multi-Threaded Code
#### Bad example
```java
public class OrderProcessor implements Runnable {

    private Order order;

    public OrderProcessor(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        // 1. Business logic
        calculateDiscount(order);

        // 2. Save to DB
        saveOrder(order);

        // 3. Send email
        sendConfirmationEmail(order);

        // 4. Log audit
        logAudit(order);
    }

    private void calculateDiscount(Order order) { }
    private void saveOrder(Order order) { }
    private void sendConfirmationEmail(Order order) { }
    private void logAudit(Order order) { }
}
```
- Why This Violates SRP? This class changes if:
    - Discount logic changes
    - DB schema changes
    - Email template changes
    - Logging strategy changes
    - Threading model changes
- That’s 5 different reasons to change
- Even worse: Now concurrency and business logic are tightly coupled

#### Refactored, seperate responsibilities
```java
public class OrderTask implements Runnable {

    private final OrderService orderService;

    public OrderTask(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run() {
        orderService.processOrder();
    }
}
```
```java
@Service
public class OrderService {

    private final DiscountService discountService;
    private final OrderRepository repository;
    private final NotificationService notificationService;
    private final AuditService auditService;

    public void processOrder() {
        discountService.apply();
        repository.save();
        notificationService.send();
        auditService.log();
    }
}
```
- Why This Is Better
    - Threading concern → `OrderTask`
    - Business concern → `OrderService`
    - DB concern → `Repository`
    - Email concern → `NotificationService`
- Each has one responsibility

### Production-style SRP violation

```java
@Service
public class PaymentService {

    public void processPayment(PaymentRequest request) {

        // validation
        if(request.getAmount() <= 0) {
            throw new IllegalArgumentException();
        }

        // business logic
        double tax = request.getAmount() * 0.18;

        // external call
        restTemplate.postForObject("http://bank/pay", request, String.class);

        // persistence
        jdbcTemplate.update("INSERT INTO payments...");

        // send email
        mailSender.send(...);

        // logging
        logger.info("Payment completed");
    }
}
```
- Reasons to change:
    - Tax rule change
    - Bank API change
    - DB change
    - Email change
    - Validation change
- Huge SRP violation

#### Proper desgin
- Validation layer
```java
@Component
public class PaymentValidator {
    public void validate(PaymentRequest request) { }
}
```

- Business logic layer
```java
@Component
public class PaymentCalculator {
    public double calculateTax(double amount) { }
}
```

- Gateway layer
```java
@Component
public class BankGateway {
    public void charge(PaymentRequest request) { }
}
```

- Persistence layer
```java
@Repository
public class PaymentRepository {
    public void save(Payment payment) { }
}
```

- Notification layer
```java
@Component
public class PaymentNotificationService {
    public void notify(Payment payment) { }
}
```

- **Orchestrator**
```java
@Service
public class PaymentOrchestrator {

    private final PaymentValidator validator;
    private final PaymentCalculator calculator;
    private final BankGateway bankGateway;
    private final PaymentRepository repository;
    private final PaymentNotificationService notificationService;

    public void process(PaymentRequest request) {

        validator.validate(request);

        double tax = calculator.calculateTax(request.getAmount());

        bankGateway.charge(request);

        repository.save(...);

        notificationService.notify(...);
    }
}
```