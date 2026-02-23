package com.guilherme.automation.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CreateBookingNegativeTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    void shouldReturn400WhenPayloadIsMalformedJson() {

        String malformedJson = """
        {
            "firstname": "Guilherme",
            "lastname": "Hirata"
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2026-01-01",
                "checkout": "2026-01-10"
            },
            "additionalneeds": "Breakfast"
        }
        """;

        given()
            .contentType(ContentType.JSON)
            .body(malformedJson)
        .when()
            .post("/booking")
        .then()
            .statusCode(400);
    }
}