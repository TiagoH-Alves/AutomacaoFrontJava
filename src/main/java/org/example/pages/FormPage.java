package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    private WebDriver driver;
    private By inputNome = By.id("firstName");
    private By inputSobrenome = By.id("lastName");
    private By inputCpf = By.id("cpf");
    private By botaoEnviar = By.id("btn-enviar");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherNome(String nome) {
        WebElement campo = driver.findElement(inputNome);
        campo.clear();
        campo.sendKeys(nome);
    }

    public void preencherSobrenome(String sobrenome) {
        WebElement campo = driver.findElement(inputSobrenome);
        campo.clear();
        campo.sendKeys(sobrenome);
    }

    public void preencherCpf(String cpf) {
        WebElement campo = driver.findElement(inputCpf);
        campo.clear();
        campo.sendKeys(cpf);
        //Sleep somente para visualizar
        try {
            Thread.sleep(4000); // espera 5 segundos
        } catch (InterruptedException e) {
            //nao realizar acao
        }
    }

    public void clicarEnviar() {
        driver.findElement(botaoEnviar).click();
    }

    public String getNomeValue() {
        return driver.findElement(inputNome).getAttribute("value");
    }
}
