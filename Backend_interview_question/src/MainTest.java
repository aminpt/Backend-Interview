import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * MainTest is a test class designed to verify the functionality of the methods in the Main class.
 */

class MainTest {

    /**
     * Test the Pack method with valid input
     */
    @Test
    void pack_validInput() {
        int maxWeight = 95;
        String productString = "(1,23.9,$45) (2,80.5,$83) (3,62.48,$53)";

        // Expected output: [3, 1]
        String expected = "[3, 1]";

        // Call the Pack method from Main class
        assertEquals(expected, Main.Pack(maxWeight, productString));
    }

    /**
     * Test the Pack method with another valid input to verify its correctness
     */
    @Test
    void pack_anotherValidInput() {
        int maxWeight = 81;
        String productString = "(1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)";

        // Expected output: [4] (only product 4 fits)
        String expected = "[4]";

        // Call the Pack method
        assertEquals(expected, Main.Pack(maxWeight, productString));
    }

    /**
     * Test the Pack method when no items can be selected
     */
    @Test
    void pack_noItemsSelected() {
        int maxWeight = 8;
        String productString = "(1,15.3,$34)";

        // Expected output: []
        String expected = "[]";

        // Call the Pack method
        assertEquals(expected, Main.Pack(maxWeight, productString));
    }

    /**
     * Test the Sort method to ensure it sorts products by weight in ascending order
     */
    @Test
    void sort_validInput() {
        ArrayList<Products> products = new ArrayList<>();
        products.add(new Products(1, 30, 100));
        products.add(new Products(2, 10, 50));
        products.add(new Products(3, 20, 60));

        // Call the Sort method
        ArrayList<Products> sortedProducts = Main.Sort(products);

        // Verify that products are sorted by weight in ascending order
        assertEquals(2, sortedProducts.get(0).id); // First product should have weight 10
        assertEquals(3, sortedProducts.get(1).id); // Second product should have weight 20
        assertEquals(1, sortedProducts.get(2).id); // Third product should have weight 30
    }

    /**
     * Test the Sort method when the products are already sorted
     */
    @Test
    void sort_alreadySorted() {
        ArrayList<Products> products = new ArrayList<>();
        products.add(new Products(1, 10, 100));
        products.add(new Products(2, 20, 200));
        products.add(new Products(3, 30, 300));

        // Call the Sort method
        ArrayList<Products> sortedProducts = Main.Sort(products);

        // Verify that the order remains the same
        assertEquals(1, sortedProducts.get(0).id); // First product (weight 10)
        assertEquals(2, sortedProducts.get(1).id); // Second product (weight 20)
        assertEquals(3, sortedProducts.get(2).id); // Third product (weight 30)
    }

}
