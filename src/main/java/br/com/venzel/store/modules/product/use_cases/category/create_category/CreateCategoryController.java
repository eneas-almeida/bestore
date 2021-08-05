package br.com.venzel.store.modules.product.use_cases.category.create_category;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.venzel.store.modules.product.dtos.category.CategoryDTO;
import br.com.venzel.store.modules.product.dtos.category.CreateCategoryDTO;

@RestController
@RequestMapping("/products/categories")
public class CreateCategoryController {

    @Autowired
    private CreateCategoryService createCategoryService;

    @PostMapping
    public ResponseEntity<Void> handle(@RequestBody CreateCategoryDTO dto) {

        CategoryDTO categoryDTO = createCategoryService.execute(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(categoryDTO.getId())
                        .toUri();

        return ResponseEntity.created(uri).build();
    }
}
