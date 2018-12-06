import java.io.FileNotFoundException;

import javax.swing.Box.Filler;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

	public void start(Stage theStage) throws FileNotFoundException {
		//Timer timer = new Timer();
		theStage.setTitle("BulletGod");
		Pane root = new Pane();
		Scene theScene = new Scene(root, 800, 600);
		theStage.setScene(theScene);
		theStage.setResizable(false);
		//root.getChildren().add(new Rectangle(300, 300,Color.BLUE)) ;
		GameMenu GameMenu = new GameMenu(root);
		GameMenu.drawBoard();
		
//        
//        if ( GameMenu.isGameStart()  ) {
//
//            EventManager GamePane = new EventManager(root);
//            GamePane.drawBoard();
//           
//            Rectangle rect = new Rectangle (100, 40, 100, 100);
//            root.getChildren().add(rect);
//            rect.setArcHeight(50);
//            rect.setArcWidth(50);
//            rect.setFill(Color.VIOLET);
//            
//            FadeTransition ft = new FadeTransition(Duration.millis(300), rect);
//            ft.setFromValue(1.0);
//            ft.setToValue(0);
//            ft.setCycleCount(1);
//            ft.play();
//            
//            //ft.setAutoReverse(true);
//        
//             		
//            
//            
//        
//            	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->GamePane.MoveUnitOne(event));
//            	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->GamePane.MoveUnitTwo(event));
//            	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->{
//    				try {
//    					GamePane.fireOne(event);
//    				} catch (FileNotFoundException e) {
//    					// TODO Auto-generated catch block
//    					e.printStackTrace();
//    				}
//    			});
//        }
        
		// theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.fireTwo(event));
		//timer.start();
		theStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}