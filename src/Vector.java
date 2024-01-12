
public class Vector {
	private double x, y, z;

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector() {
		this(0, 0);
	}

	public Vector restar(Vector otro) {
		return new Vector(this.x - otro.x, this.y - otro.y);
	}

	public Vector unitario() {
		double d = this.magnitud();
		return new Vector(this.x / d, this.y / d);
	}

	private double magnitud() {
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	public Vector mult(double f) {
		return new Vector(this.x * f, this.y * f);
	}

	public void acumular(Vector v) {
		this.x += v.x;
		this.y += v.y;
	}

	public double distanciaCon(Vector otro) {
		double dx = this.getX() - otro.getX();
		double dy = this.getY() - otro.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}

}
