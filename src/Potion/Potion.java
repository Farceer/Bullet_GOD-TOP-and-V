package Potion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Potion {
	private ImageView PotionImageView ;
	public Potion(double X_axis ,double Y_axis) throws FileNotFoundException {
		// bullet= new Image(inputstream, 50, 50, false, false);
		// bulletImageView = new ImageView(bullet);
		PotionImageView.setFitHeight(50);
		PotionImageView.setFitWidth(50);
		PotionImageView.setPreserveRatio(true);
		PotionImageView.setSmooth(false);
		PotionImageView.setX(X_axis);
		PotionImageView.setY(Y_axis);
		
	}
	public ImageView getPotionImageView() {
		return PotionImageView;
	}
	public void setPotionImageView(ImageView potionImageView) {
		PotionImageView = potionImageView;
	}

	
	
}
