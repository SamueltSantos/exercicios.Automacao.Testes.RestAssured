import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestePrimeiraApi {

    String url = "http://localhost:8080/api";

    RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri(url).build();//Montagem para reusar no .spec

    @Test
    public void Exercicio1_testeComSucessoPrimeiraApi(){

        String path = "/primeiraApi";

        RestAssured.given()
                .spec(requestSpecification)
                        .log().all()
                .when()
                        .get(path)
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
        String path = "/primeiraApiV2/"+textPathParam;

        RestAssured.given()
                .spec(requestSpecification)
                .log().all()
                .when()
                .get(path)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(textPathParam));

    }
}
