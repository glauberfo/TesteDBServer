package compraProd;

import org.junit.Assert;
import org.junit.Test;

import pagesBase.PageBase;

public class CompraBlouseTest extends PageBase{
	
	/**
	 * @author Glauber Oliveira
	 * @version 1.0
	 */
	
	private String Email = "glauber8@gmail.com";
	
	@Test
	public void CompraDireta() {
		try{
		pgim.WomenClick();
		pgsp.selecColor();
		pgsp.selecBlouse();
		pgim.trocarframe();
		String Price = pgsp.Price();
		pgbc.addCart2();
		Assert.assertEquals("Blouse", pgsp.ConfirBlouse());
		pgim.ProceedCheck();
		pgim.VoltarframeDefault();
		pgim.ProceedCheckFinal();
		pgcnu.Email(Email);
		pgcnu.CreateAccount();
		pgcnu.CadastroUser();
		pgbc.Register();
		Assert.assertEquals("7299 Universal Blvd", pgcnu.ConfirEnd());
		pgbc.ProcCheckout();
		pgsp.Terms();
		pgbc.ProcCheckout2();
		Assert.assertEquals(Price, pgsp.PriceFinal());
		pgbc.PayCheck();
		pgbc.ConfirOrder();
		Assert.assertEquals("Your order on My Store is complete.", pgbc.OrderConfir());
		}catch(Exception Erro) {
			System.out.println("Erro ao Tentar Comprar");
			Erro.printStackTrace();
		}
		
	}

}
