package restAssuredTest;


import io.restassured.RestAssured;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssTest {
    private String ApiKey;

    @Test
    public void getRequests(){
        String apiKey;
        given()
                .when()
                    .get("http://restapi.demoqa.com/utilities/whether/city/Hyderabad")
                .then()
                    .statusCode(200)
                    .statusLine("HTTP/1.1 200 OK")
                // .assertThat().body("City",equalTo("Hyderabad"))
                    .header("Connection", "close");
    }
}

/*
given()
    set cockies
    when()
        get post put
        then()
        validate
 */