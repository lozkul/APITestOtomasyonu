package test;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
public class C08_JSONPathKullanimi {
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
    public void jsonPath01() throws JSONException {
        JSONObject kisiBilgisi = new JSONObject();
        JSONObject adresBilgisi = new JSONObject();
        JSONObject cepTelBilgisi = new JSONObject();
        JSONObject evTelBilgisi = new JSONObject();
        JSONArray telBilgileri = new JSONArray();

        kisiBilgisi.put("firstName","John");
        kisiBilgisi.put("lastName","doe");
        kisiBilgisi.put("age",26);
        kisiBilgisi.put("address",adresBilgisi);
        kisiBilgisi.put("phoneNumbers",telBilgileri);

        adresBilgisi.put("streetAddress","naist street");
        adresBilgisi.put("city","Nara");
        adresBilgisi.put("postalCode","630-0192");

        cepTelBilgisi.put("type","iPhone");
        cepTelBilgisi.put("number","0123-4567-8888");

        evTelBilgisi.put("type","home");
        evTelBilgisi.put("number","0123-4567-8910");

        telBilgileri.put(cepTelBilgisi);
        telBilgileri.put(evTelBilgisi);


        System.out.println(kisiBilgisi);
        System.out.println("Isim : " + kisiBilgisi.get("firstName"));
        System.out.println("Soyisim : " + kisiBilgisi.get("lastName"));
        System.out.println("Yas : " + kisiBilgisi.get("age"));
        System.out.println("Sehir : " + kisiBilgisi.getJSONObject("address").get("city"));
        System.out.println("Posta Kodu : " + kisiBilgisi.getJSONObject("address").get("postalCode"));
        System.out.println("Sokak adi : " + kisiBilgisi.getJSONObject("address").get("streetAddress"));
        System.out.println("Cep Tel : " + kisiBilgisi.getJSONArray("phoneNumbers").
                                                      getJSONObject(0).get("number"));
        /*
        {
        "firstName":"John",
        "lastName":"doe",
        "address":
                    {
                    "streetAddress":"naist street",
                    "city":"Nara",
                    "postalCode":"630-0192"
                    },
        "age":26,
        "phoneNumbers":
                    [
                        {
                            "number":"0123-4567-8888",
                            "type":"iPhone"
                        },
                        {
                            "number":"0123-4567-8910",
                            "type":"home"
                        }
                    ]
        }
         */
    }
}
