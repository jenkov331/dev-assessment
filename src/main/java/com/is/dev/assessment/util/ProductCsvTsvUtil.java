package com.is.dev.assessment.util;


import com.is.dev.assessment.domain.Product;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductCsvTsvUtil {

    public static List<Product> fetchProducts() {
        System.out.println("Fetching products from CSV/TSV...");
        // extract CSV data into a list
        List<Product> csvProducts = extractProducts("products.csv", ',');
        // extract TSV data into a list
        List<Product> tsvProducts = extractProducts("products.tsv", '\t');
        // combine lists (if any duplicates are found, CSV entry will override TSV)
        return Stream.concat(csvProducts.stream(), tsvProducts.stream())
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<Product> extractProducts(String fileName, char separator) {
        try {
            return new CsvToBeanBuilder<Product>(new FileReader(fileName))
                    .withSeparator(separator)
                    .withIgnoreQuotations(false)
                    .withType(Product.class)
                    .build()
                    .parse()
                    .stream()
                    .distinct()
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            System.out.println("Failed to parse file: " + fileName);
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }
}