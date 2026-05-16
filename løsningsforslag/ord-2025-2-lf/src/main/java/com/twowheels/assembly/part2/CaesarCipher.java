package com.twowheels.assembly.part2;

// TODO: Import relevant libraries

public class CaesarCipher {

    /**
     * This method encrypts a given text.
     * 
     * In non-auto mode (mode is false), it uses Caesar Cipher to encrypt the text:
     * This shifts each letter of a string by a specified number of positions 
     * in the english alphabet (26 letters) while keeping the case intact. 
     * Non-alphabetic characters remain unchanged. 
     * 
     * Example:
     * The text "abz" is encrypted with a shift of 1 to "dea". Note that the z wraps around to a. 
     * The text "Hello, World!" is encrypted with a shift of 5 to "Mjqqt, Btwqi!".
     *
     * In auto mode, encryption is as follows:
     * The first alphabetic character is encrypted as in non-auto mode.
     * For the next character, the shift is determined by the result of the previously encrypted letter: 
     * 
     * If the result of the previous encryption was the letter 'a', it shifts 0,
     *  if 'b' it shifts 1, 'c' shifts 2, 'd' shifts 3, and so on.
     * 
     * Upper case or lower case of the same letter represent the same shift, so 'd' and 'D' both represent a shift of 3.
     * 
     * Example in auto mode:
     * The text "abc" is encrypted with a shift of 1 to "bce":
     * - 'a' is encrypted to 'b' (shifted 1), since shift key is given as 1
     * - 'b' is encrypted to 'c' (shifted 1), since the previous letter was encrypted to 'b'
     * - 'c' is encrypted to 'd' (shifted 2), since the previous letter was encrypted to 'c'
     * 
     * @param text the input text to be encrypted
     * @param shift the number of positions to shift each letter in the alphabet. Negative values mean shift in th e opposite direction.
     *             For example, a shift of -1 means to shift each letter backward by 1 position.
     * @param auto whether to use auto mode or not
     * @return the encrypted text
     */

    
    private boolean auto; 
    
    public void setAuto(boolean auto) {
        this.auto = auto;
    }
    public boolean isAuto() {
        return auto;
    }
    
    /**
     * Computes the positive modulus of two integers.
     *
     * This method ensures that the result is always non-negative, even if the dividend is negative.
     * For example, positiveMod(-1, 26) returns 25.
     *
     * @param a the dividend
     * @param b the divisor (must be positive)
     * @return the positive modulus result in the range [0, b)
     */
    public static int positiveMod(int a, int b) {
        return ((a % b) + b) % b;
    }

    public String encrypt(String text, int shift) {

        if (text == null) {
            return ""; // Return an empty string instead of throwing an exception
        }

        StringBuilder encryptedText = new StringBuilder();

        int nextShift = shift; // Initialize nextShift with the provided shift value

        // Loop through each character in the input string
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // Encrypt lowercase letters
            if (Character.isLowerCase(c)) {
                nextShift = positiveMod(shift + (c - 'a'), 26);
                encryptedText.append((char) (nextShift + 'a'));
                
            }
            // Encrypt uppercase letters
            else if (Character.isUpperCase(c)) {
                nextShift = positiveMod(shift + (c - 'A'), 26);
                encryptedText.append((char) (nextShift + 'A'));
            }
            // Non-alphabetic characters remain unchanged
            else {
                encryptedText.append(c);
            }
            // Update the shift for the next character if in auto mode
            if (auto) {
                // Update the shift based on the last encrypted character
                shift = nextShift;
            }
            
        }

        return encryptedText.toString();
    }

    /**
     * This method decrypts a given text using Caesar Cipher.
     * 
     * This shifts each letter of a string backward by a specified number of positions
     * in the english alphabet (26 letters) while keeping the case intact. 
     * Non-alphabetic characters remain unchanged.
     * 
     * Example:
     * The text "bcd" is decrypted with a shift of 1 back to "abc".
     * The text "Mjqqt, Btwqi!" is decrypted with a shift of 5 back to "Hello, World!".
     * 
     * @param text the input text to be decrypted
     * @param shift the number of positions to shift each letter backward in the alphabet
     * @return the decrypted text
     */

    public String decrypt(String text, int shift) {

        // TODO: Complete the method according to JavaDoc

        // return encrypt(text, -shift, auto); // This does not work in auto mode
        if (text == null) {
            return ""; // Return an empty string instead of throwing an exception
        }

        StringBuilder decryptedText = new StringBuilder();

        int nextShift = shift; // Initialize nextShift with the provided shift value

        // Loop through each character in the input string
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            // Encrypt lowercase letters
            if (Character.isLowerCase(c)) {
                int disp = positiveMod(-shift + (c - 'a'), 26);
                char encryptedChar = (char) (disp + 'a');
                decryptedText.append(encryptedChar);
                nextShift = ((c - 'a')) % 26; // Update nextShift for auto mode
            }
            // Encrypt uppercase letters
            else if (Character.isUpperCase(c)) {
                int disp = positiveMod(-shift + (c - 'A'), 26);
                char encryptedChar = (char) (disp + 'A');
                decryptedText.append(encryptedChar);
                nextShift = ((c - 'A')) % 26; // Update nextShift for auto mode
            }
            // Non-alphabetic characters remain unchanged
            else {
                decryptedText.append(c);
            }
            // Update the shift for the next character if in auto mode
            if (auto) {
                // Update the shift based on the last encrypted character
                shift = nextShift;
            }
        }

        return decryptedText.toString();
    }

    public static void main(String[] args) {
        // Example usage

        CaesarCipher cipher = new CaesarCipher();
        cipher.setAuto(false); // Set to auto mode
        
        String text = "Hello, World!";
        String encryptedText = cipher.encrypt(text,3);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = cipher.decrypt(encryptedText,3);
        System.out.println("Decrypted Text: " + decryptedText);

        cipher.setAuto(true);
        
         text = "Hello, World!";
         encryptedText = cipher.encrypt(text,3);
        System.out.println("Encrypted Text: " + encryptedText);

         decryptedText = cipher.decrypt(encryptedText,3);
        System.out.println("Decrypted Text: " + decryptedText);

    }
}
