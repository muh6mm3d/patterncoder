/*
 * NameVerifier.java
 *
 * Date: 02 January 2006
 *
 */

package org.patterncoder.util;

/**
 * Utility class which simply provides methods to check for invalid characters within the names of java source files.
 * @author Michael Nairn
 */
public class NameVerifier {
    
    /**
     * Invalid characters.
     */
    static char[] chars = {'!','"','%','`',' ','~','#','^','&','*','(',')','+','=','{','}','[',']'
            ,'@',':',';','?','>','<','|'};
    
    /**
     * Checks a source name against a list of known invalid characters. Returns a boolean value indicating wether the name is valid or not.
     * @param name The name that requires a check for invalid characters.
     * @return returns true if the name is well formaed and valid. False is returned if the name is invalid.
     */
    public static boolean verifyName(String name){
        boolean wellFormed = true;
        
        if(name.compareTo("")==0){
            wellFormed = false;
        }else{
            for(int i=0;i<chars.length;i++){
                for(int nameChar=0;nameChar<name.length();nameChar++){
                    if(chars[i] == name.charAt(nameChar)){
                        wellFormed = false;
                        break;
                    }
                }
            }
            
        }
        
        return wellFormed;
    }
    
}
