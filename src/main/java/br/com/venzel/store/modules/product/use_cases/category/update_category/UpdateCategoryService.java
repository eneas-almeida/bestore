package br.com.venzel.store.modules.product.use_cases.category.update_category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.dtos.UpdateCategoryDTO;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.utils.CategoryMessageUtils;
import br.com.venzel.store.modules.user.exceptions.UserNotFoundException;

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
