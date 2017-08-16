package lk.aduwata.repository;


import lk.aduwata.model.Advertisement;
import lk.aduwata.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * This repository is for handling the item table
 *
 * @author Sugeesh Chandraweera
 */

@Component
public interface AdvertisementRepository extends CrudRepository<Advertisement, Integer> {

    Page<Advertisement> findAllByTitleLike(String name, Pageable pageable);

    List<Advertisement> findByCategory(Category category);

    Advertisement findById(int id);

    Page<Advertisement> findByCategory(Category category, Pageable pageable);
}
