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
    public static void main() 
    {
        CSV csv;
		csv = new CSV("res/fich.csv");
		csv.parse();
	    csv.print();
    }

}
