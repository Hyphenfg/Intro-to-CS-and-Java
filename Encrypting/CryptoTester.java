/** Izzy Friedfeld-Gebaide
 *  Uni: if2266
 *  The CryptoTester class
 */
public class CryptoTester {

    public static void main(String[] args) {


        //The message to encrypt and decrypt for all three cipher types
        String message = "Hello World!";


        //TEST Substitution (use this as a template for the other two)----------
        Encryptor eS = new Encryptor("substitution", 3);
        String secretS = eS.encrypt(message);
        Decryptor dS = new Decryptor("substitution", 3);
        String messageS = dS.decrypt(secretS);
        System.out.println("\n\nSUBSTITUTION\n------------\nSecret:\t\t" + secretS + "\nMessage:\t" + messageS);


        //TEST Additive---------------------------------------------------------
        //For Additive use the character p as the key.
        Encryptor eA = new Encryptor("additive", 'p');
        String secretA = eA.encrypt(message);
        Decryptor dA = new Decryptor("additive", 'p');
        String messageA = dA.decrypt(secretA);
        System.out.println("\n\nADDITIVE\n------------\nSecret:\t\t" + secretA + "\nMessage:\t" + messageA);



        //TEST Transposition----------------------------------------------------
        //For Transposition use the word APPLE as the key.
        Encryptor eT = new Encryptor("transposition", "APPLE");
        String secretT = eT.encrypt(message);
        Decryptor dT = new Decryptor("transposition", "APPLE");
        String messageT = dT.decrypt(secretT);
        System.out.println("\n\nTRANSPOSITION\n------------\nSecret:\t\t" + secretT + "\nMessage:\t" + messageT);
        
    }
    

}
