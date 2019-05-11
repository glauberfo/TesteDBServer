package pagesBase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import itensMapeados.BotoesConf;
import itensMapeados.CadastroNovoUsuario;
import itensMapeados.ItensMenu;
import itensMapeados.SelecProdutos;
import methods.PageMethods;

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
        driver.get("http://google.com");
        
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
