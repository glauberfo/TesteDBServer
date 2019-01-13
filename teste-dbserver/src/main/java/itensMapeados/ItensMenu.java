package itensMapeados;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pagesBase.PageBase;

public class ItensMenu extends PageBase{
	
	private WebDriver driver;
	
	public ItensMenu(WebDriver driver) {
        this.driver = driver;
    }
	
	/**
	 * @author Glauber Oliveira
	 * Contem todos os itens do Menu
	 */
	
	public void WomenClick() {
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a")).click();
	}
	
	public String confirProd() {
		return driver.findElement(By.id("color_7")).getText();
	}
	
	public void ProceedCheck() {
		driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
	}

	public void SelecColor2() {
		driver.findElement(By.id("thumb_6")).click();
	}
	
    public void VoltarframeDefault() {
    	driver.switchTo().parentFrame();
    	driver.switchTo().defaultContent();
    }
    
    public void trocarframe() {
    	WebElement iFrame= driver.findElement(By.tagName("iframe"));
    	driver.switchTo().frame(iFrame);
    }
    
    public void trocarframe2() {
    	WebElement iFrame2= driver.findElement(By.tagName("iframe"));
    	driver.switchTo().frame(iFrame2);
    }
    
	public void ProceedCheckFinal() {
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
	}
	
	
}
