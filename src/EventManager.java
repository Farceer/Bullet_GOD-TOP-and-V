

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class EventManager {
		
	private Pane root;
	private Unit test;
	private Unit toot;
	private int step;
	private final static int STEP_UP=-100;
	private final static int STEP_DOWN=100;
	public static ArrayList<Bullet> bulletList;
	private boolean gg=true;
	private Label labelOne;
	private Label labelTwo;
	public static int hpOne;
	public static int hpTwo;
	
	
	
	
	public EventManager(Pane root)
	{
		this.root=root;
		this.test=new Unit(120,300);
		this.toot=new Unit(680,300);
		bulletList=new ArrayList<Bullet>();
	}
	
	void drawBoard()
	{
		this.root.getChildren().add(test.unit);
		this.root.getChildren().add(toot.unit);
		hpOne=test.hp;
		hpTwo=toot.hp;
		labelOne=new Label(Integer.toString(test.hp));
		labelOne.setLayoutX(50);
		labelOne.setLayoutY(50);
		
		
		this.root.getChildren().add(labelOne);
		
		
		labelOne=new Label(Integer.toString(1));
		labelOne.setLayoutX(50);
		labelOne.setLayoutY(50);
	
		
		this.root.getChildren().add(labelOne);

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
        
        double a=test.unit.getCenterY();
        if(test.unit.getCenterY()+step>=100 && test.unit.getCenterY()+step<=500)
        {
        	this.root.getChildren().remove(test.unit);
            test=new Unit(120,a+step);
            this.root.getChildren().add(test.unit);
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
        
        double a=toot.unit.getCenterY();
        if(toot.unit.getCenterY()+step>=100 && toot.unit.getCenterY()+step<=500)
        {
        	this.root.getChildren().remove(toot.unit);
            toot=new Unit(680,a+step);
            this.root.getChildren().add(toot.unit);
        }
        
        step=0;
        //sleep.run();
        
       
       
    
	}
<<<<<<< HEAD
	void fireOne(KeyEvent event)
	{	
			
		if(event.getCode()==KeyCode.D)
	{
		Bullet v=new Bullet(test.unit.getCenterX(),test.unit.getCenterY(),1);
=======
	void fireOne(KeyEvent event) throws FileNotFoundException
	{	if(event.getCode()==KeyCode.D)
	{
		FileInputStream inputstream = new FileInputStream("C:\\Users\\Warit\\eclipse-workspace\\-Bullet_GOD-TOP-and-V\\src\\res\\BlueShip\\Blue Ship bullet_.png");
		Bullet v=new Bullet(test.getCenterX(),test.getCenterY(),1,inputstream);
>>>>>>> cd6c1cd52ad44431ef340ea7952a99774948986c
		bulletList.add(v);
		root.getChildren().add(v.getImageView());
	}
	else if(event.getCode()==KeyCode.LEFT)
		{
<<<<<<< HEAD
			Bullet v=new Bullet(toot.unit.getCenterX(),toot.unit.getCenterY(),-1);
=======
			FileInputStream inputstream = new FileInputStream("C:\\Users\\Warit\\eclipse-workspace\\-Bullet_GOD-TOP-and-V\\src\\res\\RedShip\\Red Ship bullet.png");
			Bullet v=new Bullet(toot.getCenterX(),toot.getCenterY(),-1,inputstream);
>>>>>>> cd6c1cd52ad44431ef340ea7952a99774948986c
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
								
								if(x.bullet.getX()==test.unit.getCenterX() && x.bullet.getY()==test.unit.getCenterY() && x.bullet.isVisible())
								{
									x.bullet.setVisible(false);
									hpOne-=1;
						
									test.setHp(hpOne);
									System.out.println(test.hp);
									  
								}
								
								
								
							}
							
							for(Bullet x:bulletList)
							{	if(x.getImageView().getX()>=800 && x.getImageView().getX()<=0)
							{
								bulletList.remove(x);
							}
								
							}
							
						}
						});
					
			
					
					Thread.sleep(10);
					
					
					
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
}
