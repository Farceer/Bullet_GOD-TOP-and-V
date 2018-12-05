import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
 
public class Main extends Application 
{	
	
  
    public void start(Stage theStage) 
    {	Timer timer=new Timer();
        theStage.setTitle("BulletGod");
        Pane root = new Pane();
        Scene theScene = new Scene( root,800,600);
        theStage.setScene( theScene );
        
        theStage.setResizable(false);
        EventManager a = new EventManager(root);
        a.drawBoard();
        
        /*Test rect = new Test(120,100);
        /root.getChildren().add(rect);
      
        rect.setFill(Color.VIOLET);
    
        TranslateTransition tt = new TranslateTransition(Duration.seconds(0.2), rect);
        tt.setByX(560);
        tt.setCycleCount(1000);
        tt.setAutoReverse(true);
    
        tt.play();
    		*/
        //root.getChildren().add(new Bullet(100,100,1).bullet);
        
    
        	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.MoveUnitOne(event));
        	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.MoveUnitTwo(event));
        	theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.fireOne(event));
        	//theScene.addEventHandler(KeyEvent.KEY_PRESSED, event->a.fireTwo(event));
        timer.start();
        theStage.show();
       
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
 
    
}