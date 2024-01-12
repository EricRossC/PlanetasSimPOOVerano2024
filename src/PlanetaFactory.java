




public class PlanetaFactory {

	public static Planeta crear(String nombre, int x, int y, int masa, String tipo) {
		Planeta p;
		
		if ("NORMAL".equals(tipo)) {
			p = new Planeta(nombre, x, y, masa);
		} else {
			p = new PlanetaEstático(nombre, x, y, masa);
		}
		
		return p;
	}

}
