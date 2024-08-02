package tech.ledem.jpa.service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;
import tech.ledem.jpa.entity.User;
import tech.ledem.jpa.repository.UserRepository;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository userRepository;

public Iterable<User> search(String name) {
    if (Strings.isNotEmpty(name)) {
        return this.userRepository.getByExpression(name);
    }

    return this.userRepository.findAll();
}

}
