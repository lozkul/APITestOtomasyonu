package test;

import baseURL.HerokuAppBaseURL;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PojoHerokuappBooking;
import pojos.PojoHerokuappBookingDates;
import pojos.PojoHerokuappExpectedBody;
import pojos.PojoJsonPlace;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Post_Pojo extends HerokuAppBaseURL {

/*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body
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
                        ,
                        "additionalneeds":"wi-fi"
                    }

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
         */
    @Test
    public void post01() {
        // 1- Request icin gerekli URL ve pojo class olustur
        specHerokuApp.pathParam("pp1", "booking");
        //Request body icin Pojo class olusturduk:
        PojoHerokuappBookingDates pojoHerokuappBookingDates= new PojoHerokuappBookingDates("2021-06-01", "2021-06-10");
        PojoHerokuappBooking reqBody = new PojoHerokuappBooking("Ahmet", "Bulut", 500, false, pojoHerokuappBookingDates, "wi-fi");

        // 2- Expected Data Olustur
        PojoHerokuappExpectedBody expectedBody = new PojoHerokuappExpectedBody(24, reqBody);

        // 3- Responsei kaydet
        Response response = given().
                                spec(specHerokuApp).
                                contentType(ContentType.JSON).
                            when().
                                body(reqBody).
                                post("/{pp1}");
        response.prettyPrint();

        // 4- Assertion
        PojoHerokuappExpectedBody respPojo = response.as(PojoHerokuappExpectedBody.class);
        System.out.println("respPojo = " + respPojo);

        assertEquals(expectedBody.getBooking().getFirstname(), respPojo.getBooking().getFirstname());
        assertEquals(expectedBody.getBooking().getLastname(), respPojo.getBooking().getLastname());
        assertEquals(expectedBody.getBooking().getTotalprice(), respPojo.getBooking().getTotalprice());
        assertEquals(expectedBody.getBooking().isDepositpaid(), respPojo.getBooking().isDepositpaid());
        assertEquals(expectedBody.getBooking().getBookingdates().getCheckin(), respPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedBody.getBooking().getBookingdates().getCheckout(), respPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedBody.getBooking().getAdditionalneeds(), respPojo.getBooking().getAdditionalneeds());



    }



}
