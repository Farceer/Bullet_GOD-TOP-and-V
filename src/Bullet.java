import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet {
		 
	private Image bullet ;
	//public Rectangle bullet=new Rectangle();
	private int direction;
	//private int SPEED=5;
	private ImageView bulletImageView ; 
	public Bullet(double X_axis ,double Y_axis,int Direction,FileInputStream inputstream ) throws FileNotFoundException {
		bullet= new Image(inputstream, 50, 50, false, false);
		bulletImageView = new ImageView(bullet);
		bulletImageView.setPreserveRatio(true);
		bulletImageView.setX(X_axis);
		bulletImageView.setY(Y_axis);
		direction=Direction;
		
	}
	public void update()
	{
		bulletImageView.setX(bulletImageView.getX()+5*direction);
	}
	public int getDirection() {
		return direction;
	}
	public double getX_axis() {
		return getbulletImageView().getX();
	}
	public double getY_axis() {
		return getbulletImageView().getY();
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void setX_axis(double x_axis) {
		getbulletImageView().setX(x_axis); 
	}
	public void setY_axis(double y_axis) {
		getbulletImageView().setY(y_axis); 
	}
	public Image getBullet() {
		return bullet;
	}
	public ImageView getbulletImageView() {
		return bulletImageView;
	}
	


}
