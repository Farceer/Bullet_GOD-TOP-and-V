import java.awt.geom.Point2D;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bullet {
		
	

	public Rectangle bullet=new Rectangle();
	public int direction;
	public int speed=5;
	
	public Bullet(double x,double y,int z) {
		bullet.setX(x);
		bullet.setY(y);
		bullet.setWidth(20);
		bullet.setHeight(10);
		direction=z;
		
	}
	public void update()
	{
		bullet.setX(bullet.getX()+10*direction);
	}
	
	
	

}
