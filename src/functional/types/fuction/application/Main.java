package functional.types.fuction.application;

import functional.entities.Product;
import functional.types.fuction.util.UpperCaseName;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("HD Case", 80.90));

        // 1ª maneira - implementação de interface
        var collect_001 = list.stream().map(new UpperCaseName()).toList(); // .toList() ou collect(Collectors.toList())

        // 2ª maneira - reference method (static)
        var collect_002 = list.stream().map(Product::staticUpperCaseName).toList();

        // 3ª maneira - reference method (no static)
        var collect_003 = list.stream().map(Product::nonStaticUpperCaseName).toList();

        // 4ª maneira - expressão lambda declarada
        Function<Product, String> function = product ->  product.getName().toUpperCase();

        var collect_004 = list.stream().map(function).toList();

        // 5ª maneira - lambda inline
        var collect_005 = list.stream().map(p -> p.getName().toUpperCase()).toList();

        collect_001.forEach(System.out::println);
        collect_002.forEach(System.out::println);
        collect_003.forEach(System.out::println);
        collect_004.forEach(System.out::println);
        collect_005.forEach(System.out::println);
    }
}
