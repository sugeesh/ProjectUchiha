package lk.aduwata.repository;

import lk.aduwata.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sugeesh Chandraweera
 */
public interface CategoryRepository  extends CrudRepository<Category, Integer> {

    Page<Category> findAllByNameLike(String name, Pageable pageable);

    Category findById(String id);
}
