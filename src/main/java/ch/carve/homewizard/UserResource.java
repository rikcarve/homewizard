package ch.carve.homewizard;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import ch.carve.homewizard.entity.UserEntity;
import ch.carve.homewizard.feature.HomewizardFeatures;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/user")
@Stateless
public class UserResource {

    @PersistenceContext
    EntityManager em;

    @Inject
    @ConfigProperty(name = "homewizard.test")
    private Provider<String> test;

    @GET
    @Path("/{user}")
    @Produces(value = "application/json")
    public UserEntity getUser(@PathParam("user") String userName) {
        log.info(test.get());
        return em.createNamedQuery("getByName", UserEntity.class).setParameter("name", userName).getSingleResult();
    }

    @GET
    @Path("feature")
    public Boolean getFeature() {
        return HomewizardFeatures.FEATURE_ONE.isActive();
    }
}
