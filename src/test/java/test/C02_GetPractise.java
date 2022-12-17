package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetPractise {
    /*
        https://restful-booker.herokuapp.com/booking/1 url’ine bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        oldugunu test edin
     */

    @Test
    public void get01() {
        // 1- Request için URL ve Body hazırla
        String url = "https://restful-booker.herokuapp.com/booking/860";

        // 2- Expected Datayi hazırla


        // 3- Reponse'u kaydet
        Response response = given()
                            .when()
                            .get(url);

        response.prettyPrint();

        // 4- Assertion
        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "Cowboy")
                .statusLine("HTTP/1.1 200 OK");


    }

}
