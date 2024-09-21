import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * This project includes a method to parse the product details, sort them, and find the optimal set of products
 * that maximize the total value without exceeding the weight limit.
 * </p>
 *
 * @author amin pourtavanaie
 * @version 1.0
 * @since 2024-09-19
 */
public class Main {

    /**
     * Main method to interact with the user and solve the problem based on input.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter max weight:");
        int maxWeight = scanner.nextInt();

        // Consume the newline character after reading the integer input
        scanner.nextLine();

        System.out.println("Enter products:");
        String productString = scanner.nextLine();

        // Call the Pack function to solve the problem and display the result
        System.out.println(Pack(maxWeight, productString));
    }

    /**
     * This method selects products to maximize their value without exceeding the maximum weight.
     *
     * @param maxWeight the maximum weight the can hold.
     * @param productString the string representing the list of products in the format (id,weight,$price).
     * @return a string representing the list of selected product Ids.
     */
    public static String Pack(int maxWeight, String productString) {
        // Initialize a list to store products
        ArrayList<Products> products = new ArrayList<>();

        // Split the productString into individual product components using space as the delimiter
        String[] items = productString.split(" ");

        // Define a regex pattern to extract product Id, weight, and price from each item
        String regex = "\\((?<id>\\d+),(?<weight>([0-9]*[.])?[0-9]++),\\$(?<price>\\d+)\\)";
        Pattern pattern = Pattern.compile(regex);

        // Loop through each item, extract its details using regex, and add to the product list
        for (String item : items) {
            Matcher matcher = pattern.matcher(item);
            matcher.find();

            // Add the product to the list by extracting Id, weight, and price
            products.add(new Products(
                    Integer.valueOf(matcher.group("id")),
                    Float.valueOf(matcher.group("weight")),
                    Integer.valueOf(matcher.group("price"))
            ));
        }

        // Sort the products based on weight in ascending order
        Sort(products);

        // Get the Number of items
        int itemNumber = items.length;

        // Initialize a table to store maximum value for each weight limit
        int[][] table = new int[itemNumber + 1][maxWeight + 1];
        int weight;
        int price;

        // fill the table based on the logic(table[i][w] holds the maximum value we can achieve with the first i items, given a capacity of w).
        for (int i = 1; i <= itemNumber; i++) {
            weight = (int) products.get(i - 1).weight; // Get weight of current product
            price = products.get(i - 1).price; // Get price of current product

            for (int w = 0; w <= maxWeight; w++) {
                if (weight <= w) {
                    // Maximize the value: choose between including or excluding the product
                    table[i][w] = Math.max(table[i - 1][w], table[i - 1][w - weight] + price);
                } else {
                    // If the current product exceeds the weight limit, exclude it
                    table[i][w] = table[i - 1][w];
                }
            }
        }

        // List to store the best selected product Ids
        ArrayList<Integer> bestItems = new ArrayList<>();

        // Backtracking to find the selected items based on the filled table
        for (int i = itemNumber; i > 0; i--) {
            if (table[i][maxWeight] != table[i - 1][maxWeight]) {
                // If the value in the table differs from the previous row, it means the item was included
                bestItems.add(products.get(i - 1).id); // Add product Id to the result
                maxWeight -= (int) products.get(i - 1).weight; // Decrease the remaining weight
            }
        }

        // Return the list of best selected item Ids as a string
        return bestItems.toString();
    }

    /**
     * Sorts a list of products based on their weight in ascending order using Bubble Sort.
     * Since the maximum Id of products is 100, a simple sorting algorithm is sufficient.
     * 
     * @param products the list of products to be sorted.
     * @return the sorted list of products.
     */
    public static ArrayList<Products> Sort(ArrayList<Products> products) {
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(j).weight < products.get(i).weight) {
                    // Swap products if the next one is lighter than the current one
                    Collections.swap(products, i, j);
                }
            }
        }

        // Return the sorted list of products
        return products;
    }
}

