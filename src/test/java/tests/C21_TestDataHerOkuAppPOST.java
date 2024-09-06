package tests;

import baseUrl.SpecHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.HerOkuAppData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C21_TestDataHerOkuAppPOST extends SpecHerokuApp {
    /*
                https://restful-booker.herokuapp.com/booking url’ine
                asagidaki body'ye sahip bir POST request gonderdigimizde
                donen response’un bookingid haric asagidaki gibi oldugunu test edin.
                Request body
                       {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                "checkin" : "2021-06-01",
                                "checkout" : "2021-06-10"
                                },
                        "additionalneeds" : "wi-fi"
                        }
               Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
                          }
         */

    @Test
    public void test(){
        specHerOkuApp.pathParam("pp1","booking");
        JSONObject reqBody= HerOkuAppData.reqDataOlustur();

        JSONObject expBody=HerOkuAppData.expDataOlustur();

        Response response=given().contentType(ContentType.JSON).when()
                .spec(specHerOkuApp).body(reqBody.toString()).post("/{pp1}");

        JsonPath respJP=response.jsonPath();

       assertEquals(expBody.getJSONObject("booking").get("firstname"),respJP.get("booking.firstname"));
       assertEquals(expBody.getJSONObject("booking").get("lastname"),respJP.get("booking.lastname"));
       assertEquals(expBody.getJSONObject("booking").get("totalprice"),respJP.get("booking.totalprice"));
       assertEquals(expBody.getJSONObject("booking").get("depositpaid"),respJP.get("booking.depositpaid"));
       assertEquals(expBody.getJSONObject("booking").get("additionalneeds"),respJP.get("booking.additionalneeds"));
       assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),respJP.get("booking.bookingdates.checkin"));
       assertEquals(expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),respJP.get("booking.bookingdates.checkout"));






    }
}
