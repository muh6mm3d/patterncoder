/*
 * WizardPanelNotFoundException.java
 *
 * Date: 07 November 2005
 *
 */

package org.patterncoder.wizard;

import java.io.*;

/**
 * Exception used when a wizard panel causes an error.
 *
 * @author Michael Nairn
 */
public class WizardPanelNotFoundException extends RuntimeException {
    
    /** 
     * Creates a new instance of WizardPanelNotFoundException 
     */
    public WizardPanelNotFoundException() {
        super();
    }
    
}
