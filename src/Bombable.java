import java.io.FileInputStream;

import javafx.scene.image.ImageView;

public interface Bombable {
	public ImageView Bomb(FileInputStream bombtype);

	public void BombReClaim();

}
