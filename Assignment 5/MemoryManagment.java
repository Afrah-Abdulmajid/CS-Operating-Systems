import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java. util.Scanner;
import java.lang.System;
import java.util.Set;
import java.util.Map.Entry;
import java. util.Scanner;
import java.lang.System;
import java.lang.String;

public class MemoryManagment{
	ArrayList<TreeMap> freeList;
	ArrayList<TreeMap> mempartition;
	ArrayList<TreeMap> removedJob;
	Scanner in = new Scanner(System.in);
	TreeMap<Integer,Integer> flist;
	int j;
	int i;
	int memSize; 
	int njobs;
	public MemoryManagment(){
		flist = new TreeMap<Integer,Integer>();
		freeList = new ArrayList<TreeMap>();
		mempartition = new ArrayList<TreeMap>();
		removedJob = new ArrayList<TreeMap>();
		System.out.println("What is the Memory size you would like? ");
		memSize = in.nextInt();
		 j = 0;
		 i = 0;
		flist.put(memSize,j);
		freeList.add(flist);
		String dummy = in.nextLine();
		System.out.println("How many jobs would you like to enter? ");
		njobs = in.nextInt();
		for(int p =0;p<njobs;p++){
			TreeMap<String,Integer> initial = new TreeMap<String,Integer>();
			initial.put("0",0);
			removedJob.add(p,initial);
		}
		
		String response = "yes";
		while(response.equals("yes")){
			System.out.println("Would you like to add or remove a job? ");
			String response1 = in.next();
			if(response1.equals("add")){
				addJob();
			}
			else if(response1.equals("remove")){
				removeJob();
			}
			System.out.println("Would you like to continue? yes/no: ");
			response = in.next();
	}
	}
	public static void main(String[] args){
		new MemoryManagment();
	}

	public void addJob(){
		while(i<njobs){
			System.out.println("What is the job you would like to input? ");
			String jobName = in.next();
			System.out.println("What is the size of the job you like to input? ");
			int jobSize = in.nextInt();
			TreeMap<String,Integer> job = new TreeMap<String, Integer >();
			job.put(jobName,jobSize);
			if(mempartition.contains(job)){
				System.out.println("Job already exists. ");
			}
			else if (removedJob.contains(job)){
				int oldindex = removedJob.indexOf(job);
				mempartition.add(oldindex,job);
				i++;
				System.out.println("Memory partitions: ");
				System.out.println(mempartition);
				removedJob.remove(oldindex);
			}
			else{
				if(freeList.size() == 1){
					freeList.remove(0);
					flist.remove(memSize,j);
					j++;
					if(memSize>= jobSize){
					memSize = memSize-jobSize;
					flist.put(memSize,j);
					freeList.add(flist);
					mempartition.add(job);
					i++;
					System.out.println("Memory partitions: ");
					System.out.println(mempartition);
					System.out.println("FreeList: ");
					System.out.println(freeList);
				}
					else{
						System.out.println("Job is too big for memory. ");
					}
				}
				else if(freeList.size()>1){
					ArrayList<TreeMap> sortList = new ArrayList<TreeMap>();
					sortList = sortedAList(freeList);
					System.out.println(freeList.size());
					for(int b =0;b<sortList.size();b++){
						int key = (int) (sortList.get(b).firstKey());
						int val = (int) (sortList.get(b).get(key));
						System.out.println(key);
						if(key >= jobSize){
							TreeMap<Integer,Integer> nflist = new TreeMap<Integer,Integer>();
							sortList.remove(b);
							if(key-jobSize > 0){
								nflist.put((key-jobSize),val);
								sortList.add(nflist);
								sortList = sortedAList(sortList);
							}
							mempartition.add(val,job);
							sortList = sortedAList(sortList);
						}
					}
					i++;
					System.out.println("Memory partitions: ");
					System.out.println(mempartition);
					System.out.println("Free List: ");
					System.out.println(sortList);

				}
			
			}
		}
		}
	public static ArrayList<TreeMap> sortedAList(ArrayList<TreeMap> fL){
		int min = (int) ((fL.get(0)).firstKey());
		ArrayList<TreeMap> sList = new ArrayList<TreeMap>();
		
		while(!fL.isEmpty()){
			int index =0;
			for(int x = 0; x<fL.size();x++){
	
				if((int)((fL.get(x)).firstKey()) <= min){
					min = (int)((fL.get(x)).firstKey());
					index = x;
				}
			}
				TreeMap<Integer,Integer> temp = new TreeMap<Integer,Integer>();
				temp = fL.remove(index);			
				sList.add(temp);
			}
			
	return sList;
}


public void removeJob(){
	System.out.println("what is the name of the job you would like to remove? ");
	String rjob = in.next();
	
	for(int y = 0;y<mempartition.size(); y++){
		if(mempartition.get(y).containsKey(rjob)){
			TreeMap<String,Integer> temp = new TreeMap<String,Integer>();
			TreeMap<Integer,Integer> newfList = new TreeMap<Integer,Integer>();
			String key = (String) mempartition.get(y).firstKey();
			int val = (int) (mempartition.get(y)).get(key);
			temp = mempartition.get(y);
			removedJob.add(y,temp);
			newfList.put(val,y);
			freeList.add(newfList);
			System.out.println("Free List: ");
			System.out.println(freeList);
			mempartition.remove(temp);
			i--;
		}
		else{
			System.out.println("Job does not exist. ");
		}
	}
	System.out.println("Memory partitions: ");
	System.out.println(mempartition);
	

}

}