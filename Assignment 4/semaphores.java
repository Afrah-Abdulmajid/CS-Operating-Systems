
import java. util.Scanner;
import java.lang.System;
import java.lang.System;
import java.util.concurrent.Semaphore;
import java.util.LinkedList;
import java.util.Queue;

class semaphores{
	
	Queue <Process> queue;
	Process p ;
	
	private static Semaphore s; 
	public semaphores(){
		s = new Semaphore(1) ;
		
		queue = new LinkedList<Process>();

	}
	public Semaphore getSemaphore(){
		return s;
	}
	public Process getProcess(Process h){
		p=h;
		return p;
	}

	public void wait(Semaphore sem,Process p){
		
		if(sem.availablePermits() == 0){
			try{
			sem.acquire();
			queue.add(p);
		}
	
		catch(Exception e){
			e.printStackTrace();
	}	


	}
}
	public Queue<Process> getQProcess(){
		return queue;
	}
	public void signal(Semaphore sem, Process p){
		if(sem.availablePermits()== 0){
			try{
			sem.release();
			if(!queue.isEmpty())
				queue.remove();
		}
		
	
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
	
	}

	
