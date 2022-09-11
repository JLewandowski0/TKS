package ExceptionsMapper;



import exceptions.RentWrongDateException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class RentWrongDateExceptionMapper implements ExceptionMapper<RentWrongDateException> {
    @Override
    public Response toResponse(RentWrongDateException ex){
        return Response.status(500).entity(ex.getMessage()).build();
    }
}
