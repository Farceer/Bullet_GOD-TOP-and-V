

import java.io.FileNotFoundException;

import Button.ButtonChageStage;
import Button.QuitButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameMenu extends Pane {
	private Pane root;
	private Button Start;
	private int type = 0;
	// private Button Credit;
	private Button Quit;
	private VBox box;
	private Scene Menuscene;
	private Stage theStage;
	private ImageView Menu, GameTitle, StartGUI, QuitGUI;// Rectangle Text = new Rectangle(400, 200,Color.BLUE); GAME
													// TITLE

	public GameMenu(Pane root, Scene scene, Stage theStage, int x) throws FileNotFoundException {

		this.setType(x);
		this.root = root;
		this.theStage = theStage;
		ResouceLoader loader = new ResouceLoader();

		switch (type) {
		case 1:
			GameTitle = loader.getRedWin();
			StartGUI = loader.getReStartGUI();
			break;
		case 2:
			GameTitle = loader.getBlueWin();
			StartGUI = loader.getReStartGUI();
			break;
		case 10:
			GameTitle = loader.getBlueWin();
			StartGUI = loader.getReStartGUI();
			break;
		default:
			GameTitle = loader.getGameTitle();
			StartGUI = loader.getStartGUI();
			break;
		}
		Menu = loader.getMenu();
		this.Menuscene = scene;
		Quit = new QuitButton(loader.getQuitGUI(), theStage);
		Start = new ButtonChageStage(StartGUI, theStage, Menuscene);
		// Credit = new ButtonChageStage(StartGUI,theStage,Menuscene);
		box = new VBox(10, Start, Quit);
		box.setAlignment(Pos.CENTER);
		box.setTranslateX(325);
		box.setTranslateY(350);

	}

	public void drawBoard() {
		// root.getChildren().clear();
		if (getType() > 10) { // For Credit menu
			root.getChildren().addAll(Menu, GameTitle);
		} else {
			root.getChildren().addAll(Menu, box, GameTitle);
		}

	}

	public Stage getTheStage() {
		return theStage;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public ImageView getQuitGUI() {
		return QuitGUI;
	}

	public void setQuitGUI(ImageView quitGUI) {
		QuitGUI = quitGUI;
	}

}
