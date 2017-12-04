/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.security.MessageDigest;
 
public class MD5{
    static byte[] digest;

    public MD5(){
    }

    public static String getHash(String stringToHash)
    {
        //hexString is used to store the hash
        StringBuffer hexString = new StringBuffer();
        //get a byte array of the String to be hashed
        byte[] buffer = stringToHash.getBytes();
        try{
            //get and instance of the MD5 MessageDigest
            MessageDigest alg = MessageDigest.getInstance("MD5");
            //Make sure the Digest is clear
            alg.reset();
            //Populate the Digest with the byte array
            alg.update(buffer);
            //Create the MD5 Hash
            digest = alg.digest();
            //Now we need to pull out each char of the byte array into the StringBuffer
        }
        catch(Exception e){
            //Need to catch some exceptions
        }
        //And return the hex hash value as a String
        return asHex(digest);     
    }

    private static String asHex (byte hash[]) {
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;
        for (i = 0; i < hash.length; i++) {
            if (((int) hash[i] & 0xff) < 0x10) 
                buf.append("0");
            buf.append(Long.toString((int) hash[i] & 0xff, 16));
        }
        return buf.toString();
    }
}