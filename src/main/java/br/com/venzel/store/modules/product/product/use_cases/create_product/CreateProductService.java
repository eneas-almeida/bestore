package br.com.venzel.store.modules.product.product.use_cases.create_product;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.activity.activity.use_cases.create_cctivity.CreateActivityService;
import br.com.venzel.store.modules.product.category.dtos.CreateProductDTO;
import br.com.venzel.store.modules.product.category.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.product.dtos.ProductDTO;
import br.com.venzel.store.modules.product.product.entities.Product;
import br.com.venzel.store.modules.product.product.exceptions.ProductAlreadyExistsException;
import br.com.venzel.store.modules.product.product.mappers.ProductMapper;
import br.com.venzel.store.modules.product.product.repositories.ProductRepository;
import br.com.venzel.store.modules.product.product.utils.ProductMessageUtils;
import br.com.venzel.store.modules.user.user.entities.User;

@Service
public class CreateProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private CreateActivityService createActivityService;

    @Transactional
    public ProductDTO execute(CreateProductDTO dto) {

        /* Find product by name */

        Optional<Product> optionalEntity = productRepository.findOneByName(dto.getName());

        if (optionalEntity.isPresent()) {
            throw new ProductAlreadyExistsException(ProductMessageUtils.PRODUCT_ALREADY_EXISTS);
        }

        /* Parse dto to entity */

        Product product = productMapper.toEntity(dto);

        /* Set category default to product */

        product.setCategories(Arrays.asList(categoryRepository.findOneById(1L).get()));

        /* Save product in repository */

        productRepository.save(product);

        /* Create activity */

        createActivityService.execute(ProductMessageUtils.PRODUCT_CREATED, new User());

        /* Entity to dto and return */

        return productMapper.toDTO(product);
    }
}
