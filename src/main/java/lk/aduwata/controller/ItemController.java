package lk.aduwata.controller;

import lk.aduwata.resource.ItemResource;
import lk.aduwata.service.ItemService;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

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
    public Response getItems(
            @QueryParam("search") String search,
            @QueryParam("page") int page,
            @QueryParam("size") int size,
            @QueryParam("asc") Boolean asc,
            @QueryParam("column") String column
    ) {
        try {
            if (search == null && page == 0 && size == 0 && asc == null && column == null)
                return sendSuccessResponse(itemService.getAllItemsWithoutPagination());
            else
                return sendSuccessResponse(itemService.getItems(search, page, size, asc, column));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

    @GET
    @Path("/get_items_by_category")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems(
            @QueryParam("id") int id,
            @QueryParam("page") int page,
            @QueryParam("size") int size,
            @QueryParam("asc") Boolean asc,
            @QueryParam("column") String column
    ) {
        try {
            if (id == 0 && page == 0 && size == 0 && asc == null && column == null)
                return sendSuccessResponse(itemService.getAllItemsWithoutPagination());
            else
                return sendSuccessResponse(itemService.getItemsByCategory(id, page, size, asc, column));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

    @GET
    @Path("/by_category")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsByCategory(@QueryParam("categoryId") String id) {
        return sendSuccessResponse(itemService.getItemsByCategory(id));
    }

    @GET
    @Path("/by_id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemById(@QueryParam("id") int id) {
        return sendSuccessResponse(itemService.getItemById(id));
    }


    @POST
    @Path("/save_item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveItem(ItemResource itemResource) {
        try {
            return sendSuccessResponse(itemService.saveItem(itemResource));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

    @POST
    @Path("/save_image")
//    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @QueryParam("id") String id
    ) throws IOException {

        return sendSuccessResponse(itemService.saveImage(uploadedInputStream, id));
//        return  null;
    }

}