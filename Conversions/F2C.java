/** F2C.java - add your solutiuon to program 1 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class F2C {
    //all calculations should be done in ints//
	public static int farenheit (int f) {
		int c = ((f-32)*5)/9; //5/9 = 0
		return c;
	}
	
    public static final void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println ("Enter a temperature in farenheit");
        int f1 = scan.nextInt();
        
        System.out.println("Here is the temperature converted to Celsius: "+ farenheit(f1));
        
    }
    
}
