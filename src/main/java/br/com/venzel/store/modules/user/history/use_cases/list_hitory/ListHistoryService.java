package br.com.venzel.store.modules.user.history.use_cases.list_hitory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.user.history.dtos.HistoryDTO;
import br.com.venzel.store.modules.user.history.entities.History;
import br.com.venzel.store.modules.user.history.exceptions.HistoryNotFoundException;
import br.com.venzel.store.modules.user.history.mappers.HistoryMapper;
import br.com.venzel.store.modules.user.history.repositories.HistoryRepository;
import br.com.venzel.store.modules.user.history.utils.HistoryMessageUtils;

@Service
public class ListHistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private HistoryMapper historyMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<HistoryDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<History> histories = historyRepository.findAll(pageRequest);

        if (histories.isEmpty()) {
            throw new HistoryNotFoundException(HistoryMessageUtils.HISTORY_NOT_FOUND);
        }

        Page<HistoryDTO> pageHistoryDTO = historyMapper.toCollectionPageModel(histories);

        return pageHistoryDTO;
    }
}