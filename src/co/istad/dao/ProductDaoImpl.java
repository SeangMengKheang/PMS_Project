package co.istad.dao;

import co.istad.database.ProductDatabase;
import co.istad.exception.ProductIdNotFoundException;
import co.istad.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductDaoImpl implements ProductDao{
    private ProductDatabase productDb;
    public ProductDaoImpl() {
        productDb = new ProductDatabase();
    }
    @Override
    public Product insert(Product product) {
        productDb.getProducts().add(product);
        return product;
    }

    @Override
    public List<Product> select() {
        return productDb.getProducts();
    }

    @Override
    public Optional<Product> selectById(long id) {
        return productDb.getProducts().stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    @Override
    public Product updateById(Product product) {
        return productDb.getProducts().stream()
                .filter(pro -> pro.getId() == product.getId())
                .map(newPro -> product)
                .findFirst()
                .orElseThrow(()
                        -> new ProductIdNotFoundException(
                                String.format("Product ID = %s does not exist in DB!", product.getId())
                ));
    }

    @Override
    public Product deleteById(long id) {
        Product foundProduct = productDb.getProducts().stream()
                .filter(pro -> pro.getId() == id)
                .findFirst()
                .orElseThrow(()
                        -> new ProductIdNotFoundException(
                        String.format("Product ID = %s does not exist in DB!", id)
                ));
        productDb.getProducts().remove(foundProduct);
        return foundProduct;
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDb.getProducts().stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
