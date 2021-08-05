package br.com.venzel.store.modules.product.category.use_cases.list_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;

@RestController
@RequestMapping("/products/categories")
public class ListCategoryController {

    @Autowired
    private ListCategoryService lisCategoryService;

    @GetMapping
    public Page<CategoryDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                    @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                    @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        return lisCategoryService.execute(page, linesPerPage, orderBy, direction);
    }
}
