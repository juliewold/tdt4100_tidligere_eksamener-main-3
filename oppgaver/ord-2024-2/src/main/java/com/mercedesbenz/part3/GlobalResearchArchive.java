package com.mercedesbenz.part3;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import no.ntnu.tdt4100.part3.ResearchReport;
import no.ntnu.tdt4100.part3.SecretCode;

/**
 * Every time a project is finished at a research facility 
 * a research report is submitted to the GlobalResearchArchive.
 * 
 * The global research archive contains research results produced 
 * across all research facilities. 
 * 
 * All methods in this class are class methods.
 * A class method is a method that is bound to a class rather than its object. 
 * It doesn't require creation of a class instance to be invoked.
 */
@SuppressWarnings("unused")
public final class GlobalResearchArchive {
    
    // TODO Implement necessary fields and methods

    private GlobalResearchArchive() {} // DO NOT REMOVE THIS LINE
    // DO NOT ADD ANY CONSTRUCTORS


    /**
     * This method should be named <code>submitResearchReport</code>
     * 
     * A <code>class method</code> that submits a research report to the archive.
     * A class method is a method that is bound to a class rather than its object. 
     * It doesn't require creation of a class instance to be invoked.
     * 
     * The method returns <code>false</code> if a research report with the same ID is already submitted.
     * 
     * @param report the {@link no.ntnu.tdt4100.part3.ResearchReport}
     * @return <code>true</code> if the research report was successfully submitted, <code>false</code> otherwise.
     * 
     * @see no.ntnu.tdt4100.part3.ResearchReport
     */
    //TODO Implement the submitResearchReport class method according to the description in JavaDoc
   

   /**
    * This method should be named <code>isReportInArchive</code>
    *
    * A <code>class method</code> that checks whether the research report is in the archive.
    * The method returns <code>false</code> if a research report is not found.
    * 
    * @param reportId the {@link java.util.UUID} ID of the report
    * @return <code>true</code> if the research report exists in the archive, <code>false</code> otherwise.
    * 
    * @see no.ntnu.tdt4100.part3.ResearchReport#reportId()
    */
   //TODO Implement the isReportInArchive class method according to the description in JavaDoc
  

    /**
     * This method should be named <code>getNumberOfSubmittedResearchReports</code>
     * 
     * A <code>class method</code> that returns the number of submitted research reports worldwide
     * 
     * @return an {@link Integer} representing the number of submitted research reports, of type long
     */
    // TODO Implement the getNumberOfSubmittedResearchReports() class method according to the description in JavaDoc
   

    /**
     * This method should be named <code>wipe</code>
     * 
     * In case Mercedes is breached, they must have a last-resort
     * option to wipe its research so it doesn't fall in the hands of 
     * their competitors.
     * 
     * This <code>class method</code> wipes the global research archive.
     * 
     * After this method is called without thrown exceptions, 
     * a call to the getNumberOfSubmittedResearchReports() should return 0.
     * 
     * @param secretCode a char array containing the secret code needed to wipe the archive
     *                   the given secret code must be equal to {@link no.ntnu.tdt4100.part3.SecretCode#WIPE_CODE}
     * @throws NullPointerException if the given secret code is null
     * @throws SecurityException if the secret code is invalid
     */
    // TODO Implement the wipe() method according to the description in JavaDoc
   
}
