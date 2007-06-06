/*
 * ErrorHandler.java
 *
 * Date: 24 October 2005
 *
 */

package org.patterncoder;

import javax.swing.JOptionPane;

/**
 * Handles all errors that are produced by the patterns extension.
 * 
 * Provides options to either display a message to the user or log the error into the log file.
 *
 * @author Michael Nairn
 */
public class ErrorHandler {   
    
    private static final boolean DEBUG = System.getProperty("debug") != null ? true : false;
    
    private static final String ERROR_TITLE = "Patterns Extension Error";
    private static final String WARNING_TITLE = "Patterns Extension Warning";
    
    /**
     * Logs the message sent to it. Only does so if the system property "debug", is set to true.
     * @param s Message to log.
     */
    public static void logErrorMsg(String s){
        if(DEBUG){
            System.out.println(s);
        }
    }
    
    /**
     * Displays an error dialog box to the user, with the specified message.
     * @param error Messsage to display.
     */
    public static void printErrorMsg(String error){
        JOptionPane.showMessageDialog(null,error,ERROR_TITLE,JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Displays a warning message dialog to the user, with the specified message.
     * @param warning Message to display.
     */
    public static void printWarningMsg(String warning){
        JOptionPane.showMessageDialog(null,warning,WARNING_TITLE,JOptionPane.WARNING_MESSAGE);
    }
    
}
