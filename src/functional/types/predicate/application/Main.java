package functional.types.predicate.application;

import functional.entities.Product;
import functional.types.predicate.util.ProductPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("HD Case", 80.90));

        //list.removeIf(p -> p.getPrice() >= 100);

        // 1ª maneira - implementação de interface
        list.removeIf(new ProductPredicate());

        // 2ª maneira - reference method (static)
        list.removeIf(Product::staticProductPredicate);

        // 3ª maneira - reference method (no static)
        list.removeIf(Product::nonStaticProductPredicate);

        // 4ª maneira - expressão lambda declarada
        double min = 100.00;
        Predicate<Product> predicate = p -> p.getPrice() >= min;
        list.removeIf(predicate);

        // 5ª maneira - lambda inline
        list.removeIf(p -> p.getPrice() < 100);

        for(Product product : list){
            System.out.println(product);
        }
    }
}