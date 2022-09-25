package org.example.servers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String desc;

    public static List<Product> getCatalog() {
        return List.of(
                new Product(257462345, "Смартфон", "Смартфон"),
                new Product(226253322, "Холодильник", "Холодильник"),
                new Product(368354324, "Стиральная машинка", "Стиральная машинка"),
                new Product(275235456, "Электрическая зубная щетка", "Электрическая зубная щетка"),
                new Product(438354624, "Ноутбук", "Ноутбук"),
                new Product(825265376, "Микроволновка", "Микроволновка"),
                new Product(755532724, "Утюг", "Утюг")
        );
    }

    public static List<Product> getCart() {
        return List.of(
                new Product(368354324, "Стиральная машинка", "Стиральная машинка"),
                new Product(275235456, "Электрическая зубная щетка", "Электрическая зубная щетка"),
                new Product(755532724, "Утюг", "Утюг")
        );
    }
}
