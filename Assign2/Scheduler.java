import java.util.Arrays;
import java.util.Random;
import java. util.Scanner;
import java.lang.System;


public class Scheduler
{
	

public static void main(String[] args){
	
		Scanner in = new Scanner(System.in);
		System.out.println("Would you like to Run the program? Type 'Run' or 'Stop'");
		String response = in.next();

		while(response.equals("Run") || response.equals("run")){	
			System.out.println("Please enter the Range:");
			int range = in.nextInt();

			int numbersSeed = seedGenerator(range);
			int[] numbers = new int [10];
			numbers = RandomNumberGenerator(numbersSeed,range);
			letterSequence(numbers);

			System.out.println("Would you like to continue running the program type 'Run', if not Type 'Stop': ");
			response = in.next();
	}



	}
	public static int[] RandomNumberGenerator(int seed,int range_num){
		int[] randomNumbers = new int [10];
		Random random = new Random();
		random.setSeed(seed);
		for(int x=0; x<10;x++){
			randomNumbers[x] = random.nextInt(range_num);
			System.out.print(randomNumbers[x] + " ");
		}
		System.out.println();
		return randomNumbers;
	}
	public static void printA(){
		String letter = "A";
		System.out.print(letter+ " ");
	}
	public static void printB(){
		String letter = "B";
		System.out.print(letter+ " ");
	}

	public static void letterSequence(int[] randomNums){
		String[] letters = new String[10];
		for(int y=0; y<randomNums.length; y++){
			if(randomNums[y] % 2 == 0){
				printA();
			}
			else{
				printB();
			}
		}
		System.out.println();
	}

	public static int seedGenerator(int range_seed){
		Random random_seed = new Random();
		int in_seed = random_seed.nextInt(range_seed-1);
		
		return in_seed;
	}

}