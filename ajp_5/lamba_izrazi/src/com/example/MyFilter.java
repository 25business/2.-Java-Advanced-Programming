package com.example;

import java.util.ArrayList;
import java.util.HashMap;

public interface MyFilter {
    public ArrayList<Product> call(ArrayList<Product> products, HashMap<String, Object> criteria);
}
