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

## **Open Closed Principle (OCP)**
- **Definition:** Software entities (classes, modules, functions) should be open for extension, but closed for modification.
- You should be able to add new functionality without changing existing code.
- This helps prevent breaking existing features and makes code easier to maintain.
- Avoid modifying existing tested code.
- Changing existing code can:
  - introduce bugs
  - break other features
  - require regression testing
- Use abstraction
- OCP usually works through:
  - Interfaces
  - Abstract classes
  - Polymorphism
  - Strategy pattern
  - Dependency injection
- These allow new implementations without touching old code.

### Why OCP Matters
- Enables safe evolution of code as requirements change.
- Reduces risk of regression bugs.
- Makes code more reusable and testable.
- Encourages modular, loosely coupled design.

### Common OCP Violations
- Modifying existing classes to add new behavior instead of extending them.
- Using large switch/case or if/else blocks to handle new types or operations.
- Not leveraging abstraction (interfaces, abstract classes) for extensibility.

#### Example: OCP Violation
```java
public class PaymentProcessor {
    public void process(String paymentType) {
        if (paymentType.equals("credit")) {
            // process credit card
        } else if (paymentType.equals("paypal")) {
            // process PayPal
        } else if (paymentType.equals("crypto")) {
            // process crypto
        }
    }
}
```
- Every time a new payment type is added, this class must be modified.
- This violates OCP: the class is not closed for modification.

#### Fix: OCP Compliant Design
```java
public interface PaymentStrategy {
    void process();
}

public class CreditCardPayment implements PaymentStrategy {
    public void process() { /* ... */ }
}

public class PayPalPayment implements PaymentStrategy {
    public void process() { /* ... */ }
}

public class CryptoPayment implements PaymentStrategy {
    public void process() { /* ... */ }
}

public class PaymentProcessor {
    private PaymentStrategy paymentStrategy;
    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void process() {
        paymentStrategy.process();
    }
}
```
- New payment types can be added by creating new classes implementing `PaymentStrategy`.
- No changes needed in `PaymentProcessor`.

#### Example: OCP Violation: Logging
```java
public class LoggerService {

    public void log(String type, String message) {

        if(type.equals("FILE")) {
            logToFile(message);
        }
        else if(type.equals("DB")) {
            logToDatabase(message);
        }
    }
}
```
- Adding `KAFKA` logging requires modifying this class.

#### Fix: Better logging configuration using OCP
```java
public interface Logger {
    void log(String message);
}

public class FileLogger implements Logger {
    public void log(String message) {}
}

public class DatabaseLogger implements Logger {
    public void log(String message) {}
}

public class LoggerService {
    public void log(Logger logger, String message) {
        logger.log(message);
    }
}
```
- Adding `KAFKA` logger:
```java
public class KafkaLogger implements Logger {
    // ...
}
```

#### OCP Violation in REST Controllers
- Bad example: controller containing business logic
```java
@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest request) {

        if ("CARD".equals(request.getType())) {
            // card logic
            processCard(request);
        } 
        else if ("UPI".equals(request.getType())) {
            processUpi(request);
        } 
        else if ("NETBANKING".equals(request.getType())) {
            processNetbanking(request);
        }

        return ResponseEntity.ok("Payment processed");
    }
}
```

#### Fix using Stragegy pattern
```java
// Step 1 : Abstraction
public interface PaymentProcessor {
    void process(PaymentRequest request);
}

// Step 2 : Implement processors
@Component
public class CardPaymentProcessor implements PaymentProcessor {
    public void process(PaymentRequest request) {
        // card payment logic
    }
}

@Component
public class UpiPaymentProcessor implements PaymentProcessor {
    public void process(PaymentRequest request) {
        // upi payment logic
    }
}

// Step 3 : Processor Resolver
@Component
public class PaymentProcessorFactory {

    private Map<String, PaymentProcessor> processors;

    public PaymentProcessorFactory(List<PaymentProcessor> processorList) {
        processors = new HashMap<>();
        processors.put("CARD", processorList.get(0));
        processors.put("UPI", processorList.get(1));
    }

    public PaymentProcessor getProcessor(String type) {
        return processors.get(type);
    }
}

// Step 4 : Clean controller
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentProcessorFactory factory;

    @PostMapping
    public ResponseEntity<String> processPayment(@RequestBody PaymentRequest request) {

        PaymentProcessor processor = factory.getProcessor(request.getType());
        processor.process(request);

        return ResponseEntity.ok("Payment processed");
    }
}
```

### OCP in Spring Boot
- Spring naturally supports OCP through Dependency Injection.
- Example:
```java
public interface NotificationService {
    void send();
}
```
- Implementations:
```
EmailNotificationService
SmsNotificationService
PushNotificationService
```
- Spring can inject the appropriate implementation.
- The service using it doesn't need modification.

### Best Practices for OCP
- Use interfaces and abstract classes to define extension points.
- Favor composition and delegation over inheritance.
- Avoid modifying existing code for new requirements; extend instead.
- Use design patterns like Strategy, Decorator, and Factory to support OCP.

