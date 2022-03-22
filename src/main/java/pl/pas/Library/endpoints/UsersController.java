package pl.pas.Library.endpoints;

import pl.pas.Library.dto.UserDto;
import pl.pas.Library.DtoMapper.UserMapper;
import pl.pas.Library.managers.UserManager;
import pl.pas.Library.model.Rent;
import pl.pas.Library.model.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.*;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RequestScoped
@Path("/users")
public class UsersController {
    @Inject
    UserManager um;

    @Inject
    UserMapper mapper;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("uuid") UUID uuid) {
        User user = um.getUser(uuid);
        return Response.ok().entity(user).build();
    }

    // .../api/users
    // .../api/users?type=[]&login=[]
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(@QueryParam("type") String type, @QueryParam("login") String login) {
        if (type != null && login != null) {
            if (type.equals("part")) {
                List<User> users = um.findAllUsers(login);
                return Response.ok().entity(users).build();
            } else if (type.equals("full")) {
                User user = um.findUser(login);
                return Response.ok().entity(user).build();
            } else {
                return Response.status(400).build();
            }
        }
        if (type == null && login == null) {
            List<User> users = um.getAllUsers();
            return Response.ok().entity(users).build();
        }
        return Response.status(400).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBook(@Valid UserDto userDto) {
        User user = mapper.ConvertUserDtoToUser(userDto);
        um.addUser(user);
        return Response.status(201).entity(user).build();
    }

    @PUT
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response editUser(@PathParam("uuid") UUID uuid, @Valid UserDto userDto) {

        User user = mapper.ConvertUserDtoToUser(userDto);
        um.updateUser(uuid, user);
        return Response.ok().build();
    }

    @PUT
    @Path("/{uuid}/activate")
    public Response activeUser(@PathParam("uuid") UUID uuid) {
        um.changeActivityOfUser(uuid, true);
        return Response.ok().build();
    }

    @PUT
    @Path("/{uuid}/deactivate")
    public Response deactivateUser(@PathParam("uuid") UUID uuid) {
        um.changeActivityOfUser(uuid, false);
        return Response.ok().build();
    }

}
