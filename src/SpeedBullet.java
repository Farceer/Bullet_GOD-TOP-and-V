import java.io.FileNotFoundException;

public class SpeedBullet extends Bullet {
	
	public SpeedBullet(double X_axis, double Y_axis, int Direction) throws FileNotFoundException {
		super(X_axis,Y_axis,Direction);
		super.getbulletImageView().setScaleX(2.5);
		super.getbulletImageView().setScaleY(0.5);
		
		super.setSpeed(2);
	}
	
}
