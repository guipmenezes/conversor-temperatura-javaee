/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;

public class TestePaginaConversor {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testeConversaoFahrenheitCelsius() {
        driver.get("http://localhost:8080/ConversorTemperatura/");
        driver.manage().window().maximize();
        
        WebElement selecionaElemento = driver.findElement(By.name("opcoes1"));
        Select select1 = new Select(selecionaElemento);
        select1.selectByVisibleText("Fahrenheit");
        
        WebElement selecionaOutroElemento = driver.findElement(By.name("opcoes2"));
        Select select2 = new Select(selecionaOutroElemento);
        select2.selectByVisibleText("Celsius");
        
        driver.findElement(By.name("grau")).click();
        driver.findElement(By.name("grau")).sendKeys("212");
        driver.findElement(By.name("converter")).click();
        driver.findElement(By.cssSelector("h2:nth-child(2)")).click();
        assertThat(driver.findElement(By.cssSelector("h2:nth-child(2)")).getText(), is("O resultado foi: 100"));
    }

    @Test
    public void testeConversaoCelsiusFahrenheit() {
        driver.get("http://localhost:8080/ConversorTemperatura/");
        driver.manage().window().setSize(new Dimension(974, 1032));
        
        
        WebElement selecionaElemento = driver.findElement(By.name("opcoes1"));
        Select select1 = new Select(selecionaElemento);
        select1.selectByVisibleText("Celsius");
        
        WebElement selecionaOutroElemento = driver.findElement(By.name("opcoes2"));
        Select select2 = new Select(selecionaOutroElemento);
        select2.selectByVisibleText("Fahrenheit");
        
        driver.findElement(By.name("grau")).click();
        driver.findElement(By.name("grau")).sendKeys("100");
        driver.findElement(By.name("converter")).click();
        driver.findElement(By.cssSelector("h2:nth-child(2)")).click();
        assertThat(driver.findElement(By.cssSelector("h2:nth-child(2)")).getText(), is("O resultado foi: 212"));
    }

}
