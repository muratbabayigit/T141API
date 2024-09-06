package testDatas;

import org.json.JSONObject;

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
}
