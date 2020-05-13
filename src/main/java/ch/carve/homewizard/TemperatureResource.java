package ch.carve.homewizard;

import ch.carve.homewizard.model.TemperatureSensor;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Path("/temperature")
@Produces(MediaType.TEXT_HTML)
public class TemperatureResource {

    private static final Logger logger = LoggerFactory.getLogger(TemperatureResource.class);

    @Inject
    TemperatureService tempService;

    @Inject
    Template temperatures;

    @GET
    @RolesAllowed("user")
    public TemplateInstance get() {
        List<TemperatureSensor> data = tempService.getList();
        return temperatures
                .data("temperatures", data)
                .data("active", "Temperature");
    }

    @GET
    @RolesAllowed("user")
    @Path("/sensor/{id}")
    public TemperatureSensor getTemp(@PathParam("id") int id) {
        logger.info("Get data for sensor {}", id);
        return tempService.getSensor(id);
    }

}
