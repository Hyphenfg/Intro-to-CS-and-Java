/** Change.java - add your solutiuon to program 3 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Change {
   public static void change (int monGiv, int cost) {
		int tot = monGiv-cost;
		int dol = (tot-tot%100)/100;//total-the change = #of dollars/ 100 bc its in cents
		tot = tot-dol*100;//tot is in cents, dol is in dollars
		
		int q = tot/25;
		tot= tot- q*25;
		
		int di = tot/10;
		tot= tot-di*10;
		
		int n = tot/5;
		tot= tot-n*5;
		
		int p = tot;
		
		System.out.println ("The correct change is: ");
		System.out.println(dol +" dollars, " + q + " quarters, " +di+ " dimes, " + n + 
				" nickels, and " + p + " pennies");
	}
	
    public static final void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println ("What is the amount of money given?");
        int monGiv = scan.nextInt();//in cents
        System.out.println ("What is the amount due?");
        int cost = scan.nextInt();//in cents
        change(monGiv,cost);
    }
    
}
