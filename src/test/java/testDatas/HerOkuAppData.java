package testDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppData {
        /*
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
         */

    public static JSONObject reqDataOlustur(){
        JSONObject innerData=new JSONObject();
        innerData.put("checkin","2021-06-01");
        innerData.put("checkout","2021-06-10");

        JSONObject reqData=new JSONObject();
        reqData.put ("firstname","Ahmet");
        reqData.put("lastname","Bulut");
        reqData.put("totalprice",500);
        reqData.put("depositpaid",false);
        reqData.put("bookingdates",innerData);
        reqData.put("additionalneeds","wi-fi");


    return reqData;
    }

    public static Map<String, Object> reqDataOlsuturMAP(){
        Map<String, Object> innerMAP=new HashMap<>();
        innerMAP.put("checkin","2021-06-01");
        innerMAP.put("checkout","2021-06-10");

        Map<String, Object> reqMAP=new HashMap<>();
        reqMAP.put ("firstname","Ahmet");
        reqMAP.put("lastname","Bulut");
        reqMAP.put("totalprice",500);
        reqMAP.put("depositpaid",false);
        reqMAP.put("bookingdates",innerMAP);
        reqMAP.put("additionalneeds","wi-fi");

        return reqMAP;
    }

    /*
    Expected response body
                        {
                         "bookingid":24,
                         "booking":{
                            "firstname":"Ahmet",
                            "lastname":"Bulut",
                            "totalprice":500,
                            "depositpaid":false,
                            "bookingdates":{
                                    "checkin":"2021-06-01",
                                    "checkout":"2021-06-10"
                                            },
                            "additionalneeds":"wi-fi"
                                    }
     */

    public static JSONObject expDataOlustur(){
        JSONObject expData=new JSONObject();
        expData.put("bookingid",24);
        //JSONObject booking=reqDataOlustur();
        expData.put("booking",reqDataOlustur());
        return expData;
    }

    public static Map<String, Object> expMapDataOlustur(){
        Map<String, Object> expMap=new HashMap<>();
        expMap.put("bookingid",24);
        expMap.put("booking",reqDataOlsuturMAP());
        return expMap;
    }



}
