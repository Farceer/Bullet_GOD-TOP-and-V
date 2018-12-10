


import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
public class Bullet implements BombAble {

	protected int direction;
	protected int type;
	protected int speed = 1;
	protected ImageView ImageView;
	
	private ResouceLoader load = new ResouceLoader("Charactor/BlueShipBullet.png");
	private ResouceLoader load2 = new ResouceLoader("Charactor/RedShip bullet.png");
	

	public Bullet(double X_axis, double Y_axis, int Direction) throws FileNotFoundException {
	
	
		if(Direction==1)
		{
			ImageView = load.getInputImage();
		}
		else {
			ImageView = load2.getInputImage();
		}
		
		ImageView.setFitHeight(50);
		
		ImageView.setFitWidth(50);
		
		ImageView.setPreserveRatio(true);
		ImageView.setSmooth(false);
		ImageView.setX(X_axis);
		ImageView.setY(Y_axis);
		ImageView.setScaleY(2);
		direction = Direction;
		this.setType(0);
	}
	
	public void update() {
		
		ImageView.setX(ImageView.getX() + 10 * direction * speed);
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
	public void setType(int type) {
		this.type = type;
	}

	public ImageView getImageView() {
		return ImageView;
	}
	

	public void setSpeed(int x) {
		this.speed = x;
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

	public int getSpeed() {
		return speed;
	}

	public int getType() {
		return type;
	}


	@Override
	public Group Bomb() {
		// TODO Auto-generated method stub
		this.getImageView().setVisible(false);
		Circle rect = new Circle(this.getX_axis() + 25, this.getY_axis() + 25, 45);
		rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		FadeTransition ft = new FadeTransition(Duration.millis(200), rect);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.play();
		Group g = new Group(rect);
		return g;
	}

	@Override
	public void BombReset() {
		// TODO Auto-generated method stub
		
	}

///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////

}