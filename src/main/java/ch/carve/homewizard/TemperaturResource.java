package ch.carve.homewizard;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("temperatur")
public class TemperaturResource {

    @Inject
    private TemperaturService tempService;
    
    @GET
    @Path("list")
    public Response getTemp() {
        return Response.ok(String.valueOf(tempService.getSensor(0).getTemperatur())).build();
    }
    
}
