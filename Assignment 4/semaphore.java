
import java.util.Scanner;
import java.lang.System;
import java.lang.System;
import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;

class semaphores{
	
	Queue <Process> queue;
	Process p;
	Semaphore ss ;
	private static Semaphore s; 
	public semaphores(){
		s = new Semaphore(1) ;
		queue = new LinkedList<Process>();

	}
	public static Semaphore getSemaphore(){
		return s;
	}


	public void wait(Semaphore sem ){
		sem.acquire();
		if(sem.availablePermits() == 0){
			queue.add(process);

	}
}
	public Queue getQProcess(){
		return queue;
	}
	public void signal(Semaphore sem){
		sem.release();
		if(sem.availablePermits()==1){
			queue.remove();
		}
		}
	}

	
