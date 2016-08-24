package br.mp.mpf.simpletests.testes.aceitacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
	this.driver = driver;
    }

    public LoginPage visita(String url) {
	driver.get(url);
	return this;
    }

    public ListaProjetosPage autentica(String usuario, String senha) {
	driver.findElement(By.name("username")).sendKeys(usuario);
	driver.findElement(By.name("password")).sendKeys(senha);
	driver.findElement(By.cssSelector("input[type='submit'")).click();

	return new ListaProjetosPage(driver);
    }

}
