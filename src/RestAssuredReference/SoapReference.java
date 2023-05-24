package RestAssuredReference;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import static io.restassured.RestAssured.given;
import org.testng.Assert;
public class SoapReference {

	public static void main(String[] args) {
		String BaseURI="https://www.dataaccess.com";
		String requestBody="<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <NumberToWords xmlns=\"http://www.dataaccess.com/webservicesserver/\">\r\n"
				+ "      <ubiNum>100</ubiNum>\r\n"
				+ "    </NumberToWords>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>\r\n"
				+ "";
		//step 2 :- fetch request paramters
		XmlPath xml_req=new XmlPath(requestBody);
		String req_result=xml_req.getString("ubiNum");
		System.out.println(req_result);
		//step 3 configure the api and fetch response Body
		RestAssured.baseURI=BaseURI;
		String responseBody=given().header("Content-Type","application/xml").body(requestBody).when().post("/webservicesserver/NumberConversion.wso")
		.then().extract().response().getBody().asString();
		System.out.println(responseBody);
		//parse the response body and fetch the response parameters
		XmlPath xml_res=new XmlPath(responseBody);
		String res_result=xml_res.getString("NumbertoWordsResult");
		System.out.println(res_result);
		//validate response body paramters
		Assert.assertEquals(res_result,"six hundred ");
	}

}
