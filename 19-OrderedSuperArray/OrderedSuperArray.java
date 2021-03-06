public class OrderedSuperArray extends SarrayStr{

    // Instance Variables
    private String[] data;
    private int last;

    // had some trouble with super's data & last and this data & last but fixed it
    // just needed to make sure to reassign this data & last to super's after
    // running super methods

    // Constructors

    public OrderedSuperArray(){
	super();
	this.data = super.getData();
	this.last = super.getLast();
    }

    public OrderedSuperArray(int length){
        super(length);
	this.data = super.getData();
	this.last = super.getLast();
    }

    public OrderedSuperArray(int length, String[] list){
	super(length, list);
	this.data = super.getData();
	this.last = super.getLast();
	order();
    }

    // Methods

    public String findBiggest(int range){
	String biggest = data[0];;
	for (int i = 1; i <= range; i++){
	    if (biggest.compareTo(data[i]) < 0)
		biggest = data[i];
	}
	return biggest;
    }
    
    public int findBiggestIndex(int range){
	int index = 0;
	for (int i = 1; i <= range; i++){
	    if (data[index].compareTo(data[i]) < 0)
		index = i;
	}
	return index;
    }

    public void order(){
        int j = last;
	while (j > -1){
	    String biggest = findBiggest(j);
	    int biggestIndex = findBiggestIndex(j);
	    data[biggestIndex] = data[j];
	    data[j] = biggest;
	    j--;
	}            
    }

    public void checkIndex(int index){
	if (index > last)
	    throw new IndexOutOfBoundsException();
    }

    public String set(int index, String s){
	String old = data[index];
	try {
	    checkIndex( index );
	    data[index] = s;
	    order();
	}
	catch( IndexOutOfBoundsException e ){
	    System.out.println("Index specified is out of bounds");
	}
	return old;
    }

    public boolean add(String s){
	if (size() == 0)
	    super.add(s);
	else if (size() > 0){
	    if (s.compareTo(data[last]) > 0)
		super.add( s );
	    else {
		for (int i = 0; i <= last; i++){
		    if ((s.compareTo(data[i]) > 0) && (s.compareTo(data[i+1]) < 0)){
			super.add( i + 1, s );
			break;
		    }
		    else if (s.compareTo(data[i]) < 0){
			super.add( i, s );
			break;
		    }
		}
	    }
	}
	last++;
	this.data = super.getData();
	return true;
    }

    public void add(int index, String s){
	this.add(s);
    }
    
}
