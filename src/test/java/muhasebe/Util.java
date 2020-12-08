package muhasebe;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.ITestContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.*;


public class Util {

    static Random random = new Random();
    static int random_id = random.nextInt(1000);
    static String randomid1 = String.valueOf(random_id);

    public static void register(ITestContext context) {

        RestAssured.baseURI = "https://muhasebe-denetleme-backend.herokuapp.com";
        Response r = given()
                .contentType("application/json").

                        body("{\"id\":\""+Util.random_id+"\"," +
                                " \"name\":\"rasim1234\"," +
                                "\"email\":\"rasim.avci3@gmail.com\"," +
                                "\"company\":\"ronwell\"," +
                                "\"phonenumber\":\"string\"," +
                                "\"address\":\"myaddress\"," +
                                "\"lastlogin\":\""+getCurrentDate()+"\"," +
                                "\"activeuntil\":\""+getCurrentDate()+"\"," +
                                "\"password\":\"1234\"}").
                        when().
                        post("/register");

        String body = r.getBody().asString();

        System.out.println(body);

        JsonPath jsonPathEvaluator = r.jsonPath();
        String access_token = jsonPathEvaluator.get("access_token");
        Values.setMytoken(access_token);
        System.out.println("token: " + access_token);
        context.setAttribute("access_token", access_token);
    }

    public static <url> void getResponseTime(String url){
        System.out.println("The time taken to fetch the response "+get(url)
                .timeIn(TimeUnit.MILLISECONDS) + " milliseconds");
    }
    public static String getCurrentDate(){

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return (date.format(formatter));

    }

}
