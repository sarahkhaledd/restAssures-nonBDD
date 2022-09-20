import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;


public class postRequest {
    public static void main(String[] args) {
        RestAssured.baseURI="http://fakerestapi.azurewebsites.net/api/v1/Activities";
        RequestSpecification requestSpecification=RestAssured.given();
        requestSpecification.contentType("application/json");
        requestSpecification.body("{\"id\": 0,\"title\": \"string\",\"dueDate\": \"2022-09-20T19:35:11.214Z\",\"completed\": true}\n");
        //another way to put a body
        JSONObject object = new JSONObject();
        object.put("id",10);
        object.put("title","test");
        object.put("dueDate","2022-09-20T19:35:11.214Z");
        object.put("completed",true);
        requestSpecification.body(object.toJSONString());
        Response response =requestSpecification.get();
        response.prettyPrint();
    }
}
