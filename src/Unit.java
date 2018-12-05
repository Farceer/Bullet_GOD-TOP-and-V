import javafx.scene.shape.Circle;

public class Unit extends Circle{
		private int x;
		private int y;
		public Circle unit=new Circle();
		public int hp;
	public Circle getUnit() {
			return unit;
		}
		public void setUnit(Circle unit) {
			this.unit = unit;
		}
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
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
	public void hit()
	{
		this.hp-=1;
	}
	
	//public void takeDamage
}
