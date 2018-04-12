/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cp;

import java.nio.file.Path;

/**
 *
 * @author barth
 */
public class Resultobject implements Result{
    private Result Result;
    
    public Resultobject(){
        
    }
    
    
    
//    // Setter for resullt object
//    public void setResult(Path p){
//        this.Result = p; // ??
//        
//    }
    
    public void setResult(){
        this.Result = Result;
    }
    
    //Getter for result object
    public Result getResult(){
        return this.Result;
    }
    

    @Override
    public Path path() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int number() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

