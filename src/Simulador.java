import java.util.ArrayList;
import java.util.List;

public class Simulador {
	private List<Planeta> planetas = new ArrayList<>();
	private VisorSimulador visor;
	private int intervalo;
	
	public Simulador(int intervalo, VisorSimulador visor) {
		this.intervalo = intervalo;
		this.visor = visor;
	}

	public void agregarPlaneta(String nombre, int x, int y, int masa, String tipo) {
		Planeta p = PlanetaFactory.crear(nombre, x, y, masa, tipo);		
		planetas.add(p);
	}

	public void ejecutar() {
		long start = System.currentTimeMillis();
		
		while(System.currentTimeMillis() - start < intervalo * 1000) {
			this.ejecutarSimulacionUnaVez(planetas);
		}
	}


	private void ejecutarSimulacionUnaVez(List<Planeta> planetas) {
		double dt = 0.001;

		for (Planeta a : planetas) {
			Vector f = calcularFuerzaTotal(a, planetas);
			Vector va = f.mult(1 / a.getMasa());

			Vector dv = va.mult(dt);

			a.acelerar(dv);
		}
		for (Planeta a : planetas) {
			a.mover(dt);
		}
		visor.mostrar(planetas);
	}

	/*
	 * Esta función calculará la fuerza TOTAL que siente el planeta "a" producto de
	 * la atracción gravitatoria de todo el resto de los planetas que están en
	 * "planetas". OJO, que "planetas" igual contiene a "a".
	 */
	private Vector calcularFuerzaTotal(Planeta a, List<Planeta> planetas) {
		Vector suma = new Vector();
		for (Planeta otro : planetas) {
			if (otro == a)
				continue;

			double f = calcularFuerzaCon(a, otro);
			Vector va = crearVector(a);
			Vector vb = crearVector(otro);
			Vector vc = vb.restar(va);
			Vector vcu = vc.unitario();
			Vector vf = vcu.mult(f);

			suma.acumular(vf);
		}
		return suma;
	}

	private Vector crearVector(Planeta a) {
		return a.getPosicion();
	}

	/*
	 * Esta función calcula la fuerza de atracción entre el planeta "a" y el "otro".
	 */
	private double calcularFuerzaCon(Planeta a, Planeta otro) {
		double G = 43.42;
		double d = a.calculaDistanciaCon(otro);
		double f = G * a.getMasa() * otro.getMasa() / (d * d); // Math.pow(d, 2)
		return f;
	}

}








