import javafx.scene.image.ImageView;

public class Potion implements BombAble {
	private int direction;
	private int type;
	private int speed = 1;
	private ImageView bulletImageView;

	
	
	public Potion(double X_axis, double Y_axis, int Direction, String inputstream, int type)
	{ 
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
		this.setSpeed(0);

	
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



	@Override
	public boolean isBomb() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean setBomb(boolean status) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Object Bomb() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void BombReset() {
		// TODO Auto-generated method stub
		
	}
}
