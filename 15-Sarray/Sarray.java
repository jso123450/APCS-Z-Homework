import java.util.*;

public class Sarray{

    // Instance Variables
    int[] data;
    int last;
    Random rnd;

    // Constructors

    public Sarray() {
	this( 100 );
    }

    public Sarray(int length){
	data = new int[length];
	rnd = new Random();
	for (int i = 0; i < length; i++){
	    data[i] = rnd.nextInt(100);
	}
	last = length - 1;
    }

    public Sarray(int length, int[] list){
	data = new int[length];
        for (int i = 0; i < list.length; i++){
	    data[i] = list[i];
	}
	last = list.length - 1;
    }

    // Methods
    
    public String toString(){
	String array = "";
	for (int i = 0; i < data.length; i++){
	    array+= data[i] + ", ";
	}
	return array;
    }

    public int size(){
	int output = 0;
	for (int i = data.length - 1; i > 0; i--){
	    if (data[i] != 0){
	        output = i + 1;
		break;
	    }
	}
	return output;
    }

    public boolean add(int i){
	if (size() == data.length){
	    int[] newData = new int[size() + 1];
	    for (int n = 0; n < data.length; n++){
		newData[n] = data[n];
	    }
	    newData[ newData.length - 1 ] = i;
	    data = newData;
	}
	else {
	    data[ size() + 1 ] = i;
	}
	return true;
    }

    public void add( int index, int i ){
	int[] newData;
	if (size() != data.length){
	    newData = new int[data.length];
	}
	else {
	    newData = new int[data.length + 1];
	}
	for (int x = 0; x < index; x++){
	    newData[x] = data[x];
	}
	newData[index] = i;
	for (int x = index + 1; x < data.length + 1; x++){
	    newData[x] = data[x-1];
	}
	data = newData;
    }

    public int get(int index){
	return data[index];
    }

    public int set(int index, int i){
	int old = data[index];
	data[index] = i;
	return old;
    }

    public int remove(int index){
	int old = data[index];
	int[] newData = new int[data.length];
	for (int i = 0; i < data.length; i++){
	    if (i < index){
		newData[i] = data[i];
	    }
	    else if (i > index){
		newData[i - 1] = data[i];
	    }
	}
	data = newData;
	return old;
    }

    // Main
    public static void main(String[] args){
	Sarray array = new Sarray();
	System.out.println(array);
	System.out.println(array.size());
	array.add(5);
	System.out.println();
	System.out.println(array);
	System.out.println(array.size());
	System.out.println();
	array.add(5,5);
	System.out.println(array);
	System.out.println();
	System.out.println(array.get(5));
	array.set(5, 0);
	System.out.println(array);
	System.out.println(array.size());
	System.out.println();
	array.remove(5);
	System.out.println(array);
	System.out.println(array.size());
    }
}
