
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
public class SpaceShip implements BombAble {
	private ImageView Ship;
	private boolean type;
	private ResouceLoader loader;
	private boolean isShipBomb;
	// Game Chacractor HP

	private int hp;
	// Game Chacractor Energy
	private double energy;

	public SpaceShip(double X_axis, double Y_axis, boolean ShipType) { // ShipType True is blue , False is red
		loader = new ResouceLoader();
		if (ShipType) {
			Ship = getLoader().getBlueShip();
		} else {
			Ship = getLoader().getRedShip();
		}
		this.Ship.setX(X_axis);
		this.Ship.setY(Y_axis);
		this.type = ShipType;
		this.setHp(10);
		this.setEnergy(100);
		this.isShipBomb = false;
	}

	public ImageView getSpaceShip() {
		return this.Ship;
	}

	public void setX_axis(double x_axis) {
		getSpaceShip().setX(x_axis);
	}

	public void setY_axis(double y_axis) {
		getSpaceShip().setY(y_axis);
	}

	public double getX_axis() {
		return getSpaceShip().getX();
	}

	public double getY_axis() {
		return getSpaceShip().getY();
	}

	public ResouceLoader getLoader() {
		return this.loader;
	}

	public ImageView getShip() {
		return this.Ship;
	}

	public boolean getShipType() {
		return this.type;
	}
	public int getHp() {
		return hp;
	}

	public double getEnergy() {
		return energy;
	}

	public void setHp(int hp) {
		if (hp >= 10 ) {
			hp = 10 ;
		}
		this.hp = hp;
	}

	public void setEnergy(double energy) {
		if (energy >= 100 ) {
			energy = 100 ;
		}
		this.energy = energy;
	}



	public boolean isBomb() {
		
		return this.isShipBomb;
	}


	public boolean setBomb(boolean ShipStatus) {
		
		return this.isShipBomb = ShipStatus;
	}
	

	@Override
	public Object Bomb() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(0, 0, 800, 350);
		Rectangle rect2 = new Rectangle(0, 450, 800, 300);
		Rectangle rect3 = new Rectangle(0, 350, 350, 100);
		Rectangle rect4 = new Rectangle(450, 350, 350, 100);
		ShipBombTransition(rect, 2000);
		ShipBombTransition(rect2, 2000);
		ShipBombTransition(rect3, 1500);
		ShipBombTransition(rect4, 1500);
		Group g = new Group(rect, rect2, rect3, rect4);
		setBomb(true);
		return g;

	}

	private void ShipBombTransition(final Rectangle rect, final double millis) {
		FadeTransition ft = new FadeTransition(Duration.millis(millis), rect);
		ft.setFromValue(1);
		ft.setToValue(0);
		ft.play();
		rect.setFill(Color.WHITE);
	}

	public void BombReset() {
		// TODO Auto-generated method stub
		this.getSpaceShip().setVisible(true);
		this.setY_axis(300); // Set Ship to Center
		setBomb(false);
		this.setHp(10);
		this.setEnergy(100);

	}


///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////
///////////////////////////////////////**************************CLean Code Already*********************************************/////////////////////////////

}
