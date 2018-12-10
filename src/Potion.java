import java.io.FileNotFoundException;

public class Potion extends Bullet  {
	private String s[] = new String[] { "Item/ItemSpeed.png",
			"Item/ItemMachineGun.png",
			"Item/ItemEnergy.png"};	
	public Potion(double X_axis, double Y_axis, int Direction, int type) throws FileNotFoundException {
		super(X_axis, Y_axis, Direction);
		// TODO Auto-generated constructor stub
		ResouceLoader load = new ResouceLoader(s[type]);
		ImageView = load.getInputImage();
		// bullet= new Image(inputstream, 50, 50, false, false);
		// bulletImageView = new ImageView(bullet);
		ImageView.setFitHeight(50);
		ImageView.setFitWidth(50);
		ImageView.setPreserveRatio(true);
		ImageView.setSmooth(false);
		ImageView.setX(X_axis);
		ImageView.setY(Y_axis);
		direction = Direction;
		this.type = type;
		speed=0;
		this.setSpeed(0);
	}

	
	
}
