package atm;

import java.util.ArrayList;

public class Bankomat {

	ArrayList<Racun> racuni = new ArrayList<>();

	public Bankomat() {

	}

	/* metoda za kreiranje novog validnog racuna */
	public void kreirajRacun(int brojRacuna, String imeVlasnikaRacuna, double stanjeNaRacunu) {

		Racun racun;

		if (stanjeNaRacunu < 0 || brojRacuna < 0) {
			System.out.println("Nedozvoljeno negativno stanje!");
		} else {
			if (racuni.size() < 1) {
				racun = new Racun(brojRacuna, imeVlasnikaRacuna, stanjeNaRacunu);
				racuni.add(racun);
				System.out.printf("Racun %s kreiran.", imeVlasnikaRacuna);
				System.out.println("\n");
			} else {
				for (int i = 0; i < racuni.size(); i++) {

					if (brojRacuna == racuni.get(i).getBrojRacuna()) {
						System.out.println("Racun sa tim brojem vec postoji!");
						System.out.println();
						break;

					} else if (brojRacuna != racuni.get(i).getBrojRacuna()) {
						racun = new Racun(brojRacuna, imeVlasnikaRacuna, stanjeNaRacunu);
						racuni.add(racun);
						System.out.printf("Racun %s kreiran.", imeVlasnikaRacuna);
						System.out.println("\n");
						break;
					}
				}
			}

		}

	}

	/* metoda za transfer novca sa polaznog na ciljani racun */
	public void transfer(int polazniRacun, int ciljaniRacun, double iznos) {

		int polazni = 0;
		int ciljani = 0;

		for (int i = 0; i < racuni.size(); i++) {
			if (racuni.get(i).getBrojRacuna() == polazniRacun) {
				polazni++;
				for (int j = 0; j < racuni.size(); j++) {
					if (racuni.get(j).getBrojRacuna() == ciljaniRacun) {
						ciljani++;
						if (racuni.get(i).getStanjeNaRacunu() >= iznos) {
							racuni.get(i).setStanjeNaRacunu(racuni.get(i).getStanjeNaRacunu() - iznos);
							racuni.get(j).setStanjeNaRacunu(racuni.get(j).getStanjeNaRacunu() + iznos);
							System.out.println("Transfer izvrsen.");
							System.out.println("\n");
						} else {
							System.out.println("Nedovoljno sredstava za transfer.");
							System.out.println("\n");

						}
					}
				}
			}

		}

		if (polazni == 0) {
			System.out.println("Nepostojeci polazni racun.");
			System.out.println("\n");
		}
		if (ciljani == 0) {
			System.out.println("Nepostojeci ciljani racun.");
			System.out.println("\n");
		}

	}

	/* metoda za dodavanje depozita na racun */
	public void depozit(int brojRacuna, double depozit) {
		if (depozit < 10) {
			System.out.println("Minimalni dozvoljeni depozit je 10 novcanih jedinica.");
			System.out.println("\n");
		} else {
			for (int i = 0; i < racuni.size(); i++) {
				if (brojRacuna == racuni.get(i).getBrojRacuna()) {
					racuni.get(i).setStanjeNaRacunu(racuni.get(i).getStanjeNaRacunu() + depozit);
				} else {
					System.out.println("Nepostojeci racun.");
					System.out.println("\n");
					break;
				}
			}
		}
	}

	/* metoda za ispis svih racuna */
	public void informacije() {
		if (racuni.size() < 1) {
			System.out.println("Nema kreiranih racuna.");
			System.out.println("\n");
		} else {
			for (int i = 0; i < racuni.size(); i++) {
				System.out.println(racuni.get(i));
			}
		}
	}
}
