package br.com.venzel.store.modules.product.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.product.dtos.category.CategoryDTO;
import br.com.venzel.store.modules.product.dtos.category.CreateCategoryDTO;
import br.com.venzel.store.modules.product.dtos.product.UpdateCategoryDTO;
import br.com.venzel.store.modules.product.entities.Category;

@Component
public class CategoryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO toDTO(Category category) {
        return modelMapper.map(category, CategoryDTO.class);
    }

    public List<CategoryDTO> toCollectionModel(List<Category> categories) {
        return categories.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Category toEntity(CreateCategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }

    public void toCopyEntity(UpdateCategoryDTO dto, Category category) {
        modelMapper.map(dto, category);
    }
}
