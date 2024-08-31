package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    /*
   http://dummy.restapiexample.com/api/v1/employee/3 url'ine
   bir GET request gonderdigimizde donen response'un asagidaki gibi oldugunu test edin.

       {
           "status":"success",
           "data":{
                     "id": 12,
                     "employee_name": "Quinn Flynn",
                     "employee_salary": 342000,
                     "employee_age": 22,
                     "profile_image": ""
                   },
           "message":"Successfully! Record has been fetched."
       }
*/
    @Test
    public void test(){

        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        JSONObject innerData=new JSONObject();
        innerData.put("id",12);
        innerData.put("employee_name","Quinn Flynn");
        innerData.put("employee_salary",342000);
        innerData.put("employee_age",22);
        innerData.put( "profile_image","");

        JSONObject expData=new JSONObject();
        expData.put("status","success");
        expData.put("data",innerData);
        expData.put("message","Successfully! Record has been fetched.");

        Response response=given().when().get(url);

        JsonPath resJP=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(resJP.get("status"),expData.get("status"));
        softAssert.assertEquals(resJP.get("message"),expData.get("message"));
        softAssert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("id"));
        softAssert.assertEquals(resJP.get("data.employee_name"),expData.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(resJP.get("data.employee_salary"),expData.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(resJP.get("data.employee_age"),expData.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(resJP.get("data.profile_image"),expData.getJSONObject("data").get("profile_image"));
        softAssert.assertAll();






    }

}
