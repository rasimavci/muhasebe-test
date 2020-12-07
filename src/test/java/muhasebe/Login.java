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
    @Test
    public void authenticate(ITestContext context) {
        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                //.contentType(ContentType.JSON)
                .contentType("application/x-www-from-urlencoded").
                        body("{\n" +
                                "  \"grant_type\": \"string\",\n" +
                                "  \"name\": \"string\",\n" +
                                "  \"scope\": \"string\",\n" +
                                "  \"client_id\": \"string\",\n" +
                                "  \"client_secret\": \"string\",\n" +
                                "  \"password\": \"string\"\n" +
                                "}").
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
        Assert.assertEquals(jsonPathEvaluator.get("id"), getRandomid(), "ID returned was false !");
        //Assert.assertEquals(jsonPathEvaluator.get("password"),password1,  "Password returned was false !");
    }

    @Test
    public void registerLogin(ITestContext context) {
        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                //.contentType(ContentType.JSON)
                .contentType("application/json").
                        body("{\n" +
                                "  \"id\": \""+Util.randomid1+"\",\n" +
                                "  \"name\": \"rasim1234\",\n" +
                                "  \"company\": \"ronwell\",\n" +
                                "  \"phonenumber\": \"string\",\n" +
                                "  \"address\": \"myaddress\",\n" +
                                "  \"email\": \"rasim.avci3@gmail.com\",\n" +
                                "  \"lastlogin\": \""+getCurrentDate()+"\",\n" +
                                "  \"activeuntil\": \""+getCurrentDate()+"\",\n" +
                                "  \"password\": \"1234\"\n" +
                                "}").
                        when().
                        post("/admin-login");

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();


        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime();
    }

    @Test
    public void getToken(ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                //.contentType(ContentType.JSON)
                .contentType("application/json").
                        body("{\n" +
                                "  \"id\": \""+Util.randomid1+"\",\n" +
                                "  \"password\": \"1234\"\n" +
                                "}").
                        when().
                        post("/get_token/");

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
    public void adminLogin(ITestContext context) {
        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                //.contentType(ContentType.JSON)
                .contentType("application/json").
                        body("{\n" +
                                "  \"id\": \""+Util.randomid1+"\",\n" +
                                "  \"password\": \"1234\"\n" +
                                "}").
                        when().
                        post("/admin-login");

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

}
