
package cp;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.Level;
import java.util.logging.Logger;

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
 // Hvorfor skal der være static foran dem begge?
    

public class Main implements Result{
    /* I create a static Executorservice and LinkedBlockingDeque. These will be used
       to start and maintain my threads. */
    static ExecutorService mainEx = Executors.newCachedThreadPool();
    static LinkedBlockingDeque<File> blockDeque = new LinkedBlockingDeque();
    
 
    
    public static void main(String[] args){ 
       String spath = "C:\\Users\\barth\\Documents\\Datalogi\\2 semester\\Concurrent Programming\\Eksamen\\data_example"; 
        
       Path path = Paths.get("C:\\Users\\barth\\Documents\\Datalogi\\2 semester\\Concurrent Programming\\ConcurrencyExam\\data_example");
       Path pathTom2 = Paths.get("C:\\Users\\barth\\Documents\\Datalogi\\2 semester\\Concurrent Programming\\ConcurrencyExam\\data_example\\Testmappe m2");
       
       Result result = null;
        
               
       result = m2(pathTom2, 2000000);
       System.out.println("Pathen til den fil, hvor der er en linje der overskrider min er " + result.path() + 
               "\nLinjen der overskrider er numer : " + result.number());
      
       //List liste = m1(path);
       
       // latch med 1 i.
       CountDownLatch mainLatch = new CountDownLatch(1);
       
       mainEx.submit(() -> m1(path));
       
       
       

        
    }
    // Ide til m1: lav countdownlatch, og tæl også ned ved forloopet inde i if (f.isdirctory) loopet. Så tror jeg at det kommer til at passe.
      public static List <Result> m1(Path dir) {
            // First i create a list m1List, with will contain the result of m1 and return it.
            List <Result> m1List = new ArrayList<Result>();
           
            
            
            /* I am chageing m1's input from a path to a file, becouse File have some usefull
            methods that i would like to use.*/
            File dirFile = dir.toFile();
            
            // First i need to know, how many dicretories there are in my path.
            int c = 0;
            for (File f: dirFile.listFiles()) {
                // then i find all the directories in that path.
                if (f.isDirectory()) {
                c++;
                }
            }
            
            CountDownLatch latch = new CountDownLatch(c);
            ExecutorService ex = new ExecutorService.
            

            // I start a for loop, that will look at all the files in the givin path.
            for (File f: dirFile.listFiles()) {
                // then i find all the directories in that path.
                if (f.isDirectory()) {
                    /*I make a new list for each directory, and I run m1 on that list, and ad each result
                    to m1List.*/
                    // På højre siden af = bliver m1 startet igen.
                     //(Sekventiel løsning) List <Result> list = m1(f.toPath()); 
                     
                   
                     for(Result res: list){
                         m1List.add(res);
                     }
                     
                     
                     
                     
                     // Første forsøg med threads.
//                    Runnable runnable = () -> {
//                    List<Result> list = m1(f.toPath());
//                    
//                    for(Result res: list){
//                         m1List.add(res);
//                     }
//                           };
//                    Thread thread = new Thread(runnable);
//                    thread.start();
                      

                    
//                    mainEx.submit(new Callable<List>(){
//                    public void run(){
//                        List <Result> list = m1(f.toPath());
//                    }
//
//                        @Override
//                        public List call() throws Exception {
//                            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                        }
//                    });
                    
                    
                     
                    
                
                       
             
                } else if (f.getName().contains(".txt")) {
                    // Denne test bekræfter, at jeg får fat i alle filerne.
                    //System.out.println("Filerne i mapperne hedder: " + f.getName());
                 
                    Path p1; 
                    p1 = f.toPath();
                  
                    m1List.add(new Resultobject(p1));
    
                }
            }
            return m1List;
      }
      
      
      /**
	 * This method recursively visits a directory for text files with suffix
	 * ".dat" (notice that it is different than the one before)
	 * contained in it and its subdirectories.
	 * 
	 * You must consider only files ending with a .dat suffix.
	 * You are guaranteed that they will be text files.
	 * 
	 * Each .dat file contains some lines of text,
	 * separated by the newline character "\n".
	 * You can assume that each line contains a (non-empty)
	 * comma-separated sequence of
	 * numbers. For example: 100,200,34,25
	 * 
	 * This method looks for a .dat file that contains a line whose numbers,
	 * when added together (total), amount to at least (>=) parameter min.
	 * Once this is found, the method can return immediately
	 * (without waiting to analyse also the other files).
	 * The return value is a result that contains:
	 *  - path: the path to the text file that contains the line that respects the condition;
	 *  - number: the line number, starting from 1 (e.g., 1 if it is the first line, 3 if it is the third, etc.)
	 * 
	 */
      
      
      public static Result m2( Path dir, int min ){
          
          //* I can reuse some of the code from m1.
          File dirFile = dir.toFile();
          // I create a result object, that i later can return with a path, that meets the requriments of m2. 
          Resultobject result = null;

          //* Same as m1
          for (File f: dirFile.listFiles()) {
          //* Same as m1.
              if (f.isDirectory()) {
                  
                  // Jeg skal bruge et for loop her, for at finde alle filerne i alle mapper.
                  // Måske skal jeg bruge en counter?
//                  for(Result res: list){
//                         m1List.add(res);
                    System.out.println("Her skal jeg have lavet noget godter");

                
              } else if (f.getName().contains(".dat")) {
                  
                  /* I need to search in each dat file, and find the first one that adds up to min,
                   * so i will create a Scanner, and scan each file
                   */
                  Scanner sc = null;
                    try {
                        sc = new Scanner(f);
                    } catch (FileNotFoundException ex) {
                        System.out.println("Error in scanner m2.");
                    }
                    // Hvis jeg skal gøre noget for alle linjer, så skal gemme min variablen inde whileløkken.
                    
                   int total = 0;
                   boolean PathMinFound = false; 
                    
                    // sc.hasNextLine automatically interperts \n, so i still only need to specify the spil on commas.

                   int countLines = 0;
                   while (sc.hasNextLine() && PathMinFound == false){
                       total = 0;
                       String lines = sc.nextLine();
                       
                       countLines ++;
                     
                       String numbers[] = lines.split(","); 
                       
                       
                     
                       for(int i = 0; i < numbers.length; i++){
                           System.out.println( "Lines er lig med = " + lines + "\n");
                           total = total + Integer.parseInt(numbers[i]);
                           System.out.println("Total er lig med: " + total);
                           System.out.println("Og min er lig med " + min + " Filen er : " + f.getName() + "\n");
                          
                           if(total >= min){
                               System.out.println("Nu stopper programmet");
                               System.out.println("Linjen der hvor min = " + min + " er mindre end = " + total +" er på linjen: " + countLines + "\n");
                               
                                PathMinFound = true;
                                // Jeg skal have lavet en ny construktor, som tager countLines som number.
                                result = new Resultobject(f.toPath(),countLines);
                                
                                
                           
                           }
                       }
                        
                           
                   } 
                     sc.close();
                   
              }
          }

                   return result;
  
      }
            
            
            
            
            
            
            
            
            
            

       
      
      

      
      // fra interfacen Result
    @Override
    public Path path() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int number() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    }



    
        
        
