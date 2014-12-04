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
	ssort();
	this.data = super.getData();
	this.last = super.getLast();
    }

    // Methods

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
