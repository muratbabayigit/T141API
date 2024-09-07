package tests;

import baseUrl.SpecHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import testDatas.HerOkuAppData;

import static io.restassured.RestAssured.given;

public class P27_TokenKullanimi extends SpecHerokuApp {
static String token;
    /*
    https://restful-booker.herokuapp.com/booking/2130 (id güncellenmeli)
    adresindeki rezervasyon bilgilerini
        -H 'Content-Type: application/json' \
        -H 'Accept: application/json' \
        -H 'Cookie: token=abc123' \ veya -H 'Authorization:Basic YWRtaW46cGFzc3dvcmQxMjM=' \
        header değerleriyle PUT request göndererek update ediniz.

        Token Oluşturma
        https://restful-booker.herokuapp.com/auth
        Content-Type: application/json header derğeriyle aşağıdaki body ile POST Request yapalım
        {
                "username" : "admin",
                "password" : "password123"
        }
        Post Request yapınız

 */
    @Test
    public void test01(){
        specHerOkuApp.pathParam("pp1","auth");

        JSONObject data=new JSONObject();
        data.put("username","admin");
        data.put("password","password123");

        Response response= given().spec(specHerOkuApp).contentType(ContentType.JSON)
                                  .when().body(data.toString())
                                  .header("Content-Type","application/json").post("/{pp1}");

        response.prettyPrint();
        JsonPath resJP=response.jsonPath();
        token=resJP.getString("token");
    }

    @Test
    public void test02(){
        specHerOkuApp.pathParams("pp1","booking","pp2","1253");
        JSONObject reqBody=HerOkuAppData.reqDataOlustur();
        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON)
                                 .when().body(reqBody.toString())
                                 .header("Content-Type","application/json")
                                 .header("Accept","application/json")
                                 .header("Cookie","token="+token)
                                 .put("/{pp1}/{pp2}");

        response.prettyPrint();

    }

    @Test
    public void test03(){
        specHerOkuApp.pathParams("pp1","booking","pp2","2504");
        JSONObject reqBody=HerOkuAppData.reqDataOlustur();
        Response response=given().spec(specHerOkuApp).contentType(ContentType.JSON)
                .when().body(reqBody.toString())
                .header("Content-Type","application/json")
                .header("Accept","application/json")
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .put("/{pp1}/{pp2}");

        response.prettyPrint();

    }

    }


