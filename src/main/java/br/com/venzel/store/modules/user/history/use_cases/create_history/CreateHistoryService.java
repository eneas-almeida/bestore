package br.com.venzel.store.modules.user.history.use_cases.create_history;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.venzel.store.modules.user.history.entities.History;
import br.com.venzel.store.modules.user.history.repositories.HistoryRepository;
import br.com.venzel.store.modules.user.user.entities.User;
import br.com.venzel.store.modules.user.user.exceptions.UserNotFoundException;
import br.com.venzel.store.modules.user.user.repositories.UserRepository;
import br.com.venzel.store.modules.user.user.utils.UserMessageUtils;

@Service
public class CreateHistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void execute(String description, Long id) {

        Optional<User> optionalEntity = userRepository.findById(id);

        if (optionalEntity.isEmpty()) {
            throw new UserNotFoundException(UserMessageUtils.USER_NOT_FOUND);
        }

        User user = optionalEntity.get();

        History history = new History(description, user);

        historyRepository.save(history);
    }
}
