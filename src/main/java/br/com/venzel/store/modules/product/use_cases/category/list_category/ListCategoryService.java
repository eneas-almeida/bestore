package br.com.venzel.store.modules.product.use_cases.category.list_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.product.dtos.category.CategoryDTO;
import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.mappers.CategoryMapper;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;
import br.com.venzel.store.modules.product.utils.CategoryMessageUtils;
import br.com.venzel.store.modules.user.exceptions.user.UserNotFoundException;

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
            throw new UserNotFoundException(CategoryMessageUtils.CATEGORY_NOT_FOUND);
        }

        Page<CategoryDTO> pageCategoryDTO = categoryMapper.toCollectionPageModel(categories);

        return pageCategoryDTO;
    }
}
