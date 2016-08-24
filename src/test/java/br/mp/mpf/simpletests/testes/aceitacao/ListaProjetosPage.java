package br.mp.mpf.simpletests.testes.aceitacao;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ListaProjetosPage {

    private WebDriver driver;

    public ListaProjetosPage(WebDriver driver) {
	this.driver = driver;
    }

    public InclusaoProjetoPage novoProjeto() {
	driver.findElement(By.linkText("Novo Projeto")).click();
	return new InclusaoProjetoPage(driver);
    }

    public boolean projetoIncluidoSucesso() {
	WebElement divSucesso = driver.findElement(By.className("alert-success"));
	return divSucesso.getText().contains("Projeto incluído com sucesso!");
    }

    public boolean isValida() {
	return temBarraNavegacao() && temListagemProjetos();
    }

    private boolean temBarraNavegacao() {
	return driver.findElement(By.className("navbar")) != null;
    }

    private boolean temListagemProjetos() {
	return driver.findElement(By.tagName("h2")).getText().contains("Projetos");
    }

}
