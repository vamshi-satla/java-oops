import java.util.ArrayList;
import java.util.List;

class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters for attributes
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Customer {
    private int customerId;
    private String name;
    private ShoppingCart cart;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.cart = new ShoppingCart();
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
    }

    public double checkout() {
        return cart.calculateTotal();
    }
}

class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product) {
        items.add(product);
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

public class OnlineShoppingSystem {
    public static void main(String[] args) {
        Product laptop = new Product(1, "DELL", 50000);
        Product phone = new Product(2, "HP", 40000);

        Customer alice = new Customer(101, "Alice");
        alice.addToCart(laptop);
        alice.addToCart(phone);

        double totalAmount = alice.checkout();
        System.out.println("Total amount: $" + totalAmount);
    }
}