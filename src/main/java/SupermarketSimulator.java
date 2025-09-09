package main.java;

public class SupermarketSimulator {
    public static void main(String[] args) {

        // Це шаблон симуляції супермаркету
        // Вам потрібно буде добитися, щоб код нижче працював, коли ви його розкоментуєте
        // НЕ ЗМІНЮЙТЕ КОД НАВЕДЕНИЙ НИЖЧЕ, навпаки, напишіть та реалізуйте необхідні класи та методи, щоб код наведений нижче запрацював
        // таким чином працюємо "від зворотнього"
        // Підказки по реалізації будуть в файлі README.md

        ProductInventory inventory = new ProductInventory();
        CategoryManager categories = new CategoryManager();
        PriceCatalog prices = new PriceCatalog();
        StockManager stock = new StockManager();
        ShoppingCart cart = new ShoppingCart();

        try {
            // Імітація дій
            inventory.addProduct("Apple");
            inventory.addProduct("Bread");
            inventory.addProduct("Milk");
            categories.addCategory("Fruits");
            categories.addCategory("Bakery");
            prices.addPrice("Apple", 1.5);
            prices.addPrice("Bread", 2.0);
            prices.addPrice("Milk", 1.0);
            stock.addStock("Apple", 10);
            stock.addStock("Bread", 5);
            stock.addStock("Milk", 3);

            // Покупки
            cart.addToCart("Apple");
            stock.reduceStock("Apple");
            cart.addToCart("Milk");
            stock.reduceStock("Milk");

            // Чек
            double payment = 5.0; // Імітація оплати
            cart.checkout(prices, payment);

            // Сортування та вивід
            inventory.sortProducts();
            System.out.println("Товари: " + inventory.getProducts());
            System.out.println("Категорії: " + categories.getCategories());
            System.out.println("Ціни: " + prices.getPrices());
            System.out.println("Запаси: " + stock.getStock());
            System.out.println("Кошик: " + cart.getCart());

        } catch (OutOfStockException | NoSuchProductException | InsufficientFundsException | DuplicateCategoryException | IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
