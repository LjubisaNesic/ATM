package atm;

import java.util.InputMismatchException;

import javax.management.InvalidAttributeValueException;

public class Racun {
    // stanje objekta
    private int brojRacuna;
    private String imeVlasnikaRacuna;
    private double stanjeNaRacunu = 0;

    private static int ukupanBrojObjekata;

    /** konstruktor - no args */
    Racun() throws Exception {
	this(0, null, 0);

    }

    /** konstruktor za postavljenje pocetnog stanja */
    Racun(int brojRacuna, String imeVlasnikaRacuna, double stanjeNaRacunu) throws Exception {
	setBrojRacuna(brojRacuna);
	setImeVlasnikaRacuna(imeVlasnikaRacuna);
	setStanjeNaRacunu(stanjeNaRacunu);

	ukupanBrojObjekata++;

    }

    /******* geteri i seteri *****/
    /** vrati broj racuna */
    public int getBrojRacuna() {
	return brojRacuna;
    }

    /** postavi broj racuna */
    public void setBrojRacuna(int brojRacuna) throws Exception {
	if (brojRacuna >= 0) {
	    this.brojRacuna = brojRacuna;
	} else {
	    throw new InvalidAttributeValueException("Broj racuna nemoze biti negativan.");
	}
    }

    /** vrati ime vlasnika racuna */
    public String getImeVlasnikaRacuna() {
	return imeVlasnikaRacuna;
    }

    /** postavi ime vlasnika racuna */
    public void setImeVlasnikaRacuna(String imeVlasnikaRacuna) throws Exception {
	boolean isLetter = true;
	for (int i = 0; i < imeVlasnikaRacuna.length(); i++) {
	    if (!(Character.isLetter(imeVlasnikaRacuna.charAt(i))) && !(imeVlasnikaRacuna.charAt(i) == ' ')) {
		isLetter = false;
		break;
	    }
	}
	if (isLetter) {
	    this.imeVlasnikaRacuna = imeVlasnikaRacuna;
	} else {
	    throw new InputMismatchException("Karakteri imena moraju biti slova");
	}
    }

    /** vrati stanje na racunu */
    public double getStanjeNaRacunu() {
	return stanjeNaRacunu;
    }

    /** postavi stanje na racunu */
    public void setStanjeNaRacunu(double stanjeNaRacunu) throws Exception {
	if (stanjeNaRacunu >= 0) {
	    this.stanjeNaRacunu = stanjeNaRacunu;
	} else {
	    throw new InvalidAttributeValueException("Stanje na racunu nemoze biti negativno.");
	}
    }

    /** vrati ukupan broj instaciranih objekata */
    public int getUkupanBrojObjekata() {
	return ukupanBrojObjekata;
    }

    /** vrati informacije */
    @Override
    public String toString() {
	return "Racun [brojRacuna = " + brojRacuna + ", imeVlasnikaRacuna = " + imeVlasnikaRacuna
		+ ", stanjeNaRacunu = " + stanjeNaRacunu + "]";
    }
}
