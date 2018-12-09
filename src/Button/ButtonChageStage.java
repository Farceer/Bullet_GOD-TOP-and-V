package Button;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ButtonChageStage extends ButtonPress {
	private Stage theStage;
	private Scene scene;
	public ButtonChageStage(ImageView image,Stage theStage,Scene scene) {
		super( image);
		// TODO Auto-generated constructor stub
		this.setTheStage(theStage) ;
		this.setScene(scene) ; 

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
		
	}
	public Stage getTheStage() {
		return theStage;
	}
	public void setTheStage(Stage theStage) {
		this.theStage = theStage;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

}
