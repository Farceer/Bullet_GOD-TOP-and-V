class Timer extends Thread{
	public int time=0;
	
	public void run(){
		while(true)
		{
		try{
			Thread.sleep(1000);
			time+=1;
			System.out.println(time);
			}	
		catch(InterruptedException e){}
}
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}