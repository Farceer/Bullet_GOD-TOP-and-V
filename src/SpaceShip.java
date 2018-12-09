import java.io.FileInputStream;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpaceShip implements Bombable {
	private ImageView Ship;
	private boolean isBomb;
	private boolean type ; 
	private  ImageLoader loader ;
	public SpaceShip(double X_axis, double Y_axis,boolean b) {
		loader = new ImageLoader();
		if (b) {
			Ship = getLoader().getBlueShip();
		}else {
			Ship = getLoader().getRedShip();
		}
		Ship.setX(X_axis);
		Ship.setY(Y_axis);
		this.isBomb = false;
		this.type = b ;
	}

	public ImageView Bomb() {
		// TODO Auto-generated method stub
		
		this.getSpaceShip().setVisible(false);
		ImageView Bomb ;
		if (this.getShipType() ) {
			 Bomb = getLoader().getBlueBomb();
		}else {
			 Bomb = getLoader().getRedBomb();
		}
		Bomb.setTranslateX(this.getX_axis() - 65 + 25);
		Bomb.setTranslateY(this.getY_axis() - 65 + 25);

		FadeTransition x = new FadeTransition(Duration.millis(2000), Bomb);
		x.setFromValue(1);
		x.setToValue(0);
		x.setCycleCount(1);

		x.play();
		x.setOnFinished(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent actionEvent) {
				setBomb(true);
			}
		});

		return Bomb;
	}
	public void BombReClaim() {
		// TODO Auto-generated method stub
		this.getSpaceShip().setVisible(true);
		this.setY_axis(300); // Set Ship to Center
		this.setY_axis(300);// Set Ship to Center
		setBomb(false);
	}

	@Override
	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

	public ImageView getSpaceShip() {
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

	public ImageLoader getLoader() {
		return loader;
	}

	public ImageView getShip() {
		return Ship;
	}

	public boolean getShipType() {
		return type;
	}


}
