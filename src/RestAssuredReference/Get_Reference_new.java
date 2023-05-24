
package RestAssuredReference;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

import java.util.ArrayList;

import org.json.JSONObject;

import org.testng.Assert;
public class Get_Reference_new
{

	public static void main(String[] args) 
	{
		
		RestAssured.baseURI="https://reqres.in/";
		int statuscode=given().header("Content-Type","application/json").when().get("/api/users?page=2").then().extract().statusCode();
		String responseBody=given().header("Content-Type","application/json").when().get("/api/users?page=2").then().extract().response().getBody().prettyPrint();
		JSONObject getrequest=new JSONObject(responseBody);
        ArrayList<String> indlist=new ArrayList<String>();
        int count=getrequest.length();
		for(int i=0;i<count;i++)
        {
			JSONObject body=getrequest.getJSONArray("data").getJSONObject(i);
			
			//validate email
			String email=body.getString("email");
			Assert.assertNotNull(email);
			indlist.add(i,email);
			System.out.println(indlist.get(i));
			Assert.assertNotNull(indlist.get(i));
			
			String first_name=body.getString("first_name");
			Assert.assertNotNull(first_name);
			indlist.add(i,first_name);
			System.out.println(indlist.get(i));
			Assert.assertNotNull(indlist.get(i));
			String last_name=body.getString("last_name");
			Assert.assertNotNull(last_name);
			indlist.add(i,last_name);
			System.out.println(indlist.get(i));
			Assert.assertNotNull(indlist.get(i));

			String avatar=body.getString("avatar");
			Assert.assertNotNull(avatar);
			indlist.add(i,avatar);
			System.out.println(indlist.get(i));
			Assert.assertNotNull(indlist.get(i));
        
        
         }			
	}

}





