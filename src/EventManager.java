

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

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
        double a = ShipLeft.getCenterY();;
        
      
      //************************************* Fix Center *************************************//
        if(ShipLeft.getCenterY()+step>=100 && ShipLeft.getCenterY()+step<=500)
        {
        	this.root.getChildren().remove(ShipLeft.getSpaceShip());
            ShipLeft=new SpaceShip(120,a+step,ShipLeftinputstream);
            this.root.getChildren().add(ShipLeft.getSpaceShip());
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
        double a=ShipRight.getCenterY();
      //************************************* Fix Center *************************************//
        if(ShipRight.getCenterY()+step>=100 && ShipRight.getCenterY()+step<=500)
        {
        	this.root.getChildren().remove(ShipRight.getSpaceShip());
            ShipRight=new SpaceShip(680,a+step,ShipRightinputstream);
            this.root.getChildren().add(ShipRight.getSpaceShip());
        }
        
        step=0;
        //sleep.run();
        
       
       
    
	}
	void fireOne(KeyEvent event) throws FileNotFoundException
	{	if(event.getCode()==KeyCode.D)
	{
		FileInputStream inputstream = new FileInputStream("res\\BlueShip\\Blue Ship bullet_.png");
		Bullet v=new Bullet(ShipLeft.getCenterX(),ShipLeft.getCenterY(),1,inputstream);
		bulletList.add(v);
		root.getChildren().add(v.getImageView());
	}
	else if(event.getCode()==KeyCode.LEFT)
		{
			FileInputStream inputstream = new FileInputStream("res/RedShip/Red Ship bullet.png");
			Bullet v=new Bullet(ShipRight.getCenterX(),ShipRight.getCenterY(),-1,inputstream);
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
										
									}
								}
								
								
								
							}
							
							for(int i=bulletList.size()-1;i!=-1;i--)
							{	if(bulletList.get(i).getImageView().getX()>=850 || bulletList.get(i).getImageView().getX()<=-20)
							{
								bulletList.remove(i);
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
	
	
	ArrayList<Bullet> getArray()
	{
		return bulletList;
	}

	public FileInputStream getShipLeftinputstream() {
		return ShipLeftinputstream;
	}

	public FileInputStream getShipRightinputstream() {
		return ShipRightinputstream;
	}
}
