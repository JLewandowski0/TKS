package pl.pas.Library.endpoints;

import pl.pas.Library.dto.RentDto;
import pl.pas.Library.managers.RentManager;
import pl.pas.Library.DtoMapper.RentMapper;
import pl.pas.Library.model.Rent;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.UUID;

@RequestScoped
@Path("/rents")
public class RentsController {
    @Inject
    private RentManager rm;

    @Inject
    private RentMapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllRents() {
        List<Rent> rents = rm.getAllRents();
        return Response.ok().entity(rents).build();
    }

    // .../api/rents
    // .../api/rents/[uuid]?status=[]&obj=[]

    @GET
    @Path("/{uuid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRent(@PathParam("uuid") UUID uuid, @QueryParam("status") String status, @QueryParam("obj") String obj) {

        if (status == null && obj == null) {
            Rent rent = rm.getRent(uuid);
            return Response.ok().entity(rent).build();
        } else if (status != null && obj != null) {
            if (status.equals("current") && obj.equals("client")) {
                List<Rent> rents = rm.findAllCurrentRentsByClient(uuid);
                return Response.ok().entity(rents).build();
            } else if (status.equals("archived") && obj.equals("client")) {
                List<Rent> rents = rm.findAllArchivedRentsByClient(uuid);
                return Response.ok().entity(rents).build();
            } else if (status.equals("current") && obj.equals("book")) {
                List<Rent> rents = rm.findAllCurrentRentsByBook(uuid);
                return Response.ok().entity(rents).build();
            } else if (status.equals("archived") && obj.equals("book")) {
                List<Rent> rents = rm.findAllArchivedRentsByBook(uuid);
                return Response.ok().entity(rents).build();
            } else {
                return Response.status(400).build();
            }
        }
        return Response.status(400).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addRent(@Valid RentDto rentDto) {
        Rent rent = mapper.convertRentDtoToRent(rentDto);
        rm.addRent(rent);
        return Response.status(201).entity(rent).build();
    }

    @PUT
    @Path("/{uuid}")
    public Response endRent(@PathParam("uuid") UUID uuid) {
        rm.endRent(uuid);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{uuid}")
    public Response removeRent(@PathParam("uuid") UUID uuid) {
        rm.removeRent(uuid);
        return Response.ok().build();
    }

}
