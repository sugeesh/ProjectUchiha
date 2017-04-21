package lk.aduwata.controller;

import lk.aduwata.resource.CategoryResource;
import lk.aduwata.resource.ItemResource;
import lk.aduwata.service.CategoryService;
import lk.aduwata.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Sugeesh Chandraweera
 */
@Component
@Path("/category")
public class CategoryController extends AbstractController {
    @Autowired
    private CategoryService categoryService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories(
            @QueryParam("search") String search,
            @QueryParam("page") int page,
            @QueryParam("size") int size,
            @QueryParam("asc") Boolean asc,
            @QueryParam("column") String column
    ) {
        try {
            if (search == null && page == 0 && size == 0 && asc == null && column == null)
                return sendSuccessResponse(categoryService.getAllCategoriesWithoutPagination());
            else
                return sendSuccessResponse(categoryService.getAllCategories(search, page, size, asc, column));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

    @POST
    @Path("/save_category")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveCategory(CategoryResource categoryResource) {
        try {
            return sendSuccessResponse(categoryService.saveCategory(categoryResource));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

}
