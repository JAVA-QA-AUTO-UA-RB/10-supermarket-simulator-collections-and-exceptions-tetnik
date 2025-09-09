package main.java;

import java.util.HashSet;
import java.util.Set;

public class CategoryManager {
    private final Set<String> categories = new HashSet<>();

    public void addCategory(String category) throws DuplicateCategoryException {
        if (!categories.add(category)) {
            throw new DuplicateCategoryException("Категорія \"" + category + "\" вже існує!");
        }
    }

    public Set<String> getCategories() {
        return new HashSet<>(categories);
    }
}

