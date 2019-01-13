package teste;

import org.junit.Assert;
import org.junit.Test;

import pagesBase.PageBase;

public class TesteCompra extends PageBase{
	
	/**
	 * @author Glauber Oliveira
	 * @version 1.0
	 * Pagina de teste integrado
	 */
	
	private String Email = "glauber.fernando@gmail.com";
	private String Nome = "Glauber";
	
	@Test
	public void CompraDireta() {
//		try{
			pgim.WomenClick();
			pgsp.selecColor();
			pgsp.selecBlouse();
			pgim.trocarframe();
			pgbc.addCart2();
			Assert.assertEquals("Blouse", pgsp.ConfirBlouse());
			pgim.ProceedCheck();
			pgim.VoltarframeDefault();
			pgim.ProceedCheckFinal();
			pgcnu.Email(Email);
			pgcnu.CreateAccount();
			pgcnu.CadastroUser();
			String Endereco = pgcnu.ConfirEnd();
			Assert.assertEquals("7299 Universal Blvd", pgcnu.ConfirEnd());
//		}catch(Exception Erro) {
//			System.out.println("Erro ao Tentar Comprar");
//			Erro.printStackTrace();
//		}
		
	}

}
