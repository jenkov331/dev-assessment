package com.is.dev.assessment;

import com.is.dev.assessment.util.*;
import com.is.dev.assessment.domain.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> products = ProductCsvTsvUtil.fetchProducts();
        ProductJsonUtil.writeProductsToFile(products);
        ProductXmlUtil.writeProductsToFile(products);
    }
}