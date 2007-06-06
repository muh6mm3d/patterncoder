
package org.patterncoder.source;

import java.io.*;
import java.util.ArrayList;

/**
 * Classes implementing this interface deal with providing the location of pattern files.
 *
 * @author Michael Nairn
 */
public interface PatternSourceManager {
    
    /**
     * Returns a pattern image file specified by the name of the image.
     * @return the image file.
     * @param image the image required.
     * @throws java.io.FileNotFoundException thrown if directory not found.
     */
    public File getImage(String image)  throws FileNotFoundException;
    
    /**
     * Returns an ArrayList of Pattern source files. The ArrayList contains objects of type String.
     * @return the list of pattern source files.
     * @throws java.io.FileNotFoundException thrown if directory not found.
     */
    public ArrayList<String> getSourceFiles()  throws FileNotFoundException, Exception;
    
    /**
     * Returns the template file specified by the name of the template.
     * @return the template file.
     * @param template the template required.
     * @throws java.io.FileNotFoundException thrown if directory not found.
     */
    public File getClassTemplate(String template) throws FileNotFoundException;
    
}
