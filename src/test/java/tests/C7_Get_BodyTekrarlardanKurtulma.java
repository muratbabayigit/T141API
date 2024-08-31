package tests;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class C7_Get_BodyTekrarlardanKurtulma {
    /*
        https://restful-booker.herokuapp.com/booking/10 url’ine
             bir GET request gonderdigimizde donen Response’un,
             status code’unun 200,
             ve content type’inin application/json,
             ve response body’sindeki
                    "firstname“in, "Mary",
                 ve "lastname“in, "Jones",
                 ve "totalprice“in, 833,
                 ve "depositpaid“in, false,
                 ve "additionalneeds“in,
            oldugunu test edin
     */
    @Test
    public void test(){
        String url="https://restful-booker.herokuapp.com/booking/10";

        Response response=given().when().get(url);
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("firstname", equalTo("Mary"),
                        "lastname",equalTo("Jones"),
                        "totalprice",equalTo(367),
                        "depositpaid",equalTo(false),
                        "additionalneeds",equalTo(null));


    }
}
