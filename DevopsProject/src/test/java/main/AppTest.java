package main;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

public class AppTest {

    @Test
    public void testCSVPath() throws FileNotFoundException {
        CSV csv = new CSV("res/fich.csv");
        assertNotNull("teste la création de CSV",csv);
        
        csv.parse();
        assertEquals("teste le nom de la première colonne",csv.list[0][0],"name");
        assertEquals("teste le nom de la deuxième colonne",csv.list[0][1],"age");
        assertEquals("teste le nom de la troisième colonne",csv.list[0][2],"size");
        assertEquals(csv.list[1][0],"Theo");
        assertEquals(csv.list[1][1],"67");
        assertEquals(csv.list[1][2],"XXL");
        assertEquals(csv.list[2][0],"Ivan");
        assertEquals(csv.list[2][1],"13");
        assertEquals(csv.list[2][2],"XXS");
    }
    
    @Test
    public void testCSVPathExeption(){
        CSV csv = new CSV("res/mauvais_nom_de_fichier.csv");
        assertNull(csv.reader);
    }
    
    @Test
    public void testCSVTableau() {
        String test[][]= {{"name","age"},{"Theo","67"}};
        CSV csv= new CSV(test);
        assertNotNull("teste la création de CSV",csv);
        
        assertEquals("teste le nom de la première colonne",csv.list[0][0],test[0][0]);
        assertEquals("teste le nom de la deuxième colonne",csv.list[0][1],test[0][1]);
        assertEquals(csv.list[1][0],test[1][0]);
        assertEquals(csv.list[1][1],test[1][1]);
    }
    
    @Test
    public void testCSVTableauVide() {
        String test[][]= {{}};
        CSV csv= new CSV(test);
        assertNotNull("teste la création de CSV",csv);
        
    }
    
    @Test
    public void testCSVAffich() {
        String test=" name  age  size \nTheo  67  XXL \nIvan  13  XXS";
        CSV csv= new CSV(test);
        assertNotNull("teste la création de CSV",csv);
        
    }
    
    @Test
    public void shouldAnswerWithTrue()
    {
        App.simple();
        
    }

}