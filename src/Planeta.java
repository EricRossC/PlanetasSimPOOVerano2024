

public class Planeta {
	
	
	private String nombre;
	private Vector posicion;
	private Vector velocidad;
	private double masa;

	public Planeta(String nombre, double x, double y, double masa) {
		this.nombre = nombre;
		this.posicion = new Vector(x, y);
		this.velocidad = new Vector(0, 0);
		this.masa = masa;
	}

	public Vector getPosicion() { return this.posicion;	}
	public Vector getVelocidad() { return this.velocidad; }
	
	public String getNombre() { return nombre; }
	
	public double getMasa() {
		return masa;
	}

	public double calculaDistanciaCon(Planeta otro) {
		return this.posicion.distanciaCon(otro.posicion);
	}

	public void acelerar(Vector dv) {
		this.velocidad.acumular(dv);
	}

	public void mover(double dt) {
		this.posicion.acumular(velocidad.mult(dt));
	}

}











