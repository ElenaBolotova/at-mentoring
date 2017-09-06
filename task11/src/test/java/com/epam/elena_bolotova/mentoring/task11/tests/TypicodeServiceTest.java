package com.epam.elena_bolotova.mentoring.task11.tests;

import com.epam.elena_bolotova.mentoring.task11.bo.user.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TypicodeServiceTest {

    @BeforeTest
    public void initTest() {
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
    }

    @Test
    @Parameters("resource")
    public void checkStatusCode(String resource) {
        Response rp = given().get(resource).andReturn();
        Assert.assertEquals(rp.getStatusCode(), HttpStatus.SC_OK);
    }

    @Test
    @Parameters({"resource", "header","value"})
    public void checkResponseHeader(String resource, String header, String value) {
        Response rp = given().get(resource).andReturn();
        String valueOfContentTypeHeader = rp.getHeader(header);
        Assert.assertTrue(valueOfContentTypeHeader.contains(value));
    }

    @Test
    @Parameters({"resource", "length"})
    public void checkResponseBody(String resource, int length) {
        Response rp = given().get(resource).andReturn();
        User[] users = rp.as(User[].class);
        Assert.assertEquals(users.length, length);
    }
}
