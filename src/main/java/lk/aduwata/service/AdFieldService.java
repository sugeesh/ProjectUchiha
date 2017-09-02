package lk.aduwata.service;


import lk.aduwata.model.AdDetail;
import lk.aduwata.model.AdField;
import lk.aduwata.model.Category;
import lk.aduwata.repository.AdDetailRepository;
import lk.aduwata.repository.AdFieldRepository;
import lk.aduwata.resource.AdvertisementResource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * AdvertisementService is for providing services for the item table
 *
 * @author Sugeesh Chandraweera
 */
public class AdFieldService {

    @Autowired
    private AdFieldRepository adFieldRepository;

    public AdField getAdFieldById(int id){
        return adFieldRepository.findById(id);
    }
}
