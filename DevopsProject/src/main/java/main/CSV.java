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
		}catch(Exception e) {
			reader = null;
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
	public String  print() {

        String aff="";
        for(int i = 0;i<list.length;i++) {
            for(int j = 0;j<list[i].length;j++) {
                aff+=" "+list[i][j]+" ";
            }
            aff+="\n";
        }
        return aff;
    }
	public String firstLines(int n) {
		String res = "";
		if(n>list.length) { //Si n est trop grand on print la 1er ligne
			for(int i = 0; i < list[0].length ; i++) {
				res+=list[0][i]+" ";
			}
		}
		else { //Sinon
			for(int i = 0; i < n;i++) {
				for(int j = 0; j < list[i].length; j++) {
					res+=list[i][j]+" ";
				}
				res+="\n";
			}
		}
		return res;
	}
	public String lastLines(int n) {
		String res = "";
		if(n>list.length) { //Si n est trop grand on print la derniere ligne
			for(int i = 0; i < list[0].length ; i++) {
				res+=list[list.length-1][i]+" ";
			}
		}
		else { //Sinon
			int len = list.length - n;
			for(int i = len; i < list.length;i++) {
				for(int j = 0; j < list[i].length; j++) {
					res+=list[i][j]+" ";
				}
				res+="\n";
			}
		}
		return res;
	}
}