### Summary
- OCP helps build robust, maintainable, and scalable systems.
- Design for extension, not modification.
- Refactor code that requires frequent changes to support OCP.

## **Liskov Substitution Principle (LSP)**
- **Definition:** Objects of a superclass shall be replaceable with objects of a subclass without affecting the correctness of the program.
- Subtypes must be substitutable for their base types.
- Derived classes must extend the base classes without changing their behavior.

- Simple Meaning
  - If B extends A, then:
  - `A obj = new B();` should work without any issues.
- If the subclass changes expected behavior → LSP violation.

### Key points of LSP
- Subclass should not break parent behavior.
  - Example contract:
  - `withdraw(amount)`
  - Expected behavior: withdraw money, reduce balance
  - If subclass changes this behavior → violation.
- Subclass should not throw new unexpected exceptions
  - If parent method allows operation but subclass throws error → violation.
- Subclass should not strengthen preconditions
  - Meaning:
  - Parent allows: `withdraw(amount)`
  - Subclass should not require: `withdraw(amount > 1000 only)`
- Subclass should not weaken postconditions
  - Example:
  - Parent guarantees: deposit increases balance
  - Subclass must guarantee the same.

### Why LSP Matters
- Ensures that a subclass can stand in for its superclass.
- Guarantees the behavior of the program remains consistent when switching between base and derived classes.
- Promotes the use of abstract classes and interfaces.

### Common LSP Violations
- Overriding methods in a subclass that change the expected behavior of the method in the superclass.
- Failing to implement inherited abstract methods.
- Introducing new restrictions in the subclass that are not present in the superclass.

#### Example: LSP Violation
```java
public class Bird {
    public void fly() { /* ... */ }
}

public class Ostrich extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```
- `Ostrich` is a subclass of `Bird`, but it cannot be used interchangeably with `Bird` without breaking the code.
- This violates LSP.

#### Fix: LSP Compliant Design
```java
public abstract class Bird {
    public abstract void move();
}

public class Sparrow extends Bird {
    public void move() { /* fly */ }
}

public class Ostrich extends Bird {
    public void move() { /* run */ }
}
```
- Both `Sparrow` and `Ostrich` extend `Bird` and provide their own implementation of `move()`.
- The behavior of the program remains consistent, and the subclasses can be used interchangeably with the base class.

#### Example: another Bad design
```java
public class Rectangle {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

public class Square extends Rectangle {

    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }
}
```
- Code using Rectangle
```java
public void test(Rectangle r) {
    r.setWidth(5);
    r.setHeight(10);

    System.out.println(r.getArea());
}
```
- Expected output : 50
- But with Square
```java
Square s = new Square();
test(s);
```
- Output becomes : 100
- because width and height changed together, violates LSP.

#### Fix: Use better abstraction
```java
public interface Shape {
    int getArea();
}

public class Rectangle implements Shape {
    // ...
}

public class Square implements Shape {
    // ...
}
```

### Best Practices for LSP
- Design your classes so that they can be easily extended.
- Ensure that subclasses do not alter the expected behavior of the superclass.
- Use interfaces or abstract classes to define contracts for subclasses.
- Favor composition over inheritance to achieve code reuse.

### Summary
- LSP is about ensuring that a subclass can replace a superclass without affecting the correctness of the program.
- Adhering to LSP leads to a more robust and maintainable codebase.

## **Interface Segregation Principle (ISP)**
- **Definition:** No client should be forced to depend on methods it does not use.
- Interfaces should be client-specific rather than one general-purpose interface.
- This prevents a situation where a class is implementing an interface but not using all of its methods.

### Key points of ISP
- Prefer small, focused interfaces
  - Interfaces should represent specific capabilities.
  - Bad: `Machine`
  - Good: `Printer`, `Scanner`, `FaxMachine`
- Classes should not implement unused methods
  - If a class must implement methods that it does not need, the interface design is wrong.
- Avoid “fat interfaces”
  - A fat interface has many unrelated methods.
  - Example: `EmployeeOperations`
  - Containing:
    - payroll
    - leave
    - promotion
    - recruitment
    - training
  - These should likely be separate.

### Why ISP Matters
- Promotes the use of smaller, more specific interfaces.
- Reduces the impact of changes in the code.
- Increases the flexibility and reusability of the code.

### Common ISP Violations
- Creating large interfaces with many methods.
- Forcing classes to implement methods they do not need.
- Not using interfaces at all, leading to tight coupling between classes.

#### Example: ISP Violation
```java
public interface Worker {
    void work();
    void eat();
}

public class Human implements Worker {
    public void work() { /* ... */ }
    public void eat() { /* ... */ }
}

public class Robot implements Worker {
    public void work() { /* ... */ }
    public void eat() {
        throw new UnsupportedOperationException("Robots don't eat");
    }
}
```
- `Robot` is forced to implement the `eat()` method even though it does not need it.
- This violates ISP.

