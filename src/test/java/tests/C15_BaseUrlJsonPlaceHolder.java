package tests;

import baseUrl.SpecJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlJsonPlaceHolder extends SpecJsonPlaceHolder {
    /*
        Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin
        1- https://jsonplaceholder.typicode.com/posts endpointine bir GET request gonderdigimizde donen response’un
         status code’unun 200 oldugunu ve Response’ta 100 kayit oldugunu test edin
        2- https://jsonplaceholder.typicode.com/posts/44 endpointine bir GET request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve “title” degerinin “optio dolor molestias sit” oldugunu test edin
        3- https://jsonplaceholder.typicode.com/posts/50 endpointine bir DELETE request gonderdigimizde donen response’un
        status code’unun 200 oldugunu ve response body’sinin null oldugunu test edin

     */
    @Test
    public void test01(){

        // 1- Endpoint hazırlama( Request Body verilirse o da burada hazırlanır)
            specJsonPlaceHolder.pathParam("pp1","posts");
        // 2- Eğer verilmişse Expected Body hazırlanır( verilmemişse bu adımda bir işlem yapılmaz)

        // 3- Donen Response kayıt altına alınır
          Response response=given().when().spec(specJsonPlaceHolder).get("/{pp1}");

        // 4- Donen Response ile beklenen body assert edilir.
         response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasSize(100));
    }

    @Test
    public void test02(){

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);

        Response response=given().when().spec(specJsonPlaceHolder).get("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

    @Test
    public void test03(){
        specJsonPlaceHolder.pathParams("pp1","posts","pp2",50);

        Response response=given().when().spec(specJsonPlaceHolder).delete("/{pp1}/{pp2}");
        response.then().assertThat().statusCode(200).body("title",Matchers.nullValue());
    }
}
