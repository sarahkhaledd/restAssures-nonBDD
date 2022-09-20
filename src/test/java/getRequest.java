import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class getRequest {
    public static void main(String[] args) {
        RestAssured.baseURI="http://fakerestapi.azurewebsites.net/api/v1/Activities/1";
        RequestSpecification request = RestAssured.given();
        Response response =request.get();
        response.prettyPrint();

        //assertion on status code using non-BDD 'TestNG'
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
        //assertion on parameter inside JSONBody non-BDD
        JsonPath path = response.jsonPath();
        int id = path.getInt("id");
        Assert.assertEquals(id,1);

        //expected result BDD
         response.then().statusCode(200);
        //assertion on parameter inside JSONBody BDD
        response.then().body("id", Matchers.equalTo(1));
    }


}
