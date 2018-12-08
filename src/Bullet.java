import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet {

	private Image bullet;
	// public Rectangle bullet=new Rectangle();
	private int direction;
	public int type;
	private ImageView bulletImageView;
	private int speed = 1;
	private final ImageLoader loader = new ImageLoader();

	public Bullet(double X_axis ,double Y_axis,int Direction,Boolean type) throws FileNotFoundException {
		if ( type) {
			bulletImageView = loader.getBlueBullet();
		}else {
			bulletImageView = loader.getRedBullet();
		}
		bulletImageView.setPreserveRatio(true);
		bulletImageView.setX(X_axis);
		bulletImageView.setY(Y_axis);
		direction=Direction;
		this.type=0;
	}

	public Bullet(double X_axis, double Y_axis, int Direction, int type) {
		switch (type) {
		case 0:
			bulletImageView = loader.getItemEnergy();
			break;
		case 1:
			bulletImageView = loader.getItemMove();
			break;
		case 2:
			bulletImageView = loader.getItemSpeed();
			break;

		default:
			break;
		}
		bulletImageView = new ImageView(bullet);
		bulletImageView.setPreserveRatio(true);
		bulletImageView.setX(X_axis);
		bulletImageView.setY(Y_axis);
		direction = Direction;
		this.type = type;

	}

	public void update() {
		if (direction != 3) {
			bulletImageView.setX(bulletImageView.getX() + 10 * direction * speed);
		}

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

	public void setSpeed(int x) {
		this.speed = x;
	}

	public int getSpeed() {
		return speed;
	}

	public ImageLoader getLoader() {
		return loader;
	}

}
