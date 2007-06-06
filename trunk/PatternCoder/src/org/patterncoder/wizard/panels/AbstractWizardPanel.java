/*
 * AbstractWizardPanel.java
 *
 * Date: 23 November 2005
 *
 */

package org.patterncoder.wizard.panels;

import javax.swing.JPanel;
import java.util.Observer;

/**
 * @author Michael Nairn
 */
public abstract class AbstractWizardPanel extends JPanel implements Observer,WizardPanel {
    
    /** Creates a new instance of AbstractWizardPanel */
    public AbstractWizardPanel() {
    }
    
}
