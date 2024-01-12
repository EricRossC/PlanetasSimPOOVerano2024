import java.util.List;



public class VisorTemporizador extends VisorSimulador
{
	private int intervalo;
	private VisorSimulador visor;
	private long lastTime = 0;
	
	public VisorTemporizador(int intervalo, VisorSimulador visor)
	{
		this.intervalo = intervalo;
		this.visor = visor;
	}	
	@Override
	public void mostrar(List<Planeta> planetas) {
		long tiempoTranscurrido = System.currentTimeMillis() - lastTime;
		
		if (tiempoTranscurrido < intervalo * 1000) return;
		
		this.visor.mostrar(planetas);
		this.lastTime = System.currentTimeMillis();
	}

}








