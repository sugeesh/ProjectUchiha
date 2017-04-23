package lk.aduwata.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import lk.aduwata.resource.ItemResource;
import lk.aduwata.service.ItemService;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import java.util.Map;

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
            if (id==0 && page == 0 && size == 0 && asc == null && column == null)
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


   /* @GET
    @Path("/image/{id}")
    @Produces("image/jpeg")
    public Response buscarFoto(@PathParam("id") Long id,
                               @Context HttpHeaders header,
                               @Context HttpServletResponse response) throws IOException {
        *//*byte[] bytes = null;
        bytes = itemService.getImageStream(id);
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);


        response.setContentType("images/png");
        response.setHeader("Content-Type", "image/png");
        response.setHeader("Content-Disposition", "inline; filename=\"" + "image.png" + "\"");

        try {
            OutputStream out = response.getOutputStream();
            IOUtils.copy(in, out);
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        } catch (IOException ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).type(MediaType.TEXT_HTML).build();
        }

        return Response.ok().build();*//*

        BufferedImage image = ImageIO.read(new File("c.png"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();

        // uncomment line below to send non-streamed
        // return Response.ok(imageData).build();

        // uncomment line below to send streamed
        return Response.ok(new ByteArrayInputStream(imageData)).build();

    }
*/
   /* @POST
    @Path("/save_image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {

//        return sendSuccessResponse(itemService.saveImage(uploadedInputStream));
        return  null;
    }*/


    @POST
    @Path("/save_image")
//    @Consumes(MediaType.ALL)
    public Response uploadFile(@RequestParam("file") MultipartFile file) {

//        return sendSuccessResponse(itemService.saveImage(uploadedInputStream));
        return handleServiceException(new Exception("a"));
    }

    /*public @ResponseBody Object newClient(
            @RequestParam(value = "infoClient") String infoClientString,
            @RequestParam(value = "file") MultipartFile file) {

        // parse the json string into a valid DTO
        ClientDTO infoClient = gson.fromJson(infoClientString, ClientDTO.class);
        //call the proper service method
        this.clientService.newClient(infoClient,file);

        return null;

    }*/
}