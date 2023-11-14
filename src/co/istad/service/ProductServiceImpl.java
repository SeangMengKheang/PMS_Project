package co.istad.service;

import co.istad.dao.ProductDao;
import co.istad.dao.ProductDaoImpl;
import co.istad.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public Product insert(Product product) {
        return productDao.insert(product);
    }

    @Override
    public List<Product> select() {
        return productDao.select();
    }

    @Override
    public Optional<Product> selectById(long id) {
        return productDao.selectById(id);
    }

    @Override
    public Product updateById(Product product) {
        return productDao.updateById(product);
    }

    @Override
    public Product deleteById(long id) {
        return productDao.deleteById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDao.searchByName(name);
    }
}
