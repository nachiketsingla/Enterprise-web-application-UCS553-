import java.util.*;

class ShoppingException extends Exception {
    public ShoppingException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends ShoppingException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class OutOfStockException extends ShoppingException {
    public OutOfStockException(String message) {
        super(message);
    }
}

class EmptyCartException extends ShoppingException {
    public EmptyCartException(String message) {
        super(message);
    }
}

class PaymentException extends ShoppingException {
    public PaymentException(String message) {
        super(message);
    }
}

class Product {

    int id;
    String name;
    double price;
    int stock;

    Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

public class ShoppingCart {

    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Product> cart = new ArrayList<>();

    static Product searchProduct(int id)
            throws ProductNotFoundException {

        for (Product p : products) {
            if (p.id == id) {
                return p;
            }
        }

        throw new ProductNotFoundException(
            "Product not found."
        );
    }

    static void addToCart(int id)
            throws ProductNotFoundException,
                   OutOfStockException {

        Product p = searchProduct(id);

        if (p.stock <= 0) {
            throw new OutOfStockException(
                p.name + " is out of stock."
            );
        }

        cart.add(p);
        p.stock--;

        System.out.println(p.name + " added to cart.");
    }

    static void removeFromCart(int id)
            throws ProductNotFoundException {

        for (Product p : cart) {

            if (p.id == id) {

                cart.remove(p);
                p.stock++;

                System.out.println(
                    p.name + " removed from cart."
                );

                return;
            }
        }

        throw new ProductNotFoundException(
            "Product is not present in cart."
        );
    }

    static double calculateTotal() {

        double total = 0;

        for (Product p : cart) {
            total += p.price;
        }

        return total;
    }

    static void payment(double amount)
            throws EmptyCartException,
                   PaymentException {

        if (cart.isEmpty()) {
            throw new EmptyCartException(
                "Cart is empty."
            );
        }

        double total = calculateTotal();

        if (amount < total) {
            throw new PaymentException(
                "Insufficient payment amount."
            );
        }

        System.out.println(
            "Payment successful. Amount paid = " + amount
        );

        cart.clear();
    }

    public static void main(String[] args) {

        products.add(
            new Product(1, "Laptop", 50000, 5)
        );

        products.add(
            new Product(2, "Mouse", 1000, 10)
        );

        products.add(
            new Product(3, "Keyboard", 2000, 3)
        );

        try {

            addToCart(1);
            addToCart(2);

            System.out.println(
                "Cart Total = " + calculateTotal()
            );

            payment(51000);

        } catch (ProductNotFoundException e) {

            System.out.println(
                "Product Error: " + e.getMessage()
            );

        } catch (OutOfStockException e) {

            System.out.println(
                "Stock Error: " + e.getMessage()
            );

        } catch (EmptyCartException e) {

            System.out.println(
                "Cart Error: " + e.getMessage()
            );

        } catch (PaymentException e) {

            System.out.println(
                "Payment Error: " + e.getMessage()
            );
        }
    }
}