import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Potion {
	private Image potion ;
	private int type;

	private ImageView PotionImageView ; 
	public Potion(double X_axis ,double Y_axis,int type,FileInputStream inputstream ) throws FileNotFoundException {
		potion= new Image(inputstream, 50, 50, false, false);
		PotionImageView = new ImageView(potion);
		PotionImageView.setPreserveRatio(true);
		PotionImageView.setX(X_axis);
		PotionImageView.setY(Y_axis);
		this.type=type;

		
	}
	public Image getPotion() {
		return potion;
	}
	public void setPotion(Image potion) {
		this.potion = potion;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public ImageView getPotionImageView() {
		return PotionImageView;
	}
	public void setPotionImageView(ImageView potionImageView) {
		PotionImageView = potionImageView;
	}
	
	
	
}
