package ExceptionsMapper;


import exceptions.UserUsedInCurrentRentException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class UserUsedInCurrentRentExceptionMapper implements ExceptionMapper<UserUsedInCurrentRentException> {
    @Override
    public Response toResponse( UserUsedInCurrentRentException ex){
        return Response.status(500).entity(ex.getMessage()).build();
    }
}
