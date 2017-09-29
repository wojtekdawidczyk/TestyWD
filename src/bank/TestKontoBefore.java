package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestKontoBefore {

	private Konto konto;

	@Before
	public void setUp()  {
		konto = new Konto(1, 1000); //to sie teraz wykona przed kazdym testem
	}

	@Test
	public void testWplata() {
		konto.wplata(400);
		assertEquals(1400, konto.getSaldo());
	}

	@Test
	public void testWyplata() throws BrakSrodkow{
		konto.wyplata(400);
		assertEquals(600, konto.getSaldo());
	}
	
	@Test(expected = BrakSrodkow.class) 
	public void testWyplataBrakSrodkow() throws BrakSrodkow{
		konto.wyplata(1400);
	}
}
