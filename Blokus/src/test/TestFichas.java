package test;

import junit.framework.TestCase;
import objects.*;

public class TestFichas extends TestCase {

	private Ficha ficha;
	
	public void escenario() {
		this.ficha = new Ficha(null, null, getName());
	}
	
	public void testConstriurFicha() {
		escenario();
		assert(ficha != null);
	}
}
