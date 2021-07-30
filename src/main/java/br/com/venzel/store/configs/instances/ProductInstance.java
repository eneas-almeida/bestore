package br.com.venzel.store.configs.instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.repositories.ProductRepository;

@Service
public class ProductInstance {
    
    @Autowired
    private ProductRepository productRepository;

    public void populate() {

        productRepository.deleteAll();

        productRepository.saveAll(getList());
    }

    private List<Product> getList() {

        Product feijao = entityBuilder("feijao", 10.21);
        Product arroz = entityBuilder("arroz", 7.44);
        Product cuzcuz = entityBuilder("cuzcuz", 3.76);

        List<Product> products = new ArrayList<>();

        products.addAll(Arrays.asList(feijao, arroz, cuzcuz));

        return products;
    }

    private Product entityBuilder(String name, Double price) {

        return Product.builder()
                        .name(name)
                        .price(price)
                        .activated(true)
                        .build();
    }
}
