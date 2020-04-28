package ch.carve.homewizard;

import ch.carve.homewizard.model.SwitchListResponse;
import ch.carve.homewizard.model.SwitchToggleResponse;
import ch.carve.homewizard.model.TemperatureResponse;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@RegisterRestClient
public interface HomewizardClient {

    @GET
    @Path("telist")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<TemperatureResponse> getTemperatur();

    @GET
    @Path("telist")
    @Produces(MediaType.APPLICATION_JSON)
    TemperatureResponse getTemperaturSync();

    @GET
    @Path("swlist")
    @Produces(MediaType.APPLICATION_JSON)
    SwitchListResponse getSwitchList();

    @GET
    @Path("sw/{id}/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    SwitchToggleResponse switchToggle(@PathParam("id") int id, @PathParam("status") String status);
}
