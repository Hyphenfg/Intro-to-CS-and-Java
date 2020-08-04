/** Izzy Friedfeld-Gebaide
 *  Uni: if2266
 *  The Decryptor class
 */


public class Decryptor {



    /* INSTANCE VARIALBES-------------------------------------------------------
    *
    * Try not to change or add too many (if at all) other instance variables
    */
    private String cipher; 
    private int key1;
    private char key2;
    private String key3;



    /* CONSTRUCTOR--------------------------------------------------------------
     * 
     * You can do it with this one constructor or, if you would like, you could
     * use overloaded constructors. See Encryptor constructor for hints.
     */
    
    public Decryptor(String technique, Integer key) {
        this.cipher = technique;
        this.key1 = key;
    }
    public Decryptor(String technique, char key) {
        this.cipher = technique;
        this.key2 = key;
    }
    public Decryptor(String technique, String key) {
        this.cipher = technique;
        this.key3 = key;
    }

   
    public String decrypt(String message) {
        String temp ="";
        if(cipher.equals("substitution"))
           temp= decryptSubstitution(message, this.key1);
        else if(cipher.equals("additive"))
           temp= decryptAdditive(message, this.key2);
        else if(cipher.equals("transposition"))
           temp= decryptTransposition(message, this.key3);
        return temp;
    }


    private String decryptSubstitution(String secret, Integer key) {
        /* Write your algorithm to decrypt the Substitution cipher here */
        for (int i = 0; i<secret.length(); i++){
            int temp = (int)secret.charAt(i)-key;
            
            if(temp<32){
                temp = temp+94;
            }
            char fin = (char) temp;
            secret = secret.substring(0,i)+fin+secret.substring(i+1);;
        }
        
        return secret;
    }


    private String decryptAdditive(String secret, Character key) {
        /* Write your algorithm to decrypt the Additive cipher here */
        String [] nums = secret.split (" ");
        String fin ="";

        for (int i =0; i<nums.length;i++){
            int inDec = Integer.parseInt(nums[i],2);//binary to decimal
            int t1 = inDec^(int)key;
            fin += (char)t1;
        }
            
        return fin;
    }


    private String decryptTransposition(String secret, String key) {
        /* Write your algorithm for the Transposition cipher here */
        int col = key.length();
        int row = (int) Math.ceil(secret.length()/ (double)col) ;
        String alpMes [][] = new String [row][col];//alphabetic message
        int counter = 0; 

        //find the alphabetic order
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
        
        //message --> array
        String decr = "";
        for (int c= 0 ; c<alpMes[0].length; c++){
            for (int r = 0; r<alpMes.length; r++){
                int index = alpOrd.indexOf(""+c);
                if(counter>=secret.length() ){ 
                    alpMes[r][index] = " ";
                }
                else{
                    alpMes[r][index] = ""+secret.charAt(counter);
                    counter++;
                }
            }
        }

        for (int r = 0; r<alpMes.length; r++){
            for (int c= 0 ; c<alpMes[0].length; c++){
                decr+=  ""+alpMes[r][c];
            }
        }

        return decr;
    }
   


}
