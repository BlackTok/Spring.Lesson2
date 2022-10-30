package org.example;

import org.example.productService.Cart;
import org.example.productService.Product;
import org.example.productService.ProductRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext("org.example.productService");

        ProductRepository productRepository = context.getBean(ProductRepository.class);

        productRepository.createNewProduct(1, "Яблоко", 10);
        productRepository.createNewProduct(2, "Груша", 14);
        productRepository.createNewProduct(3, "Апельсин", 12);
        productRepository.createNewProduct(4, "Лимон", 13);
        productRepository.createNewProduct(5, "Банан", 16);

        System.out.println("Проверка ProductRepository");
        System.out.println("------------------------------------------");
        productRepository.getProductsList().forEach(
                System.out::println
        );
        System.out.println("------------------------------------------");
        System.out.println(productRepository.getProduct(2));
        System.out.println("==========================================");
        System.out.println();

        Cart cart = context.getBean(Cart.class);
        cart.addProduct(productRepository.getProduct(1));
        cart.addProduct(productRepository.getProduct(5));

        System.out.println("Проверка Cart #1");
        System.out.println("------------------------------------------");
        System.out.println(cart.getProductOfCart(5));
        System.out.println("------------------------------------------");
        cart.getCart().forEach(System.out::println);
        System.out.println("------------------------------------------");

        System.out.println("Новая корзина");
        Cart newCart = context.getBean(Cart.class);
        System.out.println("------------------------------------------");
        newCart.getCart().forEach(System.out::println);
        System.out.println("------------------------------------------");
        newCart.addProduct(productRepository.getProduct(2));
        newCart.addProduct(productRepository.getProduct(3));
        newCart.getCart().forEach(System.out::println);
        System.out.println("------------------------------------------");
        System.out.println("Удаляем товар");
        newCart.deleteProduct(2);
        System.out.println("------------------------------------------");
        newCart.getCart().forEach(System.out::println);
        System.out.println("------------------------------------------");


    }
}