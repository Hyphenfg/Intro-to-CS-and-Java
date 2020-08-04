/** Izzy Friedfeld-Gebaide
 *  Uni: if2266
 *  The Encryptor class
 */

public class Encryptor {



    /* INSTANCE VARIALBES-------------------------------------------------------
     *
     * Try not to change or add too many (if at all) other instance variables
     */
    private String cipher; //Will tell your encryptor which encryption technique to use
    private int key1;
    private char key2;
    private String key3;//The key for your encryption technique



    /* CONSTRUCTOR--------------------------------------------------------------
     * 
     * You can do it with just this one constructor or, if you would like, you 
     * could use (three) overloaded constructors. 
     * 
     * If you choose to use just one constructor, your constructor is going to
     * be pretty simple. However, your encrypt() method is going to need to 
     * convert the `key` instance variable from type `Object` to the key data 
     * type needed for whatever encryption technique is specified through the 
     * constructor argument `technique`. 
     * E.g. If cipher.equals("substitution") then, per the README, the key needs 
     * to be an integer. 
     * 
     * If you choose to use overloaded constructors, then your single instance
     * variable `Object key` will need to actually be three instance variables, 
     * each of the type required by each encryption techniques
     */
    public Encryptor(String technique, Integer key) {
        this.cipher = technique;
        this.key1 = key;
    }
    public Encryptor(String technique, char key) {
        this.cipher = technique;
        this.key2 = key;
    }
    public Encryptor(String technique, String key) {
        this.cipher = technique;
        this.key3 = key;
    }

    public String encrypt(String message) {
       String temp ="";
       if(cipher.equals("substitution"))
           temp= encryptSubstitution(message, this.key1);
       else if(cipher.equals("additive"))
           temp= encryptAdditive(message, this.key2);
       else if(cipher.equals("transposition"))
           temp= encryptTransposition(message, this.key3);
       return temp;
    }


    private String encryptSubstitution(String message, Integer key) {

        /* Write your algorithm for the Substitution cipher here */
        for (int i = 0; i<message.length(); i++){
            int temp = (int)message.charAt(i)+key;
                
            if(temp>126){
                temp = temp-94;
            }
                
            char fin = (char) temp;
            message = message.substring(0,i)+fin+ message.substring(i+1);
            }
            
        return message;
    }


    private String encryptAdditive(String message, Character key) {
        /* Write your algorithm for the Additive cipher here */    
        String fin = "";
            
        for (int i = 0; i<message.length(); i++){
            int t1 = (int)message.charAt(i)^(int)key;
            String inBin = Integer.toBinaryString(t1);
            String lead0="";

            if(inBin.length()<8){
                for(int j =0; j< 8-inBin.length(); j++){
                    lead0+= "0";
                }
                inBin = lead0+inBin;
            }

            fin += inBin +" ";
        }
            
        return fin;
    }
    

    private String encryptTransposition(String message, String key) {
        /* Write your algorithm for the Transposition cipher here */
        int col = key.length();
        int row = (int) Math.ceil(message.length()/ (double)col) ;
        String alpMes [][] = new String [row][col];//alphabetic message
        int counter = 0; 
        
        //message --> matrix
        for (int r= 0 ; r<alpMes.length; r++){ 
            for (int c = 0; c<alpMes[0].length; c++){
                if(counter>=message.length() ){ alpMes[r][c] = " ";}
                else{alpMes[r][c] = ""+message.charAt(counter++);}
            }
        }
        
        //find the alphabetic order// find what index 1 is at.. until >length()
        String alpOrd="";
        for (int i = 0; i< key.length(); i++){
            int temp= key.length()-1; 
            for (int j = 0; j< key.length(); j++){
                if (key.charAt(i)<key.charAt(j)){
                    temp--;
                }
                else if (key.charAt(i)==key.charAt(j)){
                     if(j>i){temp--;}
                }
            }
            alpOrd += ""+temp;
        }
        
        //read the message
        String enc="";
        for (int c= 0 ; c<alpMes[0].length; c++){
            for (int r = 0; r<alpMes.length; r++){
                int index = alpOrd.indexOf(""+c);
                enc+= ""+alpMes[r][index];
            }
        }
        
        return enc;

    }

    

}
