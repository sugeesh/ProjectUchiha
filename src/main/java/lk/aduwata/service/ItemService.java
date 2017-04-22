package lk.aduwata.service;


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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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


    public DataTableResponse<ItemResource> getAllItems(String search, int page, int size, Boolean asc, String column) throws ServiceException {
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

    public Object getAllItemsWithoutPagination() {
        List<ItemResource> permissions = new ArrayList<>();
        for (Item permission : itemRepository.findAll()) {
            permissions.add(ItemResource.createResource(permission));
        }
        return permissions;
    }


    public ItemResource saveItem(ItemResource itemResource) {
        Item modelItem = ItemResource.createModel(itemResource);
        modelItem.setDate(new Date());
        Item savedItem = itemRepository.save(modelItem);
        return ItemResource.createResource(savedItem);
    }


    public List<ItemResource> getItemsByCategory(String categoryId){
//        Category category = categoryService.getCategoryById(categoryId);
        Category category = new Category();
        category.setCategoryId(Integer.parseInt(categoryId));
        List<Item> itemList = itemRepository.findByCategory(category);
        List<ItemResource> itemResourceList = new ArrayList<>();
        for (Item item: itemList){
            itemResourceList.add(ItemResource.createResource(item));
        }
        return itemResourceList;
    }

    public byte[] getImageStream(Long id) throws IOException {

        InputStream is = new BufferedInputStream(new FileInputStream("c.png"));
        return IOUtils.toByteArray(is);
    }
}
