package org.example.productService;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {
    private static List<Product> productsCart = new ArrayList<>();

    public void addProduct(Product product) {
        productsCart.add(product);
    }

    public List<Product> getCart() {
        return productsCart;
    }

    public Product getProductOfCart(long id) {
        Product rtnProduct = new Product();
        for (Product product : productsCart) {
            if (product.getId() == id)
                rtnProduct = product;
        }

        return rtnProduct;
    }

    @PostConstruct
    public void clearCart() {
        productsCart.clear();
    }

    public void deleteProduct(long id) {
        int index = 0;
        for (Product product : productsCart) {
            if (product.getId() == id)
                break;

            index++;
        }

        productsCart.remove(index);
    }
}
