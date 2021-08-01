package br.com.venzel.store.modules.product.use_cases.product.update_product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.product.ProductDTO;
import br.com.venzel.store.modules.product.dtos.product.UpdateProductDTO;
import br.com.venzel.store.modules.product.entities.Product;
import br.com.venzel.store.modules.product.mappers.ProductMapper;
import br.com.venzel.store.modules.product.repositories.ProductRepository;
import br.com.venzel.store.modules.product.utils.ProductMessageUtils;
import br.com.venzel.store.modules.user.exceptions.UserNotFoundException;

@Service
public class UpdateProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public ProductDTO execute(UpdateProductDTO dto, Long id) {

        Optional<Product> optionalEntity = productRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new UserNotFoundException(ProductMessageUtils.PRODUCT_NOT_FOUND);
        }

        Product product = optionalEntity.get();

        productMapper.toCopyEntity(dto, product);

        return productMapper.toDTO(product);
    }
}
