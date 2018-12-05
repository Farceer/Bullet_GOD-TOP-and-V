

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class EventManager {
		
	private Pane root;
	private SpaceShip ShipLeft;
	private SpaceShip ShipRight;
	private int step;
	private final static int STEP_UP=-100;
	private final static int STEP_DOWN=100;
	public ArrayList<Bullet> bulletList;
	private boolean gg=true;
	//private SleepThread sleep=new SleepThread();
	//private SleepThread sleep2=new SleepThread();
	private FileInputStream ShipLeftinputstream = new FileInputStream("res/BlueShip/Blue Ship.png");
	private FileInputStream ShipRightinputstream = new FileInputStream("res/RedShip/Red Ship.jpg");
	private FileInputStream RedBomb=new FileInputStream("res/RedShip/Red Ship exposive.png");
	private FileInputStream BlueBomb=new FileInputStream("res/BlueShip/Blue Ship exposive.png");
	
	//getShipLeftinputstream();
	//getShipRigtinputstream();
	public EventManager(Pane root) throws FileNotFoundException
	{
		this.root=root;
		
		this.ShipLeft=new SpaceShip(120,300,ShipLeftinputstream);
		this.ShipRight=new SpaceShip(680,300,ShipRightinputstream);
		bulletList=new ArrayList<Bullet>();
	}
	
	void drawBoard()
	{
		this.root.getChildren().add(ShipLeft.getSpaceShip());
		this.root.getChildren().add(ShipRight.getSpaceShip());
	}
	
	void MoveUnitOne(KeyEvent event)
	{
		
        if(event.getCode()==KeyCode.W) {
        	step=STEP_UP;

        	
        }
        else if(event.getCode()==KeyCode.S)
        {
        
        	step=STEP_DOWN;
  

 
        }
        //************************************* Fix Center *************************************//
        double a = ShipLeft.getSpaceShip().getY();
        
      
      //************************************* Fix Center *************************************//
        if(ShipLeft.getY_axis()+step>=100 && ShipLeft.getY_axis()+step<=500)
        {
        	ShipLeft.setY_axis(ShipLeft.getY_axis()+step);
        }
      
        	
        
        step=0;
        //sleep2.run();
        
       
       
    
	}
	
	void MoveUnitTwo(KeyEvent event)
	{
		
		
        if(event.getCode()==KeyCode.UP) {
        	step=-100;
        }
        else if(event.getCode()==KeyCode.DOWN)
        {
        
        	step=100;
        }
      //************************************* Fix Center *************************************//
        double a=ShipRight.getSpaceShip().getY();
      //************************************* Fix Center *************************************//
        if(ShipRight.getSpaceShip().getY()+step>=100 && ShipRight.getSpaceShip().getY()+step<=500)
        {
        	ShipRight.setY_axis(ShipRight.getY_axis()+step);
        }
        
        step=0;
        //sleep.run();
        
       
       
    
	}
	void fireOne(KeyEvent event) throws FileNotFoundException
	{	if(event.getCode()==KeyCode.D)
	{
		FileInputStream inputstream = new FileInputStream("res\\BlueShip\\Blue Ship bullet_.png");
		Bullet v=new Bullet(ShipLeft.getSpaceShip().getX(),ShipLeft.getSpaceShip().getY(),1,inputstream);
		bulletList.add(v);
		root.getChildren().add(v.getImageView());
	}
	else if(event.getCode()==KeyCode.LEFT)
		{
			FileInputStream inputstream = new FileInputStream("res/RedShip/Red Ship bullet.png");
			Bullet v=new Bullet(ShipRight.getSpaceShip().getX(),ShipRight.getSpaceShip().getY(),-1,inputstream);
			bulletList.add(v);
			root.getChildren().add(v.getImageView());
		}
	if(gg)
	{	gg=false;
		Thread a = new Thread(() -> {
			while (true)
			{	
				
				try
				{	
					//for(int i=0;i!=bulletList.size();i++)
					//{
						//root.getChildren().add(bulletList.get(i).bullet);
				//	}
					
					
					Thread.sleep(10);
					Platform.runLater(new Runnable(){
						
						public void run() {
							for(Bullet x:bulletList)
								
								
							{	
								
								if(x.getImageView().getX()<=800 && x.getImageView().getX()>=0)
								{
									x.update();
								}
								else
								{
									x.getImageView().setVisible(false);
								}
								
								for(Bullet y:bulletList)
								{
									if(y.getDirection()==(-1)*x.getDirection() && y.getImageView().getX()==x.getImageView().getX() && x.getImageView().getY()==y.getImageView().getY() && x.getImageView().isVisible() && y.getImageView().isVisible())
									{
										x.getImageView().setVisible(false);
										y.getImageView().setVisible(false);
										
										Circle rect = new Circle(x.getX_axis()+25,x.getY_axis()+25,45);
								        root.getChildren().add(rect);
								      
								        rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
								    
								        FadeTransition ft = new FadeTransition(Duration.millis(200), rect);
								        ft.setFromValue(1);
								        ft.setToValue(0);
								        ft.setCycleCount(1);
								        ft.play();
										
									}
									
								}
								if(x.getX_axis()==ShipLeft.getX_axis() && x.getY_axis()==ShipLeft.getY_axis() && x.getImageView().isVisible())
								{
									x.getImageView().setVisible(false);
									  
								}
								
								
								if(x.getImageView().getX()>=850 || x.getImageView().getX()<=-20)
								{
									bulletList.remove(x);
								}
							}
							
							
		
						}
						});
					
					//ArrayList<Bullet> A=(ArrayList<Bullet>) bulletList.clone();
		
					
					
					//Thread.sleep(10);
					
					
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		
		a.start();
		
	}
	
	}
	
	void Bomb(double X_axis ,double Y_axis,FileInputStream inputstream)
	{
		
		
	}

	public FileInputStream getShipLeftinputstream() {

		return ShipLeftinputstream;
	}

	public FileInputStream getShipRightinputstream() {
		return ShipRightinputstream;
	}

}
