package methods;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pagesBase.PageBase;

public class PageMethods extends PageBase{
    
    private WebDriver driver;
	String recebeSemana;
    
    public PageMethods(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * Comandos do Teclado
     */
    
    public void usarCmdTeclado() {
    new Actions(driver).sendKeys(Keys.ENTER).perform();
    }
    
    /**
     * ******* TextField e TextArea ***********
     */
    public void logar(String email, String senha) {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(email);
        
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(senha);
        
        clicarBotao("//*[@id=\"login-form\"]/button");
        
    }
    
    public void escrever(By by, String texto) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(texto);
    }
    
    public void escrever(String id_campo, String texto) {
        escrever(By.id(id_campo), texto);
    }
    
    public String obterValorCampo(String id_campo) {
        return driver.findElement(By.id(id_campo)).getAttribute("value");
    }

    /**
     * ******* Radio e Check ***********
     */
    public void clicarRadio(String id) {
        driver.findElement(By.id(id)).click();
    }
    
    public boolean isRadioMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }
    
    public void clicarCheck(String id) {
       																											
    }
    
    public boolean isCheckMarcado(String id) {
        return driver.findElement(By.id(id)).isSelected();
    }

    /**
     * ******* Combo ***********
     */
    public void selecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }
    
    public void deselecionarCombo(String id, String valor) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        combo.deselectByVisibleText(valor);
    }
    
    public String obterValorCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }
    
    public List<String> obterValoresCombo(String id) {
        WebElement element = driver.findElement(By.id("elementosForm:esportes"));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<String>();
        for (WebElement opcao : allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }
    
    public int obterQuantidadeOpcoesCombo(String id) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }
    
    public boolean verificarOpcaoCombo(String id, String opcao) {
        WebElement element = driver.findElement(By.id(id));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(opcao)) {
                return true;
            }
        }
        return false;
    }

    /**
     * ******* Botao ***********
     */
    public void clicarBotao(String button) {
        driver.findElement(By.xpath(button)).click();
    }
    
    public String obterValueElemento(String id) {
        return driver.findElement(By.id(id)).getAttribute("value");
    }

    /**
     * ******* Link ***********
     */
    public void clicarLink(String link) {
        driver.findElement(By.linkText(link)).click();
    }

    /**
     * ******* Textos ***********
     */
    public String obterTexto(By by) {
        return driver.findElement(by).getText();
    }
    
    public int obterTexto(String id) {
        return obterTexto(By.name(id)).length();
    }

    /**
     * ******* Alerts ***********
     */
    public String alertaObterTexto() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }
    
    public String alertaObterTextoEAceita() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.accept();
        return valor;
        
    }
    
    public String alertaObterTextoENega() {
        Alert alert = driver.switchTo().alert();
        String valor = alert.getText();
        alert.dismiss();
        return valor;
        
    }
    
    public void alertaEscrever(String valor) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(valor);
        alert.accept();
    }

    /**
     * ******* Frames e Janelas ***********
     */
    public void entrarFrame(String id) {
        driver.switchTo().frame(id);
    }
    
    public void limparCampo(String id) {
        driver.findElement(By.id(id)).clear();
    }
    
    public void sairFrame() {
        driver.switchTo().defaultContent();
    }
    
    public void trocarJanela(String id) {
        driver.switchTo().window(id);
    }
    
    public String obterTituloPagina() {
        return driver.getTitle();
    }
    
    public void desloga123() {
        
        clicarBotao("//*[@id='app-layout']/nav/div/div/div[1]/ul/li/a");
        clicarBotao("//*[@id=\"app-layout\"]/nav/div/div/div[1]/ul/li/ul/li[2]/a");
    }
    
    public void diminuirTaxaVoos(String campo, String id) {
        
        double valor = Double.parseDouble(obterValorCampo(campo).replace(",", "."));
        String resultado;
        
        valor = valor * 0.10;
        resultado = String.format("%.2f", valor);
        
        limparCampo(campo);
        escrever(id, resultado);
    }
    
    public void aumentarTaxaVoos(String campo, String id) {
        
        double valor = Double.parseDouble(obterValorCampo(campo).replace(",", "."));
        String resultado;
        
        valor = valor * 10;
        resultado = String.format("%.2f", valor);
        
        limparCampo(campo);
        escrever(id, resultado);
    }
    
    /**
     * Seleciona dia com Do While
     */
    
    public String recebeSemana1Sis() {
    	return driver.findElement(By.xpath("//*[@id=\"frmSearch\"]/div/div[3]/div[1]/ul/li/div/div/table/tbody/tr/td[1]/table/tbody/tr[1]")).getText();
    }
    	public String primeroDiaSem2() {
    		return driver.findElement(By.xpath("//*[@id=\"frmSearch\"]/div/div[3]/div[1]/ul/li/div/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]")).getText();
    	}
    
	public void selecDia(String Dia) {
		recebeSemana = recebeSemana1Sis();
		System.out.println("Dias semana" + recebeSemana);
		do {
			if (recebeSemana==Dia) {
				System.out.println("Contem o dia:" + Dia);
				break;
			} 
			recebeSemana = recebeSemana1Sis();
			if (recebeSemana.contains(Dia)) {
				System.out.println("Contem o dia primeira semana:" + Dia);
				{
				recebeSemana = primeroDiaSem2();
				if(recebeSemana.contains(Dia)) {
						driver.findElement(By.xpath("//*[@id=\"frmSearch\"]/div/div[3]/div[1]/ul/li/div/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td[1]")).click();
				}
				}
			}
			recebeSemana = recebeSemana1Sis();
			if(recebeSemana.contains(Dia)) {
				System.out.println("Contem o dia Segunda semana:" + Dia);
				{
				recebeSemana = primeroDiaSem2();
				if(recebeSemana.contains(Dia)) {
					
				}
				}
			}
		} while(recebeSemana!= Dia);
		System.out.println("Dias semana" + recebeSemana);
			
		}
	
	
    
    
}
