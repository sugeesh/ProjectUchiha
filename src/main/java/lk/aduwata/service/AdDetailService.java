package lk.aduwata.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import lk.aduwata.model.AdDetail;
import lk.aduwata.model.Advertisement;
import lk.aduwata.model.Category;
import lk.aduwata.repository.AdDetailRepository;
import lk.aduwata.repository.AdvertisementRepository;
import lk.aduwata.resource.AdvertisementResource;
import lk.aduwata.util.rest.DataTableResponse;
import org.apache.commons.io.IOUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.io.*;
import java.util.*;


/**
 * AdvertisementService is for providing services for the item table
 *
 * @author Sugeesh Chandraweera
 */
public class AdDetailService {

    @Autowired
    private AdDetailRepository adDetailRepository;

    @Autowired
    private AdFieldService adFieldService;

    public AdDetail saveDetails(Advertisement advertisement, String attribute, String value) {
        AdDetail adDetail = new AdDetail();
        adDetail.setAdvertisement(advertisement);
        adDetail.setField(adFieldService.getAdFieldById(Integer.parseInt(attribute)));
        adDetail.setValue(value);
        return adDetailRepository.save(adDetail);
    }

}
