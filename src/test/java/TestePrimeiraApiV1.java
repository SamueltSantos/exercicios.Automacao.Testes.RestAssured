import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.hamcrest.Matchers;
public class TestePrimeiraApiV1 {

    String url = "http://localhost:8080/api";

    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(url).build();

    @Test
    public void Exercicio2_testeComSucessoPrimeiraApiv1(){

        String path = "/primeiraApiV1";
        String textQueryParam = "Teste-ss";

        RestAssured.given()
                .spec(requestSpecification)
                .queryParam("palavra",textQueryParam)
                    .log().all()
                .when()
                .get(path)
                .then()
                    .log().all()
                    .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(textQueryParam));

    }


}
