package task_20;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import task_20.entity.request.LoginRequest;
import task_20.entity.request.UpdateRequest;
import task_20.entity.response.LoginResponse;
import task_20.entity.response.UpdateResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Log4j
public class task_20Test extends BaseTest {

    @BeforeTest
    public void preconditions() {
        baseURI = properties.getProperty("url-api");
    }


    @Test(testName = "Get all users test", priority = 1, enabled = true)
    public void getTest() {
        Response response = given().get("users");
        response
                .then()
                .assertThat()
                .statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getInt("per_page"), 6);
        Assert.assertTrue(response.then().extract().response().jsonPath().getString("support.text").contains("To keep ReqRes free"));
    }

    @Test(testName = "Delete 2nd user test", priority = 2, enabled = true)
    public void delete2ndUserTest() {
        Response response = given().delete("users/2");
        response
                .then()
                .assertThat()
                .statusCode(204);
        Assert.assertTrue(response.body().asString().isEmpty());
    }

    @Test(testName = "Register is successful test", priority = 3, enabled = true)
    public void createUserTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(getJsonData("task20Register"))
                .post("register");
        response
                .then()
                .assertThat()
                .statusCode(200);
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("id"), properties.getProperty("id"));
        Assert.assertEquals(response.then().extract().response().jsonPath().getString("token"), properties.getProperty("token"));
    }

    @Test(testName = "Patch user test", priority = 4, enabled = true)
    public void patchUserTest() {
        UpdateRequest updateRequest = new UpdateRequest() {{
            setName(properties.getProperty("patchname"));
            setJob(properties.getProperty("patchjob"));
        }};
        Response response = given()
                .header("Content-Type", "application/json")
                .body(updateRequest)
                .patch("users/2");
        response
                .then()
                .assertThat()
                .statusCode(200);
        UpdateResponse updateResponse = response.as(UpdateResponse.class);
        Assert.assertEquals(updateResponse.getName(), properties.getProperty("patchname"));
        Assert.assertEquals(updateResponse.getJob(), properties.getProperty("patchjob"));
        Assert.assertTrue(response.then().extract().response().asString().contains("updatedAt"));
    }

    @Test(testName = "Put user test", priority = 5, enabled = true)
    public void putUserTest() {
        UpdateRequest updateRequest = new UpdateRequest() {{
            setName(properties.getProperty("putname"));
            setJob(properties.getProperty("putjob"));
        }};
        Response response = given()
                .header("Content-Type", "application/json")
                .body(updateRequest)
                .put("users/2");
        response
                .then()
                .assertThat()
                .statusCode(200);
        UpdateResponse updateResponse = response.as(UpdateResponse.class);
        Assert.assertEquals(updateResponse.getName(), properties.getProperty("putname"));

    }

    @Test(testName = "Login is successful test", priority = 6)
    public void loginOkTest() {
        LoginRequest loginRequest = new LoginRequest() {{
            setEmail(properties.getProperty("email"));
            setPassword(properties.getProperty("loginpassword"));
        }};
        Response response = given()
                .header("Content-Type", "application/json")
                .body(loginRequest)
                .post("login");
        response
                .then()
                .assertThat()
                .statusCode(200);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        Assert.assertEquals(loginResponse.getToken(), properties.getProperty("token"));
    }

    @Test(testName = "Login is not successful test", priority = 7)
    public void loginNotOkTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(getJsonData("task20Login"))
                .post("login");
        response
                .then()
                .assertThat()
                .statusCode(400);
        Assert.assertTrue(response.then().extract().response().asString().contains("Missing password"));
    }

    public String getJsonData(String filename) {
        log.debug("Get data from JSON");
        try {
            return new String(Files.readAllBytes(Paths.get("files/json/" + filename + ".json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
