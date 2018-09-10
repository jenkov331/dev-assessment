package com.is.dev.assessment.util;


import com.is.dev.assessment.domain.Product;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProductXmlUtil {

    public static void writeProductsToFile(List<Product> products)  {
        System.out.println("Writing to XML...");
        try {
            JAXBContext context = JAXBContext.newInstance(Products.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Products xmlProducts = new Products(products);
            m.marshal(xmlProducts, new File("products.xml"));
        } catch (Exception ex) {
            System.out.println("Failed to write product data to an XML file.");
            ex.printStackTrace();
        }
    }

    // must cast product list to a custom class in order to provide the root element info
    @XmlRootElement
    public static class Products {

        private List<Product> products;

        public Products() {

        }

        public Products(List<Product> product) {
            this.products = product;
        }

        @XmlElement
        public List<Product> getProduct() {
            return products;
        }

        public void setProduct(List<Product> products) {
            this.products = products;
        }
    }
}
