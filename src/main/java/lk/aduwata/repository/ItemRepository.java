package lk.aduwata.repository;


import lk.aduwata.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This repository is for handling the item table
 *
 * @author Sugeesh Chandraweera
 */

@Component
public interface ItemRepository extends CrudRepository<Item, Integer> {

    Page<Item> findAllByNameLike(String LastName, Pageable pageable);



    void deleteItemByItemId(int id);
}
