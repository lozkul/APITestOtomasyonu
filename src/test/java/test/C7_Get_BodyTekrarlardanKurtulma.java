package test;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C7_Get_BodyTekrarlardanKurtulma {
    /*
                https://restful-booker.herokuapp.com/booking/14018 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"James",
                    ve "lastname“in, "Brown",
                    ve "totalprice“in,111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"Breakfast"
                oldugunu test edin
         */

    @Test
    public void get01(){
        // 1- Request için URL ve Body hazırla (bu soruda body testi yok)
        String url = "https://restful-booker.herokuapp.com/booking/14018";


        // 2- Expected Datayi hazırla


        // 3- Reponse'u kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion
        /* bu kısım asıl yöntem. aşağıda kısaltma var
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", equalTo("James")).
                body("lastname", equalTo("Brown")).
                body("totalprice", equalTo(111)).
                body("depositpaid", equalTo(true)).
                body("additionalneeds", equalTo("Breakfast"));
*/


        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("firstname", equalTo("James"),
                "lastname", equalTo("Brown"),
                "totalprice", equalTo(111),
                "depositpaid", equalTo(true),
                "additionalneeds", equalTo("Breakfast"));

    }



}
