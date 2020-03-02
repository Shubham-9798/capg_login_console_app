package com.capg.login.defaultt;

import java.util.Scanner;

public class SigletonScanner {

	
    private static SigletonScanner single_instance = null; 
    
    // variable of type String 
    public String s; 
  
    // private constructor restricted to this class itself 
    private  Scanner Singleton() 
    { 
        return new Scanner(System.in); 
    } 
  
    // static method to create instance of Singleton class 
    public  SigletonScanner SigletonScanner() 
    { 
        if (single_instance == null) 
            single_instance = new SigletonScanner(); 
  
        return  single_instance; 
    } 

}
