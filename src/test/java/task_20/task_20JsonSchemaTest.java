package task_20;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import task_20.entity.request.UpdateRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

@Log4j
public class task_20JsonSchemaTest extends BaseTest {
    @BeforeTest
    public void preconditions() {
        baseURI = properties.getProperty("url-api");
    }

    @Test(testName = "Get users with Json Schema test", priority = 1)
    public void getTest() {
        Response response = given().get("users");
        response
                .then()
                .assertThat()
                .statusCode(200);
        response
                .then()
                .assertThat()
                .body(matchesJsonSchema(getJsonData("task20getUsersJsonSchema")));

    }

    @Test(testName = "Register is successful Json Schema test", priority = 2)
    public void createUserTest() {
        Response response = given()
                .header("Content-Type", "application/json")
                .body(getJsonData("task20Register"))
                .post("register");
        response
                .then()
                .assertThat()
                .statusCode(200);
        response
                .then()
                .assertThat()
                .body(matchesJsonSchema(getJsonData("task20createUserJsonSchema")));

    }

    @Test(testName = "Patch user Json Schema test", priority = 3)
    public void Test() {
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
        response
                .then()
                .assertThat()
                .body(matchesJsonSchema(getJsonData("task20patchUserJsonSchema")));

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
