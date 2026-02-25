import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalToIgnoringCase;

public class TesteApiPetStore {

    @Test
    public void Exercicio7_Utilizando_Post_PetStore(){

        String url = "https://petstore.swagger.io/v2/user/createWithList";

        String body ="[\n" +
                "  {\n" +
                "    \"id\": 0,\n" +
                "    \"username\": \"smlx\",\n" +
                "    \"firstName\": \"samuel\",\n" +
                "    \"lastName\": \"D,\",\n" +
                "    \"email\": \"Teste@gmail.com\",\n" +
                "    \"password\": \"1234433\",\n" +
                "    \"phone\": \"string\",\n" +
                "    \"userStatus\": 0\n" +
                "  }\n" +
                "]";

        RestAssured.given()
                .log().all()
                .headers("Content-Type","application/json")
                .headers("accept","application/json")
                .body(body)
                .when()
                .post(url)
                .then()
                .log().all()
                .assertThat()
                .statusCode(200)
        .statusLine(containsString("200"))
                .contentType("application/json")


                // ===== VALIDAÇÕES DO BODY =====
                .body("$", notNullValue())
                .body("code", notNullValue())
                .body("type", notNullValue())
                .body("message", notNullValue())

                // ===== GARANTIR QUE NÃO EXISTEM CAMPOS EXTRAS =====
                .body("size()", equalTo(3));

    }
}
