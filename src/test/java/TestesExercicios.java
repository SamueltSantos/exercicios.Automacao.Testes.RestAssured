import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestesExercicios {

    @Test
    public void Exercicio4_testeParOuImpar(){

        String url = "http://localhost:8080/exercicios/parOuImpar";
        int numero = 220;
        String msgResponseBody = "O numero 220 é par";

        RestAssured.given()
                .queryParam("numero",numero)
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                //.body(Matchers.containsString(msgResponseBody));
                .body(Matchers.equalTo(msgResponseBody));

    }

    @Test
    public void Exercicio5_testePathParamSalario(){

        String pathParamSalario = "2000";
        String url = "http://localhost:8080/exercicios/calculaSalario/"+pathParamSalario;

        RestAssured.given()
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString(pathParamSalario));

    }

    @Test
    public void Exercicio6_testeQueryValidaCPF(){

        String pathParamSalario = "2000";
        String url = "http://localhost:8080/exercicios/validarCpf";
        String cpf = "35189156060";

        RestAssured.given()
                .log().all()
                .queryParam("cpf",cpf)
                .when()
                .get(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body(Matchers.equalTo("CPF Valido"));

    }
}
