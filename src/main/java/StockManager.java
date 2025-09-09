package main.java;

import java.util.HashMap;
import java.util.Map;

public class StockManager {
    private final Map<String, Integer> stock = new HashMap<>();

    public void addStock(String product, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Кількість не може бути негативною!");
        }
        stock.put(product, stock.getOrDefault(product, 0) + quantity);
    }

    public void reduceStock(String product) throws OutOfStockException {
        int current = stock.getOrDefault(product, 0);
        if (current <= 0) {
            throw new OutOfStockException("Товар \"" + product + "\" відсутній на складі! 🛑");
        }
        stock.put(product, current - 1);
    }

    public Map<String, Integer> getStock() {
        return new HashMap<>(stock);
    }
}

