package co.istad.view;

import co.istad.model.Product;

import java.util.List;

import static java.lang.System.out;

public class ProductView {
    public static void printProductList(List<Product> products) {
        out.print("Product List");
        products.forEach(product -> {
            out.println("Id: " + product.getId());
            out.println("Name: " + product.getName());
            out.println("Quantity: " + product.getQty());
            out.println("Price: " + product.getPrice());
            out.println("Date: " + product.getImportedDate());
        });
    }
}
