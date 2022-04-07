package com.example;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.scheduler.Scheduled;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.Vertx;
import org.hibernate.reactive.mutiny.Mutiny;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class ScheduledService {
    @Inject
    Vertx vertx;
    @Inject
    Mutiny.SessionFactory sessionFactory;

    @Scheduled(every = "10s",delay = 5,delayUnit = TimeUnit.SECONDS)
    void dao(){
        Panache.withTransaction(()->{
            Uni<Long> count = LoginUser.count();
            Uni<LoginUser> id = LoginUser.findById(16);
            return Uni.combine().all().unis(count,id).asTuple();
        }).await().indefinitely();

    }
}
