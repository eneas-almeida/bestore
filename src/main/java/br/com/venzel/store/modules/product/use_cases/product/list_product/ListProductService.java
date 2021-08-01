package br.com.venzel.store.modules.product.use_cases.product.list_product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.product.ProductDTO;
import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.exceptions.product.ProductNotFoundException;
import br.com.venzel.store.modules.product.mappers.ProductMapper;
import br.com.venzel.store.modules.product.repositories.ProductRepository;
import br.com.venzel.store.modules.product.utils.ProductMessageUtils;

@Service
public class ListProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<ProductDTO> execute() {

        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            throw new ProductNotFoundException(ProductMessageUtils.PRODUCT_NOT_FOUND);
        }

        return productMapper.toCollectionModel(products);
    }
}
