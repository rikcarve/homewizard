package ch.carve.homewizard;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.carve.homewizard.model.Special;
import ch.carve.homewizard.model.SpecialMapper;
import ch.carve.homewizard.model.TemperaturSensor;

@RequestScoped
@Path("/temperatur")
@Produces("application/json")
public class TemperaturResource {

    private static final Logger logger = LoggerFactory.getLogger(TemperaturResource.class);

    @Inject
    private TemperaturService tempService;

    @Inject
    private SpecialMapper mapper;

    @GET
    @Path("/list")
    public List<TemperaturSensor> getTempList() {
        List<TemperaturSensor> list = new ArrayList<>();
//        list.add(tempService.getSensor(0));
//        list.add(tempService.getSensor(1));
//        list.add(tempService.getSensor(2));
        return list;
    }

    @GET
    @Path("/sensor/{id}")
    public CompletionStage<TemperaturSensor> getTemp(@PathParam("id") int id) {
        logger.info("Get data for sensor {}", id);
        return tempService.getSensor(id);
    }

    @GET
    @Path("/map")
    public Special getSpecial() throws Exception {
        TemperaturSensor sensor = tempService.getSensor(1).toCompletableFuture().get();
        return mapper.map(sensor);
    }
}
