package br.com.venzel.store.modules.product.use_cases.category.show_category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.category.CategoryDTO;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.exceptions.category.CategoryNotFoundException;
import br.com.venzel.store.modules.product.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.utils.CategoryMessageUtils;

@Service
public class ShowCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public CategoryDTO execute(Long id) {
        
        Optional<Category> optionalEntity = categoryRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new CategoryNotFoundException(CategoryMessageUtils.CATEGORY_NOT_FOUND);
        }

        return categoryMapper.toDTO(optionalEntity.get());
    }  
}
