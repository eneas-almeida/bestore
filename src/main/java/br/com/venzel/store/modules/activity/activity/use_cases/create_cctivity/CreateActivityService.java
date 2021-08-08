package br.com.venzel.store.modules.activity.activity.use_cases.create_cctivity;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.activity.activity.entities.Activity;
import br.com.venzel.store.modules.activity.activity.repositories.ActivityRepository;
import br.com.venzel.store.modules.user.user.entities.User;

@Service
public class CreateActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Transactional
    public void execute(String action, User user) {

        /* Create new activity */

        Activity activity = new Activity(action, user);

        /* Save activity in repository*/

        activityRepository.save(activity);
    }
}
