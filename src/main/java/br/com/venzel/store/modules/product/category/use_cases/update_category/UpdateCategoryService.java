package br.com.venzel.store.modules.product.category.use_cases.update_category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.category.dtos.UpdateCategoryDTO;
import br.com.venzel.store.modules.product.category.entities.Category;
import br.com.venzel.store.modules.product.category.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.category.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.category.utils.CategoryMessageUtils;
import br.com.venzel.store.modules.user.user.exceptions.UserNotFoundException;

@Service
public class UpdateCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    public CategoryDTO execute(UpdateCategoryDTO dto, Long id) {

        Optional<Category> optionalEntity = categoryRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new UserNotFoundException(CategoryMessageUtils.CATEGORY_NOT_FOUND);
        }
        
        Category category = optionalEntity.get();

        categoryMapper.toCopyEntity(dto, category);

        return categoryMapper.toDTO(category);
    } 
}
