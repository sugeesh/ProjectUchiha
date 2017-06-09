package lk.aduwata.service;

import lk.aduwata.model.Category;
import lk.aduwata.model.Item;
import lk.aduwata.repository.CategoryRepository;
import lk.aduwata.repository.ItemRepository;
import lk.aduwata.resource.CategoryResource;
import lk.aduwata.resource.ItemResource;
import lk.aduwata.util.rest.DataTableResponse;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Sugeesh Chandraweera
 */
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    /**
     * This method is for getting the categories for given  search string.
     * @param search
     * @param page
     * @param size
     * @param asc
     * @param column
     * @return
     * @throws ServiceException
     */
    public DataTableResponse<CategoryResource> getAllCategories(String search, int page, int size, Boolean asc, String column) throws ServiceException {
        List<CategoryResource> categoryList = new ArrayList<>();
        Sort.Direction direction = asc ? Sort.Direction.ASC : Sort.Direction.DESC;
        final String search1 = search.isEmpty() ? "%" : "%" + search + "%";
        DataTableResponse<CategoryResource> response = new DataTableResponse<>();
        try {
            Page<Category> results = categoryRepository.findAllByNameLike(search1, new PageRequest(page, size, direction, column));
            for (Category category : results) {
                categoryList.add(CategoryResource.createResource(category));
            }
            response.setTotalEntries(results.getTotalElements());
            response.setTotalPages(results.getTotalPages());
            response.setCurrentPage(page);
            response.setDataRows(categoryList);
            return response;
            /*return PagingUtil.queryPage(page, size, asc != null && asc, column,
                    paging -> itemRepository.findAllByNameLike(search1, paging), ItemResource::createResource);*/

        } catch (DataAccessException e) {
            throw e;
        }
    }

    /**
     * This method is for getting the all the categories without pagination.
     * @return list of categoryResources
     */
    public Object getAllCategoriesWithoutPagination() {
        List<CategoryResource> permissions = new ArrayList<>();
        for (Category permission : categoryRepository.findAll()) {
            permissions.add(CategoryResource.createResource(permission));
        }
        return permissions;
    }


    /**
     * This method will return the plain Category Object for the given Id
     * @param id id of the Category
     * @return Category Object
     */
    public Category getCategoryById(String id){
        return categoryRepository.findById(id);
    }


    /**
     * This method will save the category Resource
     * @param categoryResource saving object
     * @return CatrgoryResource Object with the savedDetails
     */
    public CategoryResource saveCategory(CategoryResource categoryResource) {
        Category modelCategory = CategoryResource.createModel(categoryResource);
        Category savedCategory = categoryRepository.save(modelCategory);
        return CategoryResource.createResource(savedCategory);
    }
}
