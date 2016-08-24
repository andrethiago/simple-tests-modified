package br.mp.mpf.simpletests.testes.aceitacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InclusaoProjetoPage {

    private WebDriver driver;

    public InclusaoProjetoPage(WebDriver driver) {
	this.driver = driver;
    }

    public InclusaoProjetoPage nome(String nomeProjeto) {
	driver.findElement(By.name("nome")).sendKeys(nomeProjeto);
	return this;
    }

    public InclusaoProjetoPage descricao(String descricaoProjeto) {
	driver.findElement(By.name("descricao")).sendKeys(descricaoProjeto);
	return this;
    }

    public ListaProjetosPage salvarProjeto() {
	driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
	return new ListaProjetosPage(driver);
    }

}
