package no.ntnu.tdt4100.part3;

import java.util.Random;

/**
 * Contains method for generating random strings.
 * 
 * THIS IS SUPPLIED CODE, DO NOT MODIFY THIS CODE
 */
public final class RandomGenerator {
    
    public static int Counter = 0;

    /**
     * Generates a random string of a given length
     * @param length the length of the string
     * @return a random string of a given length
     */
    public final static String generateRandomString(int length){
        Random rnd = new Random();
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String retVal = "";
        for(int i = 0; i < length; i++)
            retVal += chars.charAt(rnd.nextInt(chars.length()));
        Counter++;
        return retVal;
    }
}
