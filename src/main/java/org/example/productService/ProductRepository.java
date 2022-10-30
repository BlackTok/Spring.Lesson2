package org.example.productService;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class ProductRepository {
    private static List<Product> productList = new ArrayList<Product>();

    public void createNewProduct(long id, String title, long price) {
        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        productList.add(product);
    }

    public List<Product> getProductsList() {
        return productList;
    }

    public Product getProduct(long id) {
        return productList.get((int)id - 1);
    }
}
