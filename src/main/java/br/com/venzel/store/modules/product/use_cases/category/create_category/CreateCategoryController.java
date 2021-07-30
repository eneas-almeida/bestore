package br.com.venzel.store.modules.product.use_cases.category.create_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.CategoryDTO;

@RestController
@RequestMapping("/products/categories")
public class CreateCategoryController {

    @Autowired
    private CreateCategoryService createCategoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO handle(@RequestBody CategoryDTO dto) {

        return createCategoryService.execute(dto);
    }
}
