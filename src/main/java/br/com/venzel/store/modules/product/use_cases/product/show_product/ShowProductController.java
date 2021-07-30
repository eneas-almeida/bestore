package br.com.venzel.store.modules.product.use_cases.product.show_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.ProductDTO;

@RestController
@RequestMapping("/products")
public class ShowProductController {
    
    @Autowired
    private ShowProductService showProductService;
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO handle(@PathVariable Long id) {

        return showProductService.execute(id);
    }
}
