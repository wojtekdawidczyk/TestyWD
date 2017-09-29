package bank;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestKonto {

	@Test
	public void testWplata() {
		
		Konto konto = new Konto(1, 1000);
		konto.wplata(400);
		
		//assert konto.getSaldo() == 1400 : "niezgodne saldo"; prosty mechanizm asercji
		
		//asercje dostarczane przez bibliotekę JUnit
		assertEquals(1400, konto.getSaldo());

		//jeszcze lepsze asercje - biblioteka AssertJ
	}

	@Test
	public void testWyplata() throws BrakSrodkow{
		
		Konto konto = new Konto(1, 1000);
		konto.wyplata(400);
		
		assertEquals(600, konto.getSaldo());
		
	}
	
	@Test(expected = BrakSrodkow.class) //chcemy zeby byl ten wyjatek
	public void testWyplataBrakSrodkow() throws BrakSrodkow{
		
		Konto konto = new Konto(1, 1000);
		konto.wyplata(1400);
		
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testWyplataKwotaUjemna() throws BrakSrodkow{
		
		Konto konto = new Konto(1, 1000);
		konto.wyplata(-1400);
		
	}
	
	@Test
	public void testPrzelew() {
		
		Konto konto1 = new Konto(1, 1000);
		Konto konto2 = new Konto(2, 2000);
		konto1.przelew(konto2, 200);
		
		assertEquals(800, konto1.getSaldo());
		assertEquals(2200, konto2.getSaldo());
		
	}	
}