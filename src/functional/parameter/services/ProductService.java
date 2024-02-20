package functional.parameter.services;

import functional.entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {

    public double filteredSum(List<Product> products, Predicate<Product> predicate){
        double sum = 0.0;
        for (Product product : products){
            if(predicate.test(product)){
                sum += product.getPrice();
            }
        }
        return sum;
    }
}
