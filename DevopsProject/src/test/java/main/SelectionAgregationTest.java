package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionAgregationTest {

	@Test
	public void linestest() {
		CSV csv=new CSV("res/fich2.csv");
		CSV csv2;
		csv.parse();
		String[][] t1 = {{ "name",  "age",  "size",  "city"},{"Ivan",  "13",  "XXS",  "XXL"}};
		csv2=new CSV(t1);
		AssertEquals(csv.lines(2),csv2);
		
		String[][] t2 = {{ "name",  "age",  "size",  "city"},{"Theo",  "67",  "XXL",  "Grenoble" }};
		csv2=new CSV(t2);
		AssertEquals(csv.lines(-1),csv2);
		
		AssertEquals(csv.lines(0),csv2);
		
		String[][] t3 = {{ "name",  "age",  "size",  "city"},{"maven",  "38",  "XXL",  "Grenoble"}};
		csv2=new CSV(t3);
		AssertEquals(csv.lines(10),csv2);
	}
	
	
	@Test
	public void columnstest() {
		CSV csv=new CSV("res/fich2.csv");
		CSV csv2;
		csv.parse();
		assertNull(csv.columns(""));
		assertNull(csv.columns("existe pas"));
		
		String[][] t1 = {{"age"},{"67"},{"13"},{"38"}};
		csv2=new CSV(t1);
		AssertEquals(csv.columns("age"),csv2);
		
		
	}
	
	@Test
	public void selectColumnstest() {
		
		CSV csv=new CSV("res/fich2.csv");
		CSV csv2;
		csv.parse();
		assertNull(csv.selectColumns(""));
		assertNull(csv.selectColumns("existe pas"));
		
		String[][] t1 = {{"size","city"},{"XXL","Grenoble"},{"XXS","XXL"},{"XXL","Grenoble"}};
		csv2=new CSV(t1);
		AssertEquals(csv.selectColumns("XXL"),csv2);
		
		
	}
	
	@Test
	public void selectLinestest() {
		
		CSV csv=new CSV("res/fich2.csv");
		CSV csv2;
		csv.parse();
		assertNull(csv.selectLines(""));
		assertNull(csv.selectLines("existe pas"));
		
		String[][] t1 = {{"name",  "age",  "size",  "city" },{"maven",  "38",  "XXL",  "Grenoble"}};
		csv2=new CSV(t1);
		AssertEquals(csv.selectLines("38"),csv2);
		
	}
	
	
	

	private void AssertEquals(CSV lines, CSV csv2) {
		if(lines==null && csv2!=null) {
			fail();
		}
		if(lines!=null && csv2==null) {
			fail();
		}
		if(lines.list.length!= csv2.list.length || lines.list[0].length!=csv2.list[0].length) {
			fail();
		}
		for(int i=0;i<lines.list.length;i++) {
			for(int j=0;j<lines.list[0].length;j++) {
				if(!lines.list[i][j].equals(csv2.list[i][j])) {
					fail();
				}
			}
		}
		return;
		
	}


}
