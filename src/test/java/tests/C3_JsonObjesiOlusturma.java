package tests;

import org.json.JSONObject;
import org.junit.Test;

public class C3_JsonObjesiOlusturma {

    /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "firstname":"Jim",
        "lastname":"Brown",
        "bookingdates": {
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                         },
        "totalprice":111,
        "depositpaid":true,
        "additionalneeds":"Breakfast"
     }

     */

    //İç içe dataların olduğu verilerde ilk olarak en içteki data oluşturulur

        @Test
        public void dataCreate(){
            JSONObject innerData=new JSONObject();
            innerData.put("checkin","2018-01-01");
            innerData.put("checkout","2019-01-01");

            JSONObject data=new JSONObject();
            data.put("firstname","Jim");
            data.put("lastname","Brown");
            data.put( "bookingdates",innerData);
            data.put("totalprice",111);
            data.put("depositpaid",true);
            data.put("additionalneeds","Breakfast");

            System.out.println(data);




        }
}
