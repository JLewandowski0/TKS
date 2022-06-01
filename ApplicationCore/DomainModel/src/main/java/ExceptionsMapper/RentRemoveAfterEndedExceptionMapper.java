package ExceptionsMapper;

import exceptions.RentRemoveAfterEndedException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RentRemoveAfterEndedExceptionMapper implements ExceptionMapper<RentRemoveAfterEndedException> {
    @Override
    public Response toResponse(RentRemoveAfterEndedException ex){
        return Response.status(500).entity(ex.getMessage()).build();
    }
}
