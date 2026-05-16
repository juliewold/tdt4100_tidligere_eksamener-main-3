package com.bytebadger.assembly.part2;

// TODO: Import relevant libraries
import java.util.Iterator;
import java.util.stream.IntStream;


/**
 * This class provides methods for encrypting and decrypting text messages using the Vigenere cipher.
 * 
 * The Vigenere cipher is based on the Caesar cipher, which shifts each letter of a
 * string by a specified number of positions in the English alphabet (26 letters).
 * 
 * Instead of just one fixed shift, it has a sequence of shift values. 
 */

public class Vigenere {
    //TODO: Implement class according to JavaDoc

    private int[] shifts;

    /**
     * Constructor for the Vigenere class.
     *
     * @param shifts the number of positions to shift each letter in the alphabet. Negative values mean shift in th e opposite direction.
     *             For example, a shift of -1 means to shift each letter backward by 1 position.
     * @throws IllegalArgumentException if the key is null or empty
     */
     public Vigenere(int[] shifts) {
        // Throw exception if key is null or empty, or does not only consist of letters
        if (shifts == null || shifts.length == 0) {
            throw new IllegalArgumentException("Key must be a non-empty string containing only letters.");
        }
        this.shifts = shifts;
    }

    private IntStream getKeyStream() {
        return IntStream.iterate(0, i -> (i + 1) % shifts.length).map( i -> (shifts[i] % 26 + 26) % 26);
    }

    /**
     *  The method encrypts a given text, using the Vigenere cipher, using the object's shifts.
     * 
     * The shifts are a sequence of integers that represent the shift for each letter in the text.
     * The first letter is encrypted with the first shift,
     * the second letter with the second shift, and so on. When all shifts are used,
     * the sequence starts again from the first shift.
     * 
     * This shifts each letter of a string by a specified number of positions 
     * in the english alphabet (26 letters) while keeping the case intact. 
     * Non-alphabetic characters remain unchanged. 
     * 
     * Example:
     * The text "aBcx. yZ!" encrypted with the key sequence [2,5,-1,0], returns "cfbxae":
     * - 'a' is shifted by 2 to give 'c'
     * - 'B' is shifted by 5 to give 'F', keeping upper case
     * - 'c' is shifted by -1 to give 'b', negative indicate opposite direction
     * - 'x' is not shifted since the shift is 0
     * - dot '.' and space ' ' remain unchanged
     * Now we have used all shifts, so we start again with the first shift:
     * - 'y' is shifted by 2 to give 'a', where we wrap the alphabet: y -> z -> a
     * - 'Z' is shifted by 5 to 'E', again wrapping and keeping upper case
     * - '!' remains unchanged
     * 
     * Note that we only consude shifts for letters, not for non-alphabetic characters.
     * 
     * return null if the input text is null.
     * 
     * @param text the input text to be encrypted
     * @return the encrypted text
     */

    public  String encrypt(String text) {

        if (text == null) {
            return null; 
        }

        StringBuilder encryptedText = new StringBuilder();
        Iterator<Integer> keyStream = getKeyStream().iterator();

        // Loop through each character in the input string
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // Encrypt lowercase letters
            if (Character.isLowerCase(c)) {
                int shift = keyStream.next() % 26; 
                char encryptedChar = (char) ((c - 'a' + shift) % 26 + 'a');
                encryptedText.append(encryptedChar);
            }
            // Encrypt uppercase letters
            else if (Character.isUpperCase(c)) {
                int shift = keyStream.next() % 26;
                char encryptedChar = (char) ((c - 'A' + shift) % 26 + 'A');
                encryptedText.append(encryptedChar);
            }
            // Non-alphabetic characters remain unchanged
            else {
                encryptedText.append(c);
            }
            
        }

        return encryptedText.toString();
    }

    /**
     * This method decrypts a given text using Caesar Cipher,
     * i.e. undoes the encryption, giveing the original text.
     * 
     * Returns null if the input text is null.
     * 
     * @param text the input text to be decrypted
     * @return the decrypted text
     */

    public String decrypt(String text) {

        // TODO: Complete the method according to JavaDoc

        
        if (text == null) {
            return null;
        }

        StringBuilder decryptedText = new StringBuilder();
        Iterator<Integer> keyStream = getKeyStream().iterator();

        text.chars()
                .mapToObj(c -> (char) c)
                .map(x -> {
                    if (Character.isLowerCase(x)) {
                        return (char) ((x - 'a' + 26 - keyStream.next()) % 26 + 'a');
                    } else if (Character.isUpperCase(x)) {
                        return (char) ((x - 'A' +26 - keyStream.next()) % 26 + 'A');
                    } else {
                        return x;
                    }
                })
                .forEach(decryptedText::append);
        return decryptedText.toString();
    }

    public static void main(String[] args) {
        // Example usage

        Vigenere vigenere = new Vigenere(new int[]{2, 5, -1, 0});
        Iterator<Integer> keyStream = vigenere.getKeyStream().iterator();
        for (int i = 0; i < 10; i++) {
            System.out.println(keyStream.next());
        }

        String text = "Hello, World!";
        
        String encryptedText = vigenere.encrypt(text);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = vigenere.decrypt(encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
