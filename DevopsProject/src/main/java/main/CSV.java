package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV {
	String[][] list;
	BufferedReader reader ;
	public CSV(String[][] table ) {
		list = table;
	}
	public CSV(String path){
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			reader=null;
		}
		
	}
	public void parse() {
		ArrayList<String[]> arr = new ArrayList();
		
		String line;
		int i=0;
		try {
			while ((line = reader.readLine()) != null) {
				arr.add(line.split(" "));
				i++;
	        }
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		list = new String[arr.size()][arr.get(0).length];
		for(i = 0;i<arr.size();i++) {
			for(int j = 0;j<arr.get(i).length;j++) {
				list[i][j] = arr.get(i)[j];
			}
		}
	}
	public void  print() {
		for(int i = 0;i<list.length;i++) {
			for(int j = 0;j<list[i].length;j++) {
				System.out.print(" "+list[i][j]+" ");
			}
			System.out.println();
		}
	}
}
