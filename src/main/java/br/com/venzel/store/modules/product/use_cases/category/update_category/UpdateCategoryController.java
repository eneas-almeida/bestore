package br.com.venzel.store.modules.product.use_cases.category.update_category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.CategoryDTO;
import br.com.venzel.store.modules.product.dtos.UpdateCategoryDTO;

@RestController
@RequestMapping("/products/categories")
public class UpdateCategoryController {
    
    @Autowired
    private UpdateCategoryService updateCategoryService;

    @PutMapping("/{id}")
    public CategoryDTO handle(@RequestBody UpdateCategoryDTO dto, @PathVariable Long id) {

        return updateCategoryService.execute(dto, id);
    }
}
