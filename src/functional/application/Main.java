package functional.application;

import functional.entities.Product;

import java.util.ArrayList;
import java.util.List;

//Referência: https://github.com/acenelio/lambda1-java
public class Main {

    static public int compare(Product p1, Product p2){
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();

        list.add(new Product("TV", 900.00));
        list.add(new Product("Notebook", 1200.00));
        list.add(new Product("Tablet", 450.00));

        // criando uma função anônima - expressão lambda
        list.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
        list.sort(Main::compare);

        for (Product product : list) {
            System.out.println(product);
        }
    }
}

