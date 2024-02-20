package functional.types.consumer.application;

import functional.entities.Product;
import functional.types.consumer.util.PriceUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("HD Case", 80.90));

        // 1ª maneira - implementação de interface
        list.forEach(new PriceUpdate());

        // 2ª maneira - reference method (static)
        list.forEach(Product::staticPriceUpdate);

        // 3ª maneira - reference method (no static)
        list.forEach(Product::nonStaticPriceUpdate);

        // 4ª maneira - expressão lambda declarada
        double factor = 1.1;

        Consumer<Product> consumer = new Consumer<Product>() {
            @Override
            public void accept(Product product) {
                product.setPrice(product.getPrice() * factor);
            }
        };

        list.forEach(consumer);

        // 5ª maneira - lambda inline
        list.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        list.forEach(System.out::println);
    }
}