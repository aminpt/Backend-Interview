/**
 * A class representing a product with its price, weight, and product id.
 */
public class Products {
    int price;  // Price of the product
    float weight;  // Weight of the product
    int id;  // Product ID

    /**
     * Constructor to initialize a product with a id, weight, and price.
     *
     * @param id the ID or number of the product.
     * @param weight the weight of the product.
     * @param price the price of the product.
     */
    public Products(int id, float weight, int price) {
        this.price = price;
        this.weight = weight;
        this.id = id;
    }
}