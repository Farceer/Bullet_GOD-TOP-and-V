import java.io.FileNotFoundException;
import java.net.URL;

import javafx.application.Platform;
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

public class GameMenu extends Pane {
	private Pane root;
	private Button Start;
	private Button Credit;
	private Button Quit;
	private VBox box;
	private Scene Menuscene;
	private Stage theStage;
	 ImageView Menu, GameTitle, StartGUI, QuitGUI;// Rectangle Text = new Rectangle(400, 200,Color.BLUE); GAME
															// TITLE
	public GameMenu(Pane root, Scene scene, Stage theStage) throws FileNotFoundException {
		this.root = root;
//		String GameTitle_path = ClassLoader.getSystemResource("BG/Bullet GOD title.png").toString();
//		GameTitle  = new ImageView(new Image(GameTitle_path));
//		String StartGUI_path = ClassLoader.getSystemResource("BG/Start.png").toString();
//		StartGUI = new ImageView(new Image(StartGUI_path));
//		String QuitGUI_path = ClassLoader.getSystemResource("BG/Quit.png").toString();
//		QuitGUI= new ImageView(new Image(QuitGUI_path));
//		String Menu_path = ClassLoader.getSystemResource("BG/MenuBG.png").toString();
//		Menu = new ImageView(new Image(Menu_path));
		ImageLoader loader = new ImageLoader();
		Menu      = loader.getMenu();
		GameTitle =loader.getGameTitle();
		StartGUI = loader.getStartGUI();
		QuitGUI  = loader.getQuitGUI();
		
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
		root.getChildren().addAll(Menu,box,GameTitle);
	}


	public Stage getTheStage() {
		return theStage;
	}

	public Scene getMenuscene() {
		return Menuscene;
	}

}
