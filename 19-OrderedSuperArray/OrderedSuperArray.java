public class OrderedSuperArray extends SarrayStr{

    // Instance Variables
    private String[] data;
    private int last;

    // Constructors

    public OrderedSuperArray(){
	super();
    }

    public OrderedSuperArray(int length){
        super(length);
    }

    public OrderedSuperArray(int length, String[] list){
	super(length, list);
	order();
    }

    // Methods
    public void order(){
	int s = data.length - 1;
        for (int j = 0; j < data.length; j++){
	    String holder = data[0];
	    for (int i = 0; i < data.length; i++){
		if (holder.compareTo(data[i]) < 0){
		    holder = data[i];
		}
	    }
	    data[j] = data[s];
	    data[s] = holder;
	    s--;
	}
    }

    public String set(int index, String s){
	String old = data[index];
	data[index] = s;
	order();
	return old;
    }
    
}
