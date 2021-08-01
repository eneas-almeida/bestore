package br.com.venzel.store.modules.product.use_cases.product.show_product;

import java.util.Optional;

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
public class ShowProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public ProductDTO execute(Long id) {
        
        Optional<Product> optionalEntity = productRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new ProductNotFoundException(ProductMessageUtils.PRODUCT_NOT_FOUND);
        }

        return productMapper.toDTO(optionalEntity.get());
    }  
}
