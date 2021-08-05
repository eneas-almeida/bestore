package br.com.venzel.store.modules.product.category.use_cases.create_category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.category.dtos.CreateCategoryDTO;
import br.com.venzel.store.modules.product.category.entities.Category;
import br.com.venzel.store.modules.product.category.exceptions.CategoryAlreadyExistsException;
import br.com.venzel.store.modules.product.category.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.category.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.category.utils.CategoryMessageUtils;

@Service
public class CreateCategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    public CategoryDTO execute(CreateCategoryDTO dto) {
        Optional<Category> optionalEntity = categoryRepository.findOneByName(dto.getName());

        if (optionalEntity.isPresent()) {
            throw new CategoryAlreadyExistsException(CategoryMessageUtils.CATEGORY_ALREADY_EXISTS);
        }

        Category category = categoryMapper.toEntity(dto);

        categoryRepository.save(category);

        return categoryMapper.toDTO(category);
    }
}
