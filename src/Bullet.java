
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

	public Bullet(double X_axis, double Y_axis, int Direction, String inputstream) throws FileNotFoundException {
		ResouceLoader load = new ResouceLoader(inputstream);
		bulletImageView = load.getInputImage();
		// bullet= new Image(inputstream, 50, 50, false, false);
		bulletImageView.setFitHeight(50);
		bulletImageView.setFitWidth(50);
		bulletImageView.setPreserveRatio(true);
		bulletImageView.setSmooth(false);
		bulletImageView.setX(X_axis);
		bulletImageView.setY(Y_axis);
		direction = Direction;
		this.setType(0);
	}

	public void update() {
		
			bulletImageView.setX(bulletImageView.getX() + 10 * direction * speed);
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
	public void setType(int type) {
		this.type = type;
	}

	public ImageView getbulletImageView() {
		return bulletImageView;
	}

	public void setSpeed(int x) {
		this.speed = x;
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