#### Fix: ISP Compliant Design
```java
public interface Workable {
    void work();
}

public interface Eatable {
    void eat();
}

public class Human implements Workable, Eatable {
    public void work() { /* ... */ }
    public void eat() { /* ... */ }
}

public class Robot implements Workable {
    public void work() { /* ... */ }
}
```
- `Human` implements both `Workable` and `Eatable` interfaces.
- `Robot` only implements the `Workable` interface.
- No unnecessary methods are present in the classes, and each class only implements the methods it needs.

### Signs of ISP Violation
- Interfaces with too many methods.
- `UnsupportedOperationException`
  - `throw new UnsupportedOperationException();`
- Empty implementations
  - `public void eat() { }` in `Robot` class
- Classes implementing unrelated functionality.
- These are clear indicators that the interface is not properly segregated.

### Best Practices for ISP
- Use small, specific interfaces instead of large, general-purpose ones.
- Ensure that classes only implement methods that are relevant to them.
- Favor composition over inheritance to achieve code reuse.
- Use design patterns like Adapter and Facade to provide a simplified interface to a complex subsystem.

### Summary
- ISP is about ensuring that no client is forced to depend on methods it does not use.
- Adhering to ISP leads to a more flexible and maintainable codebase.

## **Dependency Inversion Principle (DIP)**
- **Definition:** High-level modules should not depend on low-level modules. Both should depend on abstractions (e.g., interfaces).
- Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.
- This reduces the coupling between different parts of the code and makes it more flexible and easier to maintain.

### Key points of DIP
- High-level modules = business logic
  - Examples: `OrderService`, `PaymentService`, `EmployeeService`
  - These should not depend directly on concrete classes.
- Low-level modules = implementation details
  - Examples: Database access, HTTP clients, File system, Email services
  - These should depend on interfaces.
- Use abstractions (interfaces)
  - DIP typically uses: Interfaces, Dependency Injection, Inversion of Control (IoC)
  - This is exactly what Spring Framework does automatically.

### Why DIP Matters
- Reduces the coupling between different parts of the code.
- Increases the flexibility and reusability of the code.
- Makes the code easier to test and maintain.

### Common DIP Violations
- High-level modules depending directly on low-level modules.
- Not using interfaces or abstract classes to define contracts between modules.
- Tight coupling between classes, making it difficult to change or replace them.

#### Example: DIP Violation
```java
public class LightBulb {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

public class Switch {
    private LightBulb bulb;

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
    }

    public void operate(String command) {
        if (command.equals("on")) {
            bulb.turnOn();
        } else if (command.equals("off")) {
            bulb.turnOff();
        }
    }
}
```
- `Switch` is a high-level module that directly depends on the low-level module `LightBulb`.
- This violates DIP.

#### Fix: DIP Compliant Design
```java
public interface Switchable {
    void turnOn();
    void turnOff();
}

public class LightBulb implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

public class Fan implements Switchable {
    public void turnOn() { /* ... */ }
    public void turnOff() { /* ... */ }
}

public class Switch {
    private Switchable device;

    public Switch(Switchable device) {
        this.device = device;
    }

    public void operate(String command) {
        if (command.equals("on")) {
            device.turnOn();
        } else if (command.equals("off")) {
            device.turnOff();
        }
    }
}
```
- `Switch` now depends on the `Switchable` interface, not on the concrete implementations of `LightBulb` or `Fan`.
- This adheres to DIP: high-level modules depend on abstractions, not on low-level modules.

#### Example: another DIP violation (Bad Design)
```java
public class NotificationService {

    private EmailService emailService = new EmailService();

    public void send(String message) {
        emailService.sendEmail(message);
    }
}
```
- `NotificationService` directly depends on EmailService.
- If tomorrow you want:
  - SMS notifications
  - Push notifications
  - Slack notifications
- You must modify the class.

#### Fix using Abstraction
```java
// Step 1 : Create interface
public interface MessageService {
    void send(String message);
}

// Step 2 : Implementation
public class EmailService implements MessageService {

    public void send(String message) {
        System.out.println("Sending Email");
    }
}

// Step 3 : High level module depends on interface
public class NotificationService {

    private MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send(String message) {
        messageService.send(message);
    }
}
```
- Now `NotificationService` depends on abstraction, not implementation.

### Signs of DIP violation
- `new` keyword inside business classes: `EmailService email = new EmailService();`
- Direct dependency on concrete classes
  - MySqlRepository
  - FileLogger
  - StripeGateway
- Difficult unit testing.
- Tight coupling between layers
  - `Controller → Concrete Service → Concrete Repository`

### Best Practices for DIP
- Use interfaces or abstract classes to define contracts between high-level and low-level modules.
- Ensure that high-level modules do not depend directly on low-level modules.
- Favor composition over inheritance to achieve code reuse.
- Use design patterns like Dependency Injection, Inversion of Control, and Service Locator to manage dependencies.

### Summary
- DIP is about reducing the coupling between different parts of the code by depending on abstractions, not on concrete implementations.
- Adhering to DIP leads to a more flexible, reusable, and maintainable codebase.
