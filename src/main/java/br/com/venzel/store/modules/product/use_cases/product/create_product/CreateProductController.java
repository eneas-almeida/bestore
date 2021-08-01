package br.com.venzel.store.modules.product.use_cases.product.create_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.CreateProductDTO;
import br.com.venzel.store.modules.product.dtos.ProductDTO;

@RestController
@RequestMapping("/products")
public class CreateProductController {

    @Autowired
    private CreateProductService productUserService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO handle(@RequestBody CreateProductDTO dto) {

        return productUserService.execute(dto);
    }
}
