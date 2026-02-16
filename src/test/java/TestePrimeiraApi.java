import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestePrimeiraApi {

    @Test
    public void Exercicio1_testeComSucessoPrimeiraApi(){

        String url = "http://localhost:8080/api/primeiraApi";

        RestAssured.given()
                        .log().all()
                .when()
                        .get(url)
                .then()
                        .log().all()
                        .assertThat()
                        .statusCode(200)
                .body(Matchers.containsString("Retorno da api com sucesso!!!"));

                //.body(containsString("Retorno da api com sucesso!!!"));
                //.body(equalTo("Retorno da api com sucesso!!!"));
                //.body(Matchers.containsString("Retorno da api com sucesso!!!2"));
                //.toString().contains("Retorno da api com sucesso!!!");

    }
@Test
    public void Exercicio3_testePathParamPrimeiraApiV2(){

        String textPathParam = "Teste Samuel PathParam";
        String url = "http://localhost:8080/api/primeiraApiV2/"+textPathParam;

        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(textPathParam));

    }
}
