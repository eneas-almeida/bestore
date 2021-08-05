package br.com.venzel.store.modules.product.product.use_cases.list_product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.product.product.dtos.ProductDTO;

@RestController
@RequestMapping("/products")
public class ListProductController {

    @Autowired
    private ListProductService listProductServices;

    @GetMapping
    public Page<ProductDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                @RequestParam(value = "linesPerPage", defaultValue = "4") Integer linesPerPage,
                                @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        return listProductServices.execute(page, linesPerPage, orderBy, direction);
    }
}
