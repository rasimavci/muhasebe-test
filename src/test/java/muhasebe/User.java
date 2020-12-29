package muhasebe;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.ITestContext;
import java.io.File;

public class User extends Values {

    @BeforeClass
    public static void register (ITestContext context){

        Util.register(context);

    }

    @Test(priority = 5)
    public void changePass(ITestContext context){

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/user/changepass/";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json")
                .body("{\n" +
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

        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/user/changepass");

    }

    @Test(priority = 4)
    public void user (ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/user/-legacy";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").
                        when().
                        get(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();

        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("id"),getRandomid(),  "ID returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("name"),getName1(),  "Name returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("email"),getEmail1(),  "Email returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("company"),getCompany1(),  "Company returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("phonenumber"),getPhonenumber1(),  "Phone Number returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("address"),getAddress1(),  "Address returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("lastlogin"),getLastlogin1(),  "Last Login returned was false !");
        Assert.assertEquals(jsonPathEvaluator.get("activeuntil"),getActiveuntil1(),  "Active Until returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/user");

    }
    @Test(priority = 6)
    public void historyDelete (ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/user/historydelete?enotebookid=YEV201905000008";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").body("{\n" +
                        "  \"enotebookid\": \"YEV201905000008\"\n" +
                        "}").
                        when().
                        post(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        Assert.assertEquals(statusCode, 200, "Status code returned was false !");
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line returned was false !");

        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/user/historydelete?enotebookid=YEV201905000008");
    }

    @Test(priority = 1)
    public void sendXmlinZip(ITestContext context){

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/user/sendxmlinzip/";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token")).contentType("multipart/form-data")
                .multiPart("files",new File("C:\\Users\\ozdileto\\Desktop\\gelen fatura_3_hata.zip")).
                        multiPart("files",new File("C:\\Users\\ozdileto\\Desktop\\E-Defteri.xml")).
                        multiPart("ebillid","UYM2019000056684").
                        multiPart("invoicetype","SATIS").
                        multiPart("chosenbilltype","Gider Faturası").
                        multiPart("gelengiden","gelen").body("").
                        when().
                        post(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        Assert.assertEquals(statusCode, 200, "Status code returned was false !");
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/user/admindebug");

    }

    @Test(priority = 3)
    public void getComparisonOverview (ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/user/get_comparison_overview";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").
                        when().
                        get(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        Assert.assertEquals(statusCode, 200, "Status code returned was false !");
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Status line returned was false !");

        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/user/get_comparison_overview");
    }

    @Test(priority = 2)
    public void getSpecificComparison(ITestContext context){

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        String endpoint = "/user/get_specific_comparison";
        Response r = given()
                .header("Authorization", "Bearer " + context.getAttribute("access_token"))
                .contentType("application/json").body("{\n" +
                        "  \"enotebookid\": \"YEV201905000008\"\n" +
                        "}").
                        when().
                        post(endpoint);

        String body = r.getBody().asString();
        int statusCode = r.getStatusCode();
        String statusLine = r.getStatusLine();

        System.out.println(statusCode);
        System.out.println(statusLine);
        System.out.println(body);

        Assert.assertEquals(statusCode , 200, "Status code returned was false !");
        Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Status line returned was false !");
        Util.getResponseTime("https://muhasebe-denetleme-backend.herokuapp.com/user/get_specific_comparison");
    }

}
