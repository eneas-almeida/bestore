package br.com.venzel.store.modules.product.product.use_cases.list_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.product.dtos.ProductDTO;
import br.com.venzel.store.modules.product.product.entities.Product;
import br.com.venzel.store.modules.product.product.exceptions.ProductNotFoundException;
import br.com.venzel.store.modules.product.product.mappers.ProductMapper;
import br.com.venzel.store.modules.product.product.repositories.ProductRepository;
import br.com.venzel.store.modules.product.product.utils.ProductMessageUtils;

@Service
public class ListProductService {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<ProductDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Product> products = productRepository.findAll(pageRequest);

        if (products.isEmpty()) {
            throw new ProductNotFoundException(ProductMessageUtils.PRODUCT_NOT_FOUND);
        }

        Page<ProductDTO> pageProductDTO = productMapper.toCollectionPageModel(products);

        return pageProductDTO;
    }
}
