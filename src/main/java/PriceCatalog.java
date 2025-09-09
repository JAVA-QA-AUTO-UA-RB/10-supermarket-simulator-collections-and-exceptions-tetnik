package main.java;

import java.util.HashMap;
import java.util.Map;

public class PriceCatalog {
    private final Map<String, Double> prices = new HashMap<>();

    public void addPrice(String product, double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути негативною!");
        }
        prices.put(product, price);
    }

    public double getPrice(String product) throws NoSuchProductException {
        if (!prices.containsKey(product)) {
            throw new NoSuchProductException(" Ціна для товару \"" + product + "\" відсутня!");
        }
        return prices.get(product);
    }

    public Map<String, Double> getPrices() {
        return new HashMap<>(prices);
    }
}

