package br.com.venzel.store.modules.activity.activity.use_cases.list_activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.activity.activity.dtos.ActivityDTO;

@RestController
@RequestMapping("/activities")
public class ListActivityController {
    
    @Autowired
    private ListActivityService listActivityService;

    @GetMapping
    public Page<ActivityDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                    @RequestParam(value = "orderBy", defaultValue = "createdAt") String orderBy,
                                    @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        return listActivityService.execute(page, linesPerPage, orderBy, direction);
    }
}