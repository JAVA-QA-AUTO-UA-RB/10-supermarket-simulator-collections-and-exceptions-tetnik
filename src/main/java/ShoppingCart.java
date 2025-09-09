package main.java;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<String> cart = new ArrayList<>();
    private static final int CART_LIMIT = 10;

    public void addToCart(String product) {
        if (cart.size() >= CART_LIMIT) {
            throw new CartLimitExceededException("Кошик переповнено! Максимум " + CART_LIMIT + " товарів");
        }
        cart.add(product);
    }

    public void checkout(PriceCatalog catalog, double payment)
            throws InsufficientFundsException, NoSuchProductException {
        double subtotal = 0;
        for (String p : cart) {
            subtotal += catalog.getPrice(p); // може кинути NoSuchProductException (checked)
        }
        double tax = subtotal * 0.10;
        double discount = (Math.random() * 0.10 + 0.05);
        if (cart.contains("Milk")) discount += 0.05;
        double total = (subtotal + tax) * (1 - discount);
        if (payment < total) {
            throw new InsufficientFundsException(
                    "Недостатньо коштів! Потрібно " + String.format("%.2f", total) +
                            ", а отримано " + String.format("%.2f", payment) );
        }
        System.out.printf("Оплата пройшла успішно! Загальна сума: %.2f (ПДВ: %.2f, знижка: %.0f%%)\n",
                total, tax, discount * 100);
    }

    public void printReceipt(PriceCatalog catalog) throws NoSuchProductException {
        System.out.println("===== Чек =====");
        double subtotal = 0;
        for (String p : cart) {
            double price = catalog.getPrice(p);
            System.out.printf("%s: %.2f\n", p, price);
            subtotal += price;
        }
        double tax = subtotal * 0.10;
        double discount = (Math.random() * 0.10 + 0.05);
        if (cart.contains("Milk")) discount += 0.05;
        double total = (subtotal + tax) * (1 - discount);
        System.out.printf("Проміжна сума: %.2f\n", subtotal);
        System.out.printf("ПДВ: %.2f\n", tax);
        System.out.printf("Знижка: %.0f%%\n", discount * 100);
        System.out.printf("До сплати: %.2f\n", total);
        System.out.println("================");
    }

    public List<String> getCart() {
        return new ArrayList<>(cart);
    }
}



