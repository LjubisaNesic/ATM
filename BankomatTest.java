package atm;

import java.util.Scanner;

public class BankomatTest {
	
	// pomocna metoda za lakse testiranje
	private static void kreirajTestRacune(Bankomat bankomat) {
		bankomat.kreirajRacun(1, "Ljubisa Nesic", 1000);
		bankomat.kreirajRacun(2, "Dejan Radeljic", 2000);
		bankomat.kreirajRacun(3, "Saban Saulic", 3000);
		bankomat.kreirajRacun(4, "Sanja Nesic", 4000);
		bankomat.informacije();
		System.out.println();
		
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Bankomat bankomat = new Bankomat();
	  
		// pozivanje metode za lakse testiranje
		kreirajTestRacune(bankomat);
	

		byte opcija = -1;

		while (opcija != 0) {
			System.out.println("Izaberite opciju:" + "\n1 -> kreiranje racuna"
					+ "\n2 -> Prebacivanje novca sa jednog racuna na drugi"
					+ "\n3 -> Ispisivanje detalja postojecih racuna" + "\n0 -> za izlaz");

			System.out.println();

			opcija = input.nextByte();

			if (opcija == 1) {

				System.out.print("Unesite broj novog racuna: ");
				int brojRacuna = input.nextInt();
				input.nextLine();
				System.out.print("Unsite ime vlasnika novog racuna: ");
				String imeVlasnikaRacuna = input.nextLine();
				System.out.print("Unesite pocetno stanje novog racuna: ");
				double stanjeNaRacunu = input.nextDouble();

				bankomat.kreirajRacun(brojRacuna, imeVlasnikaRacuna, stanjeNaRacunu);

			} else if (opcija == 2) {

				System.out.print("Unesite broj racuna sa kojeg zelite da prebacite iznos: ");
				int polazniRacun = input.nextInt();
				System.out.print("Unesite broj racuna na koji zelite da iznos bude prebacen: ");
				int ciljaniRacun = input.nextInt();
				System.out.print("Unesite iznos koji zelite da prebacite: ");
				double iznos = input.nextDouble();

				bankomat.transfer(polazniRacun, ciljaniRacun, iznos);

			} else if (opcija == 3) {

				bankomat.informacije();
				System.out.println();
				
			}

			while (opcija > 3 || opcija < 0) {
				System.out.println("Pogresan unos!");
				System.out.println("Izaberite opciju:" + "\n1 -> kreiranje racuna"
						+ "\n2 -> Prebacivanje novca sa jednog racuna na drugi"
						+ "\n3 -> Ispisivanje detalja postojecih racuna" + "\n0 -> za izlaz");

				System.out.println();

				opcija = input.nextByte();
			}

		}

		System.out.println("Kraj aplikacije.");

		input.close();
	}

}