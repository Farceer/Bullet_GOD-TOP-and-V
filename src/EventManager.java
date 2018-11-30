

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class EventManager {
		
	private Pane root;
	private Test test;
	private Test toot;
	private int step;
	private SleepThread sleep=new SleepThread();
	private SleepThread sleep2=new SleepThread();
	
	
	
	public EventManager(Pane root)
	{
		this.root=root;
		this.test=new Test(120,300);
		this.toot=new Test(680,300);
	}
	
	void drawBoard()
	{
		this.root.getChildren().add(test);
		this.root.getChildren().add(toot);
	}
	
	void MoveUnitOne(KeyEvent event)
	{
		
		
        if(event.getCode()==KeyCode.W) {
        	step=-100;
        }
        else if(event.getCode()==KeyCode.S)
        {
        
        	step=100;
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
}
