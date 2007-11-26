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

package org.patterncoder.source;

import javax.xml.validation.*;
import java.net.URLEncoder;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import org.xml.sax.SAXException;
import java.io.*;

import java.text.StringCharacterIterator;
import java.text.CharacterIterator;

/**
 * The PatternFileValidator class is used to validate each of the xml source files against a xmlSchema.
 * If a source file does not get validated, it will not be included.
 * @author Michael Nairn
 */
public class PatternFileValidator {
    
    static final String W3C_XML_SCHEMA ="http://www.w3.org/2001/XMLSchema";
    static final String schemaSource = "lib/extensions/patternfiles/patternschema.xsd";
    static final String schemaSource2 = "patext/patternschema.xsd";
    
    private Schema schema;
    private Validator validator;
    
    /**
     * Creates a new instance of PatternFileValidator, and compiles the validating schema.
     * @throws org.xml.sax.SAXException A SAXException is thrown if the schema file cannot be found, or there is aproblem during comilation of the schema.
     */
    public PatternFileValidator() throws SAXException {
        
        //  String sConfigFile = "patext/bluedp.properties";
        //java.net.URL in = this.getClass().getClassLoader().getResource(sConfigFile);
        //   System.out.println("in = "+in);
        //   System.out.println("File = "+in.getFile());
        //   System.out.println("Path = "+in.getPath());
        
        
        //    if (in == null) {
        //File not found! (Manage the problem)
        //       System.out.println("file not found");
        // }else{
        //   System.out.println("file found");
        // }
        // java.util.Properties props = new java.util.Properties();
        
        // try{
        // props.load(in);//throws IOException
        // }catch(IOException ioe){ioe.printStackTrace();}
        
//        System.out.println(props.getProperty("name"));//
        
        // InputStream in = PatternsExtension.class.getClassLoader().getResourceAsStream(schemaSource2);
        
        //    java.net.URL mySource = this.getClass().getClassLoader().getResource(schemaSource2);
        
        //   String schemaFile = mySource.getFile();
        
        schema = compileSchema(schemaSource);
        validator = schema.newValidator();
        validator.setErrorHandler(new ValidatorErrorHandler());
    }
    
    /**
     * Compiles the schema file specified.
     * @param schema The schema file to be comiled.
     * @throws org.xml.sax.SAXException Throws a SAXException if compilation of the schema fails.
     * @return A compiled schema, which can be used in validating.
     */
    public static Schema compileSchema(String schema) throws SAXException{
        SchemaFactory sf = SchemaFactory.newInstance(W3C_XML_SCHEMA);
        return sf.newSchema(new File(schema));
    }//compileSchema
    
    
    /**
     * Validates a source file against the compiled schema.Exceptions are thrown if the validation is Unsuccessful.
     * @param sourcefile The source file to be validated.
     * @throws org.xml.sax.SAXException Thrown if the source file cannot be validated against the schema.
     * @throws java.io.IOException Thrown if the source file cannot be read or found for any reason.
     */
    public void validateFile(String sourcefile) throws SAXException, IOException{
        sourcefile = replaceSpaces(sourcefile);   // avoids MalformedURLException if file path has spaces
        validator.validate(new StreamSource(sourcefile));
    }
    
    
    /**
     * The ErrorHandler catches any errors that occur during validation and throws a new SAXException accordingly.
     */
    class ValidatorErrorHandler implements org.xml.sax.ErrorHandler{
        
        /** Creates a new instance of MyErrorHandler */
        public ValidatorErrorHandler() {
        }
        
        
        /**
         * Catches all exceptions that cause an error, and throws a new exception with the same message.
         * @param sAXParseException The exception thrown during validation.
         * @throws org.xml.sax.SAXException Throws a new SAXException, with slightly modified message.
         */
        public void error(org.xml.sax.SAXParseException sAXParseException) throws org.xml.sax.SAXException {
            throw new SAXException("ERROR: " + sAXParseException.toString());
        }
        
        /**
         * Catches all exceptions that cause an fatal error, and throws a new exception with the same message.
         * @param sAXParseException The exception thrown during validation.
         * @throws org.xml.sax.SAXException Throws a new SAXException, with slightly modified message.
         */
        public void fatalError(org.xml.sax.SAXParseException sAXParseException) throws org.xml.sax.SAXException {
            throw new SAXException("Fatal ERROR: " + sAXParseException.toString());
        }
        
        /**
         * Catches all exceptions that cause a warning, and throws a new exception with the same message.
         * @param sAXParseException The exception thrown during validation.
         * @throws org.xml.sax.SAXException Throws a new SAXException, with slightly modified message.
         */
        public void warning(org.xml.sax.SAXParseException sAXParseException) throws org.xml.sax.SAXException {
            throw new SAXException("Warning: " + sAXParseException.toString());
        }
        
    }
    
    
    /**
     * Replaces spaces in a string with %20
     * Required as Validator#validate causes MalformedURLException if file path has spaces
     * Validator#validate is called in validateFile in this class
     * @param aText    the string to process
     * @return         a copy of the string with spaces replaced by %20
     */
    private String replaceSpaces(String aText){
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character =  iterator.current();
        while (character != CharacterIterator.DONE ){
            if (character == ' ') {
                result.append("%20");
            } else {
                //add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }
    
}
