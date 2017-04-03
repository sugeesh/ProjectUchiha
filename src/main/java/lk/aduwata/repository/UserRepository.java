package lk.aduwata.repository;


import lk.aduwata.model.Item;
import lk.aduwata.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * This repository is for handling the item table
 *
 * @author Sugeesh Chandraweera
 */

@Component
public interface UserRepository extends CrudRepository<User, Integer> {

//    Page<Item> findAllByNameLike(String LastName, Pageable pageable);

//    void deleteItemByItemId(int id);
}

