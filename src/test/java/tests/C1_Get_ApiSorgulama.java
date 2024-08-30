package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C1_Get_ApiSorgulama {

    /*
    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
 	status code’unun 200,
	ve content type’inin application/json; charset=utf-8,
	ve Server isimli Header’in degerinin Cowboy,
	ve status Line’in HTTP/1.1 200 OK
	ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
     */

    /*
        1- Endpoint hazırlama( Request Body verilirse o da burada hazırlanır)
        2- Eğer verilmişse Expected Body hazırlanır( verilmemişse bu adımda bir işlem yapılmaz)
        3- Donen Response kayıt altına alınır
        4- Donen Response ile beklenen body assert edilir.
     */
        @Test
            public void test1() {
            // 1- Endpoint hazırlama( Request Body verilirse o da burada hazırlanır)
            String url = "https://restful-booker.herokuapp.com/booking/10";

            // 2- Beklenen bir data olmadığı için expected body hazırlanmadı


            // 3- Dönen cevap kayıt altına alınır
            Response response = given().when().get(url);

            //4-Assertion İşlemlerine geçilir (Manuel isteniyor)

            System.out.println("Status Code: "+response.getStatusCode());
            System.out.println("Content Type: "+response.getContentType());
            System.out.println("Server: "+response.getHeader("Server"));
            System.out.println("Status Line: "+response.getStatusLine());
            System.out.println("Time: "+response.getTime());

            System.out.println("----------------------------------------------------");
         // System.out.println(response.prettyPrint());



        }


}
