## Description

This project contains automated tests developed as part of the test assignment for **Bookmap**.  
The tests are written in **Java**, use **Gradle** for build management, **TestNG** as the testing framework, and **Allure** for generating reports.

## Requirements

- Java 21
- Gradle 8.5

## How to Run Tests on Linux OS

1. Clone the repository:
   ```bash
   git clone https://github.com/ISaN4iK/BookmapTestTask
   cd <project_directory>
   ```
2. Run tests using Gradle:
   ```bash
    ./gradlew clean test
   ```
3. Run allure server for check report:
   ```bash
    ./gradlew allureServe
   ```

## Bug reports:

- **BUG-001:**  
  Precondition: Create instance of [Calculator.java](src%2Fmain%2Fjava%2Fohorobets%2Fcalculator%2FCalculator.java)  
  STR: Use method **add** with parameters ```1.123, 2.222222, 3.00001```  
  AR: ```6.345231999999999```  
  ER: ```6.345232```  
  <br>
- **BUG-002:**  
  Precondition: Create instance of [Calculator.java](src%2Fmain%2Fjava%2Fohorobets%2Fcalculator%2FCalculator.java)  
  STR: Use method **subtract** with parameters ```2.222222, 3.00001```  
  AR: ```-0.7777880000000001```  
  ER: ```-0.777788```  
  <br>
- **BUG-003:**  
  Precondition: Create instance of [Calculator.java](src%2Fmain%2Fjava%2Fohorobets%2Fcalculator%2FCalculator.java)  
  STR: Use method **multiply** with parameters ```1.1, 1.1```  
  AR: ```1.2100000000000002```  
  ER: ```1.21```  
  <br>
- **BUG-004:**  
  Precondition: Create instance of [Calculator.java](src%2Fmain%2Fjava%2Fohorobets%2Fcalculator%2FCalculator.java)  
  STR: Use method **divide** with parameters ```0.3, 0.1```  
  AR: ```2.9999999999999996```  
  ER: ```3.0```