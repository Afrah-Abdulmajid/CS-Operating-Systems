import java. util.Scanner;
import java.lang.System;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class addition{
	semaphores semph;

	public addition(semaphores s){
		semph = s;
	}
	int n = 0;
	int val = 0;
	String [] criticalResource = new String[10];
	Scanner in = new Scanner(System.in);
	int space = 0;



	public void addChar(Process p, String[] k){
		semaphores currSem = p.getSemp();
			if(space<k.length){
				System.out.println("What is the Character you would like to add: ");
				String word = in.nextLine();
				System.out.println(p.getProcname() + "is waiting");
				k[space] = word;
				space ++;
				System.out.println(" " + word + " Has been allocated a region");
				System.out.println(p.getProcname() + " is signalling");
				System.out.println("current output of the critical Resource: ");
				System.out.print("[");
				for(int i = 0; i<k.length ; i++){
					System.out.print(k[i] + " ");
				}
				System.out.print("]");
				///p.finishUp();
			
	}	else
			p.finishUp();
	}
}


