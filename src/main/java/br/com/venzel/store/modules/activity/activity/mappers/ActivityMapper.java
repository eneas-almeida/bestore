package br.com.venzel.store.modules.activity.activity.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.activity.activity.dtos.ActivityDTO;
import br.com.venzel.store.modules.activity.activity.dtos.CreateActivityDTO;
import br.com.venzel.store.modules.activity.activity.entities.Activity;

@Component
public class ActivityMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ActivityDTO toDTO(Activity activity) {
        return modelMapper.map(activity, ActivityDTO.class);
    }

    public List<ActivityDTO> toCollectionModel(List<Activity> histories) {
        return histories.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Page<ActivityDTO> toCollectionPageModel(Page<Activity> Histories) {
        return Histories.map(e -> toDTO(e));
    }

    public Activity toEntity(CreateActivityDTO dto) {
        return modelMapper.map(dto, Activity.class);
    }
}
