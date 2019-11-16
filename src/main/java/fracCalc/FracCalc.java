/**
 * @author Mr. Rasmussen
 */

package fracCalc;
import java.util.*;


public class FracCalc {

    public static void main(String[] args){
        // TODO: Read the input from the user and call produceAnswer with an equation
    	System.out.println("Welcome to the Fraction Calculator!");
    	
    	Scanner userInput = new Scanner(System.in);
    	boolean run = true;
    	String res = "";
    	int round = 1;
    	String numinput = "";
    	
    	
    	
    	while (run) {
    		
    		System.out.print("Enter calculation number #" + round + ":" );
    		numinput = userInput.nextLine();
    		if (numinput.contains("quit")) {
    			run = false;
    		} else {
    			res = produceAnswer(numinput);
    			
    			
    			System.out.println(res);
    		}
    		
    		
    		round++;
    	}
    	


    }

    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    {
    	// TODO: Implement this function to produce the solution to the input
    	int length = input.length();
    	int spacenum = input.indexOf(" ");
    	String firstop = input.substring(0,spacenum);
    	String secondop = input.substring(spacenum+3,length);
    	int opnum = secondop.indexOf("/");
    	int secondlength = secondop.length();
    	int wholelength = input.indexOf("_");
    	
    	
// Conditions for return values 	
    	if (secondop.contains("_")) {
    		String wholenum = secondop.substring(0,wholelength);
			String numer = secondop.substring(wholelength +1, opnum);
			String denom = secondop.substring(opnum+1, secondlength);
			String outt = "whole:" + wholenum + " numerator:" + numer + " denominator:" + denom;
        	return outt;
    		
    		
    	} else {
    		if (secondop.contains("/")) {
    			String wholenum = "0";
    			String numer = secondop.substring(0, opnum);
   				String denom = secondop.substring(opnum+1, secondlength);
   				String outt = "whole:" + wholenum + " numerator:" + numer + " denominator:" + denom;
   	        	return outt;
   	        	
   			} else {
    			String wholenum =secondop;
    			String numer = "0";
    			String denom = "1";
    			String outt = "whole:" + wholenum + " numerator:" + numer + " denominator:" + denom;
       	        return outt;
    		}
    			
    	}
    			
    	
    }

    // TODO: Fill in the space below with any helper methods that you think you will need

}
