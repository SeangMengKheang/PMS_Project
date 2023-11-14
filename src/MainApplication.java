import co.istad.model.Product;
import co.istad.service.ProductService;
import co.istad.service.ProductServiceImpl;
import co.istad.view.MenuView;
import co.istad.view.ProductView;

import java.lang.foreign.MemoryLayout;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    private static ProductService productService;
    public MainApplication() {
        ProductServiceImpl productService = new ProductServiceImpl();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        productService = new ProductServiceImpl();

        System.out.println("Welcome to PMS");
        MenuView.menu();
        int option = Integer.parseInt(scanner.nextLine());
        
        switch(option) {
            case -> {
                List<Product> products = productService.select();
                ProductView.printProductList(products);
            }
            default -> throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
