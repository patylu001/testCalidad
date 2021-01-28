package com.fca.calidad.test;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MernCrudTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    
    //System.setProperty("webdriver.chrome.driver", "/Users/patriciaortegon/Documents/Personales/fCA/Agosto-Dic-2020/Calidad/chromedriver 3");
    driver = new ChromeDriver();
    baseUrl = "https://mern-crud.herokuapp.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testPasswordCorrecto() throws Exception {
	  //Ejercicio del código
    driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("5");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
    driver.findElement(By.xpath("//form/button")).click();
    pause(5000);
    //Verificación
    WebElement elemento = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p"));
    String textoEjecucion = elemento.getText();
    String textoEsperado = "That email is already taken.";
    
    assertEquals(textoEsperado,textoEjecucion);
  }

  @Test
  public void testPasswordIncorrecto() throws Exception {
	  //Ejercicio del código
    driver.get("https://mern-crud.herokuapp.com/");
    driver.findElement(By.xpath("//div[@id='root']/div/div[2]/button")).click();
    driver.findElement(By.name("name")).click();
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("sdfsdfs");
    driver.findElement(By.name("email")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.name("age")).clear();
    driver.findElement(By.name("age")).sendKeys("5");
    driver.findElement(By.name("age")).click();
    driver.findElement(By.xpath("//div[3]/div[2]/div")).click();
    driver.findElement(By.xpath("//div[2]/div/div[2]/div")).click();
    driver.findElement(By.xpath("//form/button")).click();
    pause(5000);
    //Verificación
    WebElement elemento = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/form/div[5]/div/p"));
    String textoEjecucion = elemento.getText();
    String textoEsperado = "That email is already taken.";
    
    assertEquals(textoEsperado,textoEjecucion);
  }
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
  private void pause(long mils) {
	  try {
		  Thread.sleep(mils);
	  }catch(Exception e){
		  e.printStackTrace();
	  }
  }
}
