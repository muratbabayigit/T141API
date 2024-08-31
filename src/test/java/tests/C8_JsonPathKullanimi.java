package tests;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C8_JsonPathKullanimi {
    /*
    {
    "firstName": "John",
    "lastName": "doe",
    "age": 26,
    "address": {
        "streetAddress": "naist street",
        "city": "Nara",
        "postalCode": "630-0192"
                },
    "phoneNumbers": [
                    {
                        "type": "iPhone",
                        "number": "0123-4567-8888"
                    },
                    {
                        "type": "home",
                        "number": "0123-4567-8910"
                    }
                    ]
    }


     */

    @Test
    public void test() {
        JSONObject homeTel=new JSONObject();
        homeTel.put("type", "home");
        homeTel.put("number","0123-4567-8910");

        JSONObject iPhoneTel=new JSONObject();
        iPhoneTel.put("type", "iPhone");
        iPhoneTel.put("number","0123-4567-8888");

        JSONArray phoneNumbers=new JSONArray();
        phoneNumbers.put(0,iPhoneTel);
        phoneNumbers.put(1,homeTel);

        JSONObject address=new JSONObject();
        address.put("streetAddress", "naist street");
        address.put("city","Nara");
        address.put("postalCode","630-0192");



        JSONObject person=new JSONObject();
        person.put("firstName","John");
        person.put("lastName", "doe");
        person.put("age",26);
        person.put("address",address);
        person.put("phoneNumbers",phoneNumbers);

        System.out.println("Adı :"+person.get("firstName")+"\nSoyadı :"+person.get("lastName")+"\nYaşı :"+person.get("age"));
        System.out.println("Telefon Numarası :\n\t\t\t\t\t"+person.getJSONArray("phoneNumbers").getJSONObject(0).get("type")+" : "
                                               +person.getJSONArray("phoneNumbers").getJSONObject(0).get("number")+"\n\t\t\t\t\t"+
                                               person.getJSONArray("phoneNumbers").getJSONObject(1).get("type")+" : "
                                              +person.getJSONArray("phoneNumbers").getJSONObject(1).get("number"));

        System.out.println("Adres:\n\t\t\t\t\t"+person.getJSONObject("address").get("streetAddress")+"\n\t\t\t\t\t"+
                                                person.getJSONObject("address").get("city")+"\n\t\t\t\t\t"+
                                                person.getJSONObject("address").get("postalCode"));


    }
}
