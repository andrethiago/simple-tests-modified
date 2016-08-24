package br.mp.mpf.simpletests.testes.aceitacao;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSistemaSemPageObjectTest {

    private WebDriver driver;

    @Before
    public void before() {
	driver = new ChromeDriver();
    }

    @Test
    public void loginComSucesso() {
	// Acessa a página inicial que nos redireciona para a página de login
	driver.get("http://localhost:8080/simpletests");

	// Informa o usuário/senha e clica no botão de login
	driver.findElement(By.name("username")).sendKeys("joao@mpf.mp.br");
	driver.findElement(By.name("password")).sendKeys("123456");
	driver.findElement(By.cssSelector("input[type='submit'")).click();

	// Se a página inicial foi acessada: a barra de navegação existe e ela
	// é a página de projetos
	assertNotNull(driver.findElement(By.className("navbar")));
	assertThat(driver.findElement(By.tagName("h2")).getText(), containsString("Projetos"));
    }

    @After
    public void after() {
	driver.quit();
    }

}
