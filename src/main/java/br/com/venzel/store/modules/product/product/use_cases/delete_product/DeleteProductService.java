package br.com.venzel.store.modules.product.product.use_cases.delete_product;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.product.dtos.ProductDTO;
import br.com.venzel.store.modules.product.product.entities.Product;
import br.com.venzel.store.modules.product.product.exceptions.ProductNotFoundException;
import br.com.venzel.store.modules.product.product.mappers.ProductMapper;
import br.com.venzel.store.modules.product.product.repositories.ProductRepository;
import br.com.venzel.store.modules.product.product.utils.ProductMessageUtils;

@Service
public class DeleteProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public ProductDTO execute(Long id) {
        
        Optional<Product> optionalEntity = productRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new ProductNotFoundException(ProductMessageUtils.PRODUCT_NOT_FOUND);
        }

        Product product = optionalEntity.get();

        /* Update data */

        product.setDeletedAt(OffsetDateTime.now(Clock.systemUTC()));

        product.inactive();

        /* End update data */

        return productMapper.toDTO(product);
    }
}
