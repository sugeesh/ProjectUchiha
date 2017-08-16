package lk.aduwata.repository;

import lk.aduwata.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Sugeesh Chandraweera
 */
@NoRepositoryBean
public interface BaseItemRepository<T extends Item> extends CrudRepository<T, Integer> {


}
