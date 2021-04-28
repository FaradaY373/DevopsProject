package main;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Hello world!
 * Le test de JavaDoc
 *
 */
public class App 
{
    
    public static void main(String[] args) {
        simple();
    }
    
    public static void simple() 
    {
        CSV csv;
        csv = new CSV("res/fich2.csv");
        csv.parse();
        try {System.out.println(csv.min(1));}catch(Exception e){}
}
