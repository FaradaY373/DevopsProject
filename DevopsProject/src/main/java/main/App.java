package main;

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
        CSV csv = new CSV("res/fich.csv");
        csv.parse();
        csv.print();
    }

}
