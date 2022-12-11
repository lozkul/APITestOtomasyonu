package test;

import baseURL.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.PojoJsonPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Put_PojoClass extends JsonPlaceHolderBaseURL {
    /*
    C27_Put_PojoClass
 https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in
 response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void put01(){

        // 1- Request icin gerekli URL ve Body olustur
        specJsonPlace.pathParams("pp1", "posts", "pp2", 70);
        //Request body icin Pojo class olusturduk:
        PojoJsonPlace reqBody= new PojoJsonPlace("Ahmet", "Merhaba",10, 70);
        System.out.println("reqBody = " + reqBody);

        // 2- Expected Data Olustur
        PojoJsonPlace expBody= new PojoJsonPlace("Ahmet", "Merhaba",10, 70);
        System.out.println("expBody = " + expBody);

        // 3- Responsei kaydet
        Response response = given().
                                spec(specJsonPlace).
                                contentType(ContentType.JSON).
                            when().
                                body(reqBody).
                                put("/{pp1}/{pp2}");
        response.prettyPrint();

        // 4- Assertion
        PojoJsonPlace respPojo = response.as(PojoJsonPlace.class);
        System.out.println("respPojo = " + respPojo);

        assertEquals(expBody.getBody(), respPojo.getBody());
        assertEquals(expBody.getTitle(), respPojo.getTitle());
        assertEquals(expBody.getUserId(), respPojo.getUserId());
        assertEquals(expBody.getId(), respPojo.getId());


    }


}
