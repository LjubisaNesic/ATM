package atm;

public class Racun {

	// stanje objekta
	private int brojRacuna;
	private String imeVlasnikaRacuna;
	private double stanjeNaRacunu = 0;

	// konstruktor - no args
	Racun() {

	}

	// konstruktor za postavljenje pocetnog stanja
	Racun(int brojRacuna, String imeVlasnikaRacuna, double stanjeNaRacunu) {
		this.brojRacuna = brojRacuna;
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		this.stanjeNaRacunu = stanjeNaRacunu;

	}

	/* geteri i seteri */
	public int getBrojRacuna() {
		return brojRacuna;
	}

	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public String getImeVlasnikaRacuna() {
		return imeVlasnikaRacuna;
	}

	public void setImeVlasnikaRacuna(String imeVlasnikaRacuna) {
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
	}

	public double getStanjeNaRacunu() {
		return stanjeNaRacunu;
	}

	public void setStanjeNaRacunu(double stanjeNaRacunu) {
		this.stanjeNaRacunu = stanjeNaRacunu;
	}

	@Override
	public String toString() {
		return "Racun [brojRacuna = " + brojRacuna + ", imeVlasnikaRacuna = " + imeVlasnikaRacuna
				+ ", stanjeNaRacunu = " + stanjeNaRacunu + "]";
	}

}
