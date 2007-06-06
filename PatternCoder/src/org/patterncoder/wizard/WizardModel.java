/*
 * WizardModel.java
 *
 * Date: 06 November 2005
 *
 */

package org.patterncoder.wizard;

import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;


/**
 * The wizard model class is used to hold data required for the wizard process and the wizard framework.
 *
 * @author Michael Nairn
 */
public class WizardModel{
    
    private HashMap<Object,WizardPanelDescriptor> wp;    
    private WizardPanelDescriptor currentPanel;
    private int step;

    /** Creates a new instance of WizardModel */
    public WizardModel(){        
        wp = new HashMap<Object,WizardPanelDescriptor>();
        step = 1;
    }
    
    /**
     * Registers a panel descriptor with the wizard model.
     * This method should be called for each of the panels in a given pattern.
     * @param id the Object based id of the wizard panel descriptor.
     * @param panel the WizardPanelDescriptor object.
     */
    public void registerWizardPanel(Object id, WizardPanelDescriptor panel){
        panel.setStepNum(step);
        step++;
        wp.put(id, panel);
    }
    
    /**
     * Returns the panel descriptor of the current panel.
     * @return the current panels panel descriptor.
     */
    public WizardPanelDescriptor getCurrentPanelDesc(){
        return currentPanel;
    }
    
    /**
     * Returns the descriptor of the Panel with the same Object based id as the one supplied.
     * @param id the id of the panel descriptor required.
     * @return the panel descriptor required.
     */
    public WizardPanelDescriptor getPanelDesc(Object id){
        return (WizardPanelDescriptor) wp.get(id);
    }
    
    /**
     * Sets the value of the current decriptor to the descriptor represented by the Object value supplied.
     * @param id the id of the descriptor to be set as the current pael.
     */
    public void setCurrentPanelDesc(Object id){ 
        currentPanel = (WizardPanelDescriptor) wp.get(id);
    }   
    
    /**
     * Returns the total number of steps involved with the currently selected pattern.
     * This is used on the wizard to indicate the number of steps. i.e. (Step 1 of 3).
     * @return  the total number of steps.
     */
    public int totalNum(){
        return wp.size();
    }
    
    /**
     * Clears the wizard model, but does not remove any static panels that may have been registered.
     *
     * This method should be called when the currently selected pattern is changed by the choice panel.
     * If this is not done, the hashMap will continue to fill.
     */
    public void clearWizardModel(){
        Object id1 = "ChoicePanel";
        
        step = 1;
        WizardPanelDescriptor temp1 = (WizardPanelDescriptor)wp.get(id1);
        wp.clear();
        wp.put(id1, temp1);
        step++;
    }
    
    
}
