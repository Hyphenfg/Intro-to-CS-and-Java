/** Izzy Friedfeld-Gebaide
 *  Uni: if2266
 *  The Drunkard class
 */

public class Drunkard{
    private int avenue;
    private int street;
    private int aveStart;
    private int strStart;
    
    public Drunkard(int ave, int str){
        this.avenue = ave;
        this.street= str;
        this.aveStart = ave;
        this.strStart = str;
    }
    
    public void step(){
        int local = (int) (( 4*Math.random() )+ 1); //random # 1-4
        //1 = +ave, 2=-ave, 3 = +str, 4 = - str
        if (local == 1){
            this.avenue++;
        }
        else if(local == 2){
            this.avenue--;
        }
        else if(local == 3){
            this.street++;
        }
        else {
            this.street--;
        }

    }
    
    public void fastForward(int steps){
        for (int x = 0; steps>x; x++){
            step();
        }
    }
    
    public String getLocation(){
        return "Drunkard is at " + avenue + " ave and " + street + " street";
    }
    
    
    public int howFar(){
       return Math.abs(aveStart-avenue) + Math.abs(strStart-street); //finds the displacement
    }
}