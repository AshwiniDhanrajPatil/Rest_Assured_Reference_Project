package RestAssuredReference;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Delete_Reference {

	public static void main(String[] args) {

		RestAssured.baseURI="https://reqres.in/";
		int statuscode=given().header("Content-Type","application/json").body("").log().all().when().delete("/api/users/2").then().extract().statusCode();
		String responseBody=given().header("Content-Type","application/json").body("").log().all().when().delete("/api/users/2").then().log().all().extract().response().asString();
		System.out.println(responseBody);
		System.out.println(statuscode);

	}

}
