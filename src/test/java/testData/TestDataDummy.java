package testData;
import jdk.security.jarsigner.JarSigner;
import org.json.JSONObject;
public class TestDataDummy {


    public int statusCode = 200;
    public String contentDummyType = "application/json";

    public JSONObject innerDataJsonBodyOlustur (){

        JSONObject innerDataBodyJSON = new JSONObject();

        innerDataBodyJSON.put("id", 3);
        innerDataBodyJSON.put("employee_name","Ashton Cox");
        innerDataBodyJSON.put("employee_salary",86000);
        innerDataBodyJSON.put("employee_age", 66);
        innerDataBodyJSON.put("profile_image", "");

        return innerDataBodyJSON;
    }


    public JSONObject expectedDataBodyOlustur (){

        JSONObject expecDataJSON = new JSONObject();

        expecDataJSON.put("status", "success");
        expecDataJSON.put("data", innerDataJsonBodyOlustur());
        expecDataJSON.put("message","Successfully! Record has been fetched.");

        return expecDataJSON;
    }

}