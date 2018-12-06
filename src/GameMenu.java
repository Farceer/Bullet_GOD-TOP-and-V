import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GameMenu extends Pane {
	private Pane root;
	private Button Start;
	private Button Credit;
	private Button Exit;

	private VBox box;
	private Rectangle bg;
	private Scene Menuscene;
	private Stage theStage;

	private ImageView MenuBG;// Rectangle Text = new Rectangle(400, 200,Color.BLUE); GAME TITLE

	public GameMenu(Pane root, Scene scene, Stage theStage) {

		this.root = root;
		bg = new Rectangle(800, 600, Color.BLUE);
		bg.setOpacity(0.01);

		Start = new Button("Start");
		Credit = new Button("Credit");
		Exit = new Button("Exit");

		Start.setPrefSize(150, 30);
		Credit.setPrefSize(150, 30);
		Exit.setPrefSize(150, 30);

		box = new VBox(35, Start, Credit, Exit);
		box.setAlignment(Pos.CENTER);
		box.setTranslateX(325);
		box.setTranslateY(300);
		Menuscene = scene ;
		this.theStage = theStage ;
		Start.setOnMouseClicked((event) -> {
			theStage.setScene(scene);
		});

		Start.setOnMouseMoved((event) -> {
			Start.setPrefSize(150, 75);
		});

		Start.setOnMouseExited((event) -> {
			Start.setPrefSize(150, 30);

		});

	}

	void drawBoard() {
		root.getChildren().addAll(bg, box);

	}

 
	public Stage getTheStage() {
		return theStage;
	}

	public Scene getMenuscene() {
		return Menuscene;
	}

}
