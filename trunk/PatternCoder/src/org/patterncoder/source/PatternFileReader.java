/*
 */

package org.patterncoder.source;

import java.io.*;
import java.util.*;
import org.xml.sax.SAXException;
import org.patterncoder.wizard.WizardPanelDescriptor;
import org.patterncoder.wizard.Wizard;
import org.patterncoder.pattern.PatternClass;
import org.patterncoder.pattern.PatternModel;

/**
 * Classes implementing this interface deal with reading data from the Pattern source files.
 *
 * @author Michael Nairn
 */
public interface PatternFileReader {
    
    /**
     * Parses the specified source file, to allow for data manipulation.
     * @param file pattern source file.
     * @throws java.io.IOException thrown if ifle not found.
     */
    public void parseFile(File file)throws IOException, SAXException;
    
    /**
     * Returns the pattern name retrieved from the source file.
     *
     * @return the pattern name.
     */
    public String getPatternName();
    
    /**
     * Returns the pattern description retrieved from the source file.
     *
     * @return the pattern description.
     */
    public String getPatternDesc();
    
    /**
     * Returns the nme of the image used by the pattern.
     *
     * @return the name of the image.
     */
    public String getPatternImage();
    
    /**
     * Returns a List of PatternClass objects that were generated from the source file.
     *
     * @return a List of PatternClass objects.
     */
    public HashMap<Object,PatternClass> getPatternComponents();
    
    /**
     * Returns a list of WizardPanelDescriptor objects from data supplied in a source file.
     * @param model the current data model.
     * @return a list of WizardPanelDescriptor objects.
     */
    public List<WizardPanelDescriptor> getWizardDescriptors(Wizard parent, PatternModel model);
    
}
