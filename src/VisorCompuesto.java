import java.util.ArrayList;
import java.util.List;


public class VisorCompuesto extends VisorSimulador {

	private List<VisorSimulador> visores = new ArrayList<>();
	
	public void agregarVisor(VisorSimulador v) {
		visores.add(v);
	}
	
	@Override
	public void mostrar(List<Planeta> planetas) {
		for(VisorSimulador v : visores) {
			v.mostrar(planetas);
		}
	}
}
