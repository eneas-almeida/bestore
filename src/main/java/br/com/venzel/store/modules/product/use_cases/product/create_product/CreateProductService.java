package br.com.venzel.store.modules.product.use_cases.product.create_product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.ProductDTO;
import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.exceptions.product.ProductAlreadyExistsException;
import br.com.venzel.store.modules.product.mappers.ProductMapper;
import br.com.venzel.store.modules.product.repositories.ProductRepository;
import br.com.venzel.store.modules.product.utils.ProductMessageUtils;

@Service
public class CreateProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public ProductDTO execute(ProductDTO dto) {
        Optional<Product> optionalEntity = productRepository.findOneByName(dto.getName());

        if (optionalEntity.isPresent()) {
            throw new ProductAlreadyExistsException(ProductMessageUtils.PRODUCT_ALREADY_EXISTS);
        }

        Product product = productMapper.toEntity(dto);

        productRepository.save(product);

        return productMapper.toDTO(product);
    }
}
