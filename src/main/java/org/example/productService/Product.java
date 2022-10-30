package org.example.productService;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Product {
    long id, price;
    String title;
}
