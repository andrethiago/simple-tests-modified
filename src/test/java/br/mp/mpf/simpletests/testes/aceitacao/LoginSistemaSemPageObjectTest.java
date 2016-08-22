package br.mp.mpf.simpletests.testes.aceitacao;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSistemaSemPageObjectTest {

    @Test
    public void loginComSucesso() {

	WebDriver driver = new ChromeDriver();

	driver.get("http://localhost:8080/simpletests");

	driver.findElement(By.name("username")).sendKeys("joao@mpf.mp.br");
	driver.findElement(By.name("password")).sendKeys("123456");

	driver.findElement(By.cssSelector("input[type='submit'")).click();

    }

}
