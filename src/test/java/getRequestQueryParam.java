import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;

public class getRequestQueryParam
{ //https://reqres.in/api/users?page=2
    public static void main(String[] args) {
        RestAssured.baseURI="https://reqres.in/api/users";
        RequestSpecification requestSpecification= RestAssured.given();
        requestSpecification.queryParam("page","2");
        Response response =requestSpecification.get();
        response.prettyPrint();
        //assertion on response body parameter :first email
        JsonPath path = response.jsonPath();
        String fisrtEmail = path.getString("data[0].email");
        System.out.println(fisrtEmail);
        Assert.assertTrue(fisrtEmail.contains("@regres.in"));


    }

}
