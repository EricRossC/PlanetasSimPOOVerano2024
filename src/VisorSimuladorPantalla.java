import java.util.List;

public class VisorSimuladorPantalla extends VisorSimulador {

	public void mostrar(List<Planeta> planetas) {
		System.out.println("Estados:");
		System.out.println("----------+------+------+------+-------");
		System.out.println("NOMBRE    |    X |   Y  |  VX  |  VY ");
		System.out.println("----------+------+------+------+-------");
		for (Planeta a : planetas) {
			print(a);
		}
		System.out.println("----------+------+------+------+-------");
	}

	private static void print(Planeta a) {
		String formato = "%6.3f";
		Vector p = a.getPosicion();
		Vector v = a.getVelocidad();
		
		System.out.print(String.format("%10s", a.getNombre()));
		System.out.print("|");
		System.out.print(String.format(formato, p.getX()));
		System.out.print("|");
		System.out.print(String.format(formato, p.getY()));
		System.out.print("|");
		System.out.print(String.format(formato, v.getX()));
		System.out.print("|");
		System.out.print(String.format(formato, v.getY()));
		System.out.println();
	}

}
