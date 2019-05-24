package br.com.fox.getQuantityResults;

import org.junit.Test;

public class Init {

	private GetGoogle getGoogle = new GetGoogle();
	
	@Test
	public void gettingGoogleResults() throws Exception {
		getGoogle.setUp();
		getGoogle.getResult();
	}
	
}
