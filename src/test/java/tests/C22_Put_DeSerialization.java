package tests;

import baseUrl.SpecJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.JsonPlaceData;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class C22_Put_DeSerialization extends SpecJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine
    asagidaki body’e sahip bir PUT request yolladigimizda
    donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz

        Request Body

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }

     Response Body:

        {
            "title":"Ahmet",
            "body":"Merhaba",
            "userId":10,
            "id":70
        }
     */
    @Test
    public void test() {
        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        Map<String, Object> reqMapBody= JsonPlaceData.reqMapBodyOlustur();
        Map<String, Object> expMapBody= JsonPlaceData.reqMapBodyOlustur();

        Response response=given().contentType(ContentType.JSON).when()
                                                                .spec(specJsonPlaceHolder)
                                                                .body(reqMapBody).put("/{pp1}/{pp2}");

        Map<String, Object> respMap=response.as(HashMap.class);

        Assert.assertEquals(expMapBody.get("title"),respMap.get("title"));
        Assert.assertEquals(expMapBody.get("body"),respMap.get("body"));
        Assert.assertEquals(expMapBody.get("id"),respMap.get("id"));
        Assert.assertEquals(expMapBody.get("userId"),respMap.get("userId"));








    }

}
