package br.com.venzel.store.modules.user.history.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.user.history.dtos.CreateHistoryDTO;
import br.com.venzel.store.modules.user.history.dtos.HistoryDTO;
import br.com.venzel.store.modules.user.history.entities.History;

@Component
public class HistoryMapper {

    @Autowired
    private ModelMapper modelMapper;

    public HistoryDTO toDTO(History history) {
        return modelMapper.map(history, HistoryDTO.class);
    }

    public List<HistoryDTO> toCollectionModel(List<History> histories) {
        return histories.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Page<HistoryDTO> toCollectionPageModel(Page<History> histories) {
        return histories.map(e -> toDTO(e));
    }

    public History toEntity(CreateHistoryDTO dto) {
        return modelMapper.map(dto, History.class);
    }
}
