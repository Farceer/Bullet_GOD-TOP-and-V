package Button;

import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ButtonCredit extends ButtonChageStage {

	public ButtonCredit(ImageView image, Stage theStage, Scene scene) {
		super(image, theStage, scene);
		// TODO Auto-generated constructor stub
		DropShadow shadow = new DropShadow();
		this.setOnMouseClicked((event) -> {

			theStage.setScene(scene);
		});

		this.setOnMouseMoved((event) -> {
			this.setEffect(shadow);
			this.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));

		});

		this.setOnMouseExited((event) -> {

			this.setBackground(null);
			this.setEffect(null);
		});
		
		
		scene.setOnMouseClicked(e->{
			
		});
	}

}
