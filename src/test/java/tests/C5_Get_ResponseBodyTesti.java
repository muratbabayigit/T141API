package tests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C5_Get_ResponseBodyTesti {

    /*
        https://jsonplaceholder.typicode.com/posts/44 url'ine bir GET request yolladigimizda
            donen Response’in
             status code'unun 200,
             ve content type'inin application/json; charset=utf-8,
             ve response body'sinde bulunan userId'nin 5,
             ve response body'sinde bulunan title'in "optio dolor molestias sit"
            oldugunu test edin.
     */
    @Test
    public void test() {

        //1-Endpoint hazırlanır
        String url = "https://jsonplaceholder.typicode.com/posts/44";

        //2-Verilmişse ExpectedData hazırlanır

        //3-Response kaydedilir
        Response response = given().when().get(url);

        //4-Assertion işlemi yapılır
        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("title", Matchers.equalTo("optio dolor molestias sit"))
                .body("userId", equalTo(5));
    }
}
