package br.com.venzel.store.modules.product.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.product.dtos.ProductDTO;
import br.com.venzel.store.modules.product.entities.Product;

@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDTO toDTO(Product product) {
        return modelMapper.map(product, ProductDTO.class);
    }

    public List<ProductDTO> toCollectionModel(List<Product> products) {
        return products.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Product toEntity(ProductDTO dto) {
        return modelMapper.map(dto, Product.class);
    }

    public void toCopyEntity(ProductDTO dto, Product product) {
        modelMapper.map(dto, product);
    }
}
