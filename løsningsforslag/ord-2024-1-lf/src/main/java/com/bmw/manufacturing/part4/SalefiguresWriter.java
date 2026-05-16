package com.bmw.manufacturing.part4;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import no.ntnu.tdt4100.part4.SalesOfficeReport;

public class SalefiguresWriter {
    
    /**
     * At the end of each year, the main office produces a file which contains information 
     * the company needs to produce the fiscal report for the company as a whole.
     * 
     * This method implements the functionality to write that file.
     * 
     * Write the reports to the outputstream
     * The reports should be written in the following format:
     * isoCountryCode;unitsSold
     * 
     * Example:
     * AFG;100
     * ALB;200
     * ...
     * 
     * Make sure the outputstream is flushed before method ends.
     * Do NOT wrap the outputstream in another class such as {@link java.io.BufferedWriter} or {@link PrintWriter}
     * 
     * @param reports List of sales reports from the sales offices in the different countries
     * @param outputStream the outputstream to write the reports to
     * @throws java.io.IOException if an I/O error occurs, such as the stream is closed
     */
    public static void write(List<SalesOfficeReport> reports, OutputStream outputStream) throws IOException {
        String s = "";
        for (SalesOfficeReport salesOfficeReport : reports) {
            s += salesOfficeReport.isoCountryCode() + ";" + salesOfficeReport.unitsSold() + "\n";
        }
        outputStream.write(s.getBytes());
        outputStream.flush();
    }
}
