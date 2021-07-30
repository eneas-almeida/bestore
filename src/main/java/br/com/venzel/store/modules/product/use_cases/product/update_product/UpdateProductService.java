package br.com.venzel.store.modules.product.use_cases.product.update_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.ProductDTO;
import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.mappers.ProductMapper;
import br.com.venzel.store.modules.product.repositories.ProductRepository;

@Service
public class UpdateProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public ProductDTO execute(ProductDTO dto, Long id) {

        Product product = productMapper.toEntity(dto);

        productRepository.save(product);

        return productMapper.toDTO(product);
    }
}
