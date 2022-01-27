package Threads;

public class myThread extends Thread
{
 	public void run()
 	{
  		System.out.println("Concurrent thread started running..");
}
 	public static void main( String args[] )
 	{
  		myThread mt = new  myThread();
  		mt.start();
 	}
}

