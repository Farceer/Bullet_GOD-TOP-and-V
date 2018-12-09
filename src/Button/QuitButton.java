package Button;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class QuitButton extends ButtonPress {
	private Stage theStage;
	public QuitButton(ImageView image,Stage theStage) {
		super(image);
		this.setTheStage(theStage);
		// TODO Auto-generated constructor stub
		DropShadow shadow = new DropShadow();
		this.setOnMouseClicked((event) -> {

			Platform.exit();
			this.getTheStage().close();
			System.exit(0);

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

}
