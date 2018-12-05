import java.io.FileInputStream;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class SpaceShip {
	private ImageView SpaceShip;
	private Image Ship;
	//************************************* Fix Center *************************************//
	public SpaceShip(double X_axis, double Y_axis, FileInputStream inputstream) {
		Ship = new Image(inputstream, 276, 393, false, false);
		SpaceShip = new ImageView(Ship);
		SpaceShip.setPreserveRatio(true);
		SpaceShip.setX(X_axis);
		SpaceShip.setY(Y_axis);
		//************************************* Fix Center *************************************//
	}

//	
//	public void update()
//	{
//		imageView.setX(imageView.getX()+5*direction);
//	}

	public ImageView getSpaceShip() {
		return SpaceShip;
	}

	public Image getShip() {
		return Ship;
	}

	public double getX_axis() {
		return getSpaceShip().getX();
	}

	public double getY_axis() {
		return getSpaceShip().getY();
	}

	public void setX_axis(double x_axis) {
		getSpaceShip().setX(x_axis);
	}

	public void setY_axis(double y_axis) {
		getSpaceShip().setY(y_axis);
	}
///////////////////////////////////////////////////////************************************* Fix Center *************************************//
	public double getCenterY() {
		return 0;

	}

	public double getCenterX() {
		return 0;

	}
//////////////////////////////////////////////////////************************************* Fix Center *************************************//
}
