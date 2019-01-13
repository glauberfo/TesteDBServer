package itensMapeados;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroNovoUsuario {
	
	private WebDriver driver;
	
	public CadastroNovoUsuario(WebDriver driver) {
		this.driver = driver;
	}
	
	/**
	 * @author Glauber Oliveira
	 * Contem o mapeamento para criar um novo usuário.
	 */
	
	private String Nome = "Glauber";
	private String UltNome = "Oliveira";
	private String Senha = "g210687*";
	private String DiaAni = "21";
	private String MesAni = "6";
	private String AnoAni = "1987";
	private String Nome1 = "Glauber";
	private String UltNome1 = "Oliveira";
	private String Empresa = "DBServer";
	private String Endereco = "7299 Universal Blvd";
	private String Cidade = "Orlando";
	private String Estado = "9";
	private String CEP = "32801";
	private String Pais = "21";
	private String Celular = "407-313-9000";
	private String EndReferencia = "7299 Universal Blvd";
	
	
	public void CadastroUser() {
		SelecTratamento();
		FirstName(Nome);
		LastName(UltNome);
		Senha(Senha);
		DiaAniversario2(DiaAni);
		MesAniversario(MesAni);
		AnoAniversario(AnoAni);
		FirstName1(Nome1);
		LastName1(UltNome1);
		Company(Empresa);
		address1(Endereco);
		city(Cidade);
		State(Estado);
		ZipPostal(CEP);
		Country(Pais);
		MobilePhone(Celular);
		AdressReference(EndReferencia);
			
	}
	
	public void CreateAccount() {
		driver.findElement(By.id("SubmitCreate")).click();
	}
	
	public void SelecTratamento() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_gender1")));
		driver.findElement(By.id("id_gender1")).click();
	}
	
	public void Email(String Email) {
		driver.findElement(By.id("email_create")).sendKeys(Email);
	}
	
	public void FirstName(String Nome) {
		driver.findElement(By.id("customer_firstname")).sendKeys(Nome);
	}
	
	public void LastName(String UltNome) {
		driver.findElement(By.id("customer_lastname")).sendKeys(UltNome);
	}
	
	public void Senha(String Senha) {
		driver.findElement(By.id("passwd")).sendKeys(Senha);
	}
	
	public void DiaAniversario2(String DiaAni) {
		driver.findElement(By.id("days")).click();
		WebElement comboboxElement = driver.findElement(By.id("days"));
		Select combobox = new Select(comboboxElement);
		combobox.selectByValue(DiaAni);
	}
	
	public void MesAniversario(String MesAni) {
		driver.findElement(By.id("years")).click();
		WebElement element = driver.findElement(By.id("months"));
        Select combo = new Select(element);
        combo.selectByValue(MesAni);
	}
	
	public void AnoAniversario(String AnoAni) {
		driver.findElement(By.id("years")).click();
		WebElement element = driver.findElement(By.id("years"));
        Select combo = new Select(element);
        combo.selectByValue(AnoAni);
	}
	
	public void FirstName1(String Nome) {
		driver.findElement(By.id("firstname")).sendKeys(Nome);
	}
	
	public void LastName1(String UltNome) {
		driver.findElement(By.id("lastname")).sendKeys(UltNome);
	}
	
	public void Company(String Empresa) {
		driver.findElement(By.id("company")).sendKeys(Empresa);
	}
	
	public void address1(String Endereco) {
		driver.findElement(By.id("address1")).sendKeys(Endereco);
	}
	
	public void city(String Cidade) {
		driver.findElement(By.id("city")).sendKeys(Cidade);
	}
	
	public void State(String Estado) {
		driver.findElement(By.id("id_state")).click();
		WebElement element = driver.findElement(By.id("id_state"));
        Select combo = new Select(element);
        combo.selectByValue(Estado);
	}
	
	public void ZipPostal(String CEP) {
		driver.findElement(By.id("postcode")).sendKeys(CEP);
	}
	
	public void Country(String Pais) {
		driver.findElement(By.id("id_country")).click();
		WebElement element = driver.findElement(By.id("id_country"));
        Select combo = new Select(element);
        combo.selectByValue(Pais);
	}
	
	public void MobilePhone(String Celular) {
		driver.findElement(By.id("phone_mobile")).sendKeys(Celular);
	}
	
	public void AdressReference(String EndReferencia) {
		driver.findElement(By.id("alias")).sendKeys(EndReferencia);
	}
	
	public String ConfirEnd() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"address_delivery\"]/li[4]")));
		return driver.findElement(By.xpath("//*[@id=\"address_delivery\"]/li[4]")).getText();
	}

}
