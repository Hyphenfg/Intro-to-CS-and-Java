/** Minutes.java - add your solutiuon to program 2 of homework 1 here.
 * 
 */
import java.util.Scanner;

public class Minutes {
	// hours, days, weeks, and years
	public static int timeChange (int h, int d, int w, int y) {
		int total = yearToHour(y)+weekToHour(w)+ dayToHour(d)+h;//all in hours
		total = total*60;//60 minutes per hour
		return total;
	}
	
	public static int yearToHour(int y) {
		return dayToHour(y*365);//365 days a year
	}
	public static int weekToHour(int w) {
		return dayToHour(w*7);// 7 days a year
	}
	public static int dayToHour(int h) {
		return h*24;//24 hours a day
	}
	
    public static final void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        System.out.println ("How many years?");
        int y = scan.nextInt();
        System.out.println ("How many weeks?");
        int w = scan.nextInt();
        System.out.println ("How many days?");
        int d = scan.nextInt();
        System.out.println ("How many hours?");
        int h = scan.nextInt();
        
        int tot = timeChange (h,d,w,y);
        System.out.println("Here is the corresponding amount of minutes: "+tot);
        
    }
 }