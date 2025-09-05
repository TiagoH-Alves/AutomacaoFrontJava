package org.example.tests.steps;
import io.cucumber.java.en.*;
import org.example.driver.DriverFactory;
import utils.PreencherCep;
import utils.PreencherCpf;
import utils.PreencherData;
import utils.PreencherEmail;
import utils.PreencherTelefone;
import org.example.pages.FormPage;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class FormSteps {

    private WebDriver driver;
    private FormPage formPage;

    @Given("que o usuário está na página do formulário")
    public void usuario_esta_no_formulario() {
        driver = DriverFactory.getDriver();
        driver.get("file:///C:/Users/tiago/IdeaProjects/AutomacaoWEB/ProjetoCadastroApp/index.html");
        formPage = new FormPage(driver);
        //Sleep somente para visualizar home
        try {
            Thread.sleep(2000); // espera 5 segundos
        } catch (InterruptedException e) {
            //nao realizar acao
        }
    }

    @When("ele preenche o campo nome com {string}")
    public void preenche_nome(String nome) {
        formPage.preencherNome(nome);
    }

    @When("ele preenche o campo sobrenome com {string}")
    public void preenche_sobrenome(String sobrenome) {
        formPage.preencherSobrenome(sobrenome);
    }

    @When("ele preenche o campo CPF")
    public void preenche_cpf (){
        formPage.preencherCpf(PreencherCpf.gerarCpfFormatado());
    }

    @When("ele preenche o campo com Data de Nascimento")
    public void preencheDataDeNascimento () {
        formPage.prencherDatadeNascimento(PreencherData.gerarData());
    }

    @When("ele preenche o campo com Email")
    public void preencheCampoEmail () {
        formPage.prenchercampoEmail(PreencherEmail.gerarEmail());
    }

    @When("ele preenche o campo com CEP")
    public void PreencherCep () {
        formPage.PreencherCampoCep(PreencherCep.gerarCep());
    }

    @When("ele preenche o campo com Celular")
        public void PreencherTellefone () {
            formPage.PreencherCampoCelular(PreencherTelefone.gerarTelefoneCelular());
    }

    @Then("o campo deve conter {string}")
        public void validar_nome (String esperado){
                String valorCampo = formPage.getNomeValue();
                Assert.assertEquals("O campo não contém o valor esperado!", esperado, valorCampo);
                DriverFactory.quitDriver();
    }
}