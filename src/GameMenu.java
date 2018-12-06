import java.io.FileInputStream;
import java.io.InputStream;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameMenu {
	private Pane root ;
	private Button   Start ; 
	private Button  Credit ; 
	private Button Exit ;
	private ImageView MenuBG ;
	private VBox box;
	private Rectangle bg;
	//private FileInputStream BlueBomb=new FileInputStream("res/BlueShip/Blue Ship exposive.png");
	public GameMenu(Pane root) {
		this.root = root ; 
		Rectangle bg = new Rectangle(800, 600,Color.BLUE);
		Rectangle Text = new Rectangle(400, 200,Color.BLUE);
		bg.setOpacity(0.5);
		this.root.getChildren().add(bg);
		Start = new Button("Start");
		Credit = new Button("Credit");
		Exit = new Button("Exit");
		
		Start.setPrefSize(150, 30);
		Credit.setPrefSize(150, 30);
		Exit.setPrefSize(150, 30);
		
		VBox box = new VBox(35,Start,Credit,Exit);
		box.setAlignment(Pos.CENTER);
		box.setTranslateX(325);
		box.setTranslateY(300);
		this.root.getChildren().add(box);
		
		Start.setOnMouseClicked((event)->{
			Start.setPrefSize(100, 100);
		});
		
		Start.setOnMouseMoved((event)->{
			Start.setPrefSize(125, 125);
		});
		
		Start.setOnMouseExited((event)->{
			Start.setPrefSize(100, 30);
		});
		
		Credit.setOnMouseClicked((event)->{
			Credit.setPrefSize(100, 100);
		});
		
		Credit.setOnMouseMoved((event)->{
			Credit.setPrefSize(125, 125);
		});
		
		Credit.setOnMouseExited((event)->{
			Credit.setPrefSize(100, 30);
		});
		
		Exit.setOnMouseClicked((event)->{
			Exit.setPrefSize(100, 100);
		});
		
		Exit.setOnMouseMoved((event)->{
			Exit.setPrefSize(125, 125);
		});
		
		Exit.setOnMouseExited((event)->{
			Exit.setPrefSize(100, 30);
		});
	} 
	
	
	
	void drawBoard()
	{
		this.root.getChildren().add(bg) ;
	}
	
	
}
