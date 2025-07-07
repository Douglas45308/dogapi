package steps;

import config.APIConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DogAPIPage;

public class DogAPISteps {
    private DogAPIPage dogAPIPage;

    @Before
    public void setup() {
        APIConfig.setup();
        dogAPIPage = new DogAPIPage();
    }

    @Given("que a Dog API está disponível")
    public void queADogAPIEstaDisponivel() {
        // Setup já foi feito no @Before
    }

    @When("eu faço uma requisição GET para listar todas as raças")
    public void euFacoUmaRequisicaoGETParaListarTodasAsRacas() {
        dogAPIPage.getAllBreeds();
    }

    @When("eu faço uma requisição GET para obter imagens da raça {string}")
    public void euFacoUmaRequisicaoGETParaObterImagensDaRaca(String breed) {
        dogAPIPage.getBreedImages(breed);
    }

    @When("eu faço uma requisição GET para obter uma imagem aleatória")
    public void euFacoUmaRequisicaoGETParaObterUmaImagemAleatoria() {
        dogAPIPage.getRandomImage();
    }

    @Then("o status code da resposta deve ser {int}")
    public void oStatusCodeDaRespostaDeveSer(int statusCode) {
        dogAPIPage.validateStatusCode(statusCode);
    }

    @Then("o status da resposta deve ser success")
    public void oStatusDaRespostaDeveSerSuccess() {
        dogAPIPage.validateResponseStatus();
    }

    @Then("a resposta deve conter a lista de raças")
    public void aRespostaDeveConterAListaDeRacas() {
        dogAPIPage.validateBreedsListStructure()
                .validateBreedsExist();
    }

    @Then("a resposta deve conter as imagens da raça")
    public void aRespostaDeveConterAsImagensDaRaca() {
        dogAPIPage.validateBreedImagesStructure()
                .validateImagesExist()
                .validateImageUrls();
    }

    @Then("a resposta deve conter uma imagem aleatória")
    public void aRespostaDeveConterUmaImagemAleatoria() {
        dogAPIPage.validateRandomImageStructure()
                .validateRandomImageUrl();
    }

    @Then("a raça {string} deve estar presente na lista")
    public void aRacaDeveEstarPresenteNaLista(String breed) {
        dogAPIPage.validateBreedExists(breed);
    }

    @Then("o status da resposta deve ser error")
    public void oStatusDaRespostaDeveSerError() {
        dogAPIPage.validateErrorStatus();
    }
}
