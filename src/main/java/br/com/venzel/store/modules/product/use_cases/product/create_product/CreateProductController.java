package br.com.venzel.store.modules.product.use_cases.product.create_product;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.venzel.store.modules.product.dtos.category.CreateProductDTO;
import br.com.venzel.store.modules.product.dtos.product.ProductDTO;

@RestController
@RequestMapping("/products")
public class CreateProductController {

    @Autowired
    private CreateProductService createProductService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> handle(@RequestBody CreateProductDTO dto) {

        ProductDTO productDTO = createProductService.execute(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(productDTO.getId())
                        .toUri();

        return ResponseEntity.created(uri).build();
    }
}
