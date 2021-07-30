package br.com.venzel.store.modules.product.use_cases.category.list_category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.CategoryDTO;

@RestController
@RequestMapping("/products/categories")
public class ListCategoryController {

    @Autowired
    private ListCategoryService lisCategoryService;

    @GetMapping
    public List<CategoryDTO> handle() {
        return lisCategoryService.execute();
    }
}
