package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductInventory {
    private final List<String> products = new ArrayList<>();

    public void addProduct(String product) {
        products.add(product);
    }

    public void removeProduct(String name) throws OutOfStockException {
        if (!products.remove(name)) {
            throw new OutOfStockException("Товар \"" + name + "\" закінчився! Спробуйте інший.");
        }
    }

    public void sortProducts() {
        Collections.sort(products);
    }

    public List<String> getProducts() {
        return new ArrayList<>(products);
    }
}

