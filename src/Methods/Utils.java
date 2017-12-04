/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.regex.Pattern;

/**
 *
 * @author vega
 */
public class Utils {
    
    public static String getFileExtension(File file) 
    {
        if(file == null)
        {
            return "";
        }
        
        String fileName = file.getName();
        int dotIndex = fileName.lastIndexOf('.');
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
    }    
    
    
    public static Path getPathFrom(File choosenFile) 
    {
        return FileSystems.getDefault().getPath(choosenFile.getAbsolutePath());
    } 
    
    
    public static String getBaseName(String fileName)
    {
        int index = fileName.lastIndexOf('.');
        if(index == -1)
        {
            return fileName;
        }
        else
        {
            return fileName.substring(0,index);
        }
    }
    
    
    public static String getUniqueName(String fileName)
    {
        File f = new File("C:\\DMS-Files\\" + fileName);
        
        if (! f.exists())
        {
            return fileName;
        }
        
        int i = 1;
        
        String fName = Utils.getBaseName(fileName);
        String ext = Utils.getFileExtension(f);
        
        String newFileName = fName + "(" + i + ")." + ext;
        
        while ((new File("C:\\DMS-Files\\" + newFileName)).exists()) 
        {
            i++;
            newFileName = fName + "(" + i + ")." + ext;
        }
        
        return newFileName; 
    }
    
    
    public static void makeDirIfNotExists(String dirName) 
    {
        File dir = new File(dirName);
        
        if (! dir.exists()) 
        {
            dir.mkdir();
        }
    }
    
    
    public static boolean validateEmail(String email) {
        return Pattern.compile("^.+@.+\\..+$").matcher(email).matches();
    }
    
}


