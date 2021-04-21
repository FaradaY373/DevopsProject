package main;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import org.junit.Test;

public class LinesTest {
	@Test
    public void firstLines()
    {
		CSV csv = new CSV("res/fich.csv");
		csv.parse();
		String s ="name age size \nTheo 67 XXL \nIvan 13 XXS \n";
		assertEquals(csv.firstLines(3),s);
		String s2 = "name age size ";
		assertEquals(csv.firstLines(12),s2);
		String s3 = "";
		assertEquals(csv.firstLines(0),s3);
		assertEquals(csv.firstLines(-10),"");
		String s4 = "name age size \nTheo 67 XXL \n";
		assertEquals(csv.firstLines(2),s4);
    }
	@Test
	public void lastLines()
    {
		CSV csv = new CSV("res/fich.csv");
		csv.parse();
		String s ="name age size \nTheo 67 XXL \nIvan 13 XXS \n";
		assertEquals(csv.lastLines(3),s);
		String s2 = "Ivan 13 XXS ";
		assertEquals(csv.lastLines(12),s2);
		String s3 = "";
		assertEquals(csv.lastLines(0),s3);
		assertEquals(csv.lastLines(-10),"");
		String s4 = "Theo 67 XXL \nIvan 13 XXS \n";
		assertEquals(csv.lastLines(2),s4);
    }
}
