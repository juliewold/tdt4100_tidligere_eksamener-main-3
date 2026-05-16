package com.library.part1;

public class Task1 {
    /**
     * Which line safely parses an integer from a string?
     */
    public static int safeParseInt(String str, int defaultValue) {
        // TODO: Uncomment the correct implementation

        // try { return Integer.parseInt(str); } catch (NumberFormatException e) { return defaultValue; }
        // if (str.matches("\\d+")) return Integer.parseInt(str); else return defaultValue;
        // return str == null ? defaultValue : Integer.parseInt(str);
        // try { return Integer.valueOf(str); } catch (Exception e) { return defaultValue; }

        return -1; // Placeholder - remove after uncommenting the correct line
    }

    public static void main(String[] args) {
        System.out.println(safeParseInt("123", 0)); // Should print 123
        System.out.println(safeParseInt("invalid", -2)); // Should print -2
    }
}
