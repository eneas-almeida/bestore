package br.com.venzel.store.modules.product.category.use_cases.list_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.category.entities.Category;
import br.com.venzel.store.modules.product.category.exceptions.CategoryNotFoundException;
import br.com.venzel.store.modules.product.category.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.category.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.category.utils.CategoryMessageUtils;

@Service
public class ListCategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<CategoryDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Category> categories = categoryRepository.findAll(pageRequest);

        if (categories.isEmpty()) {
            throw new CategoryNotFoundException(CategoryMessageUtils.CATEGORY_NOT_FOUND);
        }

        Page<CategoryDTO> pageCategoryDTO = categoryMapper.toCollectionPageModel(categories);

        return pageCategoryDTO;
    }
}
