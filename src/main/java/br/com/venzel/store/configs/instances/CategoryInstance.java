package br.com.venzel.store.configs.instances;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.product.entities.Category;
import br.com.venzel.store.modules.product.repositories.CategoryRepository;

@Service
public class CategoryInstance {

    @Autowired
    private CategoryRepository categoryRepository;

    public void populate() {

        categoryRepository.deleteAll();

        categoryRepository.saveAll(getList());
    }
    
    private List<Category> getList() {

        Category cereais = entityBuilder("cereais");
        Category padaria = entityBuilder("padaria");
        Category limpeza = entityBuilder("limpeza");

        List<Category> categories = new ArrayList<>();

        categories.addAll(Arrays.asList(cereais, padaria, limpeza));

        return categories;
    }

    private Category entityBuilder(String name) {

        return Category.builder()
                        .name(name)
                        .build();
    }

}
