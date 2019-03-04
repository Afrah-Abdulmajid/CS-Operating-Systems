import java. util.Scanner;
import java.lang.System;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.lang.*;


class MutuaExclusion{
	public static void main(String[] args){
		Process t  = new Process("proc1");
		Process t2 = new Process("proc2");
		t.start();
		t2.start();

	}
}