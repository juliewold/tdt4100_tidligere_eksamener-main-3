package no.ntnu.tdt4100.part4;

/**
 * Record for errors when reading lines in the data.csv files
 * 
 * @param lineNumber the line number in the file where the error occured
 * @param errorMessage an error message describing the type of error that occured
 *
 */
public record LineReadError(int lineNumber, String errorMessage) {
}
