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
import java.util.Random;
import static io.restassured.RestAssured.*;

public class  Login extends Values{

    @BeforeClass
    public static void register (ITestContext context){

        Util.register(context);

    }

    /*@Test
    public void authenticate(ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/x-www-from-urlencoded").
                        formParam("grant_type","grant_type")
                        .formParam("name",getName1())
                        .formParam("scope","scope")
                        .formParam("client_id","client_id")
                        .formParam("client_secret","client_secret")
                        .formParam("password",getPassword1()).
                        body("").
                        when().
                        post("/authenticate");

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();


        Assert.assertEquals(statusCode, 200, "Status code returned was false !");
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/authenticate");
    }*/

    @Test
    public void registerLogin(ITestContext context) {
        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/admin-login";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").
                        body("{\n" +
                                "  \"id\": \""+getRandomid()+"\",\n" +
                                "  \"password\": \""+getPassword1()+"\"\n" +
                                "}").
                        when().
                        post(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();


        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/admin-login");
    }

    @Test
    public void getToken(ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/get_token/";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").
                        body("{\n" +
                                "  \"id\": \""+getRandomid()+"\",\n" +
                                "  \"password\": \""+getPassword1()+"\"\n" +
                                "}").
                        when().
                        post(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();

        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/get-token");

    }


    @Test
    public void adminLogin(ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/admin-login";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").
                        body("{\n" +
                                "  \"id\": \""+getRandomid()+"\",\n" +
                                "  \"password\": \""+getPassword1()+"\"\n" +
                                "}").
                        when().
                        post(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();

        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/admin-login");

    }

}
