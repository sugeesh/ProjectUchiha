package lk.aduwata.repository;


import lk.aduwata.model.AdDetail;
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
public interface AdDetailRepository extends CrudRepository<AdDetail, Integer> {

    AdDetail findById(int id);

    List<AdDetail> findByAdvertisement(Advertisement advertisement);

}
