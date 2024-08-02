package tech.ledem.jpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tech.ledem.jpa.entity.User;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findByNameContaining(String expression);

    @Query("FROM User u WHERE u.name LIKE %?1%")
    Iterable<User> getByExpression(String expression);
}
