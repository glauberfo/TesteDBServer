package itensMapeados;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BotoesConf {
	
	private WebDriver driver;
	
	public BotoesConf(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @author Glauber Oliveira
	 * Contem todos os Botões de Confirmação do Sistema 
	 */
	
	public void addCart2() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='add_to_cart']/button/span")));
		driver.findElement(By.xpath("//*[@id='add_to_cart']/button/span")).click();
	}
	
	public void addCart() {
		driver.findElement(By.id("add_to_cart")).click();
	}
	
	public void Register() {
		driver.findElement(By.id("submitAccount")).click();
	}
	
	public void ProcCheckout() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
	}
	
	public void ProcCheckout2() {
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
	}
	
	public void PayCheck() {
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
	}
	
	public void PayBank() {
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
	}
	
	public void ConfirOrder() {
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
	}
	
	public String OrderConfir() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/p[1]")));
		return driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();
	}

}
