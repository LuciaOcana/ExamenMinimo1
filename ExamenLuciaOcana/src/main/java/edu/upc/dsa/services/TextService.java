package edu.upc.dsa.services;

import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Api(value = "/text", description = "Endpoint to Text Service")
@Path("text")
public class TextService {
    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @Path("users/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("username") String userName) {
        return "Hello " + userName;
    }

    @Path("exception")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String throwIt() throws Exception {
        throw new Exception("My Exception");
    }
}
