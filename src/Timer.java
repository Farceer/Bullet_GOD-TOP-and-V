class Timer extends Thread{
	public static int TIME;
	
	public void run(){
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