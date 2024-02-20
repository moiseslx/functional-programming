package functional.parameter.application;

import functional.entities.Product;
import functional.parameter.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));
        list.add(new Product("HD Case", 100.00));
        list.add(new Product("Smartphone", 100.00));


        ProductService service = new ProductService();

        double value = service.filteredSum(list, product -> product.getPrice() == 100);

        list.forEach(System.out::println);

        System.out.println(value);
    }
}