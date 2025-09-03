package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    private WebDriver driver;
    private By inputNome = By.id("firstName");
    private By botaoEnviar = By.id("btn-enviar");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherNome(String nome) {
        WebElement campo = driver.findElement(inputNome);
        campo.clear();
        campo.sendKeys(nome);
    }

    public void clicarEnviar() {
        driver.findElement(botaoEnviar).click();
    }

    public String getNomeValue() {
        return driver.findElement(inputNome).getAttribute("value");
    }
}
