package pages;



import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.BreedImagesResponse;
import models.BreedsResponse;
import models.RandomImageResponse;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DogAPIPage {
    private Response response;

    @Step("Fazer requisição GET para listar todas as raças")
    public DogAPIPage getAllBreeds() {
        response = given()
                .when()
                .get("/breeds/list/all");
        return this;
    }

    @Step("Fazer requisição GET para obter imagens da raça: {breed}")
    public DogAPIPage getBreedImages(String breed) {
        response = given()
                .pathParam("breed", breed)
                .when()
                .get("/breed/{breed}/images");
        return this;
    }

    @Step("Fazer requisição GET para obter imagem aleatória")
    public DogAPIPage getRandomImage() {
        response = given()
                .when()
                .get("/breeds/image/random");
        return this;
    }

    @Step("Verificar se o status code é {expectedStatusCode}")
    public DogAPIPage validateStatusCode(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
        return this;
    }

    @Step("Verificar se o campo status da resposta é 'success'")
    public DogAPIPage validateResponseStatus() {
        response.then().body("status", equalTo("success"));
        return this;
    }

    @Step("Verificar se a resposta contém a lista de raças")
    public DogAPIPage validateBreedsListStructure() {
        response.then()
                .body("message", notNullValue())
                .body("message", instanceOf(java.util.Map.class));
        return this;
    }

    @Step("Verificar se a resposta contém imagens da raça")
    public DogAPIPage validateBreedImagesStructure() {
        response.then()
                .body("message", notNullValue())
                .body("message", instanceOf(java.util.List.class));
        return this;
    }

    @Step("Verificar se a resposta contém uma imagem aleatória")
    public DogAPIPage validateRandomImageStructure() {
        response.then()
                .body("message", notNullValue())
                .body("message", instanceOf(String.class));
        return this;
    }

    @Step("Verificar se todas as URLs das imagens são válidas")
    public DogAPIPage validateImageUrls() {
        BreedImagesResponse breedResponse = response.as(BreedImagesResponse.class);
        for (String imageUrl : breedResponse.getMessage()) {
            assert imageUrl.startsWith("https://");
            assert imageUrl.contains("dog.ceo");
        }
        return this;
    }

    @Step("Verificar se a URL da imagem aleatória é válida")
    public DogAPIPage validateRandomImageUrl() {
        RandomImageResponse randomResponse = response.as(RandomImageResponse.class);
        String imageUrl = randomResponse.getMessage();
        assert imageUrl.startsWith("https://");
        assert imageUrl.contains("dog.ceo");
        return this;
    }

    @Step("Verificar se existem raças na resposta")
    public DogAPIPage validateBreedsExist() {
        BreedsResponse breedsResponse = response.as(BreedsResponse.class);
        assert !breedsResponse.getMessage().isEmpty();
        return this;
    }

    @Step("Verificar se existem imagens para a raça")
    public DogAPIPage validateImagesExist() {
        BreedImagesResponse breedResponse = response.as(BreedImagesResponse.class);
        assert !breedResponse.getMessage().isEmpty();
        return this;
    }

    @Step("Verificar se a raça '{breed}' existe na lista")
    public DogAPIPage validateBreedExists(String breed) {
        BreedsResponse breedsResponse = response.as(BreedsResponse.class);
        assert breedsResponse.getMessage().containsKey(breed);
        return this;
    }

    @Step("Verificar se o campo status da resposta é 'error'")
    public DogAPIPage validateErrorStatus() {
        response.then().body("status", equalTo("error"));
        return this;
    }

    public Response getResponse() {
        return response;
    }
}
