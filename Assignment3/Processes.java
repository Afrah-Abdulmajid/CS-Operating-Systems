import java.util.LinkedList;
import java.util.Queue;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java. util.Scanner;
import java.lang.System;
import java.util.Set;
import java.util.Map.Entry;
import java. util.Scanner;
import java.lang.System;

public class Processes {
	TreeMap <String,Integer> r_queue;
	Queue <String> s_queue;
	TreeMap<String,Integer> proc; 
	int highestPriority; 
	int val;
	String str;
	String cr ;
	public Processes(){
		val = 0;
		str = " ";
		cr = "";
		r_queue= new TreeMap <String,Integer>();
		s_queue= new LinkedList <String>();
		proc = new TreeMap<String,Integer>();
		highestPriority = 0;
		Scanner in = new Scanner(System.in);
		String response = "yes";
		
		while(response.equals("yes")){
			System.out.println("Would you like to create, resume or kill?");
			String cmd = in.next();
			cmd.toLowerCase();
			if(cmd.equals("create")){
				System.out.println("What is process name?");
				String para1 = in.next();
				String dummy = in.nextLine();
				System.out.println("What is its priority?");
				int para2 = in.nextInt();
				create(para1,para2);

			}
			else if(cmd.equals("resume")){
				System.out.println("What is the name of the process?");
				String para3 = in.next();
				String dummy = in.nextLine();
				resume(para3);
				}
			else if(cmd.equals("kill")){
				System.out.println("What is the name of the process?");
				String para4 = in.next();
				String dummy = in.nextLine();
				kill(para4);
			}
			System.out.println("Do you want to continue? yes/no");
			response = in.next();
			String dummy = in.nextLine();
			response = response.toLowerCase();
		}
		
	}

	public static void main(String[] args){
		new Processes();
	}

	public void create( String procName, int priority){
		proc.put(procName,priority);
		if (s_queue.isEmpty())
			s_queue.add(procName);
		
		else{
			if(s_queue.contains(procName))
					System.out.println("Error: The Process name already exsists");
							
			else{
				s_queue.add(procName);
			}	
			}
	}

	public void resume(String procName){
		if(s_queue.contains(procName)){
			s_queue.remove(procName);
			for(String item : proc.keySet()){
				if(item.equals(procName)){
					int val = proc.get(procName);
					r_queue.put(item,val);	
				}
			}
		//System.out.println(readyTemp);
		}
		else
			System.out.println("Error: The Process name is not in the Suspended Queue");
			
		rescheduler();
		for(Map.Entry<String,Integer> queue : r_queue.entrySet()){
				if(!queue.getKey().equals(""))
					System.out.println("Process name: " + queue.getKey());
				}		
	}

	public void kill(String procName){

		if(!s_queue.isEmpty()){
			if(s_queue.contains(procName)){
				s_queue.remove(procName);	
			}
		}
		else if(r_queue.containsKey(procName)){
					r_queue.remove(procName);
				}
		else if (procName.equals(cr)){
			cr=" ";
			highestPriority = 0;
		}
		else{
			System.out.println("The Process does not exsist");
			}

				
		rescheduler();
		for(Map.Entry<String,Integer> queue : r_queue.entrySet()){
				if(!queue.getKey().equals("")){
					System.out.println("The Current Process is " + cr);
					System.out.println("Process name: " + queue.getKey()); }
				}
}
public void rescheduler(){	
	val = highestPriority;
	str = cr;
	
		for (Integer  item : r_queue.values()){
			 if(item > highestPriority){
			 	highestPriority = item;
				 }
				}
		
			if(highestPriority > val){
				int oldval = val;
				val = highestPriority;
				r_queue.put(str,oldval);
				for(Map.Entry<String,Integer> entry : r_queue.entrySet()){
					if (entry.getValue() == highestPriority){
						cr = entry.getKey();
						str = cr;
						val = entry.getValue();	
						}
					}		
			}
			r_queue.remove(str);
		System.out.println("Contents of r_queue:");

		
		
		


		

}
}