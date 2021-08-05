package br.com.venzel.store.modules.product.category.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.category.dtos.CreateCategoryDTO;
import br.com.venzel.store.modules.product.category.dtos.UpdateCategoryDTO;
import br.com.venzel.store.modules.product.category.entities.Category;

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

    public Page<CategoryDTO> toCollectionPageModel(Page<Category> categories) {
        return categories.map(e -> toDTO(e));
    }

    public Category toEntity(CreateCategoryDTO dto) {
        return modelMapper.map(dto, Category.class);
    }

    public void toCopyEntity(UpdateCategoryDTO dto, Category category) {
        modelMapper.map(dto, category);
    }
}
