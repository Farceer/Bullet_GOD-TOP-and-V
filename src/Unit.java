import javafx.scene.shape.Circle;

public class Unit extends Circle{
		private int x;
		private int y;
		public Circle unit=new Circle();
		private int hp;
	public Unit(double x, double y) {
        unit.setCenterX(x);
        unit.setCenterY(y);
        unit.setRadius(25);
        hp=5;
    }
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//public void takeDamage
}
