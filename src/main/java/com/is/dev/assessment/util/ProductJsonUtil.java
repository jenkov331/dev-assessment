package com.is.dev.assessment.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.is.dev.assessment.domain.Product;

import java.io.File;
import java.util.List;

public class ProductJsonUtil {

    public static void writeProductsToFile(List<Product> products) {
        System.out.println("Writing to JSON...");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("products.json"), products);
        } catch (Exception ex) {
            System.out.println("Failed to write product data to a JSON file.");
            ex.printStackTrace();
        }
    }
}
