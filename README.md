Knapsack Problem Solver
This project implements a solution to the Knapsack Problem using dynamic programming in Java. The program allows you to enter a set of products with weights and values, and it calculates the optimal selection of products that maximize the total value without exceeding a given weight limit.

Features
Knapsack Solver: Solves the knapsack problem using dynamic programming, ensuring that the products selected have the maximum possible value within the weight constraint.
Product Sorting: Sorts products based on their weight in ascending order.
Regex Parsing: Extracts product information from a formatted string using regular expressions.
Project Structure
Main.java: Contains the logic for solving the knapsack problem and sorting products by weight.
Products.java: Represents a product with its weight, price, and unique identifier.
MainTest.java: Unit tests for the Pack and Sort methods using JUnit 5.
How to Use
Run the Application:

When prompted, enter the maximum weight for the knapsack.
Enter the list of products in the format (id,weight,$price). Example input:
bash
Copy code
(1,23.9,$45) (2,80.5,$83) (3,62.48,$53)
The program will output the IDs of the selected products that maximize value without exceeding the weight limit.
Sample Input/Output:

Input:

bash
Copy code
Enter max weight: 95
Enter products: (1,23.9,$45) (2,80.5,$83) (3,62.48,$53)
Output:

csharp
Copy code
[3, 1]
How to Run the Tests
The project uses JUnit 5 for unit testing. The MainTest class tests the core methods of the project (Pack and Sort).

Running Tests with Maven
If you are using Maven, you can run the tests by executing:

bash
Copy code
mvn test
Running Tests from IDE
Import the project into your IDE (e.g., IntelliJ IDEA or Eclipse).
Right-click on the MainTest class and select Run to execute the tests.
Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/knapsack-solver.git
cd knapsack-solver
Open the Project in an IDE (such as IntelliJ IDEA, Eclipse, or VS Code).

Build and Run the Project:

If you're using an IDE, just run the Main class.
Alternatively, you can compile and run the project via the command line:
bash
Copy code
javac Main.java Products.java
java Main
Dependencies
JUnit 5: For unit testing. You can add the following dependency to your pom.xml if you're using Maven:

xml
Copy code
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.8.1</version>
        <scope>test</scope>
    </dependency>
</dependencies>
Project Structure
bash
Copy code
.
├── Main.java          # Main class with Pack and Sort methods
├── Products.java      # Class representing a product (weight, price, ID)
├── MainTest.java      # Unit tests for the Main class methods
├── README.md          # Project documentation
└── pom.xml            # Maven configuration file (optional)
License
This project is licensed under the MIT License - see the LICENSE file for details.

Author
Your Name - Your GitHub Profile
