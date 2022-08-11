package ru.sbrf.servers.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private Double price;

    public static List<Product> getCatalog() {
        return List.of(
                new Product("257462345", "Смартфон", 15660D),
                new Product("226253322", "Холодильник", 74000D),
                new Product("368354324", "Стиральная машинка", 500D),
                new Product("275235456", "Электрическая зубная щетка", 25000D),
                new Product("438354624", "Ноутбук", 133500D),
                new Product("825265376", "Микроволновка", 1260D),
                new Product("755532724", "Утюг", 5450D)
        );
    }

    public static List<Product> getCart() {
        return List.of(
                new Product("368354324", "Стиральная машинка", 500D),
                new Product("275235456", "Электрическая зубная щетка", 25000D),
                new Product("755532724", "Утюг", 5450D)
        );
    }
}
