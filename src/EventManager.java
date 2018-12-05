

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
	private Test test;
	private Test toot;
	private int step;
	private final static int STEP_UP=-100;
	private final static int STEP_DOWN=100;
	public ArrayList<Bullet> bulletList;
	private boolean gg=true;
	//private SleepThread sleep=new SleepThread();
	//private SleepThread sleep2=new SleepThread();
	
	
	
	public EventManager(Pane root)
	{
		this.root=root;
		this.test=new Test(120,300);
		this.toot=new Test(680,300);
		bulletList=new ArrayList<Bullet>();
	}
	
	void drawBoard()
	{
		this.root.getChildren().add(test);
		this.root.getChildren().add(toot);
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
        
        double a=test.getCenterY();
        if(test.getCenterY()+step>=100 && test.getCenterY()+step<=500)
        {
        	this.root.getChildren().remove(test);
            test=new Test(120,a+step);
            this.root.getChildren().add(test);
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
        
        double a=toot.getCenterY();
        if(toot.getCenterY()+step>=100 && toot.getCenterY()+step<=500)
        {
        	this.root.getChildren().remove(toot);
            toot=new Test(680,a+step);
            this.root.getChildren().add(toot);
        }
        
        step=0;
        //sleep.run();
        
       
       
    
	}
	void fireOne(KeyEvent event)
	{	if(event.getCode()==KeyCode.D)
	{
		Bullet v=new Bullet(test.getCenterX(),test.getCenterY(),1);
		bulletList.add(v);
		root.getChildren().add(v.bullet);
	}
	else if(event.getCode()==KeyCode.LEFT)
		{
			Bullet v=new Bullet(toot.getCenterX(),toot.getCenterY(),-1);
			bulletList.add(v);
			root.getChildren().add(v.bullet);
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
								
								if(x.bullet.getX()<=800 && x.bullet.getX()>=0)
							{
									x.update();
							}
								else
								{
									x.bullet.setVisible(false);
								}
								
							}
							
						}
						});
					
					ArrayList<Bullet> A=(ArrayList<Bullet>) bulletList.clone();
					for(int i=bulletList.size()-1;i!=-1;i--)
					{
						if(bulletList.get(i).bullet.getX()>=800 && bulletList.get(i).bullet.getX()<=0 )
						{
							bulletList.remove(i);
						}
					}
					bulletList=(ArrayList<Bullet>) A.clone();
					
					
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
