
class SleepThread extends Thread{
public void run(){
try{
Thread.sleep(50);
}
catch(InterruptedException e){}
}
}