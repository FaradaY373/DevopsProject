package main;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArifmeticTest {
	@Test
    public void min() throws TypeArithmeticException
    {
		CSV csv = new CSV("res/fich.csv");
		csv.parse();
		float f = 13.0f;
		assertEquals(csv.min(2),f,0.0000000000001);
    }
	@Test(expected = TypeArithmeticException.class)
    public void min1() throws TypeArithmeticException
    {
		CSV csv = new CSV("res/fich.csv");
		csv.parse();
		csv.min(1);
    }
	
	
	@Test
	public void max()
    {
		CSV csv = new CSV("res/fich.csv");
		csv.parse();
		float f = 67.0f;
		assertEquals(csv.max(2),f,0.0000000000001);
		float f2 = -99999999999999999999999999999999999999.f;
		assertEquals(csv.max(1),f2,0.0000000000001);
		assertEquals(csv.max(-12),f2,0.0000000000001);
    }
	@Test
	public void moyenne()
    {
		CSV csv = new CSV("res/fich.csv");
		csv.parse();
		float f = 26.666666f;
		assertEquals(csv.moyenne(2),f,0.0001);
		float f2 = -1.0f;
		assertEquals(csv.moyenne(1),f2,0.0000000000001);
		assertEquals(csv.moyenne(-12),f2,0.0000000000001);
    }
}
