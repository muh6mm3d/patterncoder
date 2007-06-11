/* Copyright (C) 2005 - 2007 the patternCoder team, http://www.patterncoder.org
 
    This file is part of the patternCoder application
 
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
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
