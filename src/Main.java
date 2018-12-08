import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

	public void start(Stage theStage) throws FileNotFoundException {
		Timer timer = new Timer();
		theStage.setTitle("BulletGod");

		Pane PaneMenu = new Pane();
		Pane PaneGame = new Pane();
		Scene MenuScene = new Scene(PaneMenu, 800, 600);
		Scene GameScene = new Scene(PaneGame, 800, 600);
		theStage.setScene(MenuScene);
		theStage.setResizable(false);
		theStage.setAlwaysOnTop(false);
		// root.getChildren().add(new Rectangle(300, 300,Color.BLUE)) ;

		GameScene.setOnMouseClicked(e -> {

			theStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				public void handle(WindowEvent t) {
					Platform.exit();

				}
			});

		});

		GameMenu GameMenu = new GameMenu(PaneMenu, GameScene, theStage);
		GameMenu.drawBoard();
		EventManager GamePane = new EventManager(PaneGame, MenuScene, theStage);
		GamePane.drawBoard();

		// ft.setAutoReverse(true);

		GameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			try {
				GamePane.MoveUnitOne(event);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			try {
				GamePane.MoveUnitTwo(event);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		GameScene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
			try {
				GamePane.fireOne(event);
			} catch (FileNotFoundException A) {
				// TODO Auto-generated catch block
				A.printStackTrace();
			}
		});

		// theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.fireTwo(event));
		timer.start();

		theStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
