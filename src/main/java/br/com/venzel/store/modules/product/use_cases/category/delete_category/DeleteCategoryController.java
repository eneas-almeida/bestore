package br.com.venzel.store.modules.product.use_cases.category.delete_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.CategoryDTO;
@RestController
@RequestMapping("/categories")
public class DeleteCategoryController {

    @Autowired
    private DeleteCategoryService deleteCategoryService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO handle(@PathVariable Long id) {

        return deleteCategoryService.execute(id);
    }
}
