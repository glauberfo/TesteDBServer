package itensMapeados;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelecProdutos {
	
	private WebDriver driver;
	
	public SelecProdutos(WebDriver driver) {
        this.driver = driver;
    }
	
	/**
	 * @author Glauber Oliveira
	 * Contem todos produtos da página
	 */
	
	public void selecBlouse() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[2]/span")).click();
	}
	
	public void selecColor() {
		driver.findElement(By.id("color_7")).click();
	}
	
	public String Price() {
		return driver.findElement(By.id("our_price_display")).getText();
	}
	
	public String PriceFinal() {
		return driver.findElement(By.id("total_product")).getText();
	}
	
	public String ConfirBlouse() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("layer_cart_product_title")));
		return driver.findElement(By.id("layer_cart_product_title")).getText();
	}
	
	public void Terms() {
		driver.findElement(By.id("cgv")).click();
	}
	
}
