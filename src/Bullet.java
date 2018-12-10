


import java.io.FileNotFoundException;

import javafx.scene.image.ImageView;
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
public class Bullet {

	private int direction;
	private int type;
	private int speed = 1;
	private ImageView bulletImageView;

	private ResouceLoader load = new ResouceLoader("Charactor/BlueShipBullet.png");
	private ResouceLoader load2 = new ResouceLoader("Charactor/RedShip bullet.png");
	

	public Bullet(double X_axis, double Y_axis, int Direction) throws FileNotFoundException {
	
	
		if(Direction==1)
		{
			bulletImageView = load.getInputImage();
		}
		else {
			bulletImageView = load2.getInputImage();
		}
		
		bulletImageView.setFitHeight(50);
		
		bulletImageView.setFitWidth(50);
		
		bulletImageView.setPreserveRatio(true);
		bulletImageView.setSmooth(false);
		bulletImageView.setX(X_axis);
		bulletImageView.setY(Y_axis);
		bulletImageView.setScaleY(2);
		direction = Direction;
		this.setType(0);
	}
	
	public Bullet(double X_axis, double Y_axis, int Direction, String inputstream, int type) {
		ResouceLoader load = new ResouceLoader(inputstream);
		bulletImageView = load.getInputImage();
		// bullet= new Image(inputstream, 50, 50, false, false);
		// bulletImageView = new ImageView(bullet);
		bulletImageView.setFitHeight(50);
		bulletImageView.setFitWidth(50);
		bulletImageView.setPreserveRatio(true);
		bulletImageView.setSmooth(false);
		bulletImageView.setX(X_axis);
		bulletImageView.setY(Y_axis);
		direction = Direction;
		this.type = type;
		speed=0;

	}

	public void update() {
		
			bulletImageView.setX(bulletImageView.getX() + 10 * direction * speed);
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
		return bulletImageView;
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

///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////

}