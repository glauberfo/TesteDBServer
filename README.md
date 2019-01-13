## TestDBServer

#### Java - Automação DBServer 

  Projeto para automatizar a plataforma de teste DBserver, buscando fazer a cobertura da maior parte possível de cenários de testes no sistema. A automação é feita utilizando a IDE do Eclipse, Framework do Selenium WebDriver e o JUnit para execução dos testes. 
Para organizar e compilar o projeto foi utilizado o Maven, que também faz o gerenciamento das pastas.
  
#### Instalação

Instalar o Maven Ultima versão. [Click aqui para baixar](https://maven.apache.org/download.cgi)

Configurar o Maven. [Click aqui para baixar](http://luizricardo.org/2014/06/instalando-configurando-e-usando-o-maven-para-gerenciar-suas-dependencias-e-seus-projetos-java/)

Fazer o download do selenium. [Click aqui para baixar](https://www.seleniumhq.org/download/)

#### Como utilizar os testes

Ao baixar o projeto do Github, as pastas já estão em ordem e existe uma arquitetura para utilizá-lo.
##### Packages 
###### main/java
methods: Todos os metodos principais do sistema que serão usados várias vezes nas classes de testes.			

itensMapeamento: Mapeamento das páginas do sistema, buscando todos os dados e guardando para reuso.

PagesBase: Páginas Base do sistema, contém o que sempre é utilizado ex: Abrir do navegador, fechar navegador, Metodos usados constantemente.

teste: Contém os testes indiduais de cada página ou parte do sistema, podem ser utilizados separados ou juntos em testes integrados.

###### test/java
compraProd: Contém os testes individuais do sistema, tudo que for incluido nesta pasta deve conter a palavra "Test" no final do nome da classe. Sem isso, os testes não serão executados automaticamente.

###### Arquivo POM

Este é o arquivo mais importante do sistema, lá constam todas as declarações, estruturas, dependências e características do projeto.

#### Usando o Projeto
PageBase
```javascript
public class PageBase {
	
	/**
	 * @author Glauber Oliveira
	 * @version 1.0
	 */
	
	public WebDriver driver;
	public PageMethods pgmt;
	public ItensMenu pgim;
	public SelecProdutos pgsp;
	public BotoesConf pgbc;
	public CadastroNovoUsuario pgcnu;
	
	@BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
	
    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "/home/chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");
        
        pgmt = new PageMethods(driver);
        pgim = new ItensMenu(driver);
        pgsp = new SelecProdutos(driver);
        pgbc = new BotoesConf(driver);
        pgcnu = new CadastroNovoUsuario(driver);
        
    }
    
    @After  
    public void tearDown() {
        driver.quit();
    }

}
```

Mapeamento - ItensMenu
```javascript
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
```
Metodo - SelecProdutos
```javascript
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

```
Teste - BotoesConf
```javascript
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
```

Teste - CadastroNovoUsuario
```javascript
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
```
##### Direitos autorais
Glauber Oliveira
