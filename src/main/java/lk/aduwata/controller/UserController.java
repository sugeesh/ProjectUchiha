package lk.aduwata.controller;


import lk.aduwata.resource.ItemResource;
import lk.aduwata.resource.UserResource;
import lk.aduwata.service.ItemService;
import lk.aduwata.service.UserService;
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
@Path("/user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @POST
    @Path("/user_register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveUser(UserResource userResource) {
        try {
            return sendSuccessResponse(userService.saveUser(userResource));
        } catch (Exception e) {
            e.printStackTrace();
            return handleServiceException(e);
        }
    }

}