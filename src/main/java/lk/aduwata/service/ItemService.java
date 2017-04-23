package lk.aduwata.service;


import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import lk.aduwata.model.Category;
import lk.aduwata.model.Item;
import lk.aduwata.repository.ItemRepository;
import lk.aduwata.resource.ItemResource;
import lk.aduwata.util.rest.DataTableResponse;
import org.apache.commons.io.IOUtils;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


/**
 * ItemService is for providing services for the item table
 *
 * @author Sugeesh Chandraweera
 */
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryService categoryService;


    /**
     * This method will return the searched item
     * @param search search word
     * @param page  page number
     * @param size  page size
     * @param asc   ase true or false
     * @param column  sorting column
     * @return ItemResource List
     */
    public DataTableResponse<ItemResource> getItems(String search, int page, int size, Boolean asc, String column) throws ServiceException {
        List<ItemResource> itemList = new ArrayList<>();
        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        final String search1 = search.isEmpty() ? "%" : "%" + search + "%";
        DataTableResponse<ItemResource> response = new DataTableResponse<>();
        try {
            Page<Item> results = itemRepository.findAllByNameLike(search1, new PageRequest(page, size, direction, column));
            for (Item item : results) {
                itemList.add(ItemResource.createResource(item));
            }
            response.setTotalEntries(results.getTotalElements());
            response.setTotalPages(results.getTotalPages());
            response.setCurrentPage(page);
            response.setDataRows(itemList);
            return response;
            /*return PagingUtil.queryPage(page, size, asc != null && asc, column,
                    paging -> itemRepository.findAllByNameLike(search1, paging), ItemResource::createResource);*/

        } catch (DataAccessException e) {

        }
        return response;
    }

    /**
     * This method will return the all the items as list
     * @return ItemResource List
     */
    public Object getAllItemsWithoutPagination() {
        List<ItemResource> permissions = new ArrayList<>();
        for (Item permission : itemRepository.findAll()) {
            permissions.add(ItemResource.createResource(permission));
        }
        return permissions;
    }


    /**
     * This method will save the Item
     * @param itemResource itemResource for the save
     * @return ItemResource with the resource details
     */
    public ItemResource saveItem(ItemResource itemResource) {
        Item modelItem = ItemResource.createModel(itemResource);
        modelItem.setDate(new Date());
        Item savedItem = itemRepository.save(modelItem);
        return ItemResource.createResource(savedItem);
    }


    public DataTableResponse<ItemResource> getItemsByCategory(int id, int page, int size, Boolean asc, String column) throws ServiceException {
        List<ItemResource> itemList = new ArrayList<>();
        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        Category category = new Category();
        category.setCategoryId(id);
        DataTableResponse<ItemResource> response = new DataTableResponse<>();
        try {
            Page<Item> results = itemRepository.findByCategory(category, new PageRequest(page, size, direction, column));
            for (Item item : results) {
                itemList.add(ItemResource.createResource(item));
            }
            response.setTotalEntries(results.getTotalElements());
            response.setTotalPages(results.getTotalPages());
            response.setCurrentPage(page);
            response.setDataRows(itemList);
            return response;
            /*return PagingUtil.queryPage(page, size, asc != null && asc, column,
                    paging -> itemRepository.findAllByNameLike(search1, paging), ItemResource::createResource);*/

        } catch (DataAccessException e) {

        }
        return response;
    }

    /**
     * This method will return the Items by category
     * @param categoryId categoryId of the searching
     * @return List of ItemResource
     */
    public List<ItemResource> getItemsByCategory(String categoryId){
        Category category = new Category();
        category.setCategoryId(Integer.parseInt(categoryId));
        List<Item> itemList = itemRepository.findByCategory(category);
        List<ItemResource> itemResourceList = new ArrayList<>();
        for (Item item: itemList){
            itemResourceList.add(ItemResource.createResource(item));
        }
        return itemResourceList;
    }

    public Map saveImage(InputStream uploadedInputStream) throws IOException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "sugeesh",
                "api_key", "239987644645947","api_secret", "6IldKlVbtxXwQhJ62S3oXgvjVOk"));


        File file = new File("saveFile");
        OutputStream outputStream = new FileOutputStream(file);
        IOUtils.copy(uploadedInputStream, outputStream);
        outputStream.close();

        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "public_id", "6",
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
