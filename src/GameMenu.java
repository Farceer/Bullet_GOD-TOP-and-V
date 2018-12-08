import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

public class GameMenu extends Pane {
	private Pane root;
	private Button Start;
	private Button Credit;
	private Button Quit;
	private VBox box;
	private Scene Menuscene;
	private Stage theStage;
	private FileInputStream BG = new FileInputStream("res/BG/MenuBG.png");
	private FileInputStream TitleBG = new FileInputStream("res/BG/Bullet GOD title.png");
	private FileInputStream StartBG = new FileInputStream("res/BG/Start.png");
	private FileInputStream QuitBG = new FileInputStream("res/BG/Quit.png");
	private ImageView Menu, GameTitle, StartGUI, QuitGUI;// Rectangle Text = new Rectangle(400, 200,Color.BLUE); GAME
															// TITLE

	public GameMenu(Pane root, Scene scene, Stage theStage) throws FileNotFoundException {

		this.root = root;
		Menu = new ImageView(new Image(BG));
		Menu.setFitHeight(600);
		Menu.setFitWidth(800);

		GameTitle = new ImageView(new Image(TitleBG));
		GameTitle.setFitHeight(200);
		GameTitle.setFitWidth(371.4285);
		GameTitle.setTranslateX(200);
		GameTitle.setTranslateY(100);

		StartGUI = new ImageView(new Image(StartBG));
		StartGUI.setFitHeight(30);
		StartGUI.setFitWidth(150);

		QuitGUI = new ImageView(new Image(QuitBG));
		QuitGUI.setFitHeight(30);
		QuitGUI.setFitWidth(150);

		Start = new Button("", StartGUI);
		Start.setBackground(null);
		Credit = new Button("Credit");

		Quit = new Button("", QuitGUI);
		Quit.setBackground(null);
		Start.setPrefSize(150, 30);
		Credit.setPrefSize(150, 30);
		Quit.setPrefSize(150, 30);

		box = new VBox(35, Start, Quit);
		box.setAlignment(Pos.CENTER);
		box.setTranslateX(325);
		box.setTranslateY(350);
		Menuscene = scene;
		this.theStage = theStage;

		DropShadow shadow = new DropShadow();
		Start.setOnMouseClicked((event) -> {

			theStage.setScene(scene);
		});

		Start.setOnMouseMoved((event) -> {
			Start.setEffect(shadow);
			Start.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));

		});

		Start.setOnMouseExited((event) -> {

			Start.setBackground(null);
			Start.setEffect(null);
		});

		Quit.setOnMouseClicked((event) -> {
			
			Platform.exit();
			theStage.close();
			System.exit(0);


		});

		Quit.setOnMouseMoved((event) -> {
			Quit.setEffect(shadow);
			Quit.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, null)));

		});

		Quit.setOnMouseExited((event) -> {

			Quit.setBackground(null);
			Quit.setEffect(null);
		});

	}

	void drawBoard() {
		root.getChildren().addAll(Menu, box, GameTitle);

	}

	public Stage getTheStage() {
		return theStage;
	}

	public Scene getMenuscene() {
		return Menuscene;
	}

}
