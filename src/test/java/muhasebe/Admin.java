package muhasebe;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.*;

public class Admin extends Values {

    @BeforeClass
    public static void register (ITestContext context){
        Util.register(context);

    }


    @Test
    public void checkAccess(ITestContext context){

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json")
                .queryParam("kwargs",Values.getKwargs()).
                        when().
                        get("/admin/check-access?kwargs=kwargs");

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();

        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");


    }

    @Test
    public void listUsers(ITestContext context){

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                //.contentType(ContentType.JSON)
                .contentType("application/json").queryParam("page","1").
                        when().
                        post("/admin/list-users?page=1");

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();

        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");

    }
    @Test
    public void changeUserData(ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").
                        body("{\n" +
                                "  \"credential_to_be_changed\": \"name\",\n" +
                                "  \"value\": \"rasim1234\",\n" +
                                "  \"user_id\": \""+Util.randomid1+"\"\n" +
                                "}").
                        when().
                        post("/admin/change-user-data");

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();


        Assert.assertEquals(statusCode, 200, "Status code returned was false !");
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line returned was false !");


    }
}
