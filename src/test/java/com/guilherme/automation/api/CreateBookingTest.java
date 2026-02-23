package com.guilherme.automation.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CreateBookingTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @Test
    void shouldCreateBookingSuccessfully() {

        String payload = """
        {
            "firstname": "Carlos",
            "lastname": "Silva",
            "totalprice": 500,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2026-03-01",
                "checkout": "2026-03-10"
            },
            "additionalneeds": "Breakfast"
        }
        """;

        given()
            .contentType(ContentType.JSON)
            .body(payload)
        .when()
            .post("/booking")
        .then()
            .statusCode(200)
            .body("bookingid", notNullValue())
            .body("booking.firstname", equalTo("Carlos"))
            .body("booking.lastname", equalTo("Silva"))
            .body("booking.totalprice", equalTo(500))
            .body("booking.depositpaid", equalTo(true));
    }
}