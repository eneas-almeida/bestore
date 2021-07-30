package br.com.venzel.store.modules.product.use_cases.category.create_category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.exceptions.category.CategoryAlreadyExistsException;
import br.com.venzel.store.modules.product.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.utils.CategoryMessageUtils;

@Service
public class CreateCategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    public CategoryDTO execute(CategoryDTO dto) {
        Optional<Category> optionalEntity = categoryRepository.findOneByName(dto.getName());

        if (optionalEntity.isPresent()) {
            throw new CategoryAlreadyExistsException(CategoryMessageUtils.CATEGORY_ALREADY_EXISTS);
        }

        Category category = categoryMapper.toEntity(dto);

        categoryRepository.save(category);

        return categoryMapper.toDTO(category);
    }
}
