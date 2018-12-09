import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

		private Stage theStage;
	public void start(Stage theStage) throws FileNotFoundException {
		Timer timer = new Timer();
		theStage.setTitle("BulletGod");
		this.theStage = theStage;
		Pane PaneMenu = new Pane();
		Pane PaneGame = new Pane();
		Pane Red =new Pane();
		Pane Blue =new Pane();
		Scene RedWin =new Scene(Red,800,600);
		Scene BlueWin = new Scene(Blue,800,600);
		Scene MenuScene = new Scene(PaneMenu, 800, 600);
		
		
		theStage.setScene(MenuScene);
		theStage.setResizable(true);
		theStage.setAlwaysOnTop(false);
		Scene GameScene = new Scene(PaneGame, 800, 600);

		GameMenu GameMenu = new GameMenu(PaneMenu, GameScene, theStage,0);
		GameMenu RedMenu =new GameMenu(Red,GameScene,theStage,1);
		GameMenu BlueMenu =new GameMenu(Blue,GameScene,theStage,2);
		RedMenu.drawBoard();
		BlueMenu.drawBoard();
		GameMenu.drawBoard();
		EventManager GamePane = new EventManager(PaneGame, MenuScene, theStage,RedWin,BlueWin,Red,Blue);


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
		
		theStage.setOnCloseRequest(e->{
			Platform.exit();
			theStage.close();
			System.exit(0);
		});
		timer.start();

		theStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public Stage getTheStage() {
		return theStage;
	}

}
