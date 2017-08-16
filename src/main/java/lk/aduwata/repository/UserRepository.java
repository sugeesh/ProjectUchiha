package lk.aduwata.repository;


import lk.aduwata.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * This repository is for handling the item table
 *
 * @author Sugeesh Chandraweera
 */

@Component
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String LastName);

}

