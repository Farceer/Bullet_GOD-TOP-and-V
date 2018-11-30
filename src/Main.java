import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
 
public class Main extends Application 
{	
	
  
    public void start(Stage theStage) 
    {
        theStage.setTitle("BulletGod");
        Pane root = new Pane();
        
        Scene theScene = new Scene( root,800,600);
        theStage.setScene( theScene );
        
        theStage.setResizable(false);
        EventManager a = new EventManager(root);
        a.drawBoard();
        	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.MoveUnitOne(event));
        	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.MoveUnitTwo(event));
        theStage.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
 
}