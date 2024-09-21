# Knapsack Problem Solver

This project implements a solution to the **Knapsack Problem** using dynamic programming in Java. The program allows you to enter a set of products with weights and values, and it calculates the optimal selection of products that maximize the total value without exceeding a given weight limit.

## Features

- **Knapsack Solver**: Solves the knapsack problem using dynamic programming, ensuring that the products selected have the maximum possible value within the weight constraint.
- **Product Sorting**: Sorts products based on their weight in ascending order.
- **Regex Parsing**: Extracts product information from a formatted string using regular expressions.

## Project Structure

- **Main.java**: Contains the logic for solving the knapsack problem and sorting products by weight.
- **Products.java**: Represents a product with its weight, price, and unique identifier.
- **MainTest.java**: Unit tests for the `Pack` and `Sort` methods using JUnit 5.

## How to Use

1. **Run the Application**:
   - When prompted, enter the maximum weight for the knapsack.
   - Enter the list of products in the format `(id,weight,$price)`. Example input:
     ```
     (1,23.9,$45) (2,80.5,$83) (3,62.48,$53)
     ```
   - The program will output the IDs of the selected products that maximize value without exceeding the weight limit.

2. **Sample Input/Output**:

   - **Input**:
     ```
     Enter max weight: 95
     Enter products: (1,23.9,$45) (2,80.5,$83) (3,62.48,$53)
     ```

   - **Output**:
     ```
     [3, 1]
     ```

## How to Run the Tests

The project uses **JUnit 5** for unit testing. The `MainTest` class tests the core methods of the project (`Pack` and `Sort`).

### Running Tests with Maven

If you are using Maven, you can run the tests by executing:

```bash
mvn test
