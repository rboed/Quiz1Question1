//Ryan Boedeker Quiz1Question1

import java.util.Scanner;
public class QuarterBackRating {
	
	/**
	 * Repeatedly display the prompt until a value within the specified range (inclusive) is entered
	 * @param input the scanner which collects the input
	 * @param prompt the prompt to display to the user
	 * @param min the lowest acceptable value
	 * @param max the highest acceptable value
	 * @return the value entered 
	 */
	
	public static double getBoundedDouble(Scanner input, String prompt, double min, double max) {
	    double lmin = min;
	    double lmax = max;
	    if (lmin > lmax) {
	      lmin = max;
	      lmax = min;
	    }
	    double ans = lmin - 1.0;
	    while (ans < lmin || ans > lmax) {
	      System.out.print(prompt + " (enter a value between " + lmin + " and " + lmax + "): ");
	      ans = input.nextDouble();
	    }
	    return ans;
	  }
	
	/**
	 * Calculates the Passer Rating of an individual NFL quarterback given his stats
	 * @param att Number of passing attempts
	 * @param comp Number of completions
	 * @param yds Passing yards
	 * @param td Touchdown passes
	 * @param inter Interceptions
	 * @return the calculated amount
	 */
	
	public static double passerRatingFunction(double att, double comp, double yds, double td, double inter){
	    return (((((comp / att) - .3) * 5) + (((yds / att) - 3) * .25) + ((td / att) * 20) + (2.375 - ((inter / att) * 25))) / 6) * 100;
	  }
	
	/**
	 * 
	 * @param args None expected
	 */
	
	public static void main(String[] args) {
		
	    System.out.println("This program calculates the Passer Rating of a single NFL quarterback,");
	    System.out.println("given his number of passing attempts, number of completions, passing yards,");
	    System.out.println("touchdown passes, and interceptions.");
	    
	    Scanner input = new Scanner(System.in);
	    
	    double att = getBoundedDouble(input, "What is the number of passing attempts?", 1.0, 9999999);
	    double comp = getBoundedDouble(input, "What is the number of completions?", 1.0, 9999999);
	    double yds = getBoundedDouble(input, "What is the number of passing yards?", 1.0, 9999999);
	    double td = getBoundedDouble(input, "What is the number of touchdown passes?", 1.0, 9999999);
	    double inter = getBoundedDouble(input, "What is the number of interceptions?", 1.0, 9999999);
	    
	    double finalPasserRating = passerRatingFunction(att, comp, yds, td, inter);
	    
	    System.out.println("The Passer Rating of the quarterback at hand is: " + finalPasserRating);
	    
	    return;
	}
}