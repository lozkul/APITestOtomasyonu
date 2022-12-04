package test;

import baseURL.DummyBaseURL;
import org.junit.Test;
import testData.TestDataDummy;

import java.util.HashMap;

public class C23_Get_DeSerialization extends DummyBaseURL {
     /*
http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
request gonderdigimizde donen response’un status code’unun 200,
content Type’inin application/json ve body’sinin asagidaki gibi oldugunu test edin.
    Response Body
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

    @Test
    public void get01(){
        // 1- Request Data hazirla
        specDummy.pathParams("pp1", "employee", "pp2", 3);

        // 2- Expected Data hazirla

        TestDataDummy testDataDummy= new TestDataDummy();

        HashMap<String, Object> expDataMap= testDataDummy.expectedDataOlusturMap();

        System.out.println(expDataMap);

    }


}
