package com.mercedesbenz.part4;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.function.Function;

import no.ntnu.tdt4100.part3.ResearchReport;

public class ReportsListWriter {
    /**
     * This method will write the list of given research reports.
     * 
     * Write the reports to the outputstream
     * The reports should be written in the following format:
     * <pre>
     * uuid of report 1;report name;published year
     * uuid of citation 1;report name;published year
     * uuid of citation 2;report name;published year
     * uuid of citation n;report name;published year
     * ----------------------------------------------
     * uuid of report2;report name;published year
     * uuid of citation 1;report name;published year
     * uuid of citation 2;report name;published year
     * uuid of citation n;report name;published year
     * </pre>
     * Example:
     * <pre>
     * 1c372693-32d1-4546-89e9-28aa20c62c30;A brief history of time;1988
     * 7360a1b6-11a1-47bc-a35f-fb9680b68fd0;Philosophiæ Naturalis Principia Mathematica;1687
     * 1abda988-fb7f-4c3c-872b-fd35566828d7;Cosmos;1980
     * 592cb3f2-c3e1-41c3-8f51-c9cc80de2801;The Field Equations of Gravitation;1916
     * ----------------------------------------------
     * 2127b574-efb0-44ec-9013-06c121981733;The Origin of Species;1859
     * 852332b1-fa00-47d4-aa2a-a7d7fd14155e;The Voyage of the Beagle;1845
     * ...
     * </pre>
     * Make sure the outputstream is flushed before method ends.
     * 
     * @param reports List of reports
     * @param outputStream the outputstream to write the reports to
     * @throws java.io.IOException if an I/O error occurs, such as the stream is closed
     * 
     * @see ReportsListWriterTests
     */
    public static void write(List<ResearchReport> reports, OutputStream outputStream) throws IOException {
        // TODO Implement this method according to the description in JavaDoc

        String s = "";
        Function<ResearchReport, String> fn = report -> report.reportId() + ";" + report.name() + ";" + report.published().getYear() + "\n";

        for (ResearchReport researchReport : reports) {
            s += fn.apply(researchReport);
            for (ResearchReport citation : researchReport.citations()) {
                s += fn.apply(citation);
            }
            s += "----------------------------------------------\n";
        }
        outputStream.write(s.getBytes());
        outputStream.flush();
    }

}
