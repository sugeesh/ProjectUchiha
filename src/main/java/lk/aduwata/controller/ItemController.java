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

    private static final String UPLOAD_FOLDER = "./a";


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
                return sendSuccessResponse(itemService.getAllItems(search, page, size, asc, column));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

    @GET
    @Path("/by_category")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsByCategory(
            @QueryParam("categoryId") String id
    ) {
        return sendSuccessResponse(itemService.getItemsByCategory(id));
    }


    @POST
    @Path("/save_item")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveItem(ItemResource itemResource) {
        try {
//            return handleServiceException(new Exception("Test1 message"));
            return sendSuccessResponse(itemService.saveItem(itemResource));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }


    @GET
    @Path("/image/{id}")
    @Produces("image/png")
    public Response buscarFoto(@PathParam("id") Long id,
                               @Context HttpHeaders header,
                               @Context HttpServletResponse response) throws IOException {
        /*byte[] bytes = null;
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

        return Response.ok().build();*/

        BufferedImage image = ImageIO.read(new File("c.png"));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();

        // uncomment line below to send non-streamed
        // return Response.ok(imageData).build();

        // uncomment line below to send streamed
        return Response.ok(new ByteArrayInputStream(imageData)).build();

    }


    /*@POST
    @Path("/save_image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {


        // check if all form parameters are provided
        if (uploadedInputStream == null || fileDetail == null)
            return Response.status(400).entity("Invalid form data").build();
        // create our destination folder, if it not exists
        try {
            createFolderIfNotExists(UPLOAD_FOLDER);
        } catch (SecurityException se) {
            return Response.status(500)
                    .entity("Can not create destination folder on server")
                    .build();
        }
        String uploadedFileLocation = UPLOAD_FOLDER + fileDetail.getFileName();
        try {
            saveToFile(uploadedInputStream, uploadedFileLocation);
        } catch (IOException e) {
            return Response.status(500).entity("Can not save file").build();
        }
        return Response.status(200)
                .entity("File saved to " + uploadedFileLocation).build();
    }

    private void saveToFile(InputStream inStream, String target)
            throws IOException {
        OutputStream out = null;
        int read = 0;
        byte[] bytes = new byte[1024];
        out = new FileOutputStream(new File(target));
        while ((read = inStream.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        out.flush();
        out.close();
    }

    private void createFolderIfNotExists(String dirName)
            throws SecurityException {
        File theDir = new File(dirName);
        if (!theDir.exists()) {
            theDir.mkdir();
        }
    }*/

    @POST
    @Path("/save_image")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {

        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "sugeesh",
                "api_key", "239987644645947",
                "api_secret", "6IldKlVbtxXwQhJ62S3oXgvjVOk"));


        File file = new File("saveFile");
        OutputStream outputStream = new FileOutputStream(file);
        IOUtils.copy(uploadedInputStream, outputStream);
        outputStream.close();

        Map result = cloudinary.uploader().upload(file, ObjectUtils.asMap(
                "public_id", "sample_id",
                "transformation", new Transformation().crop("limit").width(40).height(40),
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