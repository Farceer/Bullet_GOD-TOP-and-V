import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet {
<<<<<<< HEAD
		
	

	public Rectangle bullet=new Rectangle();
	public int direction;
	public int speed=5;
	public int damage;
	
	public Bullet(double x,double y,int z) {
		bullet.setX(x);
		bullet.setY(y);
		bullet.setWidth(20);
		bullet.setHeight(10);
		direction=z;
		damage=1;
=======
		 
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
>>>>>>> cd6c1cd52ad44431ef340ea7952a99774948986c
		
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
