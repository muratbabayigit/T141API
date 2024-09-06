package testDatas;

import java.util.HashMap;
import java.util.Map;

public class DummyData {
    public static int basariliSC=200;
    public static String contentType="application/json";

    public static Map<String,Object> mapBodyOlustur(){
/*
            {
             "status":"success",
             "data":{
                     "id":3,
                     "employee_name":"Ashton Cox",
                     "employee_salary":86000,
                     "employee_age":66,
                     "profile_image":""
                     },
             "message":"Successfully! Record has been fetched."
        }
 */
        Map<String,Object> data=new HashMap<>();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        Map<String,Object> mapData=new HashMap<>();
        mapData.put("status","success");
        mapData.put( "data",data);
        mapData.put("message","Successfully! Record has been fetched.");

        return mapData;
    }
}
