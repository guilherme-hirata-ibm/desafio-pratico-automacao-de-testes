package com.guilherme.automation.api;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ReadBookingTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    void shouldGetExistingBookingById() {

        Integer bookingId =
                given()
                        .header("Accept", "*/*")
                .when()
                        .get("/booking")
                .then()
                        .statusCode(200)
                        .extract()
                        .jsonPath()
                        .getInt("[0].bookingid");

        given()
                .header("Accept", "*/*")
        .when()
                .get("/booking/{id}", bookingId)
        .then()
                .statusCode(200)
                .body("firstname", notNullValue())
                .body("lastname", notNullValue())
                .body("totalprice", notNullValue())
                .body("depositpaid", notNullValue())
                .body("bookingdates.checkin", notNullValue())
                .body("bookingdates.checkout", notNullValue());
    }
}