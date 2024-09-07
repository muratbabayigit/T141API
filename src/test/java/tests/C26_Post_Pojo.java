package tests;

import baseUrl.SpecHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.PojoHerOkuAppExp;
import pojos.PojoHerokuAppBookingdates;
import pojos.PojoHerokuAppReq;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C26_Post_Pojo extends SpecHerokuApp {
    /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ahmet",
    	                "lastname" : "Bulut",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body // expected data
    	            {
                        "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10",
                        "additionalneeds":"wi-fi"
                        }
                    }
     */
    @Test
    public void test(){
        // 1- EndPoint ve ReqBody Hazırla
        specHerOkuApp.pathParam("pp1","booking");
        PojoHerokuAppBookingdates bookingdatesPOJO=new PojoHerokuAppBookingdates("2021-06-01","2021-06-10");
        PojoHerokuAppReq reqBodyPOJO=new PojoHerokuAppReq("Ahmet","Bulut",500,false,"wi-fi",bookingdatesPOJO);

        // 2-Expected Body Hazırla
        PojoHerokuAppReq bookingPOJO=new PojoHerokuAppReq("Ahmet","Bulut",500,false,"wi-fi",bookingdatesPOJO);
        PojoHerOkuAppExp expBodyPOJO=new PojoHerOkuAppExp(24,bookingPOJO);

        // 3-Dönen cevap kayıt altına alınır
        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON).when().body(reqBodyPOJO).post("/{pp1}");

        // 4- Assertion işlemi yapılır
        PojoHerOkuAppExp resPOJO=response.as(PojoHerOkuAppExp.class);

        //assertEquals(resPOJO.getBookingid(),expBodyPOJO.getBookingid());
        assertEquals(resPOJO.getBooking().getFirstname(),expBodyPOJO.getBooking().getFirstname());
        assertEquals(resPOJO.getBooking().getLastname(),expBodyPOJO.getBooking().getLastname());
        assertEquals(resPOJO.getBooking().getTotalprice(),expBodyPOJO.getBooking().getTotalprice());
        assertEquals(resPOJO.getBooking().getAdditionalneeds(),expBodyPOJO.getBooking().getAdditionalneeds());
        assertEquals(resPOJO.getBooking().isDepositpaid(),expBodyPOJO.getBooking().isDepositpaid());
        assertEquals(resPOJO.getBooking().getBookingdates().getCheckin(),expBodyPOJO.getBooking().getBookingdates().getCheckin());
        assertEquals(resPOJO.getBooking().getBookingdates().getCheckout(),expBodyPOJO.getBooking().getBookingdates().getCheckout());











    }
}
