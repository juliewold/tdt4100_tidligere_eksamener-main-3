package com.twowheels.assembly.part1;

@SuppressWarnings("unused")
public class Task4 {

    /**
     * This method should replace a substring at a specified index in the text with a new substring.
     * 
     * @param text     the original text to modify
     * @param newText  the new text to replace the old one
     * @param index    the index to start replacing at
     * @param length   the length of the substring to replace
     * @return the text with the substring replaced
     */

    public String stringReplacer(String text, String newText, int index, int length) {

        // TODO: Comment in the correct line of code.

            // return new StringBuilder(text).replace(0, index, newText).toString();
            // return text.substring(0, index) + newText + text.substring(index + newText.length());
            // return text.substring(0, index) + newText + text.substring(index);
            return new StringBuilder(text).replace(index, index + length, newText).toString();

    }
    
    public static void main(String[] args) {
        Task4 task = new Task4();
        System.out.println(task.stringReplacer("Hello World", "Java", 6, 5)); // Output: "Hello Java"
    }

}

