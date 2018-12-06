import java.io.FileNotFoundException;

import javax.swing.Box.Filler;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	public void start(Stage theStage) throws FileNotFoundException {
		Timer timer = new Timer();
		theStage.setTitle("BulletGod");

		Pane root1 = new Pane();
		Pane root2 = new Pane();
		Scene theScene1 = new Scene(root1, 800, 600);

		Scene theScene2 = new Scene(root2, 800, 600);
		theStage.setScene(theScene1);
		theStage.setResizable(false);
		theStage.setAlwaysOnTop(false);
		// root.getChildren().add(new Rectangle(300, 300,Color.BLUE)) ;
		theScene1.setOnMouseClicked(e -> {
			theStage.setScene(theScene2);
		});
		
		theScene2.setOnMouseClicked(e -> {
			theStage.setScene(theScene1);
		});
		
		GameMenu GameMenu = new GameMenu(root1,theScene2,theStage);
		GameMenu.drawBoard();
		EventManager GamePane = new EventManager(root2,theScene1,theStage);

	

		GamePane.drawBoard();

		// ft.setAutoReverse(true);
		 
		theScene2.addEventHandler(KeyEvent.KEY_PRESSED, event -> GamePane.MoveUnitOne(event));
		theScene2.addEventHandler(KeyEvent.KEY_PRESSED, event -> GamePane.MoveUnitTwo(event));
		theScene2.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
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
