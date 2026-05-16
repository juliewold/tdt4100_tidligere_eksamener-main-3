package com.shopstore.retail.part1;

@SuppressWarnings("unused")
public class Task3 {

    /**
     * This method should insert a string into another string at a specified index.
     * 
     * @param text   the text to insert into
     * @param insert the text to insert
     * @param index  the index to insert the text at
     * @return the text with the inserted text
     */
    public String stringInserter(String text, String insert, int index) {

        if (true) {// This line is only in place to make the code compile, do not remove it

            // return new StringBuilder(text.substring(index)).append(insert + text.substring(text.length() - 1)).toString();
            // return text + text.substring(index) + insert;
            // return insert.split(String.valueOf(index))[0] + text + insert.split(String.valueOf(index))[1];
            // return text.substring(0, index) + insert + text.substring(index);
            // return text.substring(index) + insert + text.substring(index, text.length() - 1);

        }
        return null; // This line is only in place to make the code compile, do not remove it
    }

    public static void main(String[] args) {
        // You can use this main method to test the method if you like, but it is not required
        Task3 x = new Task3();
    }

}
