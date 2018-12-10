import javafx.scene.media.MediaPlayer;

class Timer extends Thread{
	public static int TIME;
	ResouceLoader loader = new ResouceLoader();

	public void run(){
		MediaPlayer startMP=new MediaPlayer(loader.getBgMusic());
		startMP.setCycleCount(10);
		startMP.play();
	
		while(true)
		{
		try{
		
			Thread.sleep(200);
			TIME+=1;
			//System.out.println(time);
			}	
		catch(InterruptedException e){}
}
	}



	
	
}