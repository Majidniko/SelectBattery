package com.dell;

import java.util.Scanner;

public class CalculateOptimize {
private static Scanner input;

public static void main(String[] arg) {
	long startTime = System.nanoTime();
    input = new Scanner(System.in);
    // get battery pack size that user need it
    System.out.println( "Please enter battery pack size in Kwh  ");
    String inputStr0 = input.next();
   // get how many battery user like to analyze an select
    System.out.println( "Please enter number of rows in file (a value between 1 to 85) for fit in  "+inputStr0+" Kwh");
    String inputStr = input.next();
    System.out.println( "Calculation started for  " + inputStr+" rows" );
    try {
    	// run analyzing and show results
    	 OjalgoPart.Optimize( (Integer.parseInt(inputStr0)),(Integer.parseInt(inputStr)));
    	 System.out.println("Top Optimal conditiones calculated in Kwh");
    }catch(Exception e){
    	// handle error
    	System.out.println("Error in running, Please chek input value!");
    }
	long endTime = System.nanoTime();
	long duration = (endTime - startTime);
	// show program running time
	System.out.println("Duration: "+duration/1000000+" ms");
}
}
