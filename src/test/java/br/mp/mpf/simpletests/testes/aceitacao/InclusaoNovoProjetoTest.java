package br.mp.mpf.simpletests.testes.aceitacao;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InclusaoNovoProjetoTest {

    private WebDriver driver;

    @Before
    public void before() {
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void loginComSucesso() {
	LoginPage loginPage = new LoginPage(driver);
	ListaProjetosPage homePage = loginPage.
					visita("http://localhost:8080/simpletests").
					autentica("joao@mpf.mp.br","123456");

	InclusaoProjetoPage inclusaoProjetoPage = homePage.novoProjeto();

	ListaProjetosPage listaProjetosPage = inclusaoProjetoPage.
			nome("Projeto novo de Teste").descricao("Essa é a descrição do projeto.").
			salvarProjeto();

	assertTrue(listaProjetosPage.projetoIncluidoSucesso());
    }

    @After
    public void after() {
	driver.quit();
    }

}
