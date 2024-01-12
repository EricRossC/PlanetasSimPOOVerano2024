import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		VisorCompuesto visor = new VisorCompuesto();
		
		visor.agregarVisor(new VisorSimuladorArchivo());
		
		VisorCompuesto visor2 = new VisorCompuesto();
		visor2.agregarVisor(new VisorSimuladorPantalla());
		visor2.agregarVisor(new VisorSimuladorNulo());
		
		visor.agregarVisor(visor2);
		
		VisorSimulador v = new VisorTemporizador(3, visor);
		
		Simulador sim = new Simulador(10, v);

		leerPlanetas(sim);

		sim.ejecutar();
	}

	private static void leerPlanetas(Simulador sim) throws FileNotFoundException {
		Scanner s = new Scanner(new File("/home/eross/planetas.txt"));

		while (s.hasNextLine()) {
			String line = s.nextLine();
			String[] partes = line.split(",");
			String nombre = partes[0];
			int x = Integer.parseInt(partes[1]);
			int y = Integer.parseInt(partes[2]);
			int masa = Integer.parseInt(partes[3]);
			String tipo = partes[4];
			sim.agregarPlaneta(nombre, x, y, masa, tipo);
		}

		s.close();
	}
}









