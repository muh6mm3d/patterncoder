/*
 * Wizard.java
 *
 */

package org.patterncoder.wizard;

/**
 * The wizard interface defines an interface that must be implemented by the main wizard class. Methods of this interace deal with the wizard navaigation.
 * @author Michael Nairn
 */
public interface Wizard{
      
    public void next();
    
    public void back();
    
    public void cancel();
    
    public void finish();
    
    /**
     * Returns the WizardModel object being used by the current wizard object.
     * @return The model being used by the current wizard.
     */
    public WizardModel getWizardModel();
       
}
