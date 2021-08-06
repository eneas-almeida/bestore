package br.com.venzel.store.modules.user.history.use_cases.list_hitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.venzel.store.modules.user.history.dtos.HistoryDTO;

@RestController
@RequestMapping("/histories")
public class ListHistoryController {
    
    @Autowired
    private ListHistoryService listHistoryService;

    @GetMapping
    public Page<HistoryDTO> handle(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                    @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                    @RequestParam(value = "orderBy", defaultValue = "createdAt") String orderBy,
                                    @RequestParam(value = "direction", defaultValue = "DESC") String direction) {

        return listHistoryService.execute(page, linesPerPage, orderBy, direction);
    }
}