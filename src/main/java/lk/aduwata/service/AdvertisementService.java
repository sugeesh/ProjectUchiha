package lk.aduwata.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import lk.aduwata.model.Advertisement;
import lk.aduwata.model.Category;
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
import java.util.List;


/**
 * AdvertisementService is for providing services for the item table
 *
 * @author Sugeesh Chandraweera
 */
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository itemRepository;

    @Autowired
    private CategoryService categoryService;


    /**
     * This method will return the searched item
     * @param search search word
     * @param page  page number
     * @param size  page size
     * @param asc   ase true or false
     * @param column  sorting column
     * @return AdvertisementResource List
     */
    public DataTableResponse<AdvertisementResource> getItems(String search, int page, int size, Boolean asc, String column) throws ServiceException {
        List<AdvertisementResource> itemList = new ArrayList<>();
        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        final String search1 = search.isEmpty() ? "%" : "%" + search + "%";
        DataTableResponse<AdvertisementResource> response = new DataTableResponse<>();
        try {
            Page<Advertisement> results = itemRepository.findAllByTitleLike(search1, new PageRequest(page, size, direction, column));
            for (Advertisement item : results) {
                itemList.add(AdvertisementResource.createResource(item));
            }
            response.setTotalEntries(results.getTotalElements());
            response.setTotalPages(results.getTotalPages());
            response.setCurrentPage(page);
            response.setDataRows(itemList);
            return response;
            /*return PagingUtil.queryPage(page, size, asc != null && asc, column,
                    paging -> itemRepository.findAllByNameLike(search1, paging), AdvertisementResource::createResource);*/

        } catch (DataAccessException e) {

        }
        return response;
    }

    /**
     * This method will return the all the items as list
     * @return AdvertisementResource List
     */
    public Object getAllItemsWithoutPagination() {
        List<AdvertisementResource> permissions = new ArrayList<>();
        for (Advertisement permission : itemRepository.findAll()) {
            permissions.add(AdvertisementResource.createResource(permission));
        }
        return permissions;
    }


    /**
     * This method will save the Advertisement
     * @param itemResource itemResource for the save
     * @return AdvertisementResource with the resource details
     */
    public AdvertisementResource saveItem(AdvertisementResource itemResource) {
        Advertisement modelItem = AdvertisementResource.createModel(itemResource);
        modelItem.setDate(new Date());
        Advertisement savedItem = itemRepository.save(modelItem);
        return AdvertisementResource.createResource(savedItem);
    }


    public DataTableResponse<AdvertisementResource> getItemsByCategory(int id, int page, int size, Boolean asc, String column) throws ServiceException {
        List<AdvertisementResource> itemList = new ArrayList<>();
        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Category category = new Category();
        category.setId(id);
        DataTableResponse<AdvertisementResource> response = new DataTableResponse<>();
        try {
            Page<Advertisement> results = itemRepository.findByCategory(category, new PageRequest(page, size, direction, column));
            for (Advertisement item : results) {
                itemList.add(AdvertisementResource.createResource(item));
            }
            response.setTotalEntries(results.getTotalElements());
            response.setTotalPages(results.getTotalPages());
            response.setCurrentPage(page);
            response.setDataRows(itemList);
            return response;
            /*return PagingUtil.queryPage(page, size, asc != null && asc, column,
                    paging -> itemRepository.findAllByNameLike(search1, paging), AdvertisementResource::createResource);*/

        } catch (DataAccessException e) {

        }
        return response;
    }

    /**
     * This method will return the Items by category
     * @param categoryId categoryId of the searching
     * @return List of AdvertisementResource
     */
    public List<AdvertisementResource> getItemsByCategory(String categoryId){
        Category category = new Category();
        category.setId(Integer.parseInt(categoryId));
        List<Advertisement> itemList = itemRepository.findByCategory(category);
        List<AdvertisementResource> itemResourceList = new ArrayList<>();
        for (Advertisement item: itemList){
            itemResourceList.add(AdvertisementResource.createResource(item));
        }
        return itemResourceList;
    }

    public AdvertisementResource getItemById(int id){
        Advertisement item = itemRepository.findById(id);
        return AdvertisementResource.createResource(item);
    }


    public Map saveImage(InputStream uploadedInputStream,String id) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "sugeesh",
                "api_key", "239987644645947","api_secret", "6IldKlVbtxXwQhJ62S3oXgvjVOk"));


        File file = new File("saveFile");
        OutputStream outputStream = new FileOutputStream(file);
        IOUtils.copy(uploadedInputStream, outputStream);
        outputStream.close();

        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "public_id", id,
                "transformation", new Transformation().crop("limit").width(215).height(215),
                "eager", Arrays.asList(
                        new Transformation().width(200).height(200)
                                .crop("thumb").gravity("face").radius(20)
                                .effect("sepia"),
                        new Transformation().width(100).height(150)
                                .crop("fit").fetchFormat("png")
                ),
                "tags", "special, for_homepage"));


        return null;
    }
}
