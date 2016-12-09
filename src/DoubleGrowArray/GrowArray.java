package DoubleGrowArray;

class GrowArray {
	private int[] list;
	private int first;
	private int last;
	public GrowArray(int size) {
		list = new int[size];
		first = last = size/2;
	}
	public void addLast(int v) {
	    if (last >= list.length) {
	    	grow();
	    }
	    list[last++] = v;
	}
	public void addFirst(int v) {
		if (first == last - 1){
			first--;
		}
		if (first <= 0) {
		    grow();
		}
		list[first--] = v;
	}
	public void grow(){
		int[] temp = new int[list.length*3];
		int j = 0;
		for (int i = list.length; i < list.length; i++ ){
			temp[i] = list[j++];
		}
	}
	public static void main(String[] a){
		GrowArray i = new GrowArray(10);
		i.addLast(50);
		i.addFirst(100);
		i.addFirst(100);
		i.addFirst(100);
		i.addFirst(100);
		i.addFirst(100);
		i.addFirst(100);
		i.addFirst(100);
		i.addFirst(100);
		for (int j = 0; j < i.list.length; j++){
			System.out.print(i.list[j]+ " ");
		}
	}
}