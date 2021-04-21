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
	public CSV lines(int l) {
		String res[][]=new String[2][list[0].length];
			res[0]=list[0].clone();
			if(l<=0) {
				l=1;
			}
			if(l>=list.length) {
				l=list.length-1;
			}
			res[1]=list[l].clone();
		return new CSV(res);
    }
	
    public CSV columns(String s) {
    	String res[][]=new String[list.length][1];
		int i=0;
		while(i<list.length && !s.equals(list[0][i]) ) {
			i++;
		}
		if(i==list.length) {
			//la clononne n'éxiste pas
			return null;
		}
		for(int j=0;j<list.length;j++) {
			res[j][0]=list[j][i];
		}
		
	return new CSV(res);
    }
    
    
    public CSV selectColumns(Object o) {


    	ArrayList<ArrayList<String[]>> res=new ArrayList<>();
    	ArrayList <String[]> res2;
    	Boolean vue;
    	String tmp[]=new String[1];
    	
        for(int i=0;i<list.length;i++) {
        	for (int j=0;j<list[0].length;j++) {
        		if(o.equals(list[i][j])) {
        			vue=false;
        			for (ArrayList<String[]> h : res) {
        	        	for (String[] f : h) {
        	        		vue|=f[0].equals(list[0][j]);
        	        	}
        			}
        			if(!vue) {
        				res2=new ArrayList<>();
	        			for(int y=0;y<list.length;y++) {
	        				tmp[0]=list[y][j];
	        				res2.add(tmp);
	            			tmp=new String[1];
	        			}
	        			res.add(res2);
        			}
        		}
        	}
        }
        if(res.size()==0) {
        	return null;
        }
        String colone[][]=new String[res.get(0).size()][res.size()];
        int r;
        int k=0;
        for (ArrayList<String[]> h : res) {
        	r=0;
        	for (String[] f : h) {
        		colone[r][k]=f[0];
        		r++;
        	}
        	k++;
        }
		return new CSV(colone);
    }
    
    public CSV selectLines(Object o) {
    	
    	ArrayList<String[]> res=new ArrayList<String[]>();
    	String tmp[]=new String[list[0].length];
        for(int i=0;i<list.length;i++) {
        	for (int j=0;j<list[0].length;j++) {
        		if(o.equals(list[i][j])) {
        			for(int y=0;y<list[0].length;y++) {
        				tmp[y]=list[i][y];
        			}
        			res.add(tmp);
        			tmp=new String[list[0].length];
        		}
        	}
        }
        if(res.size()==0) {
        	return null;
        }
        String lines[][]=new String[res.size()+1][list[0].length];
        lines[0]=list[0].clone();
        int r=1;
        for (String[] h : res) {
        	lines[r]=h.clone();
        	r++;
        }
		return new CSV(lines);
    }
    
    
}
