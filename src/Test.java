import javafx.scene.shape.Circle;

public class Test extends Circle{
		private int x;
		private int y;
	public Test(double x, double y) {
		x=x;
		y=y;
        this.setCenterX(x);
        this.setCenterY(y);
        this.setRadius(25);
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
}
