import java.io.FileInputStream;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class SpaceShip implements Bombable {
	private ImageView SpaceShip;
	private Image Ship;
	private boolean isBomb; 
	//************************************* Fix Center *************************************//
	public SpaceShip(double X_axis, double Y_axis, FileInputStream inputstream) {
		Ship = new Image(inputstream, 50, 50, false, false);
		
		SpaceShip = new ImageView(Ship);
		SpaceShip.setFitHeight(100);
		SpaceShip.setFitWidth(50);
		SpaceShip.setPreserveRatio(true);
		SpaceShip.setX(X_axis);
		SpaceShip.setY(Y_axis);
		this.isBomb = false ; 
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
	
	

	public ImageView Bomb(FileInputStream bombtype) {
		// TODO Auto-generated method stub
			this.getSpaceShip().setVisible(false);
			ImageView  Bomb = new ImageView(new Image(bombtype));
			Bomb.setFitHeight(130);
			Bomb.setFitWidth(130);
			Bomb.setTranslateX(this.getX_axis()-65+25);
			Bomb.setTranslateY(this.getY_axis()-65+25);
			
			FadeTransition x = new FadeTransition(Duration.millis(1000), Bomb);
			x.setFromValue(1);
			x.setToValue(0);
			x.setCycleCount(1);
			
			x.play();
			x.setOnFinished(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent actionEvent) {
	            	setBomb(true);
	            }
	        });
				
		
			
			
		
			
			
			return Bomb ; 
	}

	public void BombReClaim() {
		// TODO Auto-generated method stub
		this.getSpaceShip().setVisible(true);
		this.setY_axis(300); // Set Ship to Center
		this.setY_axis(300);// Set Ship to Center
		this.isBomb = false;
	}

	@Override
	public boolean isBomb() {
		return isBomb;
	}

	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}

}
