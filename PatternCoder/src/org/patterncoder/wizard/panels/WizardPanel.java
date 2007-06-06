/*
 * WizardPanel.java
 *
 * Created on 23 November 2005, 21:24
 */

package org.patterncoder.wizard.panels;

import org.patterncoder.PatternCoderException;

/**
 *
 * @author Michael Nairn
 */
public interface WizardPanel {
   
    public void closingPanel() throws PatternCoderException;
    
    public void displayingPanel() throws PatternCoderException;
    
}
