package tests;

import baseUrl.SpecHerokuApp;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlHerokuappQueryParam extends SpecHerokuApp {

    /*
    https://restful-booker.herokuapp.com/booking endpointine
    gerekli Query parametrelerini yazarak “firstname” degeri “Jim” olan
    rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
    donen response’un status code’unun 200 oldugunu ve
    “Jim” ismine sahip en az bir booking oldugunu test edin
     */

    @Test
    public void test01(){

        specHerOkuApp.pathParam("pp1","booking").queryParam("firstname","Jim");

        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");

        response.then().assertThat().statusCode(200).body("size()", Matchers.greaterThan(0));


    }

    @Test
    public void test(){
   /*
        https://restful-booker.herokuapp.com/booking endpointine
        gerekli Query parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson” olan
        rezervasyon oldugunu test edecek bir GET request gonderdigimizde,
        donen response’un status code’unun 200 oldugunu ve “Josh Allen”
        ismine sahip en az bir booking oldugunu test edin
    */

        specHerOkuApp.pathParam("pp1","booking").queryParams("firstname","Josh","lastname","Allen");
       //  https://restful-booker.herokuapp.com/booking?firstname=Josh&lastname=Allen
        Response response=given().when().spec(specHerOkuApp).get("/{pp1}");


        response.then().assertThat().statusCode(200).body("size()",Matchers.greaterThan(0));

    }
}
