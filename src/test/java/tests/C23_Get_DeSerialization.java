package tests;

import baseUrl.SpecDummy;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import testDatas.DummyData;

import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class C23_Get_DeSerialization extends SpecDummy {
    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url'ine
    bir GET request gonderdigimizde
    donen response'un status code'unun 200,
    content Type'inin application/json
    ve body'sinin asagidaki gibi oldugunu test edin.
          Response Body---> Expected Data
         {
             "status":"success",
             "data":{
                     "id":3,
                     "employee_name":"Ashton Cox",
                     "employee_salary":86000,
                     "employee_age":66
                     "profile_image":""
                     },
             "message":"Successfully! Record has been fetched."
        }
 */
        @Test
        public void test(){
            specDummy.pathParams("pp1","employee","pp2","3");

            Map<String,Object> expBodyMAP=DummyData.mapBodyOlustur();

            Response response=given().spec(specDummy).when().get("/{pp1}/{pp2}");

            Map<String, Object> resMAP=response.as(HashMap.class);

            assertEquals(DummyData.contentType,response.getContentType());
            assertEquals(DummyData.basariliSC,response.getStatusCode());
            assertEquals(expBodyMAP.get("status"),resMAP.get("status"));
            assertEquals(expBodyMAP.get("message"),resMAP.get("message"));


          assertEquals(((Map)expBodyMAP.get("data")).get("id"), ((Map)resMAP.get("data")).get("id"));
          assertEquals(((Map)expBodyMAP.get("data")).get("employee_name"),((Map)resMAP.get("data")).get("employee_name"));
          assertEquals(((Map)expBodyMAP.get("data")).get("employee_salary"),((Map)resMAP.get("data")).get("employee_salary"));
          assertEquals(((Map)expBodyMAP.get("data")).get("employee_age"),((Map)resMAP.get("data")).get("employee_age"));
          assertEquals(((Map)expBodyMAP.get("data")).get("profile_image"),((Map)resMAP.get("data")).get("profile_image"));








        }
}
