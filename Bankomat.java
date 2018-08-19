package atm;

import java.util.ArrayList;

public class Bankomat {
    ArrayList<Racun> racuni = new ArrayList<>();

    public Bankomat() {

    }

    /** Metoda za provjeru da broj racuna nije vec u sistemu */
    private boolean isNotDouble(int brojRacuna) {
	boolean isNotDouble = true;
	if (racuni.size() > 0) {
	    for (int i = 0; i < racuni.size(); i++) {
		if (brojRacuna == racuni.get(i).getBrojRacuna()) {
		    isNotDouble = false;
		    break;
		}
	    }
	}
	return isNotDouble;
    }

    /** meotda za validaciju iznosa transakcije */
    private boolean dovoljanIznos(int indeks, double iznos) throws Exception {
	if (iznos <= racuni.get(indeks).getStanjeNaRacunu()) {
	    return true;
	} else {
	    throw new Exception("Iznos na racunu nije dovoljan za transakciju");
	}

    }

    /** Metoda za provjeru da li je prosledjeni broj racuna postojeci */
    /*
     * metoda vraca exception ako broj racuna nije u sistemu a ako jeste vraca broj
     * indeksa od racuna u listi racuni
     */
    private int postojeciIndeks(int brojRacuna) throws Exception {
	int postojeci = -1;
	for (int i = 0; i < racuni.size(); i++) {
	    if (brojRacuna == racuni.get(i).getBrojRacuna()) {
		postojeci = i;
	    }
	}
	if (postojeci >= 0) {
	    return postojeci;
	} else {
	    throw new Exception("Ne postoji racun sa tim brojem!");
	}

    }

    /** metoda za kreiranje novog validnog racuna */
    public void kreirajRacun(int brojRacuna, String imeVlasnikaRacuna, double stanjeNaRacunu) throws Exception {

	if (isNotDouble(brojRacuna)) {
	    Racun racun = new Racun(brojRacuna, imeVlasnikaRacuna, stanjeNaRacunu);
	    racuni.add(racun);
	    System.out.printf("Racun %s kreiran.", imeVlasnikaRacuna);
	    System.out.println("\n");
	} else {
	    throw new Exception("Racun sa tim brojem vec postoji!");
	}

    }

    /** metoda za transfer novca sa polaznog na ciljani racun */
    public void transfer(int polazniRacun, int ciljaniRacun, double iznos) throws Exception {
	try {
	    int polazniIndeks = postojeciIndeks(polazniRacun);
	    int ciljaniIndeks = postojeciIndeks(ciljaniRacun);
	    if (dovoljanIznos(polazniIndeks, iznos)) {
		racuni.get(polazniIndeks).setStanjeNaRacunu(racuni.get(polazniIndeks).getStanjeNaRacunu() - iznos);
		racuni.get(ciljaniIndeks).setStanjeNaRacunu(racuni.get(ciljaniIndeks).getStanjeNaRacunu() + iznos);
		System.out.println("Transfer uspijesan!");
		System.out.println();
	    }

	} catch (Exception ex) {
	    throw new Exception("Ne ispravan unos!", ex);
	}
    }

    /** metoda za dodavanje depozita na racun */
    /*
     * public void depozit(int brojRacuna, double depozit) { if (depozit < 10) {
     * System.out. println("Minimalni dozvoljeni depozit je 10 novcanih jedinica.");
     * System.out.println("\n"); } else { for (int i = 0; i < racuni.size(); i++) {
     * if (brojRacuna == racuni.get(i).getBrojRacuna()) {
     * racuni.get(i).setStanjeNaRacunu(racuni.get(i).getStanjeNaRacunu() + depozit);
     * } else { System.out.println("Nepostojeci racun."); System.out.println("\n");
     * break; } } } } /* /** metoda za ispis svih racuna
     */

    /** metoda za ispisivanje informacija svih racuna */
    public void informacije() {
	if (racuni.size() < 1) {
	    System.out.println("Nema kreiranih racuna.");
	    System.out.println("\n");
	} else {
	    for (int i = 0; i < racuni.size(); i++) {
		System.out.print((i + 1) + " ");
		System.out.println(racuni.get(i));
	    }
	}
    }
}
