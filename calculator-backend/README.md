# Calculator Backend

This project is a simple calculator backend built using Spring Boot. It provides RESTful APIs for basic arithmetic operations such as addition, subtraction, multiplication, and division.

## Project Structure

```
calculator-backend
├── src
│   └── main
│       └── java
│           └── com
│               └── example
│                   └── calculator
│                       ├── CalculatorApplication.java
│                       ├── controller
│                       │   └── CalculatorController.java
│                       ├── service
│                       │   └── CalculatorService.java
│                       └── model
│                           └── CalculationRequest.java
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   cd calculator-backend
   ```

2. **Build the project:**
   ```
   mvn clean install
   ```

3. **Run the application:**
   ```
   mvn spring-boot:run
   ```

## Usage

Once the application is running, you can access the calculator APIs at `http://localhost:8080/api/calculator`.

### API Endpoints

- **Addition**
  - `POST /api/calculator/add`
  - Request Body: `{ "a": number, "b": number }`
  - Response: `{ "result": number }`

- **Subtraction**
  - `POST /api/calculator/subtract`
  - Request Body: `{ "a": number, "b": number }`
  - Response: `{ "result": number }`

- **Multiplication**
  - `POST /api/calculator/multiply`
  - Request Body: `{ "a": number, "b": number }`
  - Response: `{ "result": number }`

- **Division**
  - `POST /api/calculator/divide`
  - Request Body: `{ "a": number, "b": number }`
  - Response: `{ "result": number }`

## Dependencies

This project uses Maven for dependency management. The main dependencies include Spring Boot and any additional libraries required for the calculator functionality.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.