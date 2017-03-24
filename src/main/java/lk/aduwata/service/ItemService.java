package lk.aduwata.service;


import lk.aduwata.model.Item;
import lk.aduwata.repository.ItemRepository;
import lk.aduwata.resource.ItemResource;
import lk.aduwata.util.rest.DataTableResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * ItemService is for providing services for the item table
 *
 * @author Sugeesh Chandraweera
 */
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public DataTableResponse<ItemResource> getAllItems(String search, int page, int size, Boolean asc, String column) throws ServiceException {
        List<ItemResource> itemList = new ArrayList<>();
        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        search = search.isEmpty() ? "%" : "%" + search + "%";
        DataTableResponse<ItemResource> response = new DataTableResponse<>();
        try {
            Page<Item> results = itemRepository.findAllByNameLike(search, new PageRequest(page, size, direction, column));
            for (Item item : results) {
                itemList.add(ItemResource.createResource(item));
            }
            response.setEntries(results.getTotalElements());
            response.setDataRows(itemList);
            return response;
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
        Item item = new Item(
                itemResource.getName(),
                itemResource.getDescription(),
                itemResource.getSize(),
                itemResource.getPrice(),
                itemResource.getColor(),
                itemResource.isUsed()
        );
        Item savedItem = itemRepository.save(item);
        return ItemResource.createResource(savedItem);
    }
}
