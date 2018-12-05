import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet {
		 
	private Image bullet ;
	//public Rectangle bullet=new Rectangle();
	private int direction;
	//private int SPEED=5;
	private ImageView imageView ; 
	public Bullet(double X_axis ,double Y_axis,int Direction,FileInputStream inputstream ) throws FileNotFoundException {
		bullet= new Image(inputstream, 50, 50, false, false);
		imageView = new ImageView(bullet);
		imageView.setPreserveRatio(true);
		imageView.setX(X_axis);
		imageView.setY(Y_axis);
		direction=Direction;
		
	}
	public void update()
	{
		imageView.setX(imageView.getX()+10*direction);
	}
	public int getDirection() {
		return direction;
	}
	public double getX_axis() {
		return getImageView().getX();
	}
	public double getY_axis() {
		return getImageView().getY();
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public void setX_axis(double x_axis) {
		getImageView().setX(x_axis); 
	}
	public void setY_axis(double y_axis) {
		getImageView().setY(y_axis); 
	}
	public Image getBullet() {
		return bullet;
	}
	public ImageView getImageView() {
		return imageView;
	}
	


}
