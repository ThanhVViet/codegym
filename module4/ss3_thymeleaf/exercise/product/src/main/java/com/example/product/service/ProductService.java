package com.example.product.service;

import com.example.product.model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer, Product> productMap;

    static {

        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Phone", "nope", "Hanoi", 100));
        productMap.put(2, new Product(2, "Book", "pk", "Danang", 100));
        productMap.put(3, new Product(3, "Cake", "ok", "Saigon", 100));
        productMap.put(4, new Product(4, "Candy", "nah", "Beijin", 100));
        productMap.put(5, new Product(5, "Mac", "duh", "Miami", 100));
        productMap.put(6, new Product(6, "Lamp", "meo", "Newyork", 100));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);

    }
    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a product name to search: ");
        String searchName = scanner.nextLine();

        List<Product> searchResults = productService.search(searchName);

        if (searchResults.isEmpty()) {
            System.out.println("No products found.");
        } else {
            System.out.println("Products found:");
            for (Product product : searchResults) {
                System.out.println("Product ID: " + product.getId() + ", Name: " + product.getName());
            }
        }
    }
    @Override
    public List<Product> search(String name) {
        List<Product> searchResults = new ArrayList<>();

        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            Product product = entry.getValue();
            if (product.getName().equalsIgnoreCase(name)) {
                searchResults.add(product);
            }
        }

        return searchResults;
    }

}
