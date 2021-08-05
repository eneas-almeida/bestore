package br.com.venzel.store.modules.product.category.use_cases.show_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.category.dtos.CategoryDTO;

@RestController
@RequestMapping("/products/categories")
public class ShowCategoryController {
    
    @Autowired
    private ShowCategoryService showCategoryService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO handle(@PathVariable Long id) {

        return showCategoryService.execute(id);
    }
}
