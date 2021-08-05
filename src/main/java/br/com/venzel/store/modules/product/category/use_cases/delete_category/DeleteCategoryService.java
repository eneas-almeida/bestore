package br.com.venzel.store.modules.product.category.use_cases.delete_category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.category.entities.Category;
import br.com.venzel.store.modules.product.category.exceptions.CategoryNotFoundException;
import br.com.venzel.store.modules.product.category.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.category.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.category.utils.CategoryMessageUtils;

@Service
public class DeleteCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional
    public CategoryDTO execute(Long id) {
        
        Optional<Category> optionalEntity = categoryRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new CategoryNotFoundException(CategoryMessageUtils.CATEGORY_NOT_FOUND);
        }

        Category category = optionalEntity.get();

        categoryRepository.deleteById(id);

        categoryRepository.flush();

        return categoryMapper.toDTO(category);
    }
}
