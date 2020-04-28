package ch.carve.homewizard;

import ch.carve.homewizard.model.Switch;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;

@Slf4j
@Path("/light")
@Produces("application/json")
public class LightResource {

    @Inject
    Template light;

    @Inject
    LightService lightService;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get() {
        ArrayList<Switch> data = lightService.getList();
        return light.data("light", data)
                .data("active", "Light");
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Path("/{id}/toggle/{status}")
    public Response toggle(@PathParam("id") int id, @PathParam("status") String status) {
        log.info("toggle {}, old status {}", id, status);
        lightService.toggle(id, "off".equals(status) ? "on" : "off");
        return Response.status(301)
                .location(URI.create("/light"))
                .build();
    }
}