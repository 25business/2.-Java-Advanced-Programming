package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Milk", 128.99));
        products.add(new Product("Eggs", 49.99));
        products.add(new Product("Coca-Cola", 99.99));
        products.add(new Product("Chocolate", 109.99));

        ArrayList<MyLambda> functions = new ArrayList<>();

        //1. Lambda koja proizvode uvecava za porez
        MyLambda function_tax = (Product p) -> p.getPrice() * 1.2;
        //2. Lambda koja proizvode smanjuje cenu za 30%
        /*
        MyLambda discount_product = (Product p) -> p.getPrice() * 0.7;

        functions.add(function_tax);
        functions.add(discount_product);

        for(MyLambda fn : functions) {
            for(Product product: products) {
                product.setPrice(fn.call(product));
                System.out.println(product);
            }
            System.out.println("------------------------------");
        }

         */
        //2. Lambda koja vraca proizvode za opseg
        MyFilter price_range_filter = (ArrayList<Product> lambda_products,
                                       HashMap<String, Object> lambda_criteria) -> {
            if(!lambda_criteria.containsKey("min_price") || !lambda_criteria.containsKey("max_price"))
                return lambda_products;

            ArrayList<Product> filtered_products = new ArrayList<>();
            double min_price = (double) lambda_criteria.get("min_price");
            double max_price = (double) lambda_criteria.get("max_price");
            for(Product p : lambda_products) {
                if(p.getPrice() >= min_price && p.getPrice() <= max_price) {
                    filtered_products.add(p);
                }
            }
            return filtered_products;
        };

        //3. Lambda koja vraca proizvode za frazu
        MyFilter phrase_filter = (ArrayList<Product> lambda_products,
                                       HashMap<String, Object> lambda_criteria) -> {
            if(!lambda_criteria.containsKey("phrase"))
                return lambda_products;

            ArrayList<Product> filtered_products = new ArrayList<>();
            String phrase = (String)lambda_criteria.get("phrase");
            for(Product p : lambda_products) {
                if(p.getName().contains(phrase)) {
                    filtered_products.add(p);
                }
            }
            return filtered_products;
        };

        ArrayList<MyFilter> filters = new ArrayList<>();
        filters.add(price_range_filter);
        filters.add(phrase_filter);
        HashMap<String, Object> criteria = new HashMap<>();
        criteria.put("min_price", 100.0);
        criteria.put("max_price", 120.0);
        criteria.put("phrase","C");

        ArrayList<Product> results = products;
        for(MyFilter filter : filters) {
            results = filter.call(results, criteria);
        }

        results.forEach(p -> System.out.println(p));
    }
}
