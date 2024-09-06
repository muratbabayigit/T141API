package tests;

import baseUrl.SpecJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PojoJPH;
import testDatas.JsonPlaceData;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C25_PojoClassPUT extends SpecJsonPlaceHolder {
    /*
   https://jsonplaceholder.typicode.com/posts/70 url'ine
   asagidaki body'e sahip bir PUT request yolladigimizda
   donen response'in
   status kodunun 200,
   content type'inin "application/json; charset=utf-8",
   Connection header degerinin "keep-alive"
   ve response body'sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
       {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }
   Response body : // expected data
       {
       "title":"Ahmet",
       "body":"Merhaba",
       "userId":10,
       "id":70
       }
*/
    @Test
    public void test01(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        PojoJPH reqBody=new PojoJPH("Ahmet","Merhaba",10,70);

        PojoJPH expBody=new PojoJPH("Ahmet","Merhaba",10,70);

        Response response=given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                                                            .when().body(reqBody).put("/{pp1}/{pp2}");

        PojoJPH resPOJO=response.as(PojoJPH.class);

      assertEquals(JsonPlaceData.basariliSC,response.getStatusCode());
      assertEquals(JsonPlaceData.contentType,response.getContentType());
      assertEquals(JsonPlaceData.header,response.getHeader("Connection"));
      assertEquals(expBody.getTitle(),resPOJO.getTitle());
      assertEquals(expBody.getBody(),resPOJO.getBody());
      assertEquals(expBody.getUserId(),resPOJO.getUserId());
      assertEquals(expBody.getId(),resPOJO.getId());

    }
}
