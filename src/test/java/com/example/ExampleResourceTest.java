package com.example;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.vertx.UniHelper;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import io.vertx.mutiny.sqlclient.SqlConnection;
import io.vertx.mutiny.sqlclient.Transaction;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ExampleResourceTest {
    @Inject
    MySQLPool mySQLPool;

    private static final String CONNECTION_KEY = "connection";
    private static final String TRANSACTION_KEY = "transaction";
}