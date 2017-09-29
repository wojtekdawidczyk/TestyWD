package bank;


public class Konto {
    private int numer;
    private int saldo;
    
    public Konto(int numer, int saldo) {
   	 this.numer = numer;
   	 this.saldo = saldo;
    }

    public int getNumer() {
   	 return numer;
    }

    public int getSaldo() {
   	 return saldo;
    }
    
    public void wplata(int kwota) {
    	if (kwota < 0) {
			throw new IllegalArgumentException("ujemna kwota w operacji wplata");
		}
		saldo += kwota;
    }
    
    public void wyplata(int kwota) throws BrakSrodkow {
    	if (kwota < 0) {
			throw new IllegalArgumentException("ujemna kwota w operacji wplata");
		}
    	if (kwota > saldo) {
			throw new BrakSrodkow("SALDO UJEMNE");
		}
    	saldo -= kwota;
    }
    
 
    
    @Override
    public String toString() {
   	 return "Konto nr " + numer + ", saldo=" +saldo;
    }

	public void przelew(Konto kontoDocelowe, int kwotaPrzelewu) {
		
		saldo -= kwotaPrzelewu;
		kontoDocelowe.saldo += kwotaPrzelewu;
		
	}

}
