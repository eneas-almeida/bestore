package br.com.venzel.store.modules.activity.activity.use_cases.list_activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.activity.activity.dtos.ActivityDTO;
import br.com.venzel.store.modules.activity.activity.entities.Activity;
import br.com.venzel.store.modules.activity.activity.exceptions.ActivityNotFoundException;
import br.com.venzel.store.modules.activity.activity.mappers.ActivityMapper;
import br.com.venzel.store.modules.activity.activity.repositories.ActivityRepository;
import br.com.venzel.store.modules.activity.activity.utils.ActivityMessageUtils;

@Service
public class ListActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityMapper activityMapper;
    
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Page<ActivityDTO> execute(Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<Activity> histories = activityRepository.findAll(pageRequest);

        if (histories.isEmpty()) {
            throw new ActivityNotFoundException(ActivityMessageUtils.ACTIVITY_NOT_FOUND);
        }

        Page<ActivityDTO> pageActivityDTO = activityMapper.toCollectionPageModel(histories);

        return pageActivityDTO;
    }
}