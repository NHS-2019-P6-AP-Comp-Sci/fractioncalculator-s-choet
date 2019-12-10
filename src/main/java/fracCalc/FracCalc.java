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
    			
    			
    			System.out.println("Result: " + res);
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
/*    	int secondop.indexOf("/") = secondop.indexOf("/");
    	int secondop.length() = secondop.length();
    	int input.indexOf("_") = input.indexOf("_");
 */   	
    	String firstfrac = testsTwo(firstop);
    	int w1 = Integer.parseInt(firstfrac.substring(0,firstfrac.indexOf("a")));
    	int n1 = Integer.parseInt(firstfrac.substring(firstfrac.indexOf("a")+1,firstfrac.indexOf("b")));
    	int d1 = Integer.parseInt(firstfrac.substring(firstfrac.indexOf("b")+1,firstfrac.length()));

    	String secondfrac = testsTwo(secondop);
    	int w2 = Integer.parseInt(secondfrac.substring(0,secondfrac.indexOf("a")));
    	int n2 = Integer.parseInt(secondfrac.substring(secondfrac.indexOf("a")+1,secondfrac.indexOf("b")));
    	int d2 = Integer.parseInt(secondfrac.substring(secondfrac.indexOf("b")+1,secondfrac.length()));


    	int lcm = Lcm(d1, d2);
    	int df =0;
    	int nf =0;
    	int div1 = lcm / d1;
    	int div2 = lcm / d2;
    	int n11 = n1*div1;
    	int n12 = 0;
    	if (w1 < 0) {
    		n12 = w1*lcm - n11;
    	} else {
    		n12 = n11 + w1*lcm;
    	}
    	
    	int n21 = n2*div2;
    	int n22 =0;
    	if (w2 < 0) {
    		n22 = w2*lcm - n21;
    	} else {
    		n22 = n21 + w2*lcm;
    	}
    

    	
    	if (input.contains(" + ")) {
    		nf = n12 + n22;
    		df = lcm;

    	}
    	if (input.contains(" - ") && !input.contains(" + ") ) {
    		nf = n12 - n22;
    		df = lcm;
    	}
    	if (input.contains(" * ")) {
    		nf = n12 * n22;
    		df = lcm *lcm;
    	}
    	if (!input.contains(" * ") && !input.contains(" - ") && !input.contains(" + ") ) {
    		nf = n12 * lcm;
    		df = lcm * n22;
    	}
    	
    	String neg = "-";
    	if (nf>0 && df>0 ) {
    		neg ="";
    	}
    	if (nf <0 && df <0) {
    		neg ="";
    	}
    	
    	nf = Math.abs(nf);
		df = Math.abs(df);
		
    	int wf =0;
    	int extra = nf/df;
	
    	
    	if (Math.abs(nf)>df) {
    		wf += extra;
    		nf -= extra*df;
    	}

    	int gcd = 0;
    	
    	if (nf==df) {
    		wf += 1;
    		nf = 0;
    		df = 0;
    	}
    	if (nf>0 && df>0) {
    		gcd = gcdtest(nf,df);
    		nf = nf/gcd;
    		df = df/gcd;
    		
    	}
    	
    	
    	
		if (wf!= 0) {
			if (nf == 0) {
				String outt = neg + "" + wf;
				return outt;
			}else {
				String outt = neg + wf + "_" + nf + "/" + df;
				return outt;
			}
    		
    		
    	} else {
    		if (nf == 0){
    			String outt = "0";
   				return outt;
   	        	
   			} else {
   				String outt = neg + nf + "/" + df;
    			return outt;
    		}
    			
    	}
    	
    	
    	
	
// Conditions for return values 	
    	
    
    			
    	
    }
    	
    

	public static int gcdtest(int d1, int d2) {
		int gcd = 1;
			for(int i = 1; i <= d1 && i <= d2; ++i) {

	            if(d1 % i == 0 && d2 % i == 0) {
	                gcd = i;
	            }
	        }
			

			return gcd;
			
    	}
		
	
		public static int Lcm(int d1, int d2) {
			int gcd = 1;
			if (d1!= 0 || d2 != 0) {
				for(int i = 1; i <= d1 && i <= d2; ++i) {

		            if(d1 % i == 0 && d2 % i == 0) {
		                gcd = i;
		            }
		        }
				
				int lcm = (d1 * d2) / gcd;
				return lcm;
				
	    	} else {
	    		int lcm = 0;
	    		System.out.println(lcm);
				return lcm;
	    	}
			
		}
			
    		
    		
    	public static String testsTwo(String secondop) {
    		if (secondop.contains("_")) {
    			
        		String wholenum = secondop.substring(0,secondop.indexOf("_"));
    			String numer = secondop.substring(secondop.indexOf("_") +1, secondop.indexOf("/"));
    			String denom = secondop.substring(secondop.indexOf("/")+1, secondop.length());
    			String outt = wholenum +"a" +numer + "b" + denom;
    			return outt;
        		
        		
        	} else {
        		if (secondop.contains("/")) {
        			String wholenum = "0";
        			String numer = secondop.substring(0, secondop.indexOf("/"));
       				String denom = secondop.substring(secondop.indexOf("/")+1, secondop.length());
       				String outt = wholenum +"a" +numer + "b" + denom;
       				return outt;
       	        	
       			} else {
        			String wholenum =secondop;
        			String numer = "0";
        			String denom = "1";
        			String outt = wholenum +"a" +numer + "b" + denom;
        			return outt;
        		}
        			
        	}
    	}
    // TODO: Fill in the space below with any helper methods that you think you will need

}
