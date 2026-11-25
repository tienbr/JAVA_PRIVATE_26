package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductServiceImpl implements ProductService {
    Scanner sc = new Scanner(System.in);
    public final List<Product> products = new ArrayList<>();
    @Override
    public void addProduct (Product product){
        if (product != null) {
            products.add(product);
        }
    }

    @Override
    public  Product findById (String id){
        Product productFound = null ;
        for (int i = 0 ; i < products.size() ; i ++){
            if (products.get(i).getId().equals(id)){
                productFound = products.get(i);
            }
        }
        return productFound;
    }
    @Override
    public void printProducts() {
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

}
