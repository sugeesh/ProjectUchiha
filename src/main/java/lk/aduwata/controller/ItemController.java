package lk.aduwata.controller;


import lk.aduwata.resource.ItemResource;
import lk.aduwata.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * ItemController is for handling the item requests
 *
 * @author Sugeesh Chandraweera
 */

@Component
@Path("/item")
public class ItemController extends AbstractController {

    @Autowired
    private ItemService itemService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllItems(
            @QueryParam("search") String search,
            @QueryParam("page") int page,
            @QueryParam("size") int size,
            @QueryParam("asc") Boolean asc,
            @QueryParam("column") String column
    ) {
        try {
            if (search == null && page == 0 && size == 0 && asc == null && column == null)
                return sendSuccessResponse("It is working");
//                return sendSuccessResponse(itemService.getAllItemsWithoutPagination());
            else
                return sendSuccessResponse(itemService.getAllItems(search, page, size, asc, column));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

    @POST
    @Path("/save_item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveItem(ItemResource itemResource) {
        try {
            return handleServiceException(new Exception("Test1 message"));
//            return sendSuccessResponse(itemService.saveItem(itemResource));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

}