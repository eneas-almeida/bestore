package br.com.venzel.store.modules.product.use_cases.product.list_product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.dtos.ProductDTO;

@RestController
@RequestMapping("/products")
public class ListProductController {

    @Autowired
    private ListProductService listProductServices;

    @GetMapping
    public List<ProductDTO> handle() {
        return this.listProductServices.execute();
    }
}
