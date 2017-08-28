package lk.aduwata.controller;

import lk.aduwata.resource.AdvertisementResource;
import lk.aduwata.service.AdvertisementService;
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
public class AdvertisementController extends AbstractController {

    @Autowired
    private AdvertisementService advertisementService;


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
                return sendSuccessResponse(advertisementService.getAllItemsWithoutPagination());
            else
                return sendSuccessResponse(advertisementService.getItems(search, page, size, asc, column));
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
                return sendSuccessResponse(advertisementService.getAllItemsWithoutPagination());
            else
                return sendSuccessResponse(advertisementService.getItemsByCategory(id, page, size, asc, column));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

    @GET
    @Path("/by_category")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsByCategory(@QueryParam("categoryId") String id) {
        return sendSuccessResponse(advertisementService.getItemsByCategory(id));
    }

    @GET
    @Path("/by_id")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemById(@QueryParam("id") int id) {
        return sendSuccessResponse(advertisementService.getItemById(id));
    }


    @POST
    @Path("/save_advertisement")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveItem(AdvertisementResource itemResource) {
        try {
            return sendSuccessResponse(advertisementService.saveItem(itemResource));
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

        return sendSuccessResponse(advertisementService.saveImage(uploadedInputStream, id));
//        return  null;
    }

}