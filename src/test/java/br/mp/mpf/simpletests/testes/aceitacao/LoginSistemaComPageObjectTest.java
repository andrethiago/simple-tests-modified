package br.mp.mpf.simpletests.testes.aceitacao;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSistemaComPageObjectTest {

    private WebDriver driver;

    @Before
    public void before() {
	driver = new ChromeDriver();
    }

    @Test
    public void loginComSucesso() {
	LoginPage loginPage = new LoginPage(driver);
	ListaProjetosPage homePage = loginPage.
					visita("http://localhost:8080/simpletests").
					autentica("joao@mpf.mp.br","123456");

	assertTrue(homePage.isValida());
    }

    @After
    public void after() {
	driver.quit();
    }

}
