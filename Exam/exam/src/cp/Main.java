
package cp;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/*
* The search is recursive: if the directory contains subdirectories,
* these are also searched and so on so forth (until there are no more
* subdirectories).
* 
* This method returns a list of results.
* The list contains a result for each text file that you find.
* Each {@link Result} stores the path of its text file,
* and the lowest number (minimum) found inside of the text file.
* 
* @param dir the directory to search
* @return a list of results ({@link Result}), each giving the lowest number found in a file
*/



public class Main {

    
    public static void main(String[] args) {
    Filter filter = new Filter();
     filter.Finder("C:\\Users\\barth\\Documents\\Datalogi\\2 semester\\Concurrent Programming\\Eksamen\\data_example");
        
      
       
        
             
        
        
        
    }
    // Dette er en hjælpefunktion, som egentlig laver alt arbejdet. 
    public static class Filter{
        // method m1 som retunere en liste, og tager imod en path.
        public static List<Result> m1( Path dir ){
            Resultobject result = new Resultobject();
            // men dette er et Resultobject ikke et Result object.
            
            List <Result> m1List = new ArrayList<Result>();
            
            File dirFile = dir.toFile();
            // Linjen over konvatere Pathen om til en file.
            
            
            for (File f: dirFile.listFiles()) {
                if (f.isDirectory()) {
                    
               
                    
                   
                 new Thread(new Runnable(){
                    public void run(){
                        m1(f.toPath());
                    }
                    }).start();
                       
             
                   
                
                
                } else if (f.getName().contains(".txt")) {
                    /*m1List.add tager imod et result, men f er en file. Der er 
                  ingen setters eller getters i Result, så jeg kan ikke lave om på
                  f?*/
                  
                  
                  // skal jeg give den path, eller file?
                    Path p1; 
                    p1 = f.toPath();
                    
                    
                   // Hvad betyder den parentes med (Result) i 
                    m1List.add((Result) p1);
                   // m1List.add(f);

                    
                }
        
       
            
        }
            return m1List;
           
        }
        
        
        
        
        
        /*Finder bliver nød til at tage imod en string, fordi ellers kan jeg ikke give en string
        i min main method, som er en sti til den mappe jeg gerne vil søge i. */
        public void Finder(String sti){
    try{
        // Linjen under burde give mig en dir som er typen path. 
        
        Path dir = Paths.get(sti);
        // Her kalder jeg på hjælpefunktionen m1.
        m1(dir);
        
   
            
         }catch (Exception e){
        e.printStackTrace();
    }
    
   
    
}
    }
}
        
       
        
        
    
    
    





