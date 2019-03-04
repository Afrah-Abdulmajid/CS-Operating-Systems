import java.lang.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Process extends Thread{
	Thread t;
	static semaphores sm = new semaphores();
	addition add = new addition(sm);
	String name;
	boolean done;
	String[] storage = new String[10];
	public Process(String procName,String[] loc){
		storage = loc;
		
		name = procName;
		
		done = false;
		
}

	public String getProcname(){
		return name;
	}
	public Thread getThread(){
		return t;
	}
	public addition getAddition(){
		return add;
	}
	public semaphores getSemp(){
		return sm;
	}

	public void run(){
		Semaphore sp = sm.getSemaphore();
		while(!done){
		
		if(sp.availablePermits() == 1){
			
		try{
				
			//System.out.println("@@@@@@@@@@@@@@@@");
			 
				//sm.wait(sp,this);
				add.addChar(this, storage);
			
				//sm.wait(sp,this);
				// try{
				// //Thread.sleep(5000);
				// }
				// catch(InterruptedException e){
				// 	e.printStackTrace();
				// }
			}	
			
		finally{
			
			sm.signal(sp,this);
		}
		}
		else{
				System.out.println("waiting **********");
				//sm.wait(sp,this);
				
					sp.release();
				
			

		
		}
		
		
		}
	}
	
	public void finishUp(){
		done = true;
	}
	public static void main(String[] args){
		String [] a = new String[10];
		int i = 0;
		Thread[] loop = new Thread [2];
			Thread t  = new Process("proc1",a);
			Thread t2 = new Process("proc2",a);
			t.start();
			t2.start();

			try{
				t.join();
				
			}
			catch(Exception e){
					e.printStackTrace();
				}

			
			try{
				
				t2.join();
			}
			catch(Exception e){
					e.printStackTrace();
				}	
			/*loop[0] = t;
			loop[1] = t2;
			for(int x = 0; x<2;x++){
				loop[x].start();

				//loop[x].stop();
			}*/
			//t.start();	
			//t2.start();
				// try{
				// t.sleep(3000);
				// }
				// catch(Exception e){
				// 	e.printStackTrace();
				// }

			
				/*try{
				t2.sleep(3000);
				}
				catch(Exception e){
					e.printStackTrace();
				}*/
			

	}

}

