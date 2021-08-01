package br.com.venzel.store.modules.product.use_cases.category.list_category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.category.CategoryDTO;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.utils.CategoryMessageUtils;
import br.com.venzel.store.modules.user.exceptions.UserNotFoundException;

@Service
public class ListCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<CategoryDTO> execute() {

        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty()) {
            throw new UserNotFoundException(CategoryMessageUtils.CATEGORY_NOT_FOUND);
        }

        return categoryMapper.toCollectionModel(categories);
    }
}
