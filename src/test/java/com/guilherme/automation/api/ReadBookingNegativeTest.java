package com.guilherme.automation.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReadBookingNegativeTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    void shouldReturn404WhenBookingIdDoesNotExist() {

        List<Integer> ids =
                given()
                        .header("Accept", "*/*")
                .when()
                        .get("/booking")
                .then()
                        .statusCode(200)
                        .extract()
                        .jsonPath()
                        .getList("bookingid", Integer.class);

        int maxId = ids.stream().mapToInt(Integer::intValue).max().orElse(0);
        int nonExistingId = maxId + 100000;

        given()
                .header("Accept", "*/*")
        .when()
                .get("/booking/{id}", nonExistingId)
        .then()
                .statusCode(404);
    }
}