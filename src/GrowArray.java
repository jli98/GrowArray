import java.io.*;
import java.util.*;

public class GrowArray {
	private int[] p;
	private int cap = 0;
	private int used = 0;
	public GrowArray() {
		p = new int[0];
	}
	
	public void extend(){
		int[] temp = p;
		cap = cap*2+1;
		p = new int[cap];
		for (int i = 0; i < temp.length; i++)
			p[i] = temp[i];
	}
	
	public void addStart(int v) {
		int[] temp = p;
		p = new int[temp.length+1];
		for (int i = 1; i < temp.length; i++)
			p[i] = temp[i];
		p[0] = v;
		used++;
	}
	
	public void addEnd(int v) {
		if (cap <= used){
		extend();
		p[used] = v;
		used++;
		}else{
			p[used] = v;
			used++;
		}
	}
	
	public void removeStart(){
		int[] temp = p;
		p = new int[temp.length-1];
		for (int i = 0; i < p.length; i++)
			p[i] = temp[i+1];
	}
	
	public void removeEnd(){
		int[] temp = p;
		p = new int[temp.length-1];
		for (int i = 0; i < p.length; i++)
			p[i] = temp[i];
	} 

	public int size() {
		return p.length;
	}

	public int get(int i) {
		return p[i];
	}

	public static void main(String []a) throws IOException{
		GrowArray list = new GrowArray();
		int v = 0;
		Scanner s = new Scanner(new FileReader("HW4a.txt"));
		while (s.hasNextLine()){
			String ins = s.next();
			if (ins.equals("ADD_FRONT")){
				while(s.hasNextInt()){
					v = s.nextInt();
					list.addStart(v);
				}
			}else
			
			if (ins.equals("ADD_BACK")){
				while(s.hasNextInt()){
					v = s.nextInt();
					list.addEnd(v);
				}
			}else
			
			if (ins.equals("REMOVE_FRONT")){	
				v = s.nextInt();
				for(int i = 0; i < v; i++)
					list.removeStart();
			}else
			
			if (ins.equals("REMOVE_BACK")){	
				v = s.nextInt();
				for(int i = 0; i < v; i++)
					list.removeEnd();
			}else
			
			if (ins.equals("OUTPUT")){	
				for (int i = 0; i < list.size(); i++)
					System.out.print(list.get(i) +  " ");
					System.out.println();
			}
		}
	    s.close();
	}
}






