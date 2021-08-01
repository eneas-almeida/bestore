package br.com.venzel.store.modules.product.use_cases.product.delete_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.product.ProductDTO;

@RestController
@RequestMapping("/products")
public class DeleteProductController {
    
    @Autowired
    private DeleteProductService deleteProductService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO handle(@PathVariable Long id) {

        return deleteProductService.execute(id);
    }
}
