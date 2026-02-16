import io.restassured.RestAssured;
import org.junit.Test;
import org.hamcrest.Matchers;
public class TestePrimeiraApiV1 {

    @Test
    public void Exercicio2_testeComSucessoPrimeiraApiv1(){

        String url = "http://localhost:8080/api/primeiraApiV1";
        String textQueryParam = "Teste-ss";

        RestAssured.given()
                .queryParam("palavra",textQueryParam)
                    .log().all()
                .when()
                .get(url)
                .then()
                    .log().all()
                    .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(textQueryParam));



    }


}
