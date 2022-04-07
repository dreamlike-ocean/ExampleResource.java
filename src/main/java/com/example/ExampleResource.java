package com.example;


import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional;
import io.smallrye.mutiny.Uni;
import io.vertx.core.impl.NoStackTraceThrowable;
import io.vertx.mutiny.core.Vertx;
import org.hibernate.reactive.mutiny.Mutiny;
import org.jboss.resteasy.reactive.server.ServerRequestFilter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;


@ApplicationScoped
@Path("")
public class ExampleResource{
    @Inject
    Vertx vertx;
    @Inject
    Mutiny.Session session;
    @Inject
    QuarkusSession quarkusSession;



    @GET
    @Consumes
    @Path("/s")
    public Uni<String> s() {
        Map<String, Object> map = quarkusSession.getAttributes();
        map.compute("key", (k,v) -> v == null ? UUID.randomUUID().toString() : v);
        return Uni.createFrom().item((String) map.get("key"));
    }



}